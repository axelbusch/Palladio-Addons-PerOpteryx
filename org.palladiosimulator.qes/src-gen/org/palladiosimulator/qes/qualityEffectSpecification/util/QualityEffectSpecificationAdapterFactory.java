/**
 * generated by Xtext 2.13.0
 */
package org.palladiosimulator.qes.qualityEffectSpecification.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.qes.qualityEffectSpecification.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage
 * @generated
 */
public class QualityEffectSpecificationAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static QualityEffectSpecificationPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualityEffectSpecificationAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = QualityEffectSpecificationPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QualityEffectSpecificationSwitch<Adapter> modelSwitch =
    new QualityEffectSpecificationSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseComponent(Component object)
      {
        return createComponentAdapter();
      }
      @Override
      public Adapter casePropertie(Propertie object)
      {
        return createPropertieAdapter();
      }
      @Override
      public Adapter caseNegation(Negation object)
      {
        return createNegationAdapter();
      }
      @Override
      public Adapter caseComponentPropertie(ComponentPropertie object)
      {
        return createComponentPropertieAdapter();
      }
      @Override
      public Adapter caseName(Name object)
      {
        return createNameAdapter();
      }
      @Override
      public Adapter caseIdentifier(Identifier object)
      {
        return createIdentifierAdapter();
      }
      @Override
      public Adapter caseType(Type object)
      {
        return createTypeAdapter();
      }
      @Override
      public Adapter caseRole(Role object)
      {
        return createRoleAdapter();
      }
      @Override
      public Adapter caseRolePropertie(RolePropertie object)
      {
        return createRolePropertieAdapter();
      }
      @Override
      public Adapter caseAssembly(Assembly object)
      {
        return createAssemblyAdapter();
      }
      @Override
      public Adapter caseTransformation(Transformation object)
      {
        return createTransformationAdapter();
      }
      @Override
      public Adapter caseNQA(NQA object)
      {
        return createNQAAdapter();
      }
      @Override
      public Adapter caseReasoning(Reasoning object)
      {
        return createReasoningAdapter();
      }
      @Override
      public Adapter caseRule(Rule object)
      {
        return createRuleAdapter();
      }
      @Override
      public Adapter caseEntry(Entry object)
      {
        return createEntryAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.palladiosimulator.qes.qualityEffectSpecification.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.palladiosimulator.qes.qualityEffectSpecification.Component <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.Component
   * @generated
   */
  public Adapter createComponentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.palladiosimulator.qes.qualityEffectSpecification.Propertie <em>Propertie</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.Propertie
   * @generated
   */
  public Adapter createPropertieAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.palladiosimulator.qes.qualityEffectSpecification.Negation <em>Negation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.Negation
   * @generated
   */
  public Adapter createNegationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.palladiosimulator.qes.qualityEffectSpecification.ComponentPropertie <em>Component Propertie</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.ComponentPropertie
   * @generated
   */
  public Adapter createComponentPropertieAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.palladiosimulator.qes.qualityEffectSpecification.Name <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.Name
   * @generated
   */
  public Adapter createNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.palladiosimulator.qes.qualityEffectSpecification.Identifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.Identifier
   * @generated
   */
  public Adapter createIdentifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.palladiosimulator.qes.qualityEffectSpecification.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.Type
   * @generated
   */
  public Adapter createTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.palladiosimulator.qes.qualityEffectSpecification.Role <em>Role</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.Role
   * @generated
   */
  public Adapter createRoleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.palladiosimulator.qes.qualityEffectSpecification.RolePropertie <em>Role Propertie</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.RolePropertie
   * @generated
   */
  public Adapter createRolePropertieAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.palladiosimulator.qes.qualityEffectSpecification.Assembly <em>Assembly</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.Assembly
   * @generated
   */
  public Adapter createAssemblyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.palladiosimulator.qes.qualityEffectSpecification.Transformation <em>Transformation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.Transformation
   * @generated
   */
  public Adapter createTransformationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.palladiosimulator.qes.qualityEffectSpecification.NQA <em>NQA</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.NQA
   * @generated
   */
  public Adapter createNQAAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.palladiosimulator.qes.qualityEffectSpecification.Reasoning <em>Reasoning</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.Reasoning
   * @generated
   */
  public Adapter createReasoningAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.palladiosimulator.qes.qualityEffectSpecification.Rule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.Rule
   * @generated
   */
  public Adapter createRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.palladiosimulator.qes.qualityEffectSpecification.Entry <em>Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.Entry
   * @generated
   */
  public Adapter createEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //QualityEffectSpecificationAdapterFactory
