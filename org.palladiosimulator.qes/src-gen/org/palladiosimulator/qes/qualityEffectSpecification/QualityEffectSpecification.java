/**
 * generated by Xtext 2.12.0
 */
package org.palladiosimulator.qes.qualityEffectSpecification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quality Effect Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecification#getComponents <em>Components</em>}</li>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecification#getTransformations <em>Transformations</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getQualityEffectSpecification()
 * @model
 * @generated
 */
public interface QualityEffectSpecification extends EObject
{
  /**
   * Returns the value of the '<em><b>Components</b></em>' containment reference list.
   * The list contents are of type {@link org.palladiosimulator.qes.qualityEffectSpecification.ComponentSpecification}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Components</em>' containment reference list.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getQualityEffectSpecification_Components()
   * @model containment="true"
   * @generated
   */
  EList<ComponentSpecification> getComponents();

  /**
   * Returns the value of the '<em><b>Transformations</b></em>' containment reference list.
   * The list contents are of type {@link org.palladiosimulator.qes.qualityEffectSpecification.TransformationSpecification}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transformations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transformations</em>' containment reference list.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getQualityEffectSpecification_Transformations()
   * @model containment="true"
   * @generated
   */
  EList<TransformationSpecification> getTransformations();

} // QualityEffectSpecification
