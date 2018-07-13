package de.uka.ipd.sdq.dsexplore.tools.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.osgi.framework.hooks.weaving.WeavingException;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.ComponentType;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.RepositoryFactory;

import FeatureCompletionModel.ComplementumVisnetis;
import FeatureCompletionModel.CompletionComponent;
import de.uka.ipd.sdq.dsexplore.tools.stereotypeapi.StereotypeAPIHelper;
import de.uka.ipd.sdq.pcm.cost.CostRepository;

/**
 * This class realizes a {@link Repository} which consists of many
 * {@link Repository Repositories}.
 *
 * @author Dominik Fuchss
 *
 */
public final class MergedRepository extends EObjectImpl implements Iterable<Repository> {
	private final Set<Repository> repositories;
	// private Repository repoWithoutAnnotations;

	public MergedRepository(Repository... repositories) {
		this.repositories = new HashSet<>();
		this.repositories.addAll(Arrays.asList(repositories));
		// this.createRepo();
	}

	public MergedRepository(List<Repository> repositories) {
		this.repositories = new HashSet<>();
		this.repositories.addAll(repositories);
		// this.createRepo();
	}

	public MergedRepository(Set<Repository> repositories) {
		this.repositories = new HashSet<>();
		this.repositories.addAll(repositories);
		// this.createRepo();
	}

	// private void createRepo() {
	// Repository repo = RepositoryFactory.eINSTANCE.createRepository();
	// repo.setEntityName("MergedRepo");
	// repo.setId("MergedRepo" + this.hashCode());
	// for (Repository r : this.repositories) {
	// Repository copy = this.copyOf(r);
	// repo.getComponents__Repository().addAll(copy.getComponents__Repository());
	// }
	// this.repoWithoutAnnotations = repo;
	//
	// }

	// private Repository copyOf(Repository repo) {
	// Copier copier = new Copier();
	// Repository newRepo = (Repository) copier.copy(repo);
	// copier.copyReferences();
	// return newRepo;
	// }

	private Repository copyOf(Repository repo) {
		Copier copier = new Copier();
		Repository newRepo = (Repository) copier.copy(repo);
		copier.copyReferences();
		return newRepo;
	}

	public List<CostRepository> getCostRepos() {
		Set<CostRepository> repos = new HashSet<>();
		for (Repository repo : this.repositories) {
			repos.addAll(StereotypeAPIHelper.getViaStereoTypeFrom(repo, CostRepository.class));
		}
		return new ArrayList<>(repos);
	}

	/**
	 * Retrieves all components annotated by a set of annotations.
	 *
	 * @param annotations
	 *            - The set of annotations.
	 * @return all components annotated by a set of annotations.
	 */
	public List<RepositoryComponent> getAffectedComponentsByFCCList(List<CompletionComponent> fccs) {
		Set<RepositoryComponent> affectedComponents = new HashSet<>();
		for (Repository repo : this.repositories) {
			for (RepositoryComponent rcs : repo.getComponents__Repository()) {
				List<CompletionComponent> realizedCCs = StereotypeAPIHelper.getViaStereoTypeFrom(rcs, CompletionComponent.class);
				if (this.anyContainedInList(realizedCCs, fccs)) {
					affectedComponents.add(rcs);
				}
			}
		}
		return new ArrayList<>(affectedComponents);
	}
	
	//TODO added for extension
	//TODO Anmerkung: wenn das MergedRepo dann eh nur noch eine Solution enth�lt, kann der repo-Parameter wegfallen und die Methode sollte dann �quivalent zur obigen sein
	public List<RepositoryComponent> getAffectedComponentsByFCCList(List<CompletionComponent> fccs, Repository repo) {
		Set<RepositoryComponent> affectedComponents = new HashSet<>();

		for (RepositoryComponent rcs : repo.getComponents__Repository()) {
			List<CompletionComponent> realizedCCs = StereotypeAPIHelper.getViaStereoTypeFrom(rcs, CompletionComponent.class);
			if (this.anyContainedInList(realizedCCs, fccs)) {
				affectedComponents.add(rcs);
			}
		}

		return new ArrayList<>(affectedComponents);
	}
	
