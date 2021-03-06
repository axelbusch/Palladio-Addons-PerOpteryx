/**
 * generated by Xtext 2.10.0
 */
package org.palladiosimulator.qes.qualityEffectSpecification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.Entry#getKey <em>Key</em>}</li>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.Entry#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getEntry()
 * @model
 * @generated
 */
public interface Entry extends EObject
{
  /**
   * Returns the value of the '<em><b>Key</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Key</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Key</em>' attribute list.
   * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getEntry_Key()
   * @model unique="false"
   * @generated
   */
  EList<String> getKey();

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage#getEntry_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.palladiosimulator.qes.qualityEffectSpecification.Entry#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // Entry
