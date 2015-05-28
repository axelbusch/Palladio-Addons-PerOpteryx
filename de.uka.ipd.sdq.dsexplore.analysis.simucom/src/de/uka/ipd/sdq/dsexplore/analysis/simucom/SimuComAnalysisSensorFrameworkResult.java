package de.uka.ipd.sdq.dsexplore.analysis.simucom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.math.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math.stat.descriptive.moment.Mean;
import org.apache.commons.math.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math.stat.descriptive.rank.Max;
import org.apache.commons.math.stat.descriptive.rank.Median;
import org.apache.commons.math.stat.descriptive.rank.Min;
import org.eclipse.emf.common.util.EList;
import org.opt4j.core.Criterion;
import org.palladiosimulator.edp2.impl.RepositoryManager;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;
import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.recorderframework.sensorframework.DatasourceConfigurationInvalidException;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.AbstractPie;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.PieEntity;
import de.uka.ipd.sdq.dsexplore.analysis.AbstractPerformanceAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IStatisticAnalysisResult;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.EvaluationAspectWithContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorFactory;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ServiceResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.adapter.StateSensorToPieAdapter;
import de.uka.ipd.sdq.sensorframework.adapter.StateSensorToTimeDeltaPieAdapter;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.statistics.PhiMixingBatchAlgorithm;
import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;
import de.uka.ipd.sdq.statistics.estimation.SampleMeanEstimator;

public class SimuComAnalysisSensorFrameworkResult extends SimuComAnalysisResult {
	
	// SensorFramework-specific attributes pushed down from superclass
	private Experiment experiment;
	private ExperimentRun run;
	
	public SimuComAnalysisSensorFrameworkResult(ExperimentRun run, Experiment experiment, PCMInstance pcmInstance, 
			UsageScenario usageScenario, Map<Criterion, EvaluationAspectWithContext> objectiveToAspect,
			SimuComQualityAttributeDeclaration qualityAttributeInfo) 
	throws AnalysisFailedException {
		super(pcmInstance);
		
		this.experiment = experiment;
		this.run = run;
		
		this.usageScenarioName = usageScenario.getEntityName(); //.replaceAll(" ", "_");
		
		this.objectiveToAspects = objectiveToAspect;
		this.qualityAttributeInfo = qualityAttributeInfo;
		
		this.results =  retrieveResults(pcmInstance);
		this.maxUtilization = calculateMaxUtil("CPU");
		
		SensorAndMeasurements sam = getUsageScenarioMeasurements();
		this.meanValue =  calculateUnivariateStatistic(sam, TimeseriesData.TIMESPAN, new Mean());
		this.stdDeviation = calculateUnivariateStatistic(sam, TimeseriesData.TIMESPAN, new StandardDeviation());
		this.medianValue = calculateUnivariateStatistic(sam, TimeseriesData.TIMESPAN, new Median());
		this.throughput = calculateThroughput(sam);
		this.observations = sam.getMeasurements().size();
		this.confidenceInterval = determineConfidenceInterval(sam);
		
		logger.debug("Initialised SimuCom result");
	}
	
    /**
     * Tries to find a matching experiment run in all data sources available. If a matching experiment run
     * is found, <code>true</code>. If not, <code>false</code> is returned.
     * @param experimentName The experiment name to match
     * @param workflowConfig
     * @param datasourceReloadCount
     * @return <code>true</code> if experiment has been found, <code>false</code> otherwise
     */
	static public boolean isExperimentRunExisting(final String experimentName, SimuComWorkflowConfiguration workflowConfig, int datasourceReloadCount) 
	{
		// IRecorderConfiguration recorderConfig = this.simuComWorkflowConfiguration.getSimulationConfiguration().getRecorderConfig();

        if (workflowConfig.getSimulationConfiguration().getRecorderName().toLowerCase().contains("sensorframework")){

            // Every few runs the datasource needs to be reloaded because the simulation will fail with OutOfmemoryError after ~300 simulations otherwise
            if (datasourceReloadCount >= 100 ){
                SensorFrameworkDataset.singleton().reload();
                datasourceReloadCount = 0;
            }
            datasourceReloadCount++;

            // Obtain DAOFactories. Search in any open data source.
            final Collection<IDAOFactory> daoFactoryCollection = SensorFrameworkDataset.singleton().getDataSources();

            for (final IDAOFactory daoFactory : daoFactoryCollection) {
                if (daoFactory == null) {
                    throw new DatasourceConfigurationInvalidException();
                }

                Experiment experiment;
                // Find an existing or create a new Experiment
                final Collection<Experiment> experimentSet = daoFactory.createExperimentDAO().findByExperimentName(experimentName);

                if (experimentSet.size() > 0){
                    experiment = experimentSet.iterator().next();

                    if (experiment.getExperimentRuns().size() > 0 && experiment.getSensors().size() > 0 ){
                        return true;
                    }

                }
            }

        }
        return false;
	}
	
