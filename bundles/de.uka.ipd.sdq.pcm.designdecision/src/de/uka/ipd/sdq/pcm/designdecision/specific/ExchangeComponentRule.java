/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.specific;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.repository.RepositoryComponent;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Exchange Component Rule</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.specific.ExchangeComponentRule#getRepositoryComponent <em>Repository Component</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.specific.ExchangeComponentRule#getAllocationContext <em>Allocation Context</em>}</li>
 * </ul>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.specific.specificPackage#getExchangeComponentRule()
 * @model
 * @generated
 */
public interface ExchangeComponentRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Repository Component</b></em>' reference list. The list
	 * contents are of type {@link org.palladiosimulator.pcm.repository.RepositoryComponent}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Component</em>' reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Repository Component</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.specific.specificPackage#getExchangeComponentRule_RepositoryComponent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<RepositoryComponent> getRepositoryComponent();

	/**
	 * Returns the value of the '<em><b>Allocation Context</b></em>' reference.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Allocation Context</em>' reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocation Context</em>' reference.
	 * @see #setAllocationContext(AllocationContext)
	 * @see de.uka.ipd.sdq.pcm.designdecision.specific.specificPackage#getExchangeComponentRule_AllocationContext()
	 * @model ordered="false"
	 * @generated
	 */
	AllocationContext getAllocationContext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.specific.ExchangeComponentRule#getAllocationContext <em>Allocation Context</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocation Context</em>' reference.
	 * @see #getAllocationContext()
	 * @generated
	 */
	void setAllocationContext(AllocationContext value);

} // ExchangeComponentRule
