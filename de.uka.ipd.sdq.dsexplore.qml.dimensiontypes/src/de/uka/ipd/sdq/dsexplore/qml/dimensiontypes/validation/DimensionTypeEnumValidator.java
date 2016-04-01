/**
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.dimensiontypes.validation;

import de.uka.ipd.sdq.dsexplore.qml.dimensiontypes.Element;
import de.uka.ipd.sdq.dsexplore.qml.dimensiontypes.Order;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link de.uka.ipd.sdq.dsexplore.qml.dimensiontypes.DimensionTypeEnum}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface DimensionTypeEnumValidator {
	boolean validate();

	boolean validateElements(EList<Element> value);
	boolean validateOrder(EList<Order> value);
}
