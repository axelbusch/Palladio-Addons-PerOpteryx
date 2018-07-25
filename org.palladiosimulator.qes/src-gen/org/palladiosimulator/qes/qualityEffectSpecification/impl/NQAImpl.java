/**
 * generated by Xtext 2.12.0
 */
package org.palladiosimulator.qes.qualityEffectSpecification.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.palladiosimulator.qes.qualityEffectSpecification.NQA;
import org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage;
import org.palladiosimulator.qes.qualityEffectSpecification.TransformationType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NQA</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.impl.NQAImpl#getQuality <em>Quality</em>}</li>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.impl.NQAImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.impl.NQAImpl#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NQAImpl extends TransformationSpecificationImpl implements NQA
{
  /**
   * The default value of the '{@link #getQuality() <em>Quality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuality()
   * @generated
   * @ordered
   */
  protected static final String QUALITY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getQuality() <em>Quality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuality()
   * @generated
   * @ordered
   */
  protected String quality = QUALITY_EDEFAULT;

  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final TransformationType TYPE_EDEFAULT = TransformationType.IS;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected TransformationType type = TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getElement() <em>Element</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected static final String ELEMENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected String element = ELEMENT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NQAImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return QualityEffectSpecificationPackage.Literals.NQA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getQuality()
  {
    return quality;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQuality(String newQuality)
  {
    String oldQuality = quality;
    quality = newQuality;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QualityEffectSpecificationPackage.NQA__QUALITY, oldQuality, quality));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransformationType getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(TransformationType newType)
  {
    TransformationType oldType = type;
    type = newType == null ? TYPE_EDEFAULT : newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QualityEffectSpecificationPackage.NQA__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getElement()
  {
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElement(String newElement)
  {
    String oldElement = element;
    element = newElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QualityEffectSpecificationPackage.NQA__ELEMENT, oldElement, element));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case QualityEffectSpecificationPackage.NQA__QUALITY:
        return getQuality();
      case QualityEffectSpecificationPackage.NQA__TYPE:
        return getType();
      case QualityEffectSpecificationPackage.NQA__ELEMENT:
        return getElement();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case QualityEffectSpecificationPackage.NQA__QUALITY:
        setQuality((String)newValue);
        return;
      case QualityEffectSpecificationPackage.NQA__TYPE:
        setType((TransformationType)newValue);
        return;
      case QualityEffectSpecificationPackage.NQA__ELEMENT:
        setElement((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case QualityEffectSpecificationPackage.NQA__QUALITY:
        setQuality(QUALITY_EDEFAULT);
        return;
      case QualityEffectSpecificationPackage.NQA__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case QualityEffectSpecificationPackage.NQA__ELEMENT:
        setElement(ELEMENT_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case QualityEffectSpecificationPackage.NQA__QUALITY:
        return QUALITY_EDEFAULT == null ? quality != null : !QUALITY_EDEFAULT.equals(quality);
      case QualityEffectSpecificationPackage.NQA__TYPE:
        return type != TYPE_EDEFAULT;
      case QualityEffectSpecificationPackage.NQA__ELEMENT:
        return ELEMENT_EDEFAULT == null ? element != null : !ELEMENT_EDEFAULT.equals(element);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (quality: ");
    result.append(quality);
    result.append(", type: ");
    result.append(type);
    result.append(", element: ");
    result.append(element);
    result.append(')');
    return result.toString();
  }

} //NQAImpl
