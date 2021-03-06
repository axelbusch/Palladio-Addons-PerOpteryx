package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.ecore.EObject;
import org.opt4j.core.problem.Creator;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.facade.IModule;
import de.uka.ipd.sdq.dsexplore.facade.ModuleRegistry;
import de.uka.ipd.sdq.dsexplore.gdof.GenomeToCandidateModelTransformation;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ClassChoice;
import de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionFactory;
import de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionFactoryImpl;
import de.uka.ipd.sdq.pcm.designdecision.specific.ClassDegree;
import de.uka.ipd.sdq.pcm.designdecision.specific.ContinuousRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.specific.DiscreteDegree;
import de.uka.ipd.sdq.pcm.designdecision.specific.DiscreteRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.specific.IndicatorDegree;
import de.uka.ipd.sdq.pcm.designdecision.specific.OrderedIntegerDegree;

/**
 * The {@link DSECreator} is responsible for randomly creating genotypes in the
 * solution space. It can query the {@link DSEProblem} for the available design
 * space.
 *
 * @author Anne
 *
 */
public class DSECreator implements Creator<DesignDecisionGenotype> {

	private DSEProblem problem;
	private Random random;

	private int numberOfNotEvaluatedPredefinedOnes;

	@Inject
	public DSECreator() {
		// XXX like this you can only set the problem once. Maybe dont save the
		// reference.
		this.problem = Opt4JStarter.getProblem();
		this.random = new Random();
		this.numberOfNotEvaluatedPredefinedOnes = this.problem.getInitialGenotypeList().size();
	}

	@Override
	public DesignDecisionGenotype create() {

		if (this.numberOfNotEvaluatedPredefinedOnes > 0) {
			DesignDecisionGenotype genome = this.problem.getInitialGenotypeList().get(this.problem.getInitialGenotypeList().size() - this.numberOfNotEvaluatedPredefinedOnes);
			this.numberOfNotEvaluatedPredefinedOnes--;
			return genome;

		}

		DesignDecisionGenotype genotype = new DesignDecisionGenotype();

		List<DegreeOfFreedomInstance> degrees = this.problem.getDesignDecisions();
		for (DegreeOfFreedomInstance DegreeOfFreedomInstance : degrees) {
			genotype.add(this.createRandomChoice(DegreeOfFreedomInstance));
		}

		return genotype;
	}

	private int createIntegerValue(DiscreteDegree discDegree) {

		if (discDegree instanceof DiscreteRangeDegree) {
			DiscreteRangeDegree dicRangeDegree = (DiscreteRangeDegree) discDegree;
			int range = dicRangeDegree.getTo() - dicRangeDegree.getFrom();
			if (!dicRangeDegree.isLowerBoundIncluded()) {
				range--;
			}
			if (!dicRangeDegree.isUpperBoundIncluded()) {
				range--;
			}
			// random.nextInt creates a random value between 0 <= x < param. I
			// want one 0 <= x <= range. Thus, I add 1
			int value = dicRangeDegree.getFrom() + this.random.nextInt(range + 1);
			return value;
		} else if (discDegree instanceof OrderedIntegerDegree) {
			OrderedIntegerDegree orderedIntegerDegree = (OrderedIntegerDegree) discDegree;
			int randomIndex = this.random.nextInt(orderedIntegerDegree.getListOfIntegers().size());
			return orderedIntegerDegree.getListOfIntegers().get(randomIndex);
		} else {
			throw new RuntimeException("Unknown degree " + discDegree.getClass().getName());
		}

	}

	private double createDoubleValue(ContinuousRangeDegree contDegree) {
		double lowerMargin = 0;
		if (contDegree.isLowerBoundIncluded()) {
			lowerMargin = Double.MIN_VALUE;
		}
		double upperMargin = 0;
		if (contDegree.isUpperBoundIncluded()) {
			upperMargin = Double.MIN_VALUE;
		}
		double factor = contDegree.getTo() - upperMargin - contDegree.getFrom() - lowerMargin;

		return contDegree.getFrom() + lowerMargin + this.random.nextDouble() * factor;

	}