	/**
	  * Tries to find a matching experiment run in the passed data source (via the passed <code>factory</code>). If a matching experiment run
	  * is found, a new {@link IStatisticAnalysisResult} is created for it. If not, <code>null</code> is returned.
	  * @param usageScenario The usage scenario to determine the response time values for.
	  * @param experimentName The experiment name to match
	  * @param pcmInstance The PCM instance to get the available resources and retrieve utilisation values.
	  * @param factory The access to the data source.
	  * @param criterionToAspect
      * @param qualityAttribute
	  * @return The instantiated {@link IStatisticAnalysisResult} for this experiment name, or <code>null</code> if no matching experiment run could be found.
	  * @throws AnalysisFailedException
	  */
	 public static IStatisticAnalysisResult findExperimentRunAndCreateResult(
	         final UsageScenario usageScenario, final String experimentName,
	         final PCMInstance pcmInstance,
	         final IDAOFactory factory,
	         Map<Criterion, EvaluationAspectWithContext> criterionToAspect,
	         SimuComQualityAttributeDeclaration qualityAttribute
	         ) throws AnalysisFailedException {
	     IStatisticAnalysisResult result = null;
	     //XXX: Quick fix: Assume that there is just one experiment with the name of the current PCM instance.
	     //Iterator<Experiment> it = factory.createExperimentDAO().findByExperimentName(experimentName
	     //		+" RunNo. "+config.getAttribute(ConstantsContainer.RUN_NO, "0")).iterator();
	     final Iterator<Experiment> it = factory.createExperimentDAO().findByExperimentName(experimentName).iterator();
	     if (it.hasNext()){
	         final Experiment resultingExperiment = it.next();
	         final Collection<ExperimentRun> runs = resultingExperiment.getExperimentRuns();
	         if (runs.size() > 0){
	             final ExperimentRun myrun = getLatestRun(runs);
	             result = new SimuComAnalysisSensorFrameworkResult(myrun, resultingExperiment, pcmInstance, usageScenario, criterionToAspect, qualityAttribute);
	         }
	     }
	     return result;
	 }
 
	private double calculateUnivariateStatistic(SensorAndMeasurements sam, TimeseriesData timespan, UnivariateStatistic stat) {
		double[] measurements = measurementsToDoubleArray(sam, timespan);
		return stat.evaluate(measurements);
	}
	
	private SensorAndMeasurements getUsageScenarioMeasurements() throws AnalysisFailedException{
		//Get usage scenario sensor. 
		Sensor respTimeSensor = getSensorForUsageScenario(experiment, this.usageScenarioName);
		if (respTimeSensor != null){
			return run.getMeasurementsOfSensor(respTimeSensor);
			
		} else 
			throw new AnalysisFailedException("Could not find sensor for usage scenario "+this.usageScenarioName);
	}
    
