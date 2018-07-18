package de.uka.ipd.sdq.dsexplore.analysis.cost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.opt4j.core.Criterion;
import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.ComposedStructure;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourcetype.ProcessingResourceType;
import org.palladiosimulator.solver.models.PCMInstance;

import de.uka.ipd.sdq.dsexplore.analysis.AbstractAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.PCMPhenotype;
import de.uka.ipd.sdq.dsexplore.facade.IModule;
import de.uka.ipd.sdq.dsexplore.facade.ModuleRegistry;
import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.pcm.cost.ComponentCost;
import de.uka.ipd.sdq.pcm.cost.ComponentCostPerInstance;
import de.uka.ipd.sdq.pcm.cost.Cost;
import de.uka.ipd.sdq.pcm.cost.CostRepository;
import de.uka.ipd.sdq.pcm.cost.FixedProcessingResourceCost;
import de.uka.ipd.sdq.pcm.cost.ProcessingResourceCost;
import de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost;
import de.uka.ipd.sdq.pcm.cost.costPackage;
import de.uka.ipd.sdq.pcm.cost.helper.CostUtil;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class CostEvaluator extends AbstractAnalysis implements IAnalysis {

	public CostEvaluator() {
		super(new CostSolverQualityAttributeDeclaration());
	}

	/** Logger for log4j. */
	private static Logger logger = Logger.getLogger("de.uka.ipd.sdq.dsexplore.analysis.cost");

	private List<CostRepository> costModels;

	private QesCostExtension qesModel;

	private DSEWorkflowConfiguration configuration;

	private Map<Long, CostAnalysisResult> previousCostResults = new HashMap<>();

	/**
	 * Sums up the initial cost of the PCM elements present in the given PCM
	 * instance. TODO For now, all cost in the internal costRepository are
	 * considered. Thus, only variable cost lead to a change in cost, e.g. the
	 * variable cost for changing processing rates.
	 *
	 * Careful: This must point to the right pcm instance first.
	 *
	 * @param pcmInstance
	 *            the PCM instance
	 * @return
	 */
	private double getInitialCost(PCMInstance pcmInstance) {
		List<Cost> costs = this.getCosts();
		double sum = 0;
		for (Iterator<Cost> iterator = costs.iterator(); iterator.hasNext();) {
			Cost cost = iterator.next();
			if (this.doesCostApply(cost, pcmInstance)) {
				sum += cost.getInitialCost();
			}
		}

		return sum;
	}

	/**
	 * Only checks uses in system (for components) and in the allocation (for
	 * processing resources)
	 *
	 * @param cost
	 * @param pcmInstance
	 * @return
	 */
	private boolean doesCostApply(Cost cost, PCMInstance pcmInstance) {
		if (cost instanceof VariableProcessingResourceCost) {
			VariableProcessingResourceCost vc = (VariableProcessingResourceCost) cost;
			ResourceContainer rc = (ResourceContainer) vc.getProcessingresourcespecification().eContainer();
			return this.checkWhetherResourceContainerIsUsed(pcmInstance, rc);
			// No usage of resource container found, return false.
		} else if (cost instanceof ComponentCost) {
			ComponentCost cc = (ComponentCost) cost;
			RepositoryComponent rc = cc.getRepositoryComponent();
			// List<AssemblyContext> asctx =
			// pcmInstance.getSystem().getAssemblyContexts__ComposedStructure();
			// TODO: also retrieve inner assembly contexts of deployed composite
			// components. Cost currently need to be specified separately.

			List<AssemblyContext> asctx = this.getAllContainedAssemblyContexts(pcmInstance.getSystem().getAssemblyContexts__ComposedStructure());

			for (AssemblyContext assemblyContext : asctx) {
				if (EMFHelper.checkIdentity(assemblyContext.getEncapsulatedComponent__AssemblyContext(), rc)) {
					return true;
				}
			}
			return false;
		} else if (cost instanceof FixedProcessingResourceCost) {
			FixedProcessingResourceCost fc = (FixedProcessingResourceCost) cost;
			ResourceContainer rc = (ResourceContainer) fc.getProcessingresourcespecification().eContainer();
			return this.checkWhetherResourceContainerIsUsed(pcmInstance, rc);
		} else {
			return true;
		}
	}

	/**
	 * Get all contained ones recursively
	 *
	 * @param assemblyContextsComposedStructure
	 * @return
	 */
	private List<AssemblyContext> getAllContainedAssemblyContexts(EList<AssemblyContext> assemblyContextsComposedStructure) {
		List<AssemblyContext> list = new ArrayList<>();
		list.addAll(assemblyContextsComposedStructure);
		for (AssemblyContext assemblyContext : assemblyContextsComposedStructure) {
			if (assemblyContext.getEncapsulatedComponent__AssemblyContext() instanceof ComposedStructure) {
				ComposedStructure composite = (ComposedStructure) assemblyContext.getEncapsulatedComponent__AssemblyContext();
				list.addAll(this.getAllContainedAssemblyContexts(composite.getAssemblyContexts__ComposedStructure()));
			}
		}
		return list;
	}

	private boolean checkWhetherResourceContainerIsUsed(PCMInstance pcmInstance, ResourceContainer rc) {
		List<AllocationContext> alloc = pcmInstance.getAllocation().getAllocationContexts_Allocation();
		for (AllocationContext allocationContext : alloc) {
			if (EMFHelper.checkIdentity(allocationContext.getResourceContainer_AllocationContext(), rc)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Careful: This must point to the right pcm instance first.
	 *
	 * @param pcmInstance
	 * @return
	 */
	private double getOperatingCost(PCMInstance pcmInstance) {
		double sum = 0;
		for (Cost cost : this.getCosts()) {
			if (this.doesCostApply(cost, pcmInstance)) {
				sum += cost.getOperatingCost();
			}
		}
		return sum;
	}

	private void updateCostModel(PCMInstance pcmInstance) {

		List<Cost> allCosts = this.getCosts();

		if (qesModel != null) {
            qesModel.updateModel(pcmInstance);
        }

		this.createCostsForReplicas(allCosts, pcmInstance);

		for (Cost cost : allCosts) {
			if (cost instanceof ComponentCost && qesModel != null) {
                qesModel.evaluateQesModel((ComponentCost) cost);
            }

			// fix links between model elements (maybe this is not needed
			// anymore...)
			if (cost instanceof ComponentCostPerInstance) {
				((ComponentCostPerInstance) cost).setAllocation(pcmInstance.getAllocation());
			} else if (cost instanceof VariableProcessingResourceCost) {

				VariableProcessingResourceCost varCost = (VariableProcessingResourceCost) cost;

				ProcessingResourceSpecification old_prs = ((VariableProcessingResourceCost) cost).getProcessingresourcespecification();
				ResourceContainer old_rc = (ResourceContainer) old_prs.eContainer();
				ProcessingResourceType ars = old_prs.getActiveResourceType_ActiveResourceSpecification();

				List<ResourceContainer> all_new_rcs = pcmInstance.getResourceEnvironment().getResourceContainer_ResourceEnvironment();

				for (ResourceContainer resourceContainer : all_new_rcs) {

					if (resourceContainer.getId().equals(old_rc.getId())) {

						List<ProcessingResourceSpecification> new_resources = resourceContainer.getActiveResourceSpecifications_ResourceContainer();

						boolean resourceTypeFound = false;

						for (ProcessingResourceSpecification new_prs : new_resources) {

							if (new_prs.getActiveResourceType_ActiveResourceSpecification().getId().equals(ars.getId())) {
								if (!resourceTypeFound) {
									// Reset the processing rate with the first
									// matching one found
									varCost.setProcessingresourcespecification(new_prs);
									resourceTypeFound = true;
								} else {
									throw new RuntimeException(
											"There are two processing resources with the same resource type within one resource container, this cannot be handled by the optimisation yet. Please change your model.");
								}
							}
						}
						break;
					}

					/*
					 * Resource resource = prs.eResource(); if (resource !=
					 * null){ URI oldURI = resource.getURI();
					 * resource.setURI(resEnvFileURI); } else {
					 * System.out.println
					 * ("Resource of ProcessingResourceSpecification "
					 * +prs.toString()+" has a null eResource!"); }
					 */
				}
			}
		}

	}

	/**
	 * FIXME: this should be more elegantly handled by separating a resource
	 * repository with costs specification from the actually used resources
	 *
	 * @param allCosts
	 * @param pcmInstance
	 */
	private void createCostsForReplicas(List<Cost> allCosts, PCMInstance pcmInstance) {

		List<ResourceContainer> containers = pcmInstance.getResourceEnvironment().getResourceContainer_ResourceEnvironment();
		List<Cost> replicaCosts = new ArrayList<>();

		// also remove old replica costs from previous candidates
		List<Cost> oldReplicaCosts = new ArrayList<>();

		for (Cost anyCost : allCosts) {

			// iterate through costs, look at all VariableProcessingResourceCost
			// or FixedProcessingResourceCost and in particular at their
			// resourcecontainer.
			ResourceContainer originalContainer = null;
			ProcessingResourceType procResourceType = null;
			ProcessingResourceCost cost = null;
			if (anyCost instanceof ProcessingResourceCost) {
				cost = ((ProcessingResourceCost) anyCost);
				originalContainer = cost.getProcessingresourcespecification().getResourceContainer_ProcessingResourceSpecification();
				procResourceType = cost.getProcessingresourcespecification().getActiveResourceType_ActiveResourceSpecification();
			} else {
				// look at next cost model element
				continue;
			}

			// check if this is a cost model element for a replica, if yes
			// delete it if its server is no longer in the resource environment
			if (originalContainer.getEntityName().contains("Replica") && !containers.contains(originalContainer)) {
				oldReplicaCosts.add(cost);
			}

			// find replicated servers and their original
			for (ResourceContainer resourceContainer : containers) {
				if (resourceContainer.getEntityName().contains("Replica") && resourceContainer.getId().contains(originalContainer.getId())) {
					// resourceContainer is a replica of
					// originalResourceContainer

					// check if there already is a cost model element for the
					// replica. If not, create a new one.
					boolean replicaAlreadyAnnotated = false;
					for (Cost existingCost : allCosts) {
						if (existingCost instanceof ProcessingResourceCost) {
							ProcessingResourceCost existingProcRateCost = (ProcessingResourceCost) existingCost;
							if (existingProcRateCost.getProcessingresourcespecification().getResourceContainer_ProcessingResourceSpecification().getId().equals(resourceContainer.getId())) {
								// there already is a cost model element
								// annotating this replica, so continue;
								replicaAlreadyAnnotated = true;
								break; // inner for loop
							}
						}
					}
					if (replicaAlreadyAnnotated) {
						continue;
					}

					// get the processing resource spec that corresponds to the
					// annotated one
					ProcessingResourceSpecification replicaProcSpec = null;
					for (ProcessingResourceSpecification procRes : resourceContainer.getActiveResourceSpecifications_ResourceContainer()) {
						if (procRes.getActiveResourceType_ActiveResourceSpecification().getId().equals(procResourceType.getId())) {
							replicaProcSpec = procRes;
							break;
						}
					}
					if (replicaProcSpec == null) {
						CostEvaluator.logger.warn("Could not find processing resource type " + procResourceType.getEntityName() + " in container " + resourceContainer.getEntityName()
								+ ", assuming that there are no costs for it in this replica");
						return;
					}

					// replicate cost element, too.
					ProcessingResourceCost replicaCost = EcoreUtil.copy(cost);
					replicaCost.setProcessingresourcespecification(replicaProcSpec);
					replicaCosts.add(replicaCost);
				}
			}
		}
		allCosts.removeAll(oldReplicaCosts);
		allCosts.addAll(replicaCosts);
	}

	@Override
	public void analyse(PCMPhenotype pheno, IProgressMonitor monitor) throws CoreException, UserCanceledException, JobFailedException, AnalysisFailedException {
		PCMInstance pcm = pheno.getPCMInstance();
		// Disabled by DTHF1
		// this.reloadCostModelIfNecessary();

		// Important: "Read in" the right PCM instance first.
		this.updateCostModel(pcm);

		double initialCost = this.getInitialCost(pcm);
		double operatingCost = this.getOperatingCost(pcm);
		this.previousCostResults.put(pheno.getNumericID(),
				new CostAnalysisResult(CostUtil.getTotalCost(initialCost, operatingCost, this.costModels.get(0).getInterest(), this.costModels.get(0).getTimePeriodYears()), initialCost, operatingCost,
						pcm, this.criterionToAspect, (CostSolverQualityAttributeDeclaration) this.qualityAttribute));
		CostUtil.getInstance().resetCache();
	}

	/*
	 * private void reloadCostModelIfNecessary() { try { CostRepository
	 * currentCostModel = this.getCostModel(this.configuration);
	 * EcoreUtil.resolveAll(currentCostModel.eResource()); if
	 * (this.costModelChanged(currentCostModel)) { // DTHF1 throw new
	 * RuntimeException("Currently not supported .. (and not needed)"); //
	 * this.costModel = currentCostModel;
	 *
	 * } } catch (CoreException e) { // TODO Logging return; } }
	 *
	 * private boolean costModelChanged(CostRepository currentCostModel) {
	 *
	 * for (Cost eachCost : currentCostModel.getCost()) { if (eachCost
	 * instanceof ComponentCost) { if
	 * (!this.getCosts().stream().anyMatch(this.contains((ComponentCost)
	 * eachCost))) { return true; } } } return false;
	 *
	 * }
	 *
	 * private Predicate<Cost> contains(ComponentCost givenCost) { return cost
	 * -> (cost instanceof ComponentCost) && (((ComponentCost)
	 * cost).getRepositoryComponent().getId().equals(givenCost.
	 * getRepositoryComponent().getId())); }
	 */
	@Override
	public void initialise(DSEWorkflowConfiguration configuration) throws CoreException {

		CostRepository costs = this.getCostModel(configuration);
		this.costModels = new ArrayList<>();
		Set<CostRepository> additionals = new HashSet<>();
		for (IModule module : ModuleRegistry.getModuleRegistry().getModules()) {
			additionals.addAll(module.getAnalysisExtension().getAdditionalCostRepositories());
		}
		this.costModels.add(costs);
		this.costModels.addAll(additionals);
		this.initialiseCriteria(configuration);

		this.configuration = configuration;

		this.qesModel = new QesCostExtension(configuration);
	}

	/**
	 * returns a cost model or throws an exception.
	 *
	 * @param configuration.getRawConfiguration()
	 * @return a CostRepository which is not null
	 * @throws CoreException
	 *             if the model could not be loaded.
	 */
	private CostRepository getCostModel(DSEWorkflowConfiguration configuration) throws CoreException {
		String costModelFileName = configuration.getRawConfiguration().getAttribute(DSEConstantsContainer.COST_FILE, "");
		CostRepository cr = (CostRepository) EMFHelper.loadFromXMIFile(costModelFileName, costPackage.eINSTANCE);
		if (cr == null) {
			throw new CoreException(new Status(IStatus.ERROR, "de.uka.ipd.sdq.dsexplore", 0, "Cost model " + costModelFileName + " could not be loaded.", null));
		}
		return cr;
	}

	@Override
	public List<Criterion> getCriterions() throws CoreException {
		List<Criterion> criterions = new ArrayList<>();

		criterions.addAll(this.criteriaList);

		return criterions;
	}

	@Override
	public IAnalysisResult retrieveResultsFor(PCMPhenotype pheno, Criterion criterion) throws CoreException, AnalysisFailedException {
		// It is always the cost value, i.e. objective and constraint always
		// have to refer to the SimpleValue (-> no statistical requirements atm)
		// If more possible aspects are added, the criterion needs to be
		// examined here

		return this.previousCostResults.get(pheno.getNumericID());
	}

	@Override
	public boolean hasObjectivePerUsageScenario() throws CoreException {
		return false;
	}

	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

	private List<Cost> getCosts() {
		List<Cost> res = new ArrayList<>();
		for (CostRepository cr : this.costModels) {
			res.addAll(cr.getCost());
		}
		return res;
	}

}
