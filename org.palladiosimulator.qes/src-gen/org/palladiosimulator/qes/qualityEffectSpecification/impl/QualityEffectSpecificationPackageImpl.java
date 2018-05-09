/**
 * generated by Xtext 2.13.0
 */
package org.palladiosimulator.qes.qualityEffectSpecification.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.palladiosimulator.qes.qualityEffectSpecification.Annotation;
import org.palladiosimulator.qes.qualityEffectSpecification.Assembly;
import org.palladiosimulator.qes.qualityEffectSpecification.AssemblyType;
import org.palladiosimulator.qes.qualityEffectSpecification.ComponentProperty;
import org.palladiosimulator.qes.qualityEffectSpecification.ComponentSpecification;
import org.palladiosimulator.qes.qualityEffectSpecification.ComponentType;
import org.palladiosimulator.qes.qualityEffectSpecification.Cost;
import org.palladiosimulator.qes.qualityEffectSpecification.Entry;
import org.palladiosimulator.qes.qualityEffectSpecification.Identifier;
import org.palladiosimulator.qes.qualityEffectSpecification.Model;
import org.palladiosimulator.qes.qualityEffectSpecification.Name;
import org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationFactory;
import org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage;
import org.palladiosimulator.qes.qualityEffectSpecification.Reasoning;
import org.palladiosimulator.qes.qualityEffectSpecification.Resource;
import org.palladiosimulator.qes.qualityEffectSpecification.ResourceProperty;
import org.palladiosimulator.qes.qualityEffectSpecification.Role;
import org.palladiosimulator.qes.qualityEffectSpecification.RoleProperty;
import org.palladiosimulator.qes.qualityEffectSpecification.RoleType;
import org.palladiosimulator.qes.qualityEffectSpecification.Rule;
import org.palladiosimulator.qes.qualityEffectSpecification.TransformationSpecification;
import org.palladiosimulator.qes.qualityEffectSpecification.TransformationType;
import org.palladiosimulator.qes.qualityEffectSpecification.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QualityEffectSpecificationPackageImpl extends EPackageImpl implements QualityEffectSpecificationPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass identifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass annotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass roleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rolePropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assemblyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resourceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resourcePropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transformationSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nqaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reasoningEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass entryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass costEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum componentTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum roleTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum assemblyTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum transformationTypeEEnum = null;

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
   * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private QualityEffectSpecificationPackageImpl()
  {
    super(eNS_URI, QualityEffectSpecificationFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link QualityEffectSpecificationPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static QualityEffectSpecificationPackage init()
  {
    if (isInited) return (QualityEffectSpecificationPackage)EPackage.Registry.INSTANCE.getEPackage(QualityEffectSpecificationPackage.eNS_URI);

    // Obtain or create and register package
    QualityEffectSpecificationPackageImpl theQualityEffectSpecificationPackage = (QualityEffectSpecificationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QualityEffectSpecificationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QualityEffectSpecificationPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theQualityEffectSpecificationPackage.createPackageContents();

    // Initialize created meta-data
    theQualityEffectSpecificationPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theQualityEffectSpecificationPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(QualityEffectSpecificationPackage.eNS_URI, theQualityEffectSpecificationPackage);
    return theQualityEffectSpecificationPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Specifications()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQES()
  {
    return qesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQES_Components()
  {
    return (EReference)qesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQES_Transformations()
  {
    return (EReference)qesEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponentSpecification()
  {
    return componentSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentSpecification_Properties()
  {
    return (EReference)componentSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponentProperty()
  {
    return componentPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getName_()
  {
    return nameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getName_Not()
  {
    return (EAttribute)nameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getName_Name()
  {
    return (EAttribute)nameEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIdentifier()
  {
    return identifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIdentifier_Not()
  {
    return (EAttribute)identifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIdentifier_Id()
  {
    return (EAttribute)identifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnnotation()
  {
    return annotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnnotation_Not()
  {
    return (EAttribute)annotationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnnotation_Annotation()
  {
    return (EAttribute)annotationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType()
  {
    return typeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getType_Not()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getType_Type()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRole()
  {
    return roleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRole_Not()
  {
    return (EAttribute)roleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRole_Type()
  {
    return (EAttribute)roleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRole_Properties()
  {
    return (EReference)roleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoleProperty()
  {
    return rolePropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssembly()
  {
    return assemblyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssembly_Not()
  {
    return (EAttribute)assemblyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssembly_Type()
  {
    return (EAttribute)assemblyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssembly_Components()
  {
    return (EReference)assemblyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResource()
  {
    return resourceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResource_Properties()
  {
    return (EReference)resourceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResourceProperty()
  {
    return resourcePropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransformationSpecification()
  {
    return transformationSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNQA()
  {
    return nqaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNQA_Quality()
  {
    return (EAttribute)nqaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNQA_Type()
  {
    return (EAttribute)nqaEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNQA_Element()
  {
    return (EAttribute)nqaEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReasoning()
  {
    return reasoningEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReasoning_Quality()
  {
    return (EAttribute)reasoningEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReasoning_Rules()
  {
    return (EReference)reasoningEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRule()
  {
    return ruleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRule_Qualities()
  {
    return (EAttribute)ruleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRule_Entries()
  {
    return (EReference)ruleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEntry()
  {
    return entryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEntry_Key()
  {
    return (EAttribute)entryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEntry_Value()
  {
    return (EAttribute)entryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCost()
  {
    return costEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCost_Type()
  {
    return (EAttribute)costEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCost_Cost()
  {
    return (EAttribute)costEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getComponentType()
  {
    return componentTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getRoleType()
  {
    return roleTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAssemblyType()
  {
    return assemblyTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getTransformationType()
  {
    return transformationTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualityEffectSpecificationFactory getQualityEffectSpecificationFactory()
  {
    return (QualityEffectSpecificationFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__SPECIFICATIONS);

    qesEClass = createEClass(QES);
    createEReference(qesEClass, QES__COMPONENTS);
    createEReference(qesEClass, QES__TRANSFORMATIONS);

    componentSpecificationEClass = createEClass(COMPONENT_SPECIFICATION);
    createEReference(componentSpecificationEClass, COMPONENT_SPECIFICATION__PROPERTIES);

    componentPropertyEClass = createEClass(COMPONENT_PROPERTY);

    nameEClass = createEClass(NAME);
    createEAttribute(nameEClass, NAME__NOT);
    createEAttribute(nameEClass, NAME__NAME);

    identifierEClass = createEClass(IDENTIFIER);
    createEAttribute(identifierEClass, IDENTIFIER__NOT);
    createEAttribute(identifierEClass, IDENTIFIER__ID);

    annotationEClass = createEClass(ANNOTATION);
    createEAttribute(annotationEClass, ANNOTATION__NOT);
    createEAttribute(annotationEClass, ANNOTATION__ANNOTATION);

    typeEClass = createEClass(TYPE);
    createEAttribute(typeEClass, TYPE__NOT);
    createEAttribute(typeEClass, TYPE__TYPE);

    roleEClass = createEClass(ROLE);
    createEAttribute(roleEClass, ROLE__NOT);
    createEAttribute(roleEClass, ROLE__TYPE);
    createEReference(roleEClass, ROLE__PROPERTIES);

    rolePropertyEClass = createEClass(ROLE_PROPERTY);

    assemblyEClass = createEClass(ASSEMBLY);
    createEAttribute(assemblyEClass, ASSEMBLY__NOT);
    createEAttribute(assemblyEClass, ASSEMBLY__TYPE);
    createEReference(assemblyEClass, ASSEMBLY__COMPONENTS);

    resourceEClass = createEClass(RESOURCE);
    createEReference(resourceEClass, RESOURCE__PROPERTIES);

    resourcePropertyEClass = createEClass(RESOURCE_PROPERTY);

    transformationSpecificationEClass = createEClass(TRANSFORMATION_SPECIFICATION);

    nqaEClass = createEClass(NQA);
    createEAttribute(nqaEClass, NQA__QUALITY);
    createEAttribute(nqaEClass, NQA__TYPE);
    createEAttribute(nqaEClass, NQA__ELEMENT);

    reasoningEClass = createEClass(REASONING);
    createEAttribute(reasoningEClass, REASONING__QUALITY);
    createEReference(reasoningEClass, REASONING__RULES);

    ruleEClass = createEClass(RULE);
    createEAttribute(ruleEClass, RULE__QUALITIES);
    createEReference(ruleEClass, RULE__ENTRIES);

    entryEClass = createEClass(ENTRY);
    createEAttribute(entryEClass, ENTRY__KEY);
    createEAttribute(entryEClass, ENTRY__VALUE);

    costEClass = createEClass(COST);
    createEAttribute(costEClass, COST__TYPE);
    createEAttribute(costEClass, COST__COST);

    // Create enums
    componentTypeEEnum = createEEnum(COMPONENT_TYPE);
    roleTypeEEnum = createEEnum(ROLE_TYPE);
    assemblyTypeEEnum = createEEnum(ASSEMBLY_TYPE);
    transformationTypeEEnum = createEEnum(TRANSFORMATION_TYPE);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    nameEClass.getESuperTypes().add(this.getComponentProperty());
    nameEClass.getESuperTypes().add(this.getRoleProperty());
    nameEClass.getESuperTypes().add(this.getResourceProperty());
    identifierEClass.getESuperTypes().add(this.getComponentProperty());
    identifierEClass.getESuperTypes().add(this.getRoleProperty());
    identifierEClass.getESuperTypes().add(this.getResourceProperty());
    annotationEClass.getESuperTypes().add(this.getComponentProperty());
    annotationEClass.getESuperTypes().add(this.getRoleProperty());
    typeEClass.getESuperTypes().add(this.getComponentProperty());
    roleEClass.getESuperTypes().add(this.getComponentProperty());
    assemblyEClass.getESuperTypes().add(this.getComponentProperty());
    resourceEClass.getESuperTypes().add(this.getComponentProperty());
    nqaEClass.getESuperTypes().add(this.getTransformationSpecification());
    reasoningEClass.getESuperTypes().add(this.getTransformationSpecification());
    costEClass.getESuperTypes().add(this.getTransformationSpecification());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Specifications(), this.getQES(), null, "specifications", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(qesEClass, org.palladiosimulator.qes.qualityEffectSpecification.QES.class, "QES", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getQES_Components(), this.getComponentSpecification(), null, "components", null, 0, -1, org.palladiosimulator.qes.qualityEffectSpecification.QES.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQES_Transformations(), this.getTransformationSpecification(), null, "transformations", null, 0, -1, org.palladiosimulator.qes.qualityEffectSpecification.QES.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(componentSpecificationEClass, ComponentSpecification.class, "ComponentSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getComponentSpecification_Properties(), this.getComponentProperty(), null, "properties", null, 0, -1, ComponentSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(componentPropertyEClass, ComponentProperty.class, "ComponentProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nameEClass, Name.class, "Name", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getName_Not(), ecorePackage.getEBoolean(), "not", null, 0, 1, Name.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getName_Name(), ecorePackage.getEString(), "name", null, 0, 1, Name.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(identifierEClass, Identifier.class, "Identifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIdentifier_Not(), ecorePackage.getEBoolean(), "not", null, 0, 1, Identifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIdentifier_Id(), ecorePackage.getEString(), "id", null, 0, 1, Identifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(annotationEClass, Annotation.class, "Annotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAnnotation_Not(), ecorePackage.getEBoolean(), "not", null, 0, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAnnotation_Annotation(), ecorePackage.getEString(), "annotation", null, 0, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getType_Not(), ecorePackage.getEBoolean(), "not", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getType_Type(), this.getComponentType(), "type", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(roleEClass, Role.class, "Role", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRole_Not(), ecorePackage.getEBoolean(), "not", null, 0, 1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRole_Type(), this.getRoleType(), "type", null, 0, 1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRole_Properties(), this.getRoleProperty(), null, "properties", null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rolePropertyEClass, RoleProperty.class, "RoleProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(assemblyEClass, Assembly.class, "Assembly", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssembly_Not(), ecorePackage.getEBoolean(), "not", null, 0, 1, Assembly.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssembly_Type(), this.getAssemblyType(), "type", null, 0, 1, Assembly.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssembly_Components(), this.getComponentSpecification(), null, "components", null, 0, -1, Assembly.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resourceEClass, Resource.class, "Resource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getResource_Properties(), this.getResourceProperty(), null, "properties", null, 0, -1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resourcePropertyEClass, ResourceProperty.class, "ResourceProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(transformationSpecificationEClass, TransformationSpecification.class, "TransformationSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nqaEClass, org.palladiosimulator.qes.qualityEffectSpecification.NQA.class, "NQA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNQA_Quality(), ecorePackage.getEString(), "quality", null, 0, 1, org.palladiosimulator.qes.qualityEffectSpecification.NQA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNQA_Type(), this.getTransformationType(), "type", null, 0, 1, org.palladiosimulator.qes.qualityEffectSpecification.NQA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNQA_Element(), ecorePackage.getEString(), "element", null, 0, 1, org.palladiosimulator.qes.qualityEffectSpecification.NQA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reasoningEClass, Reasoning.class, "Reasoning", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReasoning_Quality(), ecorePackage.getEString(), "quality", null, 0, 1, Reasoning.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReasoning_Rules(), this.getRule(), null, "rules", null, 0, -1, Reasoning.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRule_Qualities(), ecorePackage.getEString(), "qualities", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRule_Entries(), this.getEntry(), null, "entries", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(entryEClass, Entry.class, "Entry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEntry_Key(), ecorePackage.getEString(), "key", null, 0, -1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEntry_Value(), ecorePackage.getEString(), "value", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(costEClass, Cost.class, "Cost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCost_Type(), this.getTransformationType(), "type", null, 0, 1, Cost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCost_Cost(), ecorePackage.getEInt(), "cost", null, 0, 1, Cost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(componentTypeEEnum, ComponentType.class, "ComponentType");
    addEEnumLiteral(componentTypeEEnum, ComponentType.ANY);
    addEEnumLiteral(componentTypeEEnum, ComponentType.BASIC);
    addEEnumLiteral(componentTypeEEnum, ComponentType.COMPOSITE);

    initEEnum(roleTypeEEnum, RoleType.class, "RoleType");
    addEEnumLiteral(roleTypeEEnum, RoleType.ANY);
    addEEnumLiteral(roleTypeEEnum, RoleType.COMPONENT_REQUIRED_PROVIDED);
    addEEnumLiteral(roleTypeEEnum, RoleType.COMPONENT_REQUIRED);
    addEEnumLiteral(roleTypeEEnum, RoleType.COMPONENT_PROVIDED);
    addEEnumLiteral(roleTypeEEnum, RoleType.INFRASTRUCTURE_REQUIRED_PROVIDED);
    addEEnumLiteral(roleTypeEEnum, RoleType.INFRASTRUCTURE_REQUIRED);
    addEEnumLiteral(roleTypeEEnum, RoleType.INFRASTRUCTURE_PROVIDED);

    initEEnum(assemblyTypeEEnum, AssemblyType.class, "AssemblyType");
    addEEnumLiteral(assemblyTypeEEnum, AssemblyType.ANY);
    addEEnumLiteral(assemblyTypeEEnum, AssemblyType.REQUIRED);
    addEEnumLiteral(assemblyTypeEEnum, AssemblyType.PROVIDED);

    initEEnum(transformationTypeEEnum, TransformationType.class, "TransformationType");
    addEEnumLiteral(transformationTypeEEnum, TransformationType.IS);
    addEEnumLiteral(transformationTypeEEnum, TransformationType.PLUS);
    addEEnumLiteral(transformationTypeEEnum, TransformationType.MINUS);
    addEEnumLiteral(transformationTypeEEnum, TransformationType.MULTIPLICATION);
    addEEnumLiteral(transformationTypeEEnum, TransformationType.DIVISION);

    // Create resource
    createResource(eNS_URI);
  }

} //QualityEffectSpecificationPackageImpl