    /**
     * Get the latest Run from the {@link Collection} based on the getExperimentDateTime()
     * value.
     * @param runs A collection of {@link ExperimentRun}
     * @return The latest run or the first in the collection if timestamps
     * cannot properly be parsed.
     */
    private static ExperimentRun getLatestRun(final Collection<ExperimentRun> runs) {
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
    
    /**
     * Extract time stamps from the experimentDateTime string. This is just a
     * QuickFix because {@link ExperimentRun}s currently do not store their
     * time properly.
     *
     * Delete this method after Bug 395 is fixed.
     *
     * @param experimentDateTime
     * @return The {@link Date} of the {@link ExperimentRun}
     */
    private static long extractTimestamp(final String experimentDateTime) {

        // FIXME: use constant from AbstractRecorderConfigurationFactory as soon as the Recorderframework build has been fixed.
        final SimpleDateFormat dateFormat = new SimpleDateFormat(EXPERIMENT_RUN_DATE_FORMAT);
        //SimpleDateFormat dateFormat = new SimpleDateFormat(AbstractRecorderConfigurationFactory.EXPERIMENT_RUN_DATE_FORMAT);
        try {
            return dateFormat.parse(experimentDateTime).getTime();
        } catch (final ParseException e) {
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
    
	private double calculateThroughput(SensorAndMeasurements sam) throws AnalysisFailedException {
		int numberOfMeasurements = sam.getMeasurements().size();
		// we assume that the last entry is the duration.
		// still, no way to get the maximum time... because this is a collection.
		double duration = calculateUnivariateStatistic(sam, TimeseriesData.EVENTTIME, new Max()) - calculateUnivariateStatistic(sam, TimeseriesData.EVENTTIME, new Min());
		
		return numberOfMeasurements / duration;
	}
	
	// Extracted from retrieveServiceResults in superclass
	protected void retrieveServiceResultsFinish(PCMInstance pcmInstance, ResultDecoratorRepository repo, 
			HashMap<String, ExternalCallAction> idToExternalCallMap,
			Map<String, AssemblyContextContext> idToAssemblyContextMap,
			List<String> completionComponentIdsToIgnore)
	{
		Collection<Sensor> sensorList = this.experiment.getSensors();
		List<ExternalCallActionWithSensors> externalCallsInContextWithSensorsList = new LinkedList<ExternalCallActionWithSensors>();
		
		for (Sensor sensor : sensorList) {
			String sensorName = sensor.getSensorName();
			if (sensorName.contains("CallID")){
				//current sensor is an ExternalCall sensor
				
				// parse external call id
				if (sensorName.lastIndexOf(" ") < sensorName.length()-2 
						&& sensorName.lastIndexOf(" ") > -1
						&& sensorName.length() > 2){
					String externalCallID = sensorName.substring(sensorName.lastIndexOf(" ")+1, sensorName.length()-1);
				
					// 	find the external call in the model
					ExternalCallAction myCall = idToExternalCallMap.get(externalCallID);
				
					if (myCall != null){
						
						//retrieve AssemblyContext from sensor name
						String assemblyContextID = sensorName.substring(sensorName.indexOf("AssemblyCtx")+13,sensorName.indexOf("CallID")-2);
						AssemblyContextContext myAssemblyContext = idToAssemblyContextMap.get(assemblyContextID);
						if (myAssemblyContext != null){
							
							ExternalCallActionWithSensors externalCallInContextWithSensors = new ExternalCallActionWithSensors(myCall, myAssemblyContext);
							
							//reuse pair if it already there
							int index = externalCallsInContextWithSensorsList.indexOf(externalCallInContextWithSensors);
							if (index > 0){
								externalCallInContextWithSensors = externalCallsInContextWithSensorsList.get(index);
							} else {
								externalCallsInContextWithSensorsList.add(externalCallInContextWithSensors);
							}
						
							// map all result sensors to the SEFF they call
							externalCallInContextWithSensors.addSensor(sensor);
							continue;
						} 
					} else {
						// check if this is a completion component, if yes, ignore it and continue
						String componentID = sensorName.substring(sensorName.indexOf("Component: ")+11,sensorName.indexOf("AssemblyCtx")-2);
						if (completionComponentIdsToIgnore.contains(componentID)){
							logger.info("Ignoring completion component sensor "+sensorName+" when reading in SimuCom results.");
							continue;
						}
					} 
				}
				logger.warn("Cannot retrieve external call id from sensor. If this is a completion component, this is ok. Otherwise, sensor name labels must have changed. Contact developers if this sensors is needed. Sensor: "+sensorName);
			} 
			
		}
		
		//FIXME: This all does not work if composite components themselves are used several times in the system, because then, the  AssemblyContexts of the inner components will not be unique anymore.  
		
		// get the average time for the SEFFs (careful: contains network)
		// by getting the data of the chosen sensors from this.run
		
		for (ExternalCallActionWithSensors externalCallActionWithSensors : externalCallsInContextWithSensorsList) {
			List<Sensor> mySensors = externalCallActionWithSensors.getSensors();
			
			if (mySensors.size() > 0){
			
				//	create service result
				ServiceResult myServiceResult = RepositorydecoratorFactory.eINSTANCE.createAllocationServiceResult();
			
				//get SEFF for external call
				
				ContextWrapper contextWrapper = new ContextWrapper(pcmInstance);
				//set the AssemblyContext hierarchy
				List<AssemblyContext> assemblyContextHierarchy = new ArrayList<AssemblyContext>(4);
				AssemblyContextContext currentContext = externalCallActionWithSensors.getAssemblyContext();
				while (currentContext != null) {
					assemblyContextHierarchy.add(currentContext.getAssemblyContext());
					currentContext = currentContext.getParentAssemblyContext();
				}
				//the currentContext needs to be last in the list.
				Collections.reverse(assemblyContextHierarchy);
				contextWrapper.setAssCtxList(assemblyContextHierarchy);
				
				ServiceEffectSpecification seff = contextWrapper.getNextSEFF(externalCallActionWithSensors.getExternalCall());
				
				myServiceResult.setServiceEffectSpecification_ServiceResult(seff);
				
				double weightedAndCumulatedMeanResponseTime = 0;
				int totalNumberOfMeasurements = 0;
				
				for (Sensor sensor : mySensors) {
					 SensorAndMeasurements results = run.getMeasurementsOfSensor(sensor);
					 Collection<Measurement> measurements = results.getMeasurements();
					 totalNumberOfMeasurements += measurements.size();
					 weightedAndCumulatedMeanResponseTime += calculateUnivariateStatistic(results, TimeseriesData.TIMESPAN, new Mean()) * totalNumberOfMeasurements;
					 
				}
				double meanResponseTime = weightedAndCumulatedMeanResponseTime / totalNumberOfMeasurements;
				myServiceResult.setMeanResponseTime(meanResponseTime);
				
				repo.getServiceResult_ResultDecoratorRepository().add(myServiceResult);
				
			}
		
		}
	}
	
	// Extracted from retrievePassiveResourceUtil in superclass
	protected Map<String, PassiveResourceResult> retrievePassiveResourceUtilFinish(Map<String, PassiveResourceResult> idsToPassiveResourceResult)
	{
		Collection<Sensor> sensorList = this.experiment.getSensors();
		
		for (Sensor sensor : sensorList) {
			String sensorName = sensor.getSensorName();
			if (sensorName.contains("Passive Resource")){
				String passiveResourceAndAssemblyContextID = sensorName.substring(sensorName.lastIndexOf(" ")+1);
				PassiveResourceResult passiveResourceResult = idsToPassiveResourceResult.get(passiveResourceAndAssemblyContextID);
				
				if (passiveResourceResult != null){
				
					SensorAndMeasurements results = run.getMeasurementsOfSensor(sensor);
	
					if (sensorName.contains("Hold time")){
						passiveResourceResult.setAverageHoldingTime(calculateUnivariateStatistic(results, TimeseriesData.TIMESPAN, new Mean()));
					} else if (sensorName.contains("Wait time")){
						passiveResourceResult.setAverageWaitTime(calculateUnivariateStatistic(results, TimeseriesData.TIMESPAN, new Mean()));
					} else if (sensorName.contains("Util")){
						// for passive resources, also consider the capacity when calculating the util
						int capacity = Integer.parseInt(passiveResourceResult.getPassiveResource_PassiveResourceResult().getCapacity_PassiveResource().getSpecification());
						retrieveUtilisationFromSensor(sensor, passiveResourceResult, capacity);
						 
					}
				} else {
					logger.warn("Unknown passive resource id "+passiveResourceAndAssemblyContextID+", ignoring this sensor.");
				}
			}
			
		}
		
		return idsToPassiveResourceResult;
	}
	
	// Moved from superclass
	/**
	 * 
	 * @param sensor
	 * @param result
	 * @param capacity The capacity of the resource, will divide busyFraction by this number to 
	 */
	private void retrieveUtilisationFromSensor(Sensor sensor,
			UtilisationResult result, int capacity) {
				SensorAndMeasurements sam = run.getMeasurementsOfSensor(sensor);
				double busyFraction = 0;
				
		double totalTime = 0;
		double weightedSumOfJobs = 0;
		
				if (sam.getMeasurements().size() > 0){
					StateSensorToPieAdapter dataAdapter = new StateSensorToTimeDeltaPieAdapter(
							sam);
					AbstractPie pie = (AbstractPie) dataAdapter.getAdaptedObject();
					Collection<PieEntity> pieParts = pie
							.getEntities(Integer.MAX_VALUE);
					double totalIdleTime = 0;
					// 	I need to sum up all pie parts to get the 100% comparison
				
					double totalWeights = 0;
					int maxNumberOfJobs = 0;
				
					for (Iterator<PieEntity> iterator = pieParts.iterator(); iterator
					.hasNext();) {
						PieEntity pieEntity = iterator.next();
						totalTime += pieEntity.getValue();
						totalWeights += pieEntity.getValue();

						if (pieEntity.getLabel().contains("Idle")) {
							// this returns a large number > 399
							totalIdleTime = pieEntity.getValue();
						} else {
					String[] busyLabel = pieEntity.getLabel().split(" ");
						if (busyLabel.length > 1){
						try {
							String numberOfJobsString = busyLabel[1];
							int noOfJobs = Integer.parseInt(numberOfJobsString);
							totalWeights += pieEntity.getValue();
							weightedSumOfJobs += noOfJobs * pieEntity.getValue();
							if (noOfJobs > maxNumberOfJobs){
								maxNumberOfJobs = noOfJobs;
							}
						} catch (Exception e){
							logger.warn("Cannot read in queue lengths, labels of the pie chart may have changed.");
						}
						} else {
							logger.warn("Cannot read in queue lengths, labels of the pie chart may have changed.");
						}
				}

					}
					busyFraction = (1 - (totalIdleTime / totalTime));
			//queue length including the active job.
					result.setAverageQueueLength(weightedSumOfJobs / totalWeights);
					result.setMaxQueueLength(maxNumberOfJobs);
				}
		if (capacity == 1){
				result.setResourceUtilisation(busyFraction);
		} else if (totalTime > 0){
			/* if capacity is larger than 1 (for passive resources), calculate
			   the interval below the line of current resource usage, which is 
			   for each level of usage (noOfJobs) the time that it is active (x axis)
			   times the noOfJobs. Thus, this corresponds to the weightedSumOfJobs value.
			   Then divide by totalTime * capacity which is the maximum utilisation.
			   A value of 100% then means that all free resources have been used all the time. 
			*/
			double util = weightedSumOfJobs / (totalTime * capacity);
			result.setResourceUtilisation(util);
			} 
	}
	
	private ConfidenceInterval determineConfidenceInterval(SensorAndMeasurements sam) throws AnalysisFailedException {
		ConfidenceInterval ci = null;
		Sensor sensor = sam.getSensor();
		if (sensor instanceof TimeSpanSensor){
			PhiMixingBatchAlgorithm statisticChecker = new PhiMixingBatchAlgorithm();
						
			for (Measurement m : sam.getMeasurements()) {
				TimeSpanMeasurement t = (TimeSpanMeasurement)m;
				statisticChecker.offerSample(t.getTimeSpan());
			}
			if (statisticChecker.hasValidBatches()){
				ci = new SampleMeanEstimator().estimateConfidence(statisticChecker.getBatchMeans(),this.alpha);
			} 
			if (ci == null) {
				ci = new ConfidenceInterval(Double.NaN, 0, Double.POSITIVE_INFINITY, this.alpha);
			}
			return ci;
		} else {
			logger.error("Sensor of usage scenario is not a time span sensor, cannot calculate statistics.");
			return null;
		}
	}
	
	private static Sensor getSensorForUsageScenario(Experiment exp, String usageScenarioName) {
		Collection<Sensor> sensors = exp.getSensors();
		for (Iterator<Sensor> iterator = sensors.iterator(); iterator.hasNext();) {
			Sensor sensor = iterator.next();
			//logger.debug("Experiment has a sensor with ID "+sensor.getSensorID()+" and name "+sensor.getSensorName()+".");
			if (sensor.getSensorName().contains(usageScenarioName)){
				logger.debug("Found sensor for usage scenario "+usageScenarioName);
				return sensor;
			}
		}
		logger.error("No sensor found for usage scenario "+usageScenarioName);
		return null;
	}
	
	private static Sensor getSensorForResource(Experiment exp, Entity rc, ResourceType res, String sensorTypeString) {
		Collection<Sensor> sensors = exp.getSensors();
		for (Iterator<Sensor> iterator = sensors.iterator(); iterator.hasNext();) {
			Sensor sensor = iterator.next();
			//logger.debug("Experiment has a sensor with ID "+sensor.getSensorID()+" and name "+sensor.getSensorName()+".");
			if (
					(sensor.getSensorName().contains(res.getEntityName()) 
							|| /* special naming for linking resource */
							sensor.getSensorName().contains("Linking Resource")
							&& res.getEntityName().contains("LAN"))
					&& sensor.getSensorName().contains(sensorTypeString)
					&& sensor.getSensorName().contains(rc.getEntityName())){
				logger.debug("Found sensor of "+sensorTypeString+" for the resource "+rc.getEntityName()+": "+res.getEntityName());
				return sensor;
			}
		}
		logger.error("No sensor of "+sensorTypeString+" found for resource "+rc.getEntityName()+": "+res.getEntityName());
		return null;
	}
	
	/**An 
	 * array is filled with data from measurements. 
	 * 
	 * Copied from 
	 * de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports.RReport. 
	 * TODO: Possibly make this public in RReport and use it properly or refactor it 
	 * to a helper class.
	 * 
	 * XXX Keep this when using apache commons math. 
	 * 
	 * @param measurements Measurements for a sensor.
	 * @param dataSelection the data element to save.
	 * @return array with one data element per Measurement
	 * @author Henning, Anne
	 */
	private static double[] measurementsToDoubleArray(
			final SensorAndMeasurements measurements,
			final TimeseriesData dataSelection) {
		double[] measurementsArray = 
			new double[measurements.getMeasurements().size()];
		if (measurements.getMeasurements().size() == Integer.MAX_VALUE) {
			logger.error("Too many measurements. Results might be inaccurate.");
		}
		int position = 0;
		for (Measurement time : measurements.getMeasurements()) {
			TimeSpanMeasurement tsm = (TimeSpanMeasurement) time;
			measurementsArray[position++] = 
				(dataSelection == TimeseriesData.EVENTTIME) 
					? tsm.getEventTime() 
					: tsm.getTimeSpan(); 
		}
		return measurementsArray;
	}
	
	protected void getUtilisationOfResource(ActiveResourceUtilisationResult resultToFill, Entity container, ResourceType resourceType) throws AnalysisFailedException {
		Sensor utilSensor = getSensorForResource(this.experiment, container, resourceType, "State of Active Resource");
		Sensor demandedSensor = getSensorForResource(this.experiment, container, resourceType, "Demand");
		
		// for later when wait os available
		//Sensor waitSensor = getSensorForResource(this.experiment, container, resource, "Wait");
				
		if (utilSensor != null /*&& waitSensor != null*/){
			
			try {
				
				retrieveUtilisationFromSensor(utilSensor, resultToFill,1);
				
				/*
				SensorAndMeasurements sam = run.getMeasurementsOfSensor(waitSensor);
				result.setAverageWaitTime(calculateValue(sam, "mean"));
				*/
				resultToFill.setAverageWaitTime(Double.NaN);
				
				SensorAndMeasurements sam = run.getMeasurementsOfSensor(demandedSensor);
				resultToFill.setDemandedTime(calculateUnivariateStatistic(sam, TimeseriesData.TIMESPAN, new Mean()));
			
			} catch (RuntimeException e) {
				// FIXME: The call "SensorAndMeasurements sam =
				// run.getMeasurementsOfSensor(sensor);" above sometimes results
				// in a RuntimeException, because a State could not be
				// deserialised. Better fix that porperly instead of catching
				// the error here.
				resultToFill.setResourceUtilisation(Double.NaN);
				logger.error("A runtime exception occured while accessing the sendorframework. I'll try to ignore it and continue.");
				e.printStackTrace();
			} 
		} else {
			resultToFill.setResourceUtilisation(Double.NaN);
			throw new AnalysisFailedException("Could not find sensor for resource "+container.getEntityName()+": "+resourceType.getEntityName());
		}
	}
}