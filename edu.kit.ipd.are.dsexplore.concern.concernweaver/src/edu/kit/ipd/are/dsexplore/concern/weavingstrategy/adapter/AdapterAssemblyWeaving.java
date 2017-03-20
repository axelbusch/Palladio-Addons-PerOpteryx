package edu.kit.ipd.are.dsexplore.concern.weavingstrategy.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.Connector;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.RequiredRole;
import org.palladiosimulator.pcm.repository.Role;

import ConcernModel.ElementaryConcernComponent;
import edu.kit.ipd.are.dsexplore.concern.concernweaver.WeavingInstruction;
import edu.kit.ipd.are.dsexplore.concern.concernweaver.WeavingLocation;
import edu.kit.ipd.are.dsexplore.concern.exception.ConcernWeavingException;
import edu.kit.ipd.are.dsexplore.concern.exception.ErrorMessage;
import edu.kit.ipd.are.dsexplore.concern.handler.ECCStructureHandler;
import edu.kit.ipd.are.dsexplore.concern.handler.RoleHandler;
import edu.kit.ipd.are.dsexplore.concern.handler.RoleHandlerFactory;
import edu.kit.ipd.are.dsexplore.concern.util.ConcernWeaverUtil;
import edu.kit.ipd.are.dsexplore.concern.util.ConnectionInfo;
import edu.kit.ipd.are.dsexplore.concern.util.ConnectorGenerator;
import edu.kit.ipd.are.dsexplore.concern.util.ConnectorGeneratorExplorationFactory;
import edu.kit.ipd.are.dsexplore.concern.util.Pair;

public abstract class AdapterAssemblyWeaving extends AdapterWeaving {
	
	@Override
	public void weave(WeavingInstruction weavingInstruction) throws ConcernWeavingException {
		
		setAdapterAssemblyContextRegarding(weavingInstruction.getTransformationStrategy().isMultiple());
		establishConnectionTo(weavingInstruction.getECCWithConsumedFeatures());
		weaveAdapterIntoSystem(weavingInstruction.getWeavingLocation());
		
	}
	
	private void setAdapterAssemblyContextRegarding(boolean isMultiple) {
		
		if (isMultiple) {
			
			setAdapterAssemblyContext(pcmSystemManager.createAndAddAssemblyContextOf(adapter));
			
		} else {
			
			setAdapterAssemblyContext(getOrCreateAssemblyContextOf(adapter));
			
		}
		
	}
	
	private void establishConnectionTo(Pair<ElementaryConcernComponent, List<ProvidedRole>> eccAndProvidedFeatures) throws ConcernWeavingException {
		
		createConnectorsFromAdapterTo(eccAndProvidedFeatures.getSecond());
		createConnectorsFromECCToRequiredECCs(eccAndProvidedFeatures.getFirst());
		
	}
	
	private void createConnectorsFromAdapterTo(List<ProvidedRole> providedECCFeatures) throws ConcernWeavingException {
		
		AssemblyContext eccAssemblyContext = getOrCreateAssemblyContextOf((RepositoryComponent) providedECCFeatures.get(0).eContainer());
		
		for (ProvidedRole eachProvidedFeature : providedECCFeatures) {
		
			RequiredRole requiredRole = (RequiredRole) getComplimentaryRoleOf(eachProvidedFeature, getRequiredRolesOfAdapter());
			ConnectionInfo connectionInfo = new ConnectionInfo(requiredRole, eachProvidedFeature, adapterAssemblyContext, eccAssemblyContext);
			addConnector(createConnectorBy(connectionInfo));
			
		}

	}
	
	private AssemblyContext getOrCreateAssemblyContextOf(RepositoryComponent component) {
		
		Optional<AssemblyContext> result = pcmSystemManager.getAssemblyContextBy(getAssemblyContextInstantiating(component));
		if (result.isPresent()) {
			
			return result.get();
			
		}
		
		return pcmSystemManager.createAndAddAssemblyContextOf(component);
		
	}
	
