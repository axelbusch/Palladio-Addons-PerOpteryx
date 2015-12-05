/**
 */
package de.uka.ipd.sdq.pcm.designdecision.gdof.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.analyzer.resultdecorator.ResultdecoratorPackage;

import de.uka.ipd.sdq.featuremodel.featuremodelPackage;
import de.uka.ipd.sdq.pcm.cost.costPackage;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;
import de.uka.ipd.sdq.pcm.designdecision.gdof.ChangeableElementDescription;
import de.uka.ipd.sdq.pcm.designdecision.gdof.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.gdof.DoFRepository;
import de.uka.ipd.sdq.pcm.designdecision.gdof.HelperOCLDefinition;
import de.uka.ipd.sdq.pcm.designdecision.gdof.InstanceSelectionRule;
import de.uka.ipd.sdq.pcm.designdecision.gdof.OCLRule;
import de.uka.ipd.sdq.pcm.designdecision.gdof.SelectionRule;
import de.uka.ipd.sdq.pcm.designdecision.gdof.StaticContextRule;
import de.uka.ipd.sdq.pcm.designdecision.gdof.StaticSelectionRule;
import de.uka.ipd.sdq.pcm.designdecision.gdof.ValueRule;
import de.uka.ipd.sdq.pcm.designdecision.gdof.gdofFactory;
import de.uka.ipd.sdq.pcm.designdecision.gdof.gdofPackage;
import de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl;
import de.uka.ipd.sdq.pcm.designdecision.qualityproperties.qualitypropertiesPackage;
import de.uka.ipd.sdq.pcm.designdecision.qualityproperties.impl.qualitypropertiesPackageImpl;
import de.uka.ipd.sdq.pcm.designdecision.specific.specificPackage;
import de.uka.ipd.sdq.pcm.designdecision.specific.impl.specificPackageImpl;
import de.uka.ipd.sdq.pcm.resourcerepository.resourcerepositoryPackage;
import genericdesigndecision.GenericdesigndecisionPackage;
import genericdesigndecision.genericDoF.GenericDoFPackage;
import de.uka.ipd.sdq.pcm.resourcerepository.impl.resourcerepositoryPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class gdofPackageImpl extends EPackageImpl implements gdofPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass changeableElementDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass helperOCLDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticContextRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectionRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doFRepositoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceSelectionRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticSelectionRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass degreeOfFreedomEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.uka.ipd.sdq.pcm.designdecision.gdof.gdofPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private gdofPackageImpl() {
		super(eNS_URI, gdofFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link gdofPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static gdofPackage init() {
		if (isInited)
			return (gdofPackage) EPackage.Registry.INSTANCE.getEPackage(gdofPackage.eNS_URI);

		// Obtain or create and register package
		gdofPackageImpl thegdofPackage = (gdofPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof gdofPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
						: new gdofPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		costPackage.eINSTANCE.eClass();
		featuremodelPackage.eINSTANCE.eClass();
		GenericdesigndecisionPackage.eINSTANCE.eClass();
		ResultdecoratorPackage.eINSTANCE.eClass();
		GenericDoFPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		designdecisionPackageImpl thedesigndecisionPackage = (designdecisionPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(designdecisionPackage.eNS_URI) instanceof designdecisionPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(designdecisionPackage.eNS_URI)
						: designdecisionPackage.eINSTANCE);
		qualitypropertiesPackageImpl thequalitypropertiesPackage = (qualitypropertiesPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(qualitypropertiesPackage.eNS_URI) instanceof qualitypropertiesPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(qualitypropertiesPackage.eNS_URI)
						: qualitypropertiesPackage.eINSTANCE);
		resourcerepositoryPackageImpl theresourcerepositoryPackage = (resourcerepositoryPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(resourcerepositoryPackage.eNS_URI) instanceof resourcerepositoryPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(resourcerepositoryPackage.eNS_URI)
						: resourcerepositoryPackage.eINSTANCE);
		specificPackageImpl thespecificPackage = (specificPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(specificPackage.eNS_URI) instanceof specificPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(specificPackage.eNS_URI) : specificPackage.eINSTANCE);

		// Create package meta-data objects
		thegdofPackage.createPackageContents();
		thedesigndecisionPackage.createPackageContents();
		thequalitypropertiesPackage.createPackageContents();
		theresourcerepositoryPackage.createPackageContents();
		thespecificPackage.createPackageContents();

		// Initialize created meta-data
		thegdofPackage.initializePackageContents();
		thedesigndecisionPackage.initializePackageContents();
		thequalitypropertiesPackage.initializePackageContents();
		theresourcerepositoryPackage.initializePackageContents();
		thespecificPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thegdofPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(gdofPackage.eNS_URI, thegdofPackage);
		return thegdofPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getChangeableElementDescription() {
		return changeableElementDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getChangeableElementDescription_PcmValueRule() {
		return (EReference) changeableElementDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getChangeableElementDescription_PcmSelectionRule() {
		return (EReference) changeableElementDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValueRule() {
		return valueRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOCLRule() {
		return oclRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOCLRule_PcmHelperDefinition() {
		return (EReference) oclRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHelperOCLDefinition() {
		return helperOCLDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStaticContextRule() {
		return staticContextRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSelectionRule() {
		return selectionRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDoFRepository() {
		return doFRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDoFRepository_PcmDofs() {
		return (EReference) doFRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInstanceSelectionRule() {
		return instanceSelectionRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInstanceSelectionRule_PcmContextInstance() {
		return (EReference) instanceSelectionRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStaticSelectionRule() {
		return staticSelectionRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDegreeOfFreedom() {
		return degreeOfFreedomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDegreeOfFreedom_PcmChangeableElementDescriptions() {
		return (EReference) degreeOfFreedomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDegreeOfFreedom_PcmPrimaryChangeable() {
		return (EReference) degreeOfFreedomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public gdofFactory getgdofFactory() {
		return (gdofFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		changeableElementDescriptionEClass = createEClass(CHANGEABLE_ELEMENT_DESCRIPTION);
		createEReference(changeableElementDescriptionEClass, CHANGEABLE_ELEMENT_DESCRIPTION__PCM_VALUE_RULE);
		createEReference(changeableElementDescriptionEClass, CHANGEABLE_ELEMENT_DESCRIPTION__PCM_SELECTION_RULE);

		valueRuleEClass = createEClass(VALUE_RULE);

		oclRuleEClass = createEClass(OCL_RULE);
		createEReference(oclRuleEClass, OCL_RULE__PCM_HELPER_DEFINITION);

		helperOCLDefinitionEClass = createEClass(HELPER_OCL_DEFINITION);

		staticContextRuleEClass = createEClass(STATIC_CONTEXT_RULE);

		selectionRuleEClass = createEClass(SELECTION_RULE);

		doFRepositoryEClass = createEClass(DO_FREPOSITORY);
		createEReference(doFRepositoryEClass, DO_FREPOSITORY__PCM_DOFS);

		instanceSelectionRuleEClass = createEClass(INSTANCE_SELECTION_RULE);
		createEReference(instanceSelectionRuleEClass, INSTANCE_SELECTION_RULE__PCM_CONTEXT_INSTANCE);

		staticSelectionRuleEClass = createEClass(STATIC_SELECTION_RULE);

		degreeOfFreedomEClass = createEClass(DEGREE_OF_FREEDOM);
		createEReference(degreeOfFreedomEClass, DEGREE_OF_FREEDOM__PCM_CHANGEABLE_ELEMENT_DESCRIPTIONS);
		createEReference(degreeOfFreedomEClass, DEGREE_OF_FREEDOM__PCM_PRIMARY_CHANGEABLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		featuremodelPackage thefeaturemodelPackage = (featuremodelPackage) EPackage.Registry.INSTANCE
				.getEPackage(featuremodelPackage.eNS_URI);
		GenericDoFPackage theGenericDoFPackage = (GenericDoFPackage) EPackage.Registry.INSTANCE
				.getEPackage(GenericDoFPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		changeableElementDescriptionEClass.getESuperTypes().add(thefeaturemodelPackage.getNamedElement());
		changeableElementDescriptionEClass.getESuperTypes().add(theGenericDoFPackage.getChangeableElementDescription());
		valueRuleEClass.getESuperTypes().add(this.getOCLRule());
		valueRuleEClass.getESuperTypes().add(theGenericDoFPackage.getValueRule());
		oclRuleEClass.getESuperTypes().add(theGenericDoFPackage.getOCLRule());
		helperOCLDefinitionEClass.getESuperTypes().add(this.getOCLRule());
		helperOCLDefinitionEClass.getESuperTypes().add(this.getStaticContextRule());
		helperOCLDefinitionEClass.getESuperTypes().add(theGenericDoFPackage.getHelperOCLDefinition());
		staticContextRuleEClass.getESuperTypes().add(theGenericDoFPackage.getStaticContextRule());
		selectionRuleEClass.getESuperTypes().add(this.getOCLRule());
		selectionRuleEClass.getESuperTypes().add(theGenericDoFPackage.getSelectionRule());
		doFRepositoryEClass.getESuperTypes().add(theGenericDoFPackage.getDoFRepository());
		instanceSelectionRuleEClass.getESuperTypes().add(this.getSelectionRule());
		instanceSelectionRuleEClass.getESuperTypes().add(theGenericDoFPackage.getInstanceSelectionRule());
		staticSelectionRuleEClass.getESuperTypes().add(this.getSelectionRule());
		staticSelectionRuleEClass.getESuperTypes().add(this.getStaticContextRule());
		staticSelectionRuleEClass.getESuperTypes().add(theGenericDoFPackage.getStaticSelectionRule());
		degreeOfFreedomEClass.getESuperTypes().add(thefeaturemodelPackage.getNamedElement());
		degreeOfFreedomEClass.getESuperTypes().add(theGenericDoFPackage.getADegreeOfFreedom());

		// Initialize classes and features; add operations and parameters
		initEClass(changeableElementDescriptionEClass, ChangeableElementDescription.class,
				"ChangeableElementDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChangeableElementDescription_PcmValueRule(), this.getValueRule(), null, "pcmValueRule", null,
				1, 1, ChangeableElementDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChangeableElementDescription_PcmSelectionRule(), this.getSelectionRule(), null,
				"pcmSelectionRule", null, 0, 1, ChangeableElementDescription.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueRuleEClass, ValueRule.class, "ValueRule", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(oclRuleEClass, OCLRule.class, "OCLRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOCLRule_PcmHelperDefinition(), this.getHelperOCLDefinition(), null, "pcmHelperDefinition",
				null, 0, -1, OCLRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(helperOCLDefinitionEClass, HelperOCLDefinition.class, "HelperOCLDefinition", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(staticContextRuleEClass, StaticContextRule.class, "StaticContextRule", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(selectionRuleEClass, SelectionRule.class, "SelectionRule", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(doFRepositoryEClass, DoFRepository.class, "DoFRepository", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDoFRepository_PcmDofs(), this.getDegreeOfFreedom(), null, "pcmDofs", null, 0, -1,
				DoFRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(instanceSelectionRuleEClass, InstanceSelectionRule.class, "InstanceSelectionRule", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstanceSelectionRule_PcmContextInstance(), this.getChangeableElementDescription(), null,
				"pcmContextInstance", null, 0, 1, InstanceSelectionRule.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(staticSelectionRuleEClass, StaticSelectionRule.class, "StaticSelectionRule", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(degreeOfFreedomEClass, DegreeOfFreedom.class, "DegreeOfFreedom", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDegreeOfFreedom_PcmChangeableElementDescriptions(), this.getChangeableElementDescription(),
				null, "pcmChangeableElementDescriptions", null, 1, -1, DegreeOfFreedom.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEReference(getDegreeOfFreedom_PcmPrimaryChangeable(), this.getChangeableElementDescription(), null,
				"pcmPrimaryChangeable", null, 1, 1, DegreeOfFreedom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //gdofPackageImpl
