/**
 */
package ConcernModel.impl;

import ConcernModel.AnnotationTarget;
import ConcernModel.ConcernModelPackage;
import ConcernModel.JoinPoint;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ConcernModel.impl.AnnotationTargetImpl#getJoinPoint <em>Join Point</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnnotationTargetImpl extends AnnotationImpl implements AnnotationTarget {
	/**
	 * The default value of the '{@link #getJoinPoint() <em>Join Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinPoint()
	 * @generated
	 * @ordered
	 */
	protected static final JoinPoint JOIN_POINT_EDEFAULT = JoinPoint.SIGNATURE;

	/**
	 * The cached value of the '{@link #getJoinPoint() <em>Join Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinPoint()
	 * @generated
	 * @ordered
	 */
	protected JoinPoint joinPoint = JOIN_POINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationTargetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcernModelPackage.Literals.ANNOTATION_TARGET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoinPoint getJoinPoint() {
		return joinPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJoinPoint(JoinPoint newJoinPoint) {
		JoinPoint oldJoinPoint = joinPoint;
		joinPoint = newJoinPoint == null ? JOIN_POINT_EDEFAULT : newJoinPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcernModelPackage.ANNOTATION_TARGET__JOIN_POINT, oldJoinPoint, joinPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConcernModelPackage.ANNOTATION_TARGET__JOIN_POINT:
				return getJoinPoint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConcernModelPackage.ANNOTATION_TARGET__JOIN_POINT:
				setJoinPoint((JoinPoint)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConcernModelPackage.ANNOTATION_TARGET__JOIN_POINT:
				setJoinPoint(JOIN_POINT_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConcernModelPackage.ANNOTATION_TARGET__JOIN_POINT:
				return joinPoint != JOIN_POINT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (joinPoint: ");
		result.append(joinPoint);
		result.append(')');
		return result.toString();
	}

} //AnnotationTargetImpl