/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.specific.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.pcm.designdecision.specific.FeatureSubset;
import de.uka.ipd.sdq.pcm.designdecision.specific.specificPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Feature Subset</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.designdecision.specific.impl.FeatureSubsetImpl#getFeature <em>
 * Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureSubsetImpl extends EObjectImpl implements FeatureSubset {
    /**
     * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFeature()
     * @generated
     * @ordered
     */
    protected EList<Feature> feature;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected FeatureSubsetImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return specificPackage.Literals.FEATURE_SUBSET;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Feature> getFeature() {
        if (this.feature == null)
        {
            this.feature = new EObjectResolvingEList<Feature>(Feature.class, this,
                    specificPackage.FEATURE_SUBSET__FEATURE);
        }
        return this.feature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID)
        {
        case specificPackage.FEATURE_SUBSET__FEATURE:
            return this.getFeature();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID)
        {
        case specificPackage.FEATURE_SUBSET__FEATURE:
            this.getFeature().clear();
            this.getFeature().addAll((Collection<? extends Feature>) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID)
        {
        case specificPackage.FEATURE_SUBSET__FEATURE:
            this.getFeature().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID)
        {
        case specificPackage.FEATURE_SUBSET__FEATURE:
            return this.feature != null && !this.feature.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // FeatureSubsetImpl
