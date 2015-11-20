/**
 */
package genericdesigndecision.impl;

import genericdesigndecision.DiscreteRangeChoice;
import genericdesigndecision.GenericdesigndecisionPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Discrete Range Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link genericdesigndecision.impl.DiscreteRangeChoiceImpl#getChosenValue <em>Chosen Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DiscreteRangeChoiceImpl extends ChoiceImpl implements DiscreteRangeChoice {
	/**
	 * The default value of the '{@link #getChosenValue() <em>Chosen Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChosenValue()
	 * @generated
	 * @ordered
	 */
	protected static final int CHOSEN_VALUE_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiscreteRangeChoiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericdesigndecisionPackage.Literals.DISCRETE_RANGE_CHOICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getChosenValue() {
		// TODO: implement this method to return the 'Chosen Value' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChosenValue(int newChosenValue) {
		// TODO: implement this method to set the 'Chosen Value' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenericdesigndecisionPackage.DISCRETE_RANGE_CHOICE__CHOSEN_VALUE:
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
			case GenericdesigndecisionPackage.DISCRETE_RANGE_CHOICE__CHOSEN_VALUE:
				setChosenValue((Integer)newValue);
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
			case GenericdesigndecisionPackage.DISCRETE_RANGE_CHOICE__CHOSEN_VALUE:
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
			case GenericdesigndecisionPackage.DISCRETE_RANGE_CHOICE__CHOSEN_VALUE:
				return getChosenValue() != CHOSEN_VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //DiscreteRangeChoiceImpl