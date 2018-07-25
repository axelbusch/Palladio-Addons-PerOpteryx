/**
 * generated by Xtext 2.12.0
 */
package org.palladiosimulator.qes.qualityEffectSpecification.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.palladiosimulator.qes.qualityEffectSpecification.Annotation;
import org.palladiosimulator.qes.qualityEffectSpecification.QualityEffectSpecificationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.impl.AnnotationImpl#isNot <em>Not</em>}</li>
 *   <li>{@link org.palladiosimulator.qes.qualityEffectSpecification.impl.AnnotationImpl#getAnnotation <em>Annotation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnnotationImpl extends ComponentPropertyImpl implements Annotation
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
   * The default value of the '{@link #getAnnotation() <em>Annotation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotation()
   * @generated
   * @ordered
   */
  protected static final String ANNOTATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAnnotation() <em>Annotation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotation()
   * @generated
   * @ordered
   */
  protected String annotation = ANNOTATION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AnnotationImpl()
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
    return QualityEffectSpecificationPackage.Literals.ANNOTATION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, QualityEffectSpecificationPackage.ANNOTATION__NOT, oldNot, not));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAnnotation()
  {
    return annotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnnotation(String newAnnotation)
  {
    String oldAnnotation = annotation;
    annotation = newAnnotation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QualityEffectSpecificationPackage.ANNOTATION__ANNOTATION, oldAnnotation, annotation));
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
      case QualityEffectSpecificationPackage.ANNOTATION__NOT:
        return isNot();
      case QualityEffectSpecificationPackage.ANNOTATION__ANNOTATION:
        return getAnnotation();
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
      case QualityEffectSpecificationPackage.ANNOTATION__NOT:
        setNot((Boolean)newValue);
        return;
      case QualityEffectSpecificationPackage.ANNOTATION__ANNOTATION:
        setAnnotation((String)newValue);
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
      case QualityEffectSpecificationPackage.ANNOTATION__NOT:
        setNot(NOT_EDEFAULT);
        return;
      case QualityEffectSpecificationPackage.ANNOTATION__ANNOTATION:
        setAnnotation(ANNOTATION_EDEFAULT);
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
      case QualityEffectSpecificationPackage.ANNOTATION__NOT:
        return not != NOT_EDEFAULT;
      case QualityEffectSpecificationPackage.ANNOTATION__ANNOTATION:
        return ANNOTATION_EDEFAULT == null ? annotation != null : !ANNOTATION_EDEFAULT.equals(annotation);
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
    result.append(", annotation: ");
    result.append(annotation);
    result.append(')');
    return result.toString();
  }

} //AnnotationImpl
