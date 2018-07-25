/**
 * generated by Xtext 2.12.0
 */
package org.palladiosimulator.qes.qualityEffectSpecification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>NQA</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.NQA#getQuality <em>Quality</em>}</li>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.NQA#getType <em>Type</em>}</li>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.NQA#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getNQA()
 * @model
 * @generated
 */
public interface NQA extends TransformationSpecification
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
   * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getNQA_Quality()
   * @model
   * @generated
   */
  String getQuality();

  /**
   * Sets the value of the '{@link org.palladiosimulator.qes.qualityEffectSpecification.NQA#getQuality <em>Quality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quality</em>' attribute.
   * @see #getQuality()
   * @generated
   */
  void setQuality(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.palladiosimulator.qes.qualityEffectSpecification.TransformationType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.TransformationType
   * @see #setType(TransformationType)
   * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getNQA_Type()
   * @model
   * @generated
   */
  TransformationType getType();

  /**
   * Sets the value of the '{@link org.palladiosimulator.qes.qualityEffectSpecification.NQA#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.TransformationType
   * @see #getType()
   * @generated
   */
  void setType(TransformationType value);

  /**
   * Returns the value of the '<em><b>Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' attribute.
   * @see #setElement(String)
   * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getNQA_Element()
   * @model
   * @generated
   */
  String getElement();

  /**
   * Sets the value of the '{@link org.palladiosimulator.qes.qualityEffectSpecification.NQA#getElement <em>Element</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' attribute.
   * @see #getElement()
   * @generated
   */
  void setElement(String value);

} // NQA
