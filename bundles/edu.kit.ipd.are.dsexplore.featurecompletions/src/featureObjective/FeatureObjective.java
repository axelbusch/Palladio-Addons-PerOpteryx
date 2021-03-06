/**
 */
package featureObjective;

import FeatureCompletionModel.DescribedElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Objective</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link featureObjective.FeatureObjective#getFeatureGroups <em>Feature Groups</em>}</li>
 *   <li>{@link featureObjective.FeatureObjective#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link featureObjective.FeatureObjective#getAnnotatableElement <em>Annotatable Element</em>}</li>
 * </ul>
 *
 * @see featureObjective.FeatureObjectivePackage#getFeatureObjective()
 * @model
 * @generated
 */
public interface FeatureObjective extends DescribedElement {
	/**
	 * Returns the value of the '<em><b>Feature Groups</b></em>' containment reference list.
	 * The list contents are of type {@link featureObjective.FeatureGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Groups</em>' containment reference list.
	 * @see featureObjective.FeatureObjectivePackage#getFeatureObjective_FeatureGroups()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<FeatureGroup> getFeatureGroups();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link featureObjective.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see featureObjective.FeatureObjectivePackage#getFeatureObjective_Constraints()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Annotatable Element</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotatable Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotatable Element</em>' reference list.
	 * @see featureObjective.FeatureObjectivePackage#getFeatureObjective_AnnotatableElement()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EObject> getAnnotatableElement();

} // FeatureObjective
