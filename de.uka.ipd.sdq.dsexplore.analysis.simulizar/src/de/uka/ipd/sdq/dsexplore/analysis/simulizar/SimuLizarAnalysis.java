package de.uka.ipd.sdq.dsexplore.analysis.simulizar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.opt4j.core.Criterion;
import org.palladiosimulator.recorderframework.AbstractRecorderConfigurationFactory;
import org.palladiosimulator.recorderframework.sensorframework.SensorFrameworkRecorderConfigurationFactory;
import org.palladiosimulator.simulizar.launcher.PCMInterpreterLauncher;
import org.palladiosimulator.simulizar.launcher.jobs.PCMInterpreterRootCompositeJob;
import org.palladiosimulator.simulizar.runconfig.SimuLizarWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.analysis.AbstractAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
//import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisQualityAttributeDeclaration;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.IStatisticAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.PCMPhenotype;
import de.uka.ipd.sdq.dsexplore.exception.ExceptionHelper;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedInfeasibilityConstraint;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedObjective;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedSatisfactionConstraint;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

public class SimuLizarAnalysis extends AbstractAnalysis implements IAnalysis {
	/** Logger for log4j. */
	
	 private static Logger logger = Logger.getLogger("de.uka.ipd.sdq.dsexplore.simulizar");
	/**
	 * Store the launch parameters so that we do not have to pass them all the
	 * time.
	 */
	private ILaunchConfiguration config;

	private String initialExperimentName;
	private Map<Integer, String> previousExperimentNames = new HashMap<Integer, String>();

	private SimuComWorkflowConfiguration simuComWorkflowConfiguration;

	private int datasourceReloadCount = 1;

	public SimuLizarAnalysis() {
		super(new SimuLizarQualityAttributeDeclaration());
		// TODO Auto-generated constructor stub
	}
	private String getExperimentName(PCMPhenotype pheno) {
		return this.initialExperimentName + " " + pheno.getGenotypeID();
	}


	@Override
	public void analyse(PCMPhenotype pheno, IProgressMonitor monitor)
			throws CoreException, UserCanceledException, JobFailedException,
			AnalysisFailedException {
		 final String experimentName = getExperimentName(pheno);
	        this.previousExperimentNames.put(pheno.getGenotypeID().hashCode(), experimentName);
	        
	        ILaunchConfigurationWorkingCopy launchWorkingCopy = this.config.getWorkingCopy();
	        launchWorkingCopy.setAttribute(AbstractSimulationConfig.EXPERIMENT_RUN, experimentName);
	        this.simuComWorkflowConfiguration = new DSESimuLizarWorkflowLauncher().deriveConfiguration(launchWorkingCopy);
	        this.simuComWorkflowConfiguration.setOverwriteWithoutAsking(true);        
      /*  ILaunchConfigurationWorkingCopy launchWorkingCopy = this.config.getWorkingCopy();
        launchWorkingCopy.setAttribute(AbstractSimulationConfig.EXPERIMENT_RUN, experimentName);
                
       this.simuComWorkflowConfiguration = new DSESimuLizarWorkflowLauncher().deriveConfiguration(launchWorkingCopy);
       // this.simuComWorkflowConfiguration = new DSESimuLizarWorkflowLauncher().deriveConfiguration(this.config);
       System.out.println("hello");
        this.simuComWorkflowConfiguration.setOverwriteWithoutAsking(true);*/
        
        //this.simuComWorkflowConfiguration.getSimulationConfiguration().setNameBase(experimentName);
        //((AbstractRecorderConfigurationFactory)this.simuComWorkflowConfiguration.getSimulationConfiguration().getRecorderConfigurationFactory()).setExperimentNameAndRunName(experimentName);

        System.gc();
if (isExperimentRunDoesNotExist(experimentName)) {	
			launchSimuLizar(monitor);
		}
		
	}
	
