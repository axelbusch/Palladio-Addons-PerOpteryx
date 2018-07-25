/**
 * generated by Xtext 2.12.0
 */
package org.palladiosimulator.qes.qualityEffectSpecification;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reasoning</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.Reasoning#getQuality <em>Quality</em>}</li>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.Reasoning#getRules <em>Rules</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getReasoning()
 * @model
 * @generated
 */
public interface Reasoning extends TransformationSpecification
{
  /**
   * Returns the value of the '<em><b>Quality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Quality</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quality</em>' attribute.
   * @see #setQuality(String)
   * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getReasoning_Quality()
   * @model
   * @generated
   */
  String getQuality();

  /**
   * Sets the value of the '{@link org.palladiosimulator.qes.qualityEffectSpecification.Reasoning#getQuality <em>Quality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quality</em>' attribute.
   * @see #getQuality()
   * @generated
   */
  void setQuality(String value);

  /**
   * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
   * The list contents are of type {@link org.palladiosimulator.qes.qualityEffectSpecification.Rule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rules</em>' containment reference list.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getReasoning_Rules()
   * @model containment="true"
   * @generated
   */
  EList<Rule> getRules();

} // Reasoning
