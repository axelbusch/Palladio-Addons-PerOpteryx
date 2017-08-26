package edu.kit.ipd.are.dsexplore.concern.concernweaver;

import java.util.List;

import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;

import ConcernModel.ElementaryConcernComponent;
import TransformationModel.Transformation;
import edu.kit.ipd.are.dsexplore.concern.util.Pair;

/**
 * This class is a container for the weaving instruction informations required
 * by the concern weaver.
 *
 * @author scheerer
 *
 */
public class WeavingInstruction {

	private final Pair<ElementaryConcernComponent, List<ProvidedRole>> eccWithConsumedFeatures;
	private final WeavingLocation weavingLocation;
	private final Transformation transformationStrategy;
	private final ResourceContainer resourceContainer;

	/**
	 * The constructor.
	 *
	 * @param eccWithConsumedFeatures
	 *            - A pair of an ECC with its corresponding provided features.
	 * @param weavingLocation
	 *            - The concrete weaving location in the PCM model.
	 * @param transformationStrategy
	 *            - The transformation strategy which defines the integration
	 *            mechanism.
	 * @param resourceContainer
	 *            - The resource container the ECC is going to be allocated.
	 */
	public WeavingInstruction(Pair<ElementaryConcernComponent, List<ProvidedRole>> eccWithConsumedFeatures, WeavingLocation weavingLocation, Transformation transformationStrategy,
			ResourceContainer resourceContainer) {
		this.eccWithConsumedFeatures = eccWithConsumedFeatures;
		this.weavingLocation = weavingLocation;
		this.transformationStrategy = transformationStrategy;
		this.resourceContainer = resourceContainer;
	}

	/**
	 * The getter-method of the ECC and provided features pair.
	 *
	 * @return a pair of an ECC and its provided features.
	 */
	public Pair<ElementaryConcernComponent, List<ProvidedRole>> getECCWithConsumedFeatures() {
		return this.eccWithConsumedFeatures;
	}

	/**
	 * The getter-method of the weaving location.
	 *
	 * @return the concrete weaving location in the PCM model.
	 */
	public WeavingLocation getWeavingLocation() {
		return this.weavingLocation;
	}

	/**
	 * The getter-method of the transformation strategy.
	 *
	 * @return the transformation strategy which defines the integration
	 *         mechanism.
	 */
	public Transformation getTransformationStrategy() {
		return this.transformationStrategy;
	}

	/**
	 * The getter-method of the resource container.
	 *
	 * @return the resource container the ECC is going to be allocated.
	 */
	public ResourceContainer getResourceContainer() {
		return this.resourceContainer;
	}

}
