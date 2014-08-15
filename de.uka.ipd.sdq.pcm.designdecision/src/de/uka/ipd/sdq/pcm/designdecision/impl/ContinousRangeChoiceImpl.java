/**
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import org.eclipse.emf.ecore.EClass;

import de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Continous Range Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ContinousRangeChoiceImpl#getChosenValue <em>Chosen Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContinousRangeChoiceImpl extends ChoiceImpl implements ContinousRangeChoice {
	/**
	 * The default value of the '{@link #getChosenValue() <em>Chosen Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChosenValue()
	 * @generated
	 * @ordered
	 */
	protected static final double CHOSEN_VALUE_EDEFAULT = 0.0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContinousRangeChoiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.CONTINOUS_RANGE_CHOICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not 
	 */
	public double getChosenValue() {
		return ((Double)this.getValue()).doubleValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void setChosenValue(double newChosenValue) {
		this.setValue(new Double(newChosenValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.CONTINOUS_RANGE_CHOICE__CHOSEN_VALUE:
				return getChosenValue();
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
			case designdecisionPackage.CONTINOUS_RANGE_CHOICE__CHOSEN_VALUE:
				setChosenValue((Double)newValue);
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
			case designdecisionPackage.CONTINOUS_RANGE_CHOICE__CHOSEN_VALUE:
				setChosenValue(CHOSEN_VALUE_EDEFAULT);
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
			case designdecisionPackage.CONTINOUS_RANGE_CHOICE__CHOSEN_VALUE:
				return getChosenValue() != CHOSEN_VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}


} //ContinousRangeChoiceImpl