	private void launchSimuLizar(IProgressMonitor monitor) throws CoreException, AnalysisFailedException,UserCanceledException, JobFailedException {
		// TODO Auto-generated method stub
		String featureConfigFile = this.simuComWorkflowConfiguration.getFeatureConfigFile();
		if (featureConfigFile != null && !"".equals(featureConfigFile)) {
			ResourceSetPartition pcmPartition = this.blackboard
					.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
			pcmPartition.loadModel(featureConfigFile);
		}

		PCMInterpreterRootCompositeJob job = new PCMInterpreterRootCompositeJob((SimuLizarWorkflowConfiguration) this.simuComWorkflowConfiguration);
		job.setBlackboard(blackboard);
		job.execute(monitor);
	}
	private boolean isExperimentRunDoesNotExist(String experimentName) {

		if (this.simuComWorkflowConfiguration.getSimulationConfiguration().getRecorderName().contains("sensorframework")) {

			// Every few runs the datasource needs to be reloaded because the
			// simulation will fail with OutOfmemoryError after ~300 simulations
			// otherwise
			if (this.datasourceReloadCount >= 100) {
				SensorFrameworkDataset.singleton().reload();
				this.datasourceReloadCount = 0;
			}
			this.datasourceReloadCount++;

			// Obtain DAOFactories. Search in any open data source.
			Collection<IDAOFactory> daoFactoryCollection = SensorFrameworkDataset
					.singleton().getDataSources();

			for (IDAOFactory daoFactory : daoFactoryCollection) {

				Experiment experiment;
				// Find an existing or create a new Experiment
				Collection<Experiment> experimentSet = daoFactory
						.createExperimentDAO().findByExperimentName(
								experimentName);

				if (experimentSet.size() > 0) {
					experiment = experimentSet.iterator().next();

					if (experiment.getExperimentRuns().size() > 0) {
						return false;
					}

				}
			}

		}
		return true;
	}
	
	/*
	 * 
	 */

	@Override
	public void initialise(DSEWorkflowConfiguration configuration)
			throws CoreException {
		this.previousExperimentNames.clear();

        this.config = configuration.getRawConfiguration();
        if (blackboard == null){
            throw ExceptionHelper.createNewCoreException("Error in initialisation: No Blackboard was set when initialising the SimuLizar Analysis. Contact the developers.");
        }

        this.initialExperimentName = this.config.getAttribute(SimuComConfig.EXPERIMENT_RUN, "");

        //		this.objectives = new ArrayList<Objective>(scenarios.size());
        //		for (UsageScenario usageScenario : scenarios) {
        //			objectives.add(new UsageScenarioBasedObjective(this.getQualityAttribute(), Objective.Sign.MIN, usageScenario));
        //		}

        initialiseCriteria(configuration);		
	}
	
	

