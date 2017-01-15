package edu.kit.ipd.are.dsexplore.concern.concernweaver.test.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.modelversioning.emfprofile.EMFProfilePackage;
import org.modelversioning.emfprofile.Profile;
import org.modelversioning.emfprofileapplication.EMFProfileApplicationPackage;
import org.palladiosimulator.analyzer.workflow.blackboard.PCMResourceSetPartition;
import org.palladiosimulator.analyzer.workflow.configurations.AbstractPCMWorkflowRunConfiguration;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.solver.models.PCMInstance;

import ConcernModel.ConcernModelPackage;
import ConcernModel.ConcernRepository;
import ConcernModel.ElementaryConcernComponent;
import TransformationModel.TransformationModelPackage;
import TransformationModel.TransformationRepository;

public class ConcernWeavingTestUtil {

	public final static String RELATIVE_REPOSITORY_PERSISTING_PATH = "./result/pcm_$_weaved.repository";
	public final static String RELATIVE_CONCERN_REPOSITORY_PERSISTING_PATH = "./result/pcm_concern_repo_weaved.repository";
	public final static String RELATIVE_ASSEMBLY_PERSISTING_PATH = "./result/pcm_assembly_weaved.system";
	public final static String RELATIVE_ALLOCATION_PERSISTING_PATH = "./result/pcm_allocation_weaved.allocation";
	public final static String REPOSITORY_FILE_EXTENSION = "repository";
	public final static String RELATIV_PCM_ALLOCATION_MODEL_PATH_SEGMENT = "/models/ms_base.allocation";
	public final static String RELATIV_PCM_RESOURCE_ENV_MODEL_PATH_SEGMENT = "/models/ms.resourceenvironment";
	public final static String RELATIVE_PCM_REPOSITORY_MODEL_PATH_SEGMENT = "/models/ms.repository";
	public final static String RELATIV_PCM_USAGE_MODEL_PATH_SEGMENT = "/models/ms_usage.usagemodel";
	public final static String RELATIVE_PCM_ASSEMBLY_PATH_SEGMENT = "/models/ms_base.system";
	public final static String RELATIVE_CONCERN_REALIZATION_MODEL_PATH_SEGMENT = "/models/ossec.repository";
	public final static String RELATIVE_CONCERN_REPOSITORY_MODEL_PATH_SEGMENT = "/models/concern.concernmodel";
	public final static String RELATIVE_CONCERN_TRANSFORMATION_MODEL_PATH_SEGMENT = "/models/TransformationRepository.transformationmodel";
	public final static String RELATIVE_CONCERN_REALIZATION_ANNOTATION_MODEL_PATH_SEGMENT = "/models/annotations.emfprofile_diagram";
	public final static String RELATIVE_PCM_CONCERN_MODEL_PATH_SEGMENT = "/assembly_models/TemporaryConcernRepository.repository";
	public final static String RELATIVE_RESULT_FOLDER_PATH_SEGMENT = "/result";	
	
	private final static String ECC_DETECTION_NAME = "Detection";
	private final static String ECC_RESPONSE_NAME = "Response";
	private final static String ECC_ANALYSIS_NAME = "Analysis";
	
	public static Repository loadConcernRealization() {
		
		return (Repository) loadWithProfiles(ConcernModelPackage.eINSTANCE, RELATIVE_CONCERN_REALIZATION_MODEL_PATH_SEGMENT);
	
	}
	
	public static Repository loadPCMConcernRepository() {
		
		return (Repository) loadWithoutProfiles(RepositoryPackage.eINSTANCE, RELATIVE_PCM_CONCERN_MODEL_PATH_SEGMENT);
		
	}
	
	public static ConcernRepository loadConcernRepository() {
		
		return (ConcernRepository) loadWithProfiles(ConcernModelPackage.eINSTANCE, RELATIVE_CONCERN_REPOSITORY_MODEL_PATH_SEGMENT);
		
	}
	
	//Not working at this time...
	public static TransformationRepository loadTransformation() {
		
		return (TransformationRepository) loadWithoutProfiles(TransformationModelPackage.eINSTANCE, RELATIVE_CONCERN_TRANSFORMATION_MODEL_PATH_SEGMENT);
		
	}

	public static PCMInstance loadPCM() {

		List<String> modelFiles = new ArrayList<String>();
		modelFiles.add(getAbsolutePathOf(RELATIV_PCM_ALLOCATION_MODEL_PATH_SEGMENT));
		modelFiles.add(getAbsolutePathOf(RELATIV_PCM_USAGE_MODEL_PATH_SEGMENT));
		modelFiles.add(getAbsolutePathOf(RELATIVE_PCM_REPOSITORY_MODEL_PATH_SEGMENT));
		modelFiles.add(getAbsolutePathOf(RELATIVE_PCM_ASSEMBLY_PATH_SEGMENT));
		modelFiles.add(getAbsolutePathOf(RELATIV_PCM_RESOURCE_ENV_MODEL_PATH_SEGMENT));
		
		PCMResourceSetPartition set = createPCMResourceSetPartition(modelFiles);
		PCMInstance pcm = new PCMInstance(set);

		return pcm;
		
	}
	
