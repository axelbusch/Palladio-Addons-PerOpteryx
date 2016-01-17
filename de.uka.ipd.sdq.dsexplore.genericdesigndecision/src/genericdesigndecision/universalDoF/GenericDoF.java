/**
 */
package genericdesigndecision.universalDoF;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Do F</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link genericdesigndecision.universalDoF.GenericDoF#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see genericdesigndecision.universalDoF.UniversalDoFPackage#getGenericDoF()
 * @model
 * @generated
 */
public interface GenericDoF extends EObject {
	
	public static final String ALLOCATION_DOF = "Allocation Degree";
	public static final String ASSEMBLED_COMPONENT_DOF = "Assembled Component Degree";
	public static final String CAPACITY_DOF = "Capacity Degree";
	public static final String CONTINUOUS_PROCESSING_RATE_DOF = "Continuous Processing Rate Degree";
	
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see genericdesigndecision.universalDoF.UniversalDoFPackage#getGenericDoF_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link genericdesigndecision.universalDoF.GenericDoF#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean equals(GenericDoF gdof);

} // GenericDoF