	public Choice createRandomChoice(DegreeOfFreedomInstance degree) {
		designdecisionFactory factory = designdecisionFactoryImpl.init();

		Choice choice;
		IModule module;
		// Check whether module want to handle this degree.
		if ((module = this.getModule(degree)) != null) {
			choice = module.getCreateExtension().getChoice(degree);
		} else if (degree instanceof IndicatorDegree) {
			choice = this.processIndicator(degree, factory);
		} else if (degree instanceof DiscreteDegree) {
			DiscreteRangeChoice discChoice = factory.createDiscreteRangeChoice();
			discChoice.setChosenValue(this.createIntegerValue((DiscreteDegree) degree));
			choice = discChoice;
		} else if (degree instanceof ContinuousRangeDegree) {
			ContinousRangeChoice contChoice = factory.createContinousRangeChoice();
			contChoice.setChosenValue(this.createDoubleValue((ContinuousRangeDegree) degree));
			choice = contChoice;
		} else if (degree instanceof ClassDegree) {
			ClassChoice enumChoice = factory.createClassChoice();
			enumChoice.setChosenValue(this.createRandomEntity((ClassDegree) degree));
			choice = enumChoice;
		} else if (degree.getDof() != null) {
			Object chosenValue = this.createRandomValue(degree);
			if (chosenValue instanceof EObject) {
				ClassChoice classChoice = factory.createClassChoice();
				classChoice.setChosenValue((EObject) chosenValue);
				choice = classChoice;
			} else if (chosenValue instanceof Double) {
				ContinousRangeChoice continuousNumberChoice = factory.createContinousRangeChoice();
				continuousNumberChoice.setChosenValue(((Double) chosenValue).doubleValue());
				choice = continuousNumberChoice;
			} else if (chosenValue instanceof Integer) {
				DiscreteRangeChoice integerNumberChoice = factory.createDiscreteRangeChoice();
				integerNumberChoice.setChosenValue(((Integer) chosenValue).intValue());
				choice = integerNumberChoice;
			} else {
				throw new RuntimeException("Cannot handle choice returned by GDoF transformation " + chosenValue.getClass().getName());
			}
		} else {
			throw new RuntimeException("Unknown degree " + degree.getClass().getName());
		}
		choice.setDegreeOfFreedomInstance(degree);
		return choice;
	}

	private IModule getModule(DegreeOfFreedomInstance degree) {
		for (IModule module : ModuleRegistry.getModuleRegistry().getModules()) {
			if (module.getCreateExtension().shallHandle(degree)) {
				return module;
			}
		}
		return null;
	}

	/**
	 * Process an {@link IndicatorDegree}.
	 *
	 * @param degree
	 *            the degree
	 * @param factory
	 *            the factory
	 * @return the choice (initialized with {@code null} or another default
	 *         value) for the degree
	 * @author Dominik Fuchss
	 */
	private Choice processIndicator(DegreeOfFreedomInstance degree, designdecisionFactory factory) {
		throw new RuntimeException("Unknown indicator " + degree.getClass().getName());
	}

	private Object createRandomValue(DegreeOfFreedomInstance degree) {

		Collection<Object> possibleValues = GenomeToCandidateModelTransformation.valueRuleForCollection(degree.getDof().getPrimaryChangeable(), degree.getPrimaryChanged(),
				GenomeToCandidateModelTransformation.getPCMRootElements(Opt4JStarter.getProblem().getInitialInstance()));

		List<Object> list;
		if (possibleValues instanceof List) {
			list = (List<Object>) possibleValues;
		} else {
			list = new ArrayList<>(possibleValues);
		}

		int index = this.random.nextInt(list.size());
		return list.get(index);
	}

	private EObject createRandomEntity(ClassDegree enumDegree) {
		List<EObject> domain = enumDegree.getClassDesignOptions();
		int index = this.random.nextInt(domain.size());
		return domain.get(index);

	}

	public void setNumberOfNotEvaluatedPredefinedOnes(int numberOfNotEvaluatedPredefinedOnes) {
		this.numberOfNotEvaluatedPredefinedOnes = numberOfNotEvaluatedPredefinedOnes;
	}

	public int getNumberOfNotEvaluatedPredefinedOnes() {
		return this.numberOfNotEvaluatedPredefinedOnes;
	}
}
