/**
 */
package org.palladiosimulator.qualitymodel.provider;

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

import org.palladiosimulator.qualitymodel.util.QualityModelAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class QualityModelItemProviderAdapterFactory extends QualityModelAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection supportedTypes = new ArrayList();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityModelItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.qualitymodel.Nqr} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NqrItemProvider nqrItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.qualitymodel.Nqr}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createNqrAdapter() {
		if (nqrItemProvider == null) {
			nqrItemProvider = new NqrItemProvider(this);
		}

		return nqrItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.qualitymodel.Mapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingItemProvider mappingItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.qualitymodel.Mapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createMappingAdapter() {
		if (mappingItemProvider == null) {
			mappingItemProvider = new MappingItemProvider(this);
		}

		return mappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.qualitymodel.Transformation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationItemProvider transformationItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.qualitymodel.Transformation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createTransformationAdapter() {
		if (transformationItemProvider == null) {
			transformationItemProvider = new TransformationItemProvider(this);
		}

		return transformationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.qualitymodel.Reasoning} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReasoningItemProvider reasoningItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.qualitymodel.Reasoning}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createReasoningAdapter() {
		if (reasoningItemProvider == null) {
			reasoningItemProvider = new ReasoningItemProvider(this);
		}

		return reasoningItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.qualitymodel.QuantityReduction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QuantityReductionItemProvider quantityReductionItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.qualitymodel.QuantityReduction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createQuantityReductionAdapter() {
		if (quantityReductionItemProvider == null) {
			quantityReductionItemProvider = new QuantityReductionItemProvider(this);
		}

		return quantityReductionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.qualitymodel.StatisticReduction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatisticReductionItemProvider statisticReductionItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.qualitymodel.StatisticReduction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createStatisticReductionAdapter() {
		if (statisticReductionItemProvider == null) {
			statisticReductionItemProvider = new StatisticReductionItemProvider(this);
		}

		return statisticReductionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.qualitymodel.MappingRepository} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingRepositoryItemProvider mappingRepositoryItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.qualitymodel.MappingRepository}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createMappingRepositoryAdapter() {
		if (mappingRepositoryItemProvider == null) {
			mappingRepositoryItemProvider = new MappingRepositoryItemProvider(this);
		}

		return mappingRepositoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.qualitymodel.MappingEntry} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingEntryItemProvider mappingEntryItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.qualitymodel.MappingEntry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createMappingEntryAdapter() {
		if (mappingEntryItemProvider == null) {
			mappingEntryItemProvider = new MappingEntryItemProvider(this);
		}

		return mappingEntryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.qualitymodel.TransformationRepository} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationRepositoryItemProvider transformationRepositoryItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.qualitymodel.TransformationRepository}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createTransformationRepositoryAdapter() {
		if (transformationRepositoryItemProvider == null) {
			transformationRepositoryItemProvider = new TransformationRepositoryItemProvider(this);
		}

		return transformationRepositoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.qualitymodel.ReasoningRepository} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReasoningRepositoryItemProvider reasoningRepositoryItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.qualitymodel.ReasoningRepository}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createReasoningRepositoryAdapter() {
		if (reasoningRepositoryItemProvider == null) {
			reasoningRepositoryItemProvider = new ReasoningRepositoryItemProvider(this);
		}

		return reasoningRepositoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.qualitymodel.NqrRepository} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NqrRepositoryItemProvider nqrRepositoryItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.qualitymodel.NqrRepository}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createNqrRepositoryAdapter() {
		if (nqrRepositoryItemProvider == null) {
			nqrRepositoryItemProvider = new NqrRepositoryItemProvider(this);
		}

		return nqrRepositoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.qualitymodel.ReasoningComponent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReasoningComponentItemProvider reasoningComponentItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.qualitymodel.ReasoningComponent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createReasoningComponentAdapter() {
		if (reasoningComponentItemProvider == null) {
			reasoningComponentItemProvider = new ReasoningComponentItemProvider(this);
		}

		return reasoningComponentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.palladiosimulator.qualitymodel.ReasoningSystem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReasoningSystemItemProvider reasoningSystemItemProvider;

	/**
	 * This creates an adapter for a {@link org.palladiosimulator.qualitymodel.ReasoningSystem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createReasoningSystemAdapter() {
		if (reasoningSystemItemProvider == null) {
			reasoningSystemItemProvider = new ReasoningSystemItemProvider(this);
		}

		return reasoningSystemItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class) || (((Class)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (nqrItemProvider != null) nqrItemProvider.dispose();
		if (mappingItemProvider != null) mappingItemProvider.dispose();
		if (transformationItemProvider != null) transformationItemProvider.dispose();
		if (reasoningItemProvider != null) reasoningItemProvider.dispose();
		if (quantityReductionItemProvider != null) quantityReductionItemProvider.dispose();
		if (statisticReductionItemProvider != null) statisticReductionItemProvider.dispose();
		if (mappingRepositoryItemProvider != null) mappingRepositoryItemProvider.dispose();
		if (mappingEntryItemProvider != null) mappingEntryItemProvider.dispose();
		if (transformationRepositoryItemProvider != null) transformationRepositoryItemProvider.dispose();
		if (reasoningRepositoryItemProvider != null) reasoningRepositoryItemProvider.dispose();
		if (nqrRepositoryItemProvider != null) nqrRepositoryItemProvider.dispose();
		if (reasoningComponentItemProvider != null) reasoningComponentItemProvider.dispose();
		if (reasoningSystemItemProvider != null) reasoningSystemItemProvider.dispose();
	}

}