	public static PCMResourceSetPartition createPCMResourceSetPartition(List<String> modelFiles) {
		
		List<EPackage> profilePackages = Arrays.asList(EMFProfilePackage.eINSTANCE, 
													   EMFProfileApplicationPackage.eINSTANCE, 
													   NotationPackage.eINSTANCE,
													   ConcernModelPackage.eINSTANCE,
													   getProfile(new ResourceSetImpl()));
		
		PCMResourceSetPartition resourceSetPartition = new PCMResourceSetPartition();
		resourceSetPartition.initialiseResourceSetEPackages(AbstractPCMWorkflowRunConfiguration.PCM_EPACKAGES);
		resourceSetPartition.initialiseResourceSetEPackages((EPackage[]) profilePackages.toArray());

		for (String modelFile : modelFiles) {
			
			resourceSetPartition.loadModel(modelFile);
			
		}
		resourceSetPartition.resolveAllProxies();
		
		return resourceSetPartition;
		
	}

	private static EObject loadWithoutProfiles(EPackage modelPackage, String relativePath) {

        ResourceSet set = new ResourceSetImpl();
        
        registerDefaultPackages(set);
        registerPackage(set, modelPackage);
 
		return load(set.getResource(URI.createFileURI(getAbsolutePathOf(relativePath)), true));
  
	}
	
	public static EObject loadWithProfiles(EPackage modelPackage, String relativePath) {

        ResourceSet set = new ResourceSetImpl();
        
        registerDefaultPackages(set);
        registerPackage(set, modelPackage);
        loadProfile(set);
 
		return load(set.getResource(URI.createFileURI(getAbsolutePathOf(relativePath)), true));
  
	}

	private static EObject load(Resource resource) {

		return resource.getContents().get(0);
		
	}

	private static void loadProfile(ResourceSet set) {
		
		registerPackage(set, getProfile(set));
		
	}

	private static Profile getProfile(ResourceSet set) {
		
		Resource resource = set.getResource(URI.createFileURI(getAbsolutePathOf(RELATIVE_CONCERN_REALIZATION_ANNOTATION_MODEL_PATH_SEGMENT)), true);
		return (Profile) resource.getContents().get(0);
		
	}

	private static void registerPackage(ResourceSet set, EPackage modelPackage) {
		
		set.getPackageRegistry().put(modelPackage.getNsURI(), modelPackage);
		
	}
	
	private static void registerDefaultPackages(ResourceSet set) {
		
		set.getPackageRegistry().put(EMFProfilePackage.eNS_URI, EMFProfilePackage.eINSTANCE);
        set.getPackageRegistry().put(EMFProfileApplicationPackage.eNS_URI, EMFProfileApplicationPackage.eINSTANCE);
        set.getPackageRegistry().put(NotationPackage.eNS_PREFIX, NotationPackage.eINSTANCE);
		
	}

	public static void registerFactories() {
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		reg.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
        
	}
	
	public static String getAbsolutePathOf(String relativePath) {
		
		return System.getProperty("user.dir") + relativePath;
		
	}
	
	public static String getAbsoluteResultFolderPathOf(Repository repository) {
		
		return String.format("%1s/%2s.%3s", new File(getAbsolutePathOf(RELATIVE_RESULT_FOLDER_PATH_SEGMENT)), repository.getEntityName(), REPOSITORY_FILE_EXTENSION);
		
	}
	
	public static ElementaryConcernComponent getDetectionECCOf(ConcernRepository concern) {
		
		return concern.getConcerns().stream().flatMap(eachConcern -> eachConcern.getComponents().stream())
											 .filter(eachECC -> eachECC.getName().equals(ECC_DETECTION_NAME))
											 .findFirst().get();
																
	}
	
	public static ElementaryConcernComponent getResponseECCOf(ConcernRepository concern) {
		
		return concern.getConcerns().stream().flatMap(eachConcern -> eachConcern.getComponents().stream())
											 .filter(eachECC -> eachECC.getName().equals(ECC_RESPONSE_NAME))
											 .findFirst().get();
																
	}
	
	public static ElementaryConcernComponent getAnalysisECCOf(ConcernRepository concern) {
		
		return concern.getConcerns().stream().flatMap(eachConcern -> eachConcern.getComponents().stream())
											 .filter(eachECC -> eachECC.getName().equals(ECC_ANALYSIS_NAME))
											 .findFirst().get();
																
	}
	
}
