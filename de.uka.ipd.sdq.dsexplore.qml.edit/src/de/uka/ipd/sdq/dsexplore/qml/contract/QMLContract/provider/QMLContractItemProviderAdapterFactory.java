/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.util.QMLContractAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class QMLContractItemProviderAdapterFactory extends QMLContractAdapterFactory
		implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public QMLContractItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SimpleQMLContract} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected SimpleQMLContractItemProvider simpleQMLContractItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SimpleQMLContract}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createSimpleQMLContractAdapter() {
		if (simpleQMLContractItemProvider == null) {
			simpleQMLContractItemProvider = new SimpleQMLContractItemProvider(this);
		}

		return simpleQMLContractItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Percentile} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected PercentileItemProvider percentileItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Percentile}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPercentileAdapter() {
		if (percentileItemProvider == null) {
			percentileItemProvider = new PercentileItemProvider(this);
		}

		return percentileItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Frequency} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected FrequencyItemProvider frequencyItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Frequency}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFrequencyAdapter() {
		if (frequencyItemProvider == null) {
			frequencyItemProvider = new FrequencyItemProvider(this);
		}

		return frequencyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RangeValue} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected RangeValueItemProvider rangeValueItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RangeValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRangeValueAdapter() {
		if (rangeValueItemProvider == null) {
			rangeValueItemProvider = new RangeValueItemProvider(this);
		}

		return rangeValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Mean} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MeanItemProvider meanItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Mean}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMeanAdapter() {
		if (meanItemProvider == null) {
			meanItemProvider = new MeanItemProvider(this);
		}

		return meanItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Variance} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected VarianceItemProvider varianceItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Variance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVarianceAdapter() {
		if (varianceItemProvider == null) {
			varianceItemProvider = new VarianceItemProvider(this);
		}

		return varianceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.NumericLiteral} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected NumericLiteralItemProvider numericLiteralItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.NumericLiteral}.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNumericLiteralAdapter() {
		if (numericLiteralItemProvider == null) {
			numericLiteralItemProvider = new NumericLiteralItemProvider(this);
		}

		return numericLiteralItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumLiteral} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected EnumLiteralItemProvider enumLiteralItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumLiteral}.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEnumLiteralAdapter() {
		if (enumLiteralItemProvider == null) {
			enumLiteralItemProvider = new EnumLiteralItemProvider(this);
		}

		return enumLiteralItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SetLiteral} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected SetLiteralItemProvider setLiteralItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SetLiteral}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSetLiteralAdapter() {
		if (setLiteralItemProvider == null) {
			setLiteralItemProvider = new SetLiteralItemProvider(this);
		}

		return setLiteralItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RefinedQMLContract} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected RefinedQMLContractItemProvider refinedQMLContractItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RefinedQMLContract}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createRefinedQMLContractAdapter() {
		if (refinedQMLContractItemProvider == null) {
			refinedQMLContractItemProvider = new RefinedQMLContractItemProvider(this);
		}

		return refinedQMLContractItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Value} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ValueItemProvider valueItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Value}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createValueAdapter() {
		if (valueItemProvider == null) {
			valueItemProvider = new ValueItemProvider(this);
		}

		return valueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Objective} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ObjectiveItemProvider objectiveItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Objective}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createObjectiveAdapter() {
		if (objectiveItemProvider == null) {
			objectiveItemProvider = new ObjectiveItemProvider(this);
		}

		return objectiveItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Constraint} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ConstraintItemProvider constraintItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Constraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConstraintAdapter() {
		if (constraintItemProvider == null) {
			constraintItemProvider = new ConstraintItemProvider(this);
		}

		return constraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Restriction} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected RestrictionItemProvider restrictionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Restriction}.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRestrictionAdapter() {
		if (restrictionItemProvider == null) {
			restrictionItemProvider = new RestrictionItemProvider(this);
		}

		return restrictionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Goal} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected GoalItemProvider goalItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Goal}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGoalAdapter() {
		if (goalItemProvider == null) {
			goalItemProvider = new GoalItemProvider(this);
		}

		return goalItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.ScaleLiteral} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScaleLiteralItemProvider scaleLiteralItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.ScaleLiteral}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScaleLiteralAdapter() {
		if (scaleLiteralItemProvider == null) {
			scaleLiteralItemProvider = new ScaleLiteralItemProvider(this);
		}

		return scaleLiteralItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void dispose() {
		if (simpleQMLContractItemProvider != null)
			simpleQMLContractItemProvider.dispose();
		if (percentileItemProvider != null)
			percentileItemProvider.dispose();
		if (frequencyItemProvider != null)
			frequencyItemProvider.dispose();
		if (rangeValueItemProvider != null)
			rangeValueItemProvider.dispose();
		if (meanItemProvider != null)
			meanItemProvider.dispose();
		if (varianceItemProvider != null)
			varianceItemProvider.dispose();
		if (numericLiteralItemProvider != null)
			numericLiteralItemProvider.dispose();
		if (enumLiteralItemProvider != null)
			enumLiteralItemProvider.dispose();
		if (setLiteralItemProvider != null)
			setLiteralItemProvider.dispose();
		if (refinedQMLContractItemProvider != null)
			refinedQMLContractItemProvider.dispose();
		if (valueItemProvider != null)
			valueItemProvider.dispose();
		if (objectiveItemProvider != null)
			objectiveItemProvider.dispose();
		if (constraintItemProvider != null)
			constraintItemProvider.dispose();
		if (restrictionItemProvider != null)
			restrictionItemProvider.dispose();
		if (goalItemProvider != null)
			goalItemProvider.dispose();
		if (scaleLiteralItemProvider != null)
			scaleLiteralItemProvider.dispose();
	}

}
