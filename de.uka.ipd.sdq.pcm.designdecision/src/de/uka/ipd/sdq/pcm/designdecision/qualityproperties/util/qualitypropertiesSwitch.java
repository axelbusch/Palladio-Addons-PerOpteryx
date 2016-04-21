/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.qualityproperties.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import de.uka.ipd.sdq.pcm.designdecision.qualityproperties.ConfidenceInterval;
import de.uka.ipd.sdq.pcm.designdecision.qualityproperties.DoubleQualityProperty;
import de.uka.ipd.sdq.pcm.designdecision.qualityproperties.ElementQualityProperty;
import de.uka.ipd.sdq.pcm.designdecision.qualityproperties.IntegerQualityProperty;
import de.uka.ipd.sdq.pcm.designdecision.qualityproperties.NumericQualityProperty;
import de.uka.ipd.sdq.pcm.designdecision.qualityproperties.QualityPrediction;
import de.uka.ipd.sdq.pcm.designdecision.qualityproperties.QualityProperty;
import de.uka.ipd.sdq.pcm.designdecision.qualityproperties.qualitypropertiesPackage;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.qualityproperties.qualitypropertiesPackage
 * @generated
 */
public class qualitypropertiesSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static qualitypropertiesPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public qualitypropertiesSwitch() {
        if (modelPackage == null) {
            modelPackage = qualitypropertiesPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param ePackage
     *            the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(final EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(final int classifierID, final EObject theEObject) {
        switch (classifierID) {
        case qualitypropertiesPackage.NUMERIC_QUALITY_PROPERTY: {
            final NumericQualityProperty numericQualityProperty = (NumericQualityProperty) theEObject;
            T result = this.caseNumericQualityProperty(numericQualityProperty);
            if (result == null) {
                result = this.caseQualityProperty(numericQualityProperty);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case qualitypropertiesPackage.CONFIDENCE_INTERVAL: {
            final ConfidenceInterval confidenceInterval = (ConfidenceInterval) theEObject;
            T result = this.caseConfidenceInterval(confidenceInterval);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case qualitypropertiesPackage.ELEMENT_QUALITY_PROPERTY: {
            final ElementQualityProperty elementQualityProperty = (ElementQualityProperty) theEObject;
            T result = this.caseElementQualityProperty(elementQualityProperty);
            if (result == null) {
                result = this.caseQualityProperty(elementQualityProperty);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case qualitypropertiesPackage.INTEGER_QUALITY_PROPERTY: {
            final IntegerQualityProperty integerQualityProperty = (IntegerQualityProperty) theEObject;
            T result = this.caseIntegerQualityProperty(integerQualityProperty);
            if (result == null) {
                result = this.caseNumericQualityProperty(integerQualityProperty);
            }
            if (result == null) {
                result = this.caseQualityProperty(integerQualityProperty);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case qualitypropertiesPackage.DOUBLE_QUALITY_PROPERTY: {
            final DoubleQualityProperty doubleQualityProperty = (DoubleQualityProperty) theEObject;
            T result = this.caseDoubleQualityProperty(doubleQualityProperty);
            if (result == null) {
                result = this.caseNumericQualityProperty(doubleQualityProperty);
            }
            if (result == null) {
                result = this.caseQualityProperty(doubleQualityProperty);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case qualitypropertiesPackage.QUALITY_PREDICTION: {
            final QualityPrediction qualityPrediction = (QualityPrediction) theEObject;
            T result = this.caseQualityPrediction(qualityPrediction);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case qualitypropertiesPackage.QUALITY_PROPERTY: {
            final QualityProperty qualityProperty = (QualityProperty) theEObject;
            T result = this.caseQualityProperty(qualityProperty);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        default:
            return this.defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Numeric Quality Property</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Numeric Quality Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNumericQualityProperty(final NumericQualityProperty object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Confidence Interval</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Confidence Interval</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConfidenceInterval(final ConfidenceInterval object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Element Quality Property</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Element Quality Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseElementQualityProperty(final ElementQualityProperty object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Integer Quality Property</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Integer Quality Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntegerQualityProperty(final IntegerQualityProperty object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Double Quality Property</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Double Quality Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDoubleQualityProperty(final DoubleQualityProperty object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Quality Prediction</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Quality Prediction</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseQualityPrediction(final QualityPrediction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Quality Property</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Quality Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseQualityProperty(final QualityProperty object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(final EObject object) {
        return null;
    }

} // qualitypropertiesSwitch
