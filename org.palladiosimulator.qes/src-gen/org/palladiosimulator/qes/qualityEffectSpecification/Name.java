/**
 * generated by Xtext 2.12.0
 */
package org.palladiosimulator.qes.qualityEffectSpecification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.Name#isNot <em>Not</em>}</li>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.Name#getAutonym <em>Autonym</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getName_()
 * @model
 * @generated
 */
public interface Name extends ComponentProperty, RoleProperty, ResourceProperty
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
   * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getName_Not()
   * @model
   * @generated
   */
  boolean isNot();

  /**
   * Sets the value of the '{@link org.palladiosimulator.qes.qualityEffectSpecification.Name#isNot <em>Not</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Not</em>' attribute.
   * @see #isNot()
   * @generated
   */
  void setNot(boolean value);

  /**
   * Returns the value of the '<em><b>Autonym</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Autonym</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Autonym</em>' attribute.
   * @see #setAutonym(String)
   * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getName_Autonym()
   * @model
   * @generated
   */
  String getAutonym();

  /**
   * Sets the value of the '{@link org.palladiosimulator.qes.qualityEffectSpecification.Name#getAutonym <em>Autonym</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Autonym</em>' attribute.
   * @see #getAutonym()
   * @generated
   */
  void setAutonym(String value);

} // Name
