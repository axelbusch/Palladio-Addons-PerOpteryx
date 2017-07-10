package edu.kit.ipd.are.dsexplore.analysis.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.opt4j.core.Criterion;
import org.palladiosimulator.pcm.core.composition.AssemblyConnector;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.Connector;
import org.palladiosimulator.pcm.system.System;
import org.palladiosimulator.solver.models.PCMInstance;

import de.uka.ipd.sdq.dsexplore.analysis.AbstractAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.PCMPhenotype;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import edu.kit.ipd.are.dsexplore.analysis.security.model.Attacker;
import edu.kit.ipd.are.dsexplore.analysis.security.model.Component;
import edu.kit.ipd.are.dsexplore.analysis.security.model.Scenario;

public class SecurityEvaluator extends AbstractAnalysis implements IAnalysis {

	/** Logger for log4j. */
	private static Logger logger = Logger.getLogger("edu.kit.ipd.are.dsexplore.analysis.security");

	private final Map<Long, SecurityAnalysisResult> previousSecurityResults = new HashMap<Long, SecurityAnalysisResult>();

	public SecurityEvaluator() {
		super(new SecuritySolverQualityAttributeDeclaration());
	}

	@Override
	public void analyse(final PCMPhenotype pheno, final IProgressMonitor monitor)
			throws CoreException, UserCanceledException, JobFailedException, AnalysisFailedException {
		final PCMInstance pcm = pheno.getPCMInstance();
		final System system = pcm.getSystem();

		// get attakc entry vector length
		int atk_entry_length = system.getProvidedRoles_InterfaceProvidingEntity().size();

		// create a map with AssemblyContexts as keys,
		// values are AssemblyContexts they are connected to (requiring)
		List<Connector> connectors = system.getConnectors__ComposedStructure();
		Map<AssemblyContext, List<AssemblyContext>> assMap = new HashMap<>();
		for (AssemblyContext assContext : system.getAssemblyContexts__ComposedStructure()) {
			List<AssemblyContext> targets = this.getRequiringAssemblyContexts(assContext, connectors); // TODO
			assMap.put(assContext, targets);
		}

		// list of all components
		List<Component> components = this.createComponents(assMap.keySet());
		// get theta matrix
		int[][] theta = this.getTheta(assMap);
		// create scenario and calc the MTTSF
		Scenario scenario = new Scenario(theta, components.toArray(new Component[0]));
		final int mySecurityValue = (int) scenario.calcMTTSF(atk_entry_length, this.getAttacker());
		logger.debug(mySecurityValue);

		final int securityValue = (int) this.calcMTTSF_Scen1();

		// write out Results
		this.previousSecurityResults.put(pheno.getNumericID(), new SecurityAnalysisResult(securityValue, pcm,
				this.criterionToAspect, (SecuritySolverQualityAttributeDeclaration) this.qualityAttribute));
	}

	private List<AssemblyContext> getRequiringAssemblyContexts(AssemblyContext assContext, List<Connector> connectors) {
		List<AssemblyContext> targets = new ArrayList<>();
		// go through each connector
		for (Connector connector : connectors) {
			// check type of Connector and if connector is connected to the
			// provided AssemblyContext. If so, add it to return list.
			if (connector instanceof AssemblyConnector) {
				AssemblyConnector assConnector = (AssemblyConnector) connector;
				if (assConnector.getRequiringAssemblyContext_AssemblyConnector().equals(assContext)) {
					targets.add(assConnector.getProvidingAssemblyContext_AssemblyConnector());
				}
			}
		}
		return targets;
	}

	private List<Component> createComponents(Set<AssemblyContext> assSet) {
		List<Component> components = new ArrayList<>();
		for (AssemblyContext assContext : assSet) {
			Component.Builder component = new Component.Builder().name(assContext.getEntityName());
			component.TTDV(200); // TODO
			component.PoCoB(0.2); // TODO
			components.add(component.build());
		}
		return components;
	}

	private Attacker getAttacker() {
		return new Attacker(0.01, 100, 200); // TODO
	}

	private int[][] getTheta(Map<AssemblyContext, List<AssemblyContext>> assMap) {
		int theta_size = assMap.keySet().size() + 1;
		int[][] theta = new int[theta_size][theta_size];
		List<AssemblyContext> assList = new ArrayList<>(assMap.keySet());
		for (int i = 0; i < assList.size(); i++) {
			AssemblyContext assContext = assList.get(i);
			for (AssemblyContext reqAssContext : assMap.get(assContext)) {
				int reqIndex = assList.indexOf(reqAssContext);
				theta[i][reqIndex] += 1;
			}

		}
		// TODO what about multiple ways etc
		// logger.debug(Arrays.deepToString(theta));
		return theta;
	}

	private double calcMTTSF_Scen1() { // TODO: Delete later
		int[][] theta = new int[6][6];
		theta[0][2] = 1;
		theta[1][3] = 1;
		theta[2][3] = 1;
		theta[3][4] = 2;
		theta[4][5] = 2;

		Component[] components = new Component[5];
		components[0] = new Component.Builder().TTDV(200).PoCoB(0.2).build();
		components[1] = new Component(250, 0.3);
		components[2] = new Component(125, 0.4);
		components[3] = new Component(150, 0.2);
		components[4] = new Component(300, 0.2);

		Attacker a = this.getAttacker();
		Scenario s = new Scenario(theta, components);
		return s.calcMTTSF(2, a);
	}

	@Override
	public void initialise(final DSEWorkflowConfiguration configuration) throws CoreException {
		logger.debug("hi from initialise()");
		this.initialiseCriteria(configuration);
	}

	@Override
	public boolean hasStatisticResultsFor() throws CoreException {
		return false;
	}

	@Override
	public IAnalysisResult retrieveResultsFor(final PCMPhenotype pheno, final Criterion criterion)
			throws CoreException, AnalysisFailedException {
		// It is always the cost value, i.e. objective and constraint always have to refer to the
		// SimpleValue (-> no statistical requirements atm)
		// If more possible aspects are added, the criterion needs to be examined here

		return this.previousSecurityResults.get(pheno.getNumericID());
	}

	@Override
	public boolean hasObjectivePerUsageScenario() throws CoreException {
		return false;
	}

	@Override
	public void setBlackboard(final MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

}
