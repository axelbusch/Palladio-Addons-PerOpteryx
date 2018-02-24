/**
 * generated by Xtext 2.13.0
 */
package org.palladiosimulator.qes.qualityEffectSpecification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.Model#getSpecifications <em>Specifications</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Specifications</b></em>' containment reference list.
   * The list contents are of type {@link org.palladiosimulator.qes.qualityEffectSpecification.QES}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Specifications</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Specifications</em>' containment reference list.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getModel_Specifications()
   * @model containment="true"
   * @generated
   */
  EList<QES> getSpecifications();

} // Model
