/**
 */
package de.uka.ipd.sdq.pcm.designdecision.gdof;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.designdecision.gdof.gdofPackage
 * @generated
 */
public interface gdofFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	gdofFactory eINSTANCE = de.uka.ipd.sdq.pcm.designdecision.gdof.impl.gdofFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Changeable Element Description</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Changeable Element Description</em>'.
	 * @generated
	 */
	ChangeableElementDescription createChangeableElementDescription();

	/**
	 * Returns a new object of class '<em>Value Rule</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Value Rule</em>'.
	 * @generated
	 */
	ValueRule createValueRule();

	/**
	 * Returns a new object of class '<em>OCL Rule</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @return a new object of class '<em>OCL Rule</em>'.
	 * @generated
	 */
	OCLRule createOCLRule();

	/**
	 * Returns a new object of class '<em>Helper OCL Definition</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Helper OCL Definition</em>'.
	 * @generated
	 */
	HelperOCLDefinition createHelperOCLDefinition();

	/**
	 * Returns a new object of class '<em>Do FRepository</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Do FRepository</em>'.
	 * @generated
	 */
	DoFRepository createDoFRepository();

	/**
	 * Returns a new object of class '<em>Instance Selection Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Selection Rule</em>'.
	 * @generated
	 */
	InstanceSelectionRule createInstanceSelectionRule();

	/**
	 * Returns a new object of class '<em>Static Selection Rule</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Static Selection Rule</em>'.
	 * @generated
	 */
	StaticSelectionRule createStaticSelectionRule();

	/**
	 * Returns a new object of class '<em>Degree Of Freedom</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Degree Of Freedom</em>'.
	 * @generated
	 */
	DegreeOfFreedom createDegreeOfFreedom();

	/**
	 * Returns a new object of class '<em>Decorator Model Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Decorator Model Description</em>'.
	 * @generated
	 */
	DecoratorModelDescription createDecoratorModelDescription();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	gdofPackage getgdofPackage();

} // gdofFactory
