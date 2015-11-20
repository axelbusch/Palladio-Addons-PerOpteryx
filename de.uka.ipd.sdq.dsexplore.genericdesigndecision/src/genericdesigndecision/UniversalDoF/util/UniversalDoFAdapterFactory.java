/**
 */
package genericdesigndecision.UniversalDoF.util;

import genericdesigndecision.GenericDoF.DegreeOfFreedom;

import genericdesigndecision.UniversalDoF.*;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see genericdesigndecision.UniversalDoF.UniversalDoFPackage
 * @generated
 */
public class UniversalDoFAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UniversalDoFPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UniversalDoFAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UniversalDoFPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UniversalDoFSwitch<Adapter> modelSwitch =
		new UniversalDoFSwitch<Adapter>() {
			@Override
			public Adapter caseGenericDoFToDegreeOfFreedomMap(Map.Entry<GenericDoF, DegreeOfFreedom> object) {
				return createGenericDoFToDegreeOfFreedomMapAdapter();
			}
			@Override
			public Adapter caseMetamodelDescription(MetamodelDescription object) {
				return createMetamodelDescriptionAdapter();
			}
			@Override
			public Adapter caseGDoFRepository(GDoFRepository object) {
				return createGDoFRepositoryAdapter();
			}
			@Override
			public Adapter caseGenericDoF(GenericDoF object) {
				return createGenericDoFAdapter();
			}
			@Override
			public Adapter caseAMetamodelDescription(AMetamodelDescription object) {
				return createAMetamodelDescriptionAdapter();
			}
			@Override
			public Adapter caseUniversalDoF(UniversalDoF object) {
				return createUniversalDoFAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Generic Do FTo Degree Of Freedom Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createGenericDoFToDegreeOfFreedomMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link genericdesigndecision.UniversalDoF.MetamodelDescription <em>Metamodel Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see genericdesigndecision.UniversalDoF.MetamodelDescription
	 * @generated
	 */
	public Adapter createMetamodelDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link genericdesigndecision.UniversalDoF.GDoFRepository <em>GDo FRepository</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see genericdesigndecision.UniversalDoF.GDoFRepository
	 * @generated
	 */
	public Adapter createGDoFRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link genericdesigndecision.UniversalDoF.GenericDoF <em>Generic Do F</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see genericdesigndecision.UniversalDoF.GenericDoF
	 * @generated
	 */
	public Adapter createGenericDoFAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link genericdesigndecision.UniversalDoF.AMetamodelDescription <em>AMetamodel Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see genericdesigndecision.UniversalDoF.AMetamodelDescription
	 * @generated
	 */
	public Adapter createAMetamodelDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link genericdesigndecision.UniversalDoF.UniversalDoF <em>Universal Do F</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see genericdesigndecision.UniversalDoF.UniversalDoF
	 * @generated
	 */
	public Adapter createUniversalDoFAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //UniversalDoFAdapterFactory