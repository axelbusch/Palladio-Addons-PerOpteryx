/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Unit Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.UnitRepository#getUnits <em>Units</em>}</li>
 * </ul>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractTypePackage#getUnitRepository()
 * @model
 * @generated
 */
public interface UnitRepository extends EObject, Identifier {
	/**
	 * Returns the value of the '<em><b>Units</b></em>' reference list. The list contents are of
	 * type {@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Unit}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Units</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Units</em>' reference list.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractTypePackage#getUnitRepository_Units()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Unit> getUnits();

} // UnitRepository
