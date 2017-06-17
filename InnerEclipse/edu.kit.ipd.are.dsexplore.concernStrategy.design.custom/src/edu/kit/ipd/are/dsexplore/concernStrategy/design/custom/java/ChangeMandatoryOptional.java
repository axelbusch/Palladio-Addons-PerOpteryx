package edu.kit.ipd.are.dsexplore.concernStrategy.design.custom.java;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DEdge;

import concernStrategy.Feature;
import concernStrategy.Simple;
import concernStrategy.StrategymodelFactory;
import concernStrategy.StrategymodelPackage;
import concernStrategy.impl.StrategymodelFactoryImpl;
import concernStrategy.impl.StrategymodelPackageImpl;

public class ChangeMandatoryOptional implements org.eclipse.sirius.tools.api.ui.IExternalJavaAction {

	@Override
	public boolean canExecute(Collection<? extends EObject> arg0) {
		return true;
	}

	/*
	 * This function changes the type of the simple relationship form mandatory
	 * to optional an vice versa.
	 */
	@Override
	public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {

		StrategymodelPackage stratModPack = StrategymodelPackageImpl.init();
		StrategymodelFactory stratFactory = StrategymodelFactoryImpl.init();

		// Assume the selected Object is an edge between two features in a
		// simple relationship
		// target variable is the target of the edge, so the item in the lower
		// hierarchy
		EObject selectedEObject = arg0.iterator().next();
		DEdge edge = (DEdge) selectedEObject;
		Feature target = (Feature) edge.getTarget();

		Simple simple = (Simple) target.eContainer();

		if (Utilities.isOptionalChild(target)) {
			simple.getOptionalChildren().remove(target);
			simple.getMandatoryChildren().add(target);
		} else {
			simple.getMandatoryChildren().remove(target);
			simple.getOptionalChildren().add(target);
		}

	}
}