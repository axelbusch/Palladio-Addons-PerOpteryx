package org.palladiosimulator.qualitymodel.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumLiteral;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.NumericLiteral;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SetLiteral;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.ValueLiteral;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionType;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeEnum;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeNumeric;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeSet;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Element;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumRelationSemantics;
// import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.NumericRange;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Order;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.RelationSemantics;

public class NqrUtil {

	public static double calculateSetValue(final SetLiteral setValue, final ArrayList<Element> rankedElements) {
		final Element[] values = (Element[]) setValue.getValues().toArray();
		double result = 0;
		if (values.length == 0) {
			return -1;
		}

		for (final Element value : values) {
			for (int j = 0; j < rankedElements.size(); ++j) {
				if (EcoreUtil.equals(rankedElements.get(j), value)) {
					result += j + 1;
				}
			}
		}

		return result;
	}

	public static double getNqrValue(final Dimension criterionDim, final Dimension targetDim,
			final ValueLiteral value) {
		final DimensionType type = criterionDim.getType();
		final RelationSemantics relSem = type.getRelationSemantics();
		final ValueLiteral targetLiteral = value;

		/*
		 * try{ targetLiteral =
		 * targetCrit.getAspects().get(0).getAspectRequirement().
		 * getAspectRequirementLiteral(); }catch(RuntimeException e) {
		 * System.err.println("Criterion does not apply"); e.printStackTrace();
		 * }
		 */

		double result;

		if (type instanceof DimensionTypeSet) {
			final DimensionTypeSet dts = (DimensionTypeSet) type;
			final List<Element> elems = dts.getElements();
			final List<Order> order = dts.getOrder();
			final ArrayList<Element> rankedElements = rankElements(elems, order, relSem);
			// HashMap<Element, Double> scoredElements =
			// scoreElements(rankedElements, scale);
			// final Element[] targetElement;
			if (targetLiteral instanceof SetLiteral) {
				// only first target element will be evaluated
				// targetElement =
				// (Element[])((SetLiteral)targetLiteral).getValues().toArray();
				result = calculateSetValue((SetLiteral) targetLiteral, rankedElements);
			} else {
				throw new RuntimeException("Mismatch between DimensionType and ValueLiteral");
			}
		} else if (type instanceof DimensionTypeEnum) {
			final DimensionTypeEnum dte = (DimensionTypeEnum) type;
			final List<Element> elems = dte.getElements();
			final List<Order> order = dte.getOrder();
			final ArrayList<Element> rankedElements = rankElements(elems, order, relSem);
			// HashMap<Element, Double> scoredElements =
			// scoreElements(rankedElements, scale);
			Element targetElement;
			if (targetLiteral instanceof EnumLiteral) {
				targetElement = ((EnumLiteral) targetLiteral).getValue();
			} else {
				throw new RuntimeException("Mismatch between DimensionType and ValueLiteral");
			}

			result = rankedElements.indexOf(targetElement);
		} else if (type instanceof DimensionTypeNumeric) {
			// final DimensionTypeNumeric dtn = (DimensionTypeNumeric) type;
			// final NumericRange range = dtn.getRange();
			// final double lower = range.getLowerLimit();
			// final double upper = range.getUpperLimit();
			Double targetValue;

			if (targetLiteral instanceof NumericLiteral) {
				// only first target element will be evaluated
				targetValue = ((NumericLiteral) targetLiteral).getValue();
			} else {
				throw new RuntimeException("Mismatch between DimensionType and ValueLiteral");
			}

			// result = (targetValue-lower)/(upper-lower);
			result = targetValue;
		} else {
			throw new RuntimeException("Wrong DimensionType!");
		}
		return result;
	}

	/*
	 * public static Element[] getElementsForCriterium(Criterion criterion) {
	 * DimensionType type = criterion.getDimension().getType();
	 * RelationSemantics relSem = type.getRelationSemantics(); ValueLiteral
	 * targetLiteral = criterion.getAspects().get(0).getAspectRequirement().
	 * getAspectRequirementLiteral();
	 *
	 * Element[] result;
	 *
	 * if (type instanceof DimensionTypeSet) { DimensionTypeSet dts =
	 * (DimensionTypeSet)type; List<Element> elems = dts.getElements();
	 * List<Order> order = dts.getOrder(); ArrayList<Element> rankedElements =
	 * rankElements(elems, order, relSem); HashMap<Element, Double>
	 * scoredElements = scoreElements(rankedElements); Element[] targetElement;
	 * if (targetLiteral instanceof SetLiteral) { // only first target element
	 * will be evaluated targetElement =
	 * (Element[])((SetLiteral)targetLiteral).getValues().toArray(); } else
	 * throw new
	 * RuntimeException("Mismatch between DimensionType and ValueLiteral");
	 * result = targetElement; } else if (type instanceof DimensionTypeEnum) {
	 * DimensionTypeEnum dte = (DimensionTypeEnum)type; List<Element> elems =
	 * dte.getElements(); List<Order> order = dte.getOrder(); ArrayList<Element>
	 * rankedElements = rankElements(elems, order, relSem); HashMap<Element,
	 * Double> scoredElements = scoreElements(rankedElements); Element
	 * targetElement; if (targetLiteral instanceof EnumLiteral) { targetElement
	 * = ((EnumLiteral)targetLiteral).getValue(); } else throw new
	 * RuntimeException("Mismatch between DimensionType and ValueLiteral");
	 *
	 * result = new Element[1]; result[0] = targetElement; } else if (type
	 * instanceof DimensionTypeNumeric) { DimensionTypeNumeric dtn =
	 * (DimensionTypeNumeric)type; NumericRange range = dtn.getRange(); double
	 * lower = range.getLowerLimit(); double upper = range.getUpperLimit();
	 * Double targetValue;
	 *
	 * if (targetLiteral instanceof NumericLiteral) { // only first target
	 * element will be evaluated targetValue =
	 * ((NumericLiteral)targetLiteral).getValue(); } else throw new
	 * RuntimeException("Mismatch between DimensionType and ValueLiteral");
	 *
	 * result = new Element[1]; //result[0] = (targetValue-lower)/(upper-lower);
	 * } else throw new RuntimeException("Wrong DimensionType!"); return result;
	 * }
	 */

	/*
	 * public static HashMap<Element, Double> scoreElements(List<Element> elems)
	 * { HashMap<Element, Double> resultMap = new HashMap<Element, Double>();
	 * double factor = 0.0; factor = 1.0/(elems.size()-1); for (int i = 0; i <
	 * elems.size(); ++i) resultMap.put(elems.get(i), factor * i); return
	 * resultMap; }
	 */

	public static ArrayList<Element> rankElements(final List<Element> elems, final List<Order> order,
			final RelationSemantics relSem) {
		assert (order.size() > 0);
		final ArrayList<Element> resultOrder = new ArrayList<Element>();

		resultOrder.add(order.get(0).getBiggerElement());
		resultOrder.add(order.get(0).getSmallerElement());

		for (int i = 1; i < order.size(); ++i) {
			final Order ord = order.get(i);
			if (!resultOrder.contains(ord.getBiggerElement())) {
				resultOrder.add(0, ord.getBiggerElement());
			}
			if (!resultOrder.contains(ord.getSmallerElement())) {
				resultOrder.add(resultOrder.indexOf(ord.getBiggerElement()) + 1, ord.getSmallerElement());
			}
		}

		if (relSem.getRelSem() == EnumRelationSemantics.INCREASING) {
			Collections.reverse(resultOrder);
		}
		return resultOrder;
	}

}