	private Predicate<AssemblyContext> getAssemblyContextInstantiating(RepositoryComponent component) {
		
		return assemblyContext -> ConcernWeaverUtil.areEqual(assemblyContext.getEncapsulatedComponent__AssemblyContext(), component);
		
	}
	
	private <T extends Role> ConnectorGenerator getApplicableConnectorGeneratorBy(ConnectionInfo connectionInfo) throws ConcernWeavingException {
		
		ConnectorGeneratorExplorationFactory factory = ConnectorGeneratorExplorationFactory.getBy(pcmSystemManager);
		return factory.getApplicableConnectorGeneratorBy(connectionInfo);
		
	}
	
	private void createConnectorsFromECCToRequiredECCs(ElementaryConcernComponent ecc) throws ConcernWeavingException {

		ECCStructureHandler eccHandler = new ECCStructureHandler(ecc, concernRepositoryManager);
		for (RepositoryComponent eachComponent : eccHandler.getStructureOfECCAndRequiredAccordingTo(resolveOnlyComponents())) {
			
			createConnectorsBy(eachComponent).forEach(this::addConnector);
			
		}
		
	}
	
	private Function<RepositoryComponent, List<RepositoryComponent>> resolveOnlyComponents() {
		
		return (component) -> Arrays.asList(component);
		
	}
	
	private List<Connector> createConnectorsBy(RepositoryComponent component) throws ConcernWeavingException {
		
		AssemblyContext requiredAssemblyContext = getOrCreateAssemblyContextOf(component);
		
		List<Connector> createdConnectors = new ArrayList<Connector>();
		for (RequiredRole eachRequiredRole : component.getRequiredRoles_InterfaceRequiringEntity()) {
			
			ProvidedRole providedRole = (ProvidedRole) getComplimentaryRoleOf(eachRequiredRole, concernRepositoryManager.getAllProvidedRoles());
			AssemblyContext providedAssemblyContext = getOrCreateAssemblyContextOf((RepositoryComponent) providedRole.eContainer());
			
			ConnectionInfo connectionInfo = new ConnectionInfo(eachRequiredRole, providedRole, requiredAssemblyContext, providedAssemblyContext);
			createdConnectors.add(createConnectorBy(connectionInfo));
			
		}
		
		return createdConnectors;
		
	}
	
	protected <T extends Role> Role getComplimentaryRoleOf(Role role, List<T> complimentaryRoleSpace) throws ConcernWeavingException {
		
		return getRoleHandlerBy(role).getComplimentaryRoleOf(role, complimentaryRoleSpace)
			  			  			 .orElseThrow(() -> new ConcernWeavingException(ErrorMessage.missingComplimentaryRole((RepositoryComponent) role.eContainer(), role)));
		
	}

	private RoleHandler getRoleHandlerBy(Role role) throws ConcernWeavingException {
		
		return RoleHandlerFactory.getBy(role, concernRepositoryManager).orElseThrow(() -> new ConcernWeavingException(ErrorMessage.unsupportedRole()));
		
	}

	private Connector createConnectorBy(ConnectionInfo connectionInfo) throws ConcernWeavingException {
		
		ConnectorGenerator generator = getApplicableConnectorGeneratorBy(connectionInfo);
		return generator.createConnectorBy(connectionInfo);
		
	}
	
	protected List<RequiredRole> getRequiredRolesOfAdapter() {
		
		return adapter.getRequiredRoles_InterfaceRequiringEntity();
		
	}
	
	protected void addConnector(Connector connectorToAdd) {
		
		if (!pcmSystemManager.existConnector(connectorToAdd)) {
			
			pcmSystemManager.addConnectors(connectorToAdd);
			
		}
		
	}
	
	public abstract void weaveAdapterIntoSystem(WeavingLocation weavingLocation) throws ConcernWeavingException;
	
}
