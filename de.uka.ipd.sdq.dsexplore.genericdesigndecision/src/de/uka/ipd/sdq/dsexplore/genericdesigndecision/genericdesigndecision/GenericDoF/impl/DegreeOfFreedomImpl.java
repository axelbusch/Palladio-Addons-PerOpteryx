/**
 */
package de.uka.ipd.sdq.dsexplore.genericdesigndecision.genericdesigndecision.GenericDoF.impl;

import de.uka.ipd.sdq.dsexplore.genericdesigndecision.genericdesigndecision.GenericDoF.ChangeableElementDescription;
import de.uka.ipd.sdq.dsexplore.genericdesigndecision.genericdesigndecision.GenericDoF.DegreeOfFreedom;
import de.uka.ipd.sdq.dsexplore.genericdesigndecision.genericdesigndecision.GenericDoF.GenericDoFPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Degree Of Freedom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.genericdesigndecision.genericdesigndecision.GenericDoF.impl.DegreeOfFreedomImpl#getAddedElements <em>Added Elements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.genericdesigndecision.genericdesigndecision.GenericDoF.impl.DegreeOfFreedomImpl#getChangeableElementDescriptions <em>Changeable Element Descriptions</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.genericdesigndecision.genericdesigndecision.GenericDoF.impl.DegreeOfFreedomImpl#getInteractionConstraints <em>Interaction Constraints</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.genericdesigndecision.genericdesigndecision.GenericDoF.impl.DegreeOfFreedomImpl#getPrimaryChangeable <em>Primary Changeable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DegreeOfFreedomImpl extends MinimalEObjectImpl.Container implements DegreeOfFreedom {
	/**
	 * The cached value of the '{@link #getAddedElements() <em>Added Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EClass> addedElements;

	/**
	 * The cached value of the '{@link #getChangeableElementDescriptions() <em>Changeable Element Descriptions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangeableElementDescriptions()
	 * @generated
	 * @ordered
	 */
	protected EList<ChangeableElementDescription> changeableElementDescriptions;

	/**
	 * The cached value of the '{@link #getInteractionConstraints() <em>Interaction Constraints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteractionConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<EOperation> interactionConstraints;

	/**
	 * The cached value of the '{@link #getPrimaryChangeable() <em>Primary Changeable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryChangeable()
	 * @generated
	 * @ordered
	 */
	protected ChangeableElementDescription primaryChangeable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DegreeOfFreedomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericDoFPackage.Literals.DEGREE_OF_FREEDOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClass> getAddedElements() {
		if (addedElements == null) {
			addedElements = new EObjectResolvingEList<EClass>(EClass.class, this, GenericDoFPackage.DEGREE_OF_FREEDOM__ADDED_ELEMENTS);
		}
		return addedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChangeableElementDescription> getChangeableElementDescriptions() {
		if (changeableElementDescriptions == null) {
			changeableElementDescriptions = new EObjectContainmentEList<ChangeableElementDescription>(ChangeableElementDescription.class, this, GenericDoFPackage.DEGREE_OF_FREEDOM__CHANGEABLE_ELEMENT_DESCRIPTIONS);
		}
		return changeableElementDescriptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EOperation> getInteractionConstraints() {
		if (interactionConstraints == null) {
			interactionConstraints = new EObjectResolvingEList<EOperation>(EOperation.class, this, GenericDoFPackage.DEGREE_OF_FREEDOM__INTERACTION_CONSTRAINTS);
		}
		return interactionConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeableElementDescription getPrimaryChangeable() {
		if (primaryChangeable != null && primaryChangeable.eIsProxy()) {
			InternalEObject oldPrimaryChangeable = (InternalEObject)primaryChangeable;
			primaryChangeable = (ChangeableElementDescription)eResolveProxy(oldPrimaryChangeable);
			if (primaryChangeable != oldPrimaryChangeable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenericDoFPackage.DEGREE_OF_FREEDOM__PRIMARY_CHANGEABLE, oldPrimaryChangeable, primaryChangeable));
			}
		}
		return primaryChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeableElementDescription basicGetPrimaryChangeable() {
		return primaryChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryChangeable(ChangeableElementDescription newPrimaryChangeable) {
		ChangeableElementDescription oldPrimaryChangeable = primaryChangeable;
		primaryChangeable = newPrimaryChangeable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericDoFPackage.DEGREE_OF_FREEDOM__PRIMARY_CHANGEABLE, oldPrimaryChangeable, primaryChangeable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenericDoFPackage.DEGREE_OF_FREEDOM__CHANGEABLE_ELEMENT_DESCRIPTIONS:
				return ((InternalEList<?>)getChangeableElementDescriptions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenericDoFPackage.DEGREE_OF_FREEDOM__ADDED_ELEMENTS:
				return getAddedElements();
			case GenericDoFPackage.DEGREE_OF_FREEDOM__CHANGEABLE_ELEMENT_DESCRIPTIONS:
				return getChangeableElementDescriptions();
			case GenericDoFPackage.DEGREE_OF_FREEDOM__INTERACTION_CONSTRAINTS:
				return getInteractionConstraints();
			case GenericDoFPackage.DEGREE_OF_FREEDOM__PRIMARY_CHANGEABLE:
				if (resolve) return getPrimaryChangeable();
				return basicGetPrimaryChangeable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GenericDoFPackage.DEGREE_OF_FREEDOM__ADDED_ELEMENTS:
				getAddedElements().clear();
				getAddedElements().addAll((Collection<? extends EClass>)newValue);
				return;
			case GenericDoFPackage.DEGREE_OF_FREEDOM__CHANGEABLE_ELEMENT_DESCRIPTIONS:
				getChangeableElementDescriptions().clear();
				getChangeableElementDescriptions().addAll((Collection<? extends ChangeableElementDescription>)newValue);
				return;
			case GenericDoFPackage.DEGREE_OF_FREEDOM__INTERACTION_CONSTRAINTS:
				getInteractionConstraints().clear();
				getInteractionConstraints().addAll((Collection<? extends EOperation>)newValue);
				return;
			case GenericDoFPackage.DEGREE_OF_FREEDOM__PRIMARY_CHANGEABLE:
				setPrimaryChangeable((ChangeableElementDescription)newValue);
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
			case GenericDoFPackage.DEGREE_OF_FREEDOM__ADDED_ELEMENTS:
				getAddedElements().clear();
				return;
			case GenericDoFPackage.DEGREE_OF_FREEDOM__CHANGEABLE_ELEMENT_DESCRIPTIONS:
				getChangeableElementDescriptions().clear();
				return;
			case GenericDoFPackage.DEGREE_OF_FREEDOM__INTERACTION_CONSTRAINTS:
				getInteractionConstraints().clear();
				return;
			case GenericDoFPackage.DEGREE_OF_FREEDOM__PRIMARY_CHANGEABLE:
				setPrimaryChangeable((ChangeableElementDescription)null);
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
			case GenericDoFPackage.DEGREE_OF_FREEDOM__ADDED_ELEMENTS:
				return addedElements != null && !addedElements.isEmpty();
			case GenericDoFPackage.DEGREE_OF_FREEDOM__CHANGEABLE_ELEMENT_DESCRIPTIONS:
				return changeableElementDescriptions != null && !changeableElementDescriptions.isEmpty();
			case GenericDoFPackage.DEGREE_OF_FREEDOM__INTERACTION_CONSTRAINTS:
				return interactionConstraints != null && !interactionConstraints.isEmpty();
			case GenericDoFPackage.DEGREE_OF_FREEDOM__PRIMARY_CHANGEABLE:
				return primaryChangeable != null;
		}
		return super.eIsSet(featureID);
	}

} //DegreeOfFreedomImpl
