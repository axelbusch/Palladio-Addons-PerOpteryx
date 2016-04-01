/**
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.validation;

import de.uka.ipd.sdq.dsexplore.qml.contract.EnumRangeValueType;
import de.uka.ipd.sdq.dsexplore.qml.contract.ValueLiteral;

/**
 * A sample validator interface for {@link de.uka.ipd.sdq.dsexplore.qml.contract.RangeValue}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface RangeValueValidator {
	boolean validate();

	boolean validateRangeLimitLiteral(ValueLiteral value);
	boolean validateType(EnumRangeValueType value);
}
