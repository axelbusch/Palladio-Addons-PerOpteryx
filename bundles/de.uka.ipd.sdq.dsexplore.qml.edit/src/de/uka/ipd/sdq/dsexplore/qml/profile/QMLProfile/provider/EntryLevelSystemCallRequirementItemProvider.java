/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.EntryLevelSystemCallRequirement;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.EntryLevelSystemCallRequirement} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class EntryLevelSystemCallRequirementItemProvider extends RequirementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public EntryLevelSystemCallRequirementItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addEntryLevelSystemCallPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Entry Level System Call feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEntryLevelSystemCallPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_EntryLevelSystemCallRequirement_entryLevelSystemCall_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_EntryLevelSystemCallRequirement_entryLevelSystemCall_feature",
						"_UI_EntryLevelSystemCallRequirement_type"),
				QMLProfilePackage.Literals.ENTRY_LEVEL_SYSTEM_CALL_REQUIREMENT__ENTRY_LEVEL_SYSTEM_CALL, true, false,
				true, null, null, null));
	}

	/**
	 * This returns EntryLevelSystemCallRequirement.gif. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EntryLevelSystemCallRequirement"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((EntryLevelSystemCallRequirement) object).getId();
		return label == null || label.length() == 0 ? getString("_UI_EntryLevelSystemCallRequirement_type")
				: getString("_UI_EntryLevelSystemCallRequirement_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
