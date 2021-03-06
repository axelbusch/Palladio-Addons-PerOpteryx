/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.specific;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Ordered Integer Degree</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.specific.OrderedIntegerDegree#getListOfIntegers <em>List Of Integers</em>}</li>
 * </ul>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.specific.specificPackage#getOrderedIntegerDegree()
 * @model
 * @generated
 */
public interface OrderedIntegerDegree extends DiscreteDegree, OrderedDataTypeDegree {
	/**
	 * Returns the value of the '<em><b>List Of Integers</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List Of Integers</em>' attribute list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List Of Integers</em>' attribute list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.specific.specificPackage#getOrderedIntegerDegree_ListOfIntegers()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Integer> getListOfIntegers();

} // OrderedIntegerDegree