	@Override
	public IAnalysisResult retrieveResultsFor(PCMPhenotype pheno,
			Criterion criterion) throws CoreException, AnalysisFailedException {
		if (criterion instanceof UsageScenarioBasedObjective) {
			return this.retrieveSimuComResults(pheno,
					((UsageScenarioBasedObjective) criterion)
							.getUsageScenario());
		} else if (criterion instanceof UsageScenarioBasedInfeasibilityConstraint) {
			// Handle constraint here
			// As the mean is default (for the value as well as the evaluation
			// aspect of the constraint), no further action is required
			// We allowed only mean constraint during the initialization

			return this.retrieveSimuComResults(pheno,
					((UsageScenarioBasedInfeasibilityConstraint) criterion)
							.getUsageScenario());
		} else if (criterion instanceof UsageScenarioBasedSatisfactionConstraint) {
			// Handle constraint here
			// As the mean is default (for the value as well as the evaluation
			// aspect of the constraint), no further action is required
			// We allowed only mean constraint during the initialization

			return this.retrieveSimuComResults(pheno,
					((UsageScenarioBasedSatisfactionConstraint) criterion)
							.getUsageScenario());
		}
		throw new CoreException(
				new Status(
						Status.ERROR,
						"de.uka.ipd.sdq.dsexplore.analysis.simulizar",
						"Cannot handle Criterion of type "
								+ criterion.getClass()
								+ ". Required is UsageScenarioBasedObjective or UsageScenarioBasedConstraint."));
	}
	

private IStatisticAnalysisResult retrieveSimuComResults(PCMPhenotype pheno,
		UsageScenario usageScenario) throws CoreException,
		AnalysisFailedException {

    final String experimentName = this.previousExperimentNames.get(pheno.getGenotypeID().hashCode());
    final PCMResourceSetPartition pcmPartition = (PCMResourceSetPartition)this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
    final PCMInstance pcmInstance = new PCMInstance(pcmPartition);

    IStatisticAnalysisResult result = null;
    final int selectedDataSourceID =
            config.getAttribute(
                    SensorFrameworkRecorderConfigurationFactory.DATASOURCE_ID, -1);

    // try the configured data source first.
    final IDAOFactory factory = SensorFrameworkDataset.singleton().getDataSourceByID(selectedDataSourceID);
    if (factory != null){
        result = findExperimentRunAndCreateResult(usageScenario,
                experimentName, pcmInstance, factory);
    }

    if (result == null){
        // try all other open data sources.
        final Collection<IDAOFactory> daoFactories = SensorFrameworkDataset.singleton().getDataSources();
        for (final IDAOFactory idaoFactory : daoFactories) {
            if (idaoFactory == factory){
                // we tried this one already
                continue;
            }
            result = findExperimentRunAndCreateResult(usageScenario,
                    experimentName, pcmInstance, idaoFactory);

            if (result != null){
                logger.warn("Found matching experiment run for this candidate in data source "+idaoFactory.getName()+" "+idaoFactory.getDescription()+"(id: "+idaoFactory.getID()+"), using it as the result for this candidate. Unload all other data sources and restart the optimisation if this is not correct. Candidate: "+pheno.getNumericID()+" "+pheno.getGenotypeID());
                break;
            }
        }
    }


    if (result == null){
        final String errormessage = "There was no experiment run or no experiment for experiment named \""
                +experimentName+"\" in any available data source after analysing the PCM instance \""
                +experimentName+"\" of candidate "+pheno.getNumericID()+" "+pheno.getGenotypeID();
        logger.error(errormessage);
        throw new AnalysisFailedException(errormessage);
    }

    return result;
}

private IStatisticAnalysisResult findExperimentRunAndCreateResult(
		UsageScenario usageScenario, String experimentName,
		PCMInstance pcmInstance, IDAOFactory factory)
		throws AnalysisFailedException {
	IStatisticAnalysisResult result = null;
	// XXX: Quick fix: Assume that there is just one experiment with the
	// name of the current PCM instance.
	// Iterator<Experiment> it =
	// factory.createExperimentDAO().findByExperimentName(experimentName
	// +" RunNo. "+config.getAttribute(ConstantsContainer.RUN_NO,
	// "0")).iterator();
	Iterator<Experiment> it = factory.createExperimentDAO()
			.findByExperimentName(experimentName).iterator();
	if (it.hasNext()) {
		Experiment resultingExperiment = it.next();
		Collection<ExperimentRun> runs = resultingExperiment
				.getExperimentRuns();
		if (runs.size() > 0) {
			ExperimentRun myrun = getLatestRun(runs);
			result = new SimuLizarAnalysisResult(myrun,resultingExperiment,pcmInstance,usageScenario,this.criterionToAspect, (SimuLizarQualityAttributeDeclaration) this.qualityAttribute);
		}
	}
	return result;
}

/**
 * Get the latest Run from the {@link Collection} based on the getExperimentDateTime()
 * value.
 * @param runs A collection of {@link ExperimentRun}
 * @return The latest run or the first in the collection if timestamps
 * cannot properly be parsed.
 */
private ExperimentRun getLatestRun(final Collection<ExperimentRun> runs) {
    final Iterator<ExperimentRun> iterator = runs.iterator();
    ExperimentRun latest = iterator.next();
    //FIXME: Due to Bug 395, I cannot get the order of ExperimentRuns.
    //Quickfix: Extract it from the (nasty) ExperimentDateTime String as a long.
    long dateLatest = extractTimestamp(latest.getExperimentDateTime());
    for (; iterator.hasNext();) {
        final ExperimentRun experimentRun = iterator.next();
        logger.debug("Looking at run "+experimentRun.getExperimentDateTime());
        final long runDate = extractTimestamp(experimentRun.getExperimentDateTime());
        if (dateLatest < runDate){
            latest = experimentRun;
            dateLatest = runDate;
        }
    }
    logger.debug("Latest run: "+latest.getExperimentDateTime());
    return latest;
}

//FIXME: use constant from AbstractRecorderConfigurationFactory.EXPERIMENT_RUN_DATE_FORMAT
// as soon as the Recorderframework build has been fixed. 
public static final String EXPERIMENT_RUN_DATE_FORMAT = "yyyy/MM/dd HH:mm:ss:SSS";



private long extractTimestamp(String experimentDateTime) {
	
	// FIXME: use constant from AbstractRecorderConfigurationFactory as soon as the Recorderframework build has been fixed. 
	//SimpleDateFormat dateFormat = new SimpleDateFormat(EXPERIMENT_RUN_DATE_FORMAT);
    SimpleDateFormat dateFormat = new SimpleDateFormat(AbstractRecorderConfigurationFactory.EXPERIMENT_RUN_DATE_FORMAT);
	try {
		return dateFormat.parse(experimentDateTime).getTime();
	} catch (ParseException e) {
		logger.error("Cannot parse sensorframework experiment run String");
		e.printStackTrace();
		return 0;
	}
	
	//return Date.parse(experimentDateTime);

    /*//Cut the "Run " part.
    experimentDateTime = experimentDateTime.substring(4);
    final String[] experimentDateTimeArray = experimentDateTime.split(" ");
    final String month = experimentDateTimeArray[1];

    //This is stupid, but what else to do with the nasty string...
    int monthNo = 0;
    if (month.equals("Jan")){
        monthNo = 1;
    } else if (month.equals("Feb")){
        monthNo = 2;
    } else if (month.equals("Mar")){
        monthNo = 3;
    } else if (month.equals("Apr")){
        monthNo = 4;
    } else if (month.equals("May")){
        monthNo = 5;
    } else if (month.equals("Jun")){
        monthNo = 6;
    } else if (month.equals("Jul")){
        monthNo = 7;
    } else if (month.equals("Aug")){
        monthNo = 8;
    } else if (month.equals("Sep")){
        monthNo = 9;
    } else if (month.equals("Oct")){
        monthNo = 10;
    } else if (month.equals("Nov")){
        monthNo = 11;
    } else {
        monthNo = 12;
    }

    final int day = Integer.parseInt(experimentDateTimeArray[2]);
    final String[] time = experimentDateTimeArray[3].split(":");
    final int hour = Integer.parseInt(time[0]);
    final int minute = Integer.parseInt(time[1]);
    final int second = Integer.parseInt(time[2]);
    final int year = Integer.parseInt(experimentDateTimeArray[5]);

    //The date in seconds since year 0.
    final long date = (((((year * 12) + monthNo) * 31 + day)* 24 + hour)*60 + minute ) * 60 + second;

    return date;*/
}




	@Override
	public boolean hasStatisticResults() throws CoreException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasObjectivePerUsageScenario() throws CoreException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		// TODO Auto-generated method stub
		this.blackboard = blackboard;
	}

}

class DSESimuLizarWorkflowLauncher extends PCMInterpreterLauncher {

	public SimuComWorkflowConfiguration deriveConfiguration(
			ILaunchConfiguration config) throws CoreException {
		return super.deriveConfiguration(config, ILaunchManager.RUN_MODE);

	}

}
