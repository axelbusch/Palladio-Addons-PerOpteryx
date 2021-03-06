/**
 */
package featureSolution;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see featureSolution.FeatureSolutionPackage
 * @generated
 */
public interface FeatureSolutionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FeatureSolutionFactory eINSTANCE = featureSolution.impl.FeatureSolutionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Adapter Inclusion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Adapter Inclusion</em>'.
	 * @generated
	 */
	AdapterInclusion createAdapterInclusion();

	/**
	 * Returns a new object of class '<em>Behaviour Inclusion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behaviour Inclusion</em>'.
	 * @generated
	 */
	BehaviourInclusion createBehaviourInclusion();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FeatureSolutionPackage getFeatureSolutionPackage();

} //FeatureSolutionFactory
