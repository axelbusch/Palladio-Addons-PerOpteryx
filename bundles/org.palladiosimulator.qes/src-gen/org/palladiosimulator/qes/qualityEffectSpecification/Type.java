/**
 * generated by Xtext 2.10.0
 */
package org.palladiosimulator.qes.qualityEffectSpecification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.Type#isNot <em>Not</em>}</li>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.Type#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getType()
 * @model
 * @generated
 */
public interface Type extends ComponentProperty
{
  /**
   * Returns the value of the '<em><b>Not</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Not</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Not</em>' attribute.
   * @see #setNot(boolean)
   * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getType_Not()
   * @model
   * @generated
   */
  boolean isNot();

  /**
   * Sets the value of the '{@link org.palladiosimulator.qes.qualityEffectSpecification.Type#isNot <em>Not</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Not</em>' attribute.
   * @see #isNot()
   * @generated
   */
  void setNot(boolean value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.palladiosimulator.qes.qualityEffectSpecification.ComponentType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.ComponentType
   * @see #setType(ComponentType)
   * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getType_Type()
   * @model
   * @generated
   */
  ComponentType getType();

  /**
   * Sets the value of the '{@link org.palladiosimulator.qes.qualityEffectSpecification.Type#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.ComponentType
   * @see #getType()
   * @generated
   */
  void setType(ComponentType value);

} // Type
