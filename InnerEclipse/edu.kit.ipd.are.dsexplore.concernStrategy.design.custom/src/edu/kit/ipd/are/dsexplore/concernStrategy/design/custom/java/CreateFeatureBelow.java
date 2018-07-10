package edu.kit.ipd.are.dsexplore.concernStrategy.design.custom.java;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import concernStrategy.ChildRelation;
import concernStrategy.Feature;
import concernStrategy.FeatureGroup;
import concernStrategy.Simple;
import concernStrategy.StrategymodelFactory;
import concernStrategy.StrategymodelPackage;
import concernStrategy.impl.StrategymodelFactoryImpl;
import concernStrategy.impl.StrategymodelPackageImpl;

public class CreateFeatureBelow implements org.eclipse.sirius.tools.api.ui.IExternalJavaAction {

	@Override
	public boolean canExecute(Collection<? extends EObject> arg0) {
		return true;
	}

	/*
	 * This method creates a child below the selected feature. If there are no
	 * sibling features, it creates a simple relationship with an optional
	 * children.
	 */
	@Override
	public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
		// assuming it's a feature
		EObject selectedEObject = arg0.iterator().next();
		Feature parentFeature = (Feature) selectedEObject;

		StrategymodelPackage stratModPack = StrategymodelPackageImpl.init();
		StrategymodelFactory stratFactory = StrategymodelFactoryImpl.init();

		// use Utilities class for more information
		int childrenContainerType = Utilities.getChildRelationshipType(parentFeature);

		// If there is no container, create a simple container (as opposed to a
		// feature group) as a default case
		if (childrenContainerType == 0) {
			EClass eclass = stratModPack.getSimple();
			ChildRelation cr = (ChildRelation) stratFactory.create(eclass);

			parentFeature.setChildrelation(cr);
			childrenContainerType = 1;
		}

		ChildRelation childRelationship = parentFeature.getChildrelation();

		EClass eclass = stratModPack.getFeature();
		Feature newFeature = (Feature) stratFactory.create(eclass);
		newFeature.setName("New Feature");

		// add optional child (as opposed to mandatory) as a default case
		if (childrenContainerType == 1) {
			((Simple) childRelationship).getOptionalChildren().add(newFeature);
			return;
		}

		if (childrenContainerType == 2) {
			((FeatureGroup) childRelationship).getChildren().add(newFeature);
		}
	}

}