	/**
	 * @param realizingComponents
	 * @param cvs
	 */
	public static RepositoryComponent getComponentFullfillingCV(List<RepositoryComponent> realizingComponents, List<ComplementumVisnetis> cvs) {
		for (RepositoryComponent repositoryComponent : realizingComponents) {
			
			//Visnetum at component
			List<ComplementumVisnetis> fullfilledByComponentCVs = StereotypeAPIHelper.getViaStereoTypeFrom(repositoryComponent, ComplementumVisnetis.class);
			//Visnetum at interface
			List<ComplementumVisnetis> fullfilledByInterfaceCVs = repositoryComponent.getProvidedRoles_InterfaceProvidingEntity().stream()
					.flatMap(role -> StereotypeAPIHelper.getViaStereoTypeFrom(((OperationProvidedRole) role).getProvidedInterface__OperationProvidedRole(), ComplementumVisnetis.class).stream())
					.collect(Collectors.toList());
			//Visnetum at signature
			List<ComplementumVisnetis> fullfilledBySignatureCVs = repositoryComponent.getProvidedRoles_InterfaceProvidingEntity().stream()
					.flatMap(role -> ((OperationProvidedRole) role).getProvidedInterface__OperationProvidedRole().getSignatures__OperationInterface().stream())
					.flatMap(signature -> StereotypeAPIHelper.getViaStereoTypeFrom(signature, ComplementumVisnetis.class).stream())
					.collect(Collectors.toList());
			//TODO verschiedene targets betrachten -> component, interface, signature
			if (anyCVcontainedInList(fullfilledByComponentCVs, cvs) ||
				anyCVcontainedInList(fullfilledByInterfaceCVs, cvs) ||
				anyCVcontainedInList(fullfilledBySignatureCVs, cvs)) {
				return repositoryComponent;
			}
		}
		throw new WeavingException("no realizing component for completion components found or ambigous components found");
	}

	/**
	 * @param rcs
	 * @param cvs
	 * @return
	 */
	private static boolean anyCVcontainedInList(List<ComplementumVisnetis> fullfilledCVs, List<ComplementumVisnetis> cvs) {
		for (ComplementumVisnetis complementumVisnetis : fullfilledCVs) {
			if (cvs.stream().anyMatch(cv -> cv.getId().equals(complementumVisnetis.getId()))) {
				return true;
			}
		}
		return false;
	}

	private boolean anyContainedInList(List<CompletionComponent> realizedCCs, List<CompletionComponent> listToContainedIn) {
		for (CompletionComponent completionComponent : realizedCCs) {
			if (listToContainedIn.contains(completionComponent)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Creates and add a adapter component to the concern solution repository.
	 *
	 * @param name
	 *            - The name of the adapter component.
	 * @return the created adapter component.
	 */
	public RepositoryComponent createAndAddAdapter(String name, Repository repo) {
		BasicComponent adapter = this.createAdapter(name);
		repo.getComponents__Repository().add(adapter);
		return adapter;
	}

	private BasicComponent createAdapter(String name) {
		BasicComponent adapter = RepositoryFactory.eINSTANCE.createBasicComponent();
		adapter.setComponentType(ComponentType.BUSINESS_COMPONENT);
		adapter.setEntityName(name);
		return adapter;
	}

	// private void addAdapter(BasicComponent adapter) {
	// this.repoWithoutAnnotations.getComponents__Repository().add(adapter);
	// }

	// public Repository getAsRepoWithoutStereotypes() {
	// return this.repoWithoutAnnotations;
	// }

	public List<ProvidedRole> getAllProvidedRoles() {
		List<ProvidedRole> prs = new ArrayList<>();

		for (Repository repo : this.repositories) {
			for (RepositoryComponent c : repo.getComponents__Repository()) {
				List<ProvidedRole> role = c.getProvidedRoles_InterfaceProvidingEntity();
				prs.addAll(role);
			}
		}
		return prs;
	}

	@Override
	public Iterator<Repository> iterator() {
		return this.repositories.iterator();
	}

}
