/**
 * generated by Xtext 2.10.0
 */
package org.palladiosimulator.qes.qualityEffectSpecification.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.palladiosimulator.qes.qualityEffectSpecification.Name;
import org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.impl.NameImpl#isNot <em>Not</em>}</li>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.impl.NameImpl#getAutonym <em>Autonym</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NameImpl extends ComponentPropertyImpl implements Name
{
  /**
   * The default value of the '{@link #isNot() <em>Not</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNot()
   * @generated
   * @ordered
   */
  protected static final boolean NOT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNot() <em>Not</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNot()
   * @generated
   * @ordered
   */
  protected boolean not = NOT_EDEFAULT;

  /**
   * The default value of the '{@link #getAutonym() <em>Autonym</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAutonym()
   * @generated
   * @ordered
   */
  protected static final String AUTONYM_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAutonym() <em>Autonym</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAutonym()
   * @generated
   * @ordered
   */
  protected String autonym = AUTONYM_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NameImpl()
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
    return QualityEffectSpecificationPackage.Literals.NAME;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isNot()
  {
    return not;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNot(boolean newNot)
  {
    boolean oldNot = not;
    not = newNot;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QualityEffectSpecificationPackage.NAME__NOT, oldNot, not));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAutonym()
  {
    return autonym;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAutonym(String newAutonym)
  {
    String oldAutonym = autonym;
    autonym = newAutonym;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QualityEffectSpecificationPackage.NAME__AUTONYM, oldAutonym, autonym));
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
      case QualityEffectSpecificationPackage.NAME__NOT:
        return isNot();
      case QualityEffectSpecificationPackage.NAME__AUTONYM:
        return getAutonym();
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
      case QualityEffectSpecificationPackage.NAME__NOT:
        setNot((Boolean)newValue);
        return;
      case QualityEffectSpecificationPackage.NAME__AUTONYM:
        setAutonym((String)newValue);
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
      case QualityEffectSpecificationPackage.NAME__NOT:
        setNot(NOT_EDEFAULT);
        return;
      case QualityEffectSpecificationPackage.NAME__AUTONYM:
        setAutonym(AUTONYM_EDEFAULT);
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
      case QualityEffectSpecificationPackage.NAME__NOT:
        return not != NOT_EDEFAULT;
      case QualityEffectSpecificationPackage.NAME__AUTONYM:
        return AUTONYM_EDEFAULT == null ? autonym != null : !AUTONYM_EDEFAULT.equals(autonym);
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
    result.append(" (not: ");
    result.append(not);
    result.append(", autonym: ");
    result.append(autonym);
    result.append(')');
    return result.toString();
  }

} //NameImpl
