package edu.kit.ipd.are.dsexplore.concern.weavingstrategy;

import edu.kit.ipd.are.dsexplore.concern.concernweaver.WeavingInstruction;
import edu.kit.ipd.are.dsexplore.concern.exception.ConcernWeavingException;

/**
 * The weaving strategy interface contains all methods that need to be
 * implemented in order to integrate a concern solution into a given PCM model
 * according to the strategy of a class implementing this interface.
 * 
 * @author scheerer
 *
 */
public interface IWeavingStrategy {

	/**
	 * Weaves an adapter into the PCM repository.
	 * 
	 * @param weavingInstruction
	 *            - The weaving instructions contains all informations necessary
	 *            to perform a proper weaving process.
	 * @throws ConcernWeavingException
	 *             - Will be thrown if there occurs any error during the weaving
	 *             process.
	 */
	public abstract void weaveRepository(WeavingInstruction weavingInstruction) throws ConcernWeavingException;

	/**
	 * Weaves an adapter into the PCM system.
	 * 
	 * @param weavingInstruction
	 *            - The weaving instructions contains all informations necessary
	 *            to perform a proper weaving process.
	 * @throws ConcernWeavingException
	 *             - Will be thrown if there occurs any error during the weaving
	 *             process.
	 */
	public abstract void weaveAssembly(WeavingInstruction weavingInstruction) throws ConcernWeavingException;

	/**
	 * Weaves an adapter into the PCM allocation.
	 * 
	 * @param weavingInstruction
	 *            - The weaving instructions contains all informations necessary
	 *            to perform a proper weaving process.
	 * @throws ConcernWeavingException
	 *             - Will be thrown if there occurs any error during the weaving
	 *             process.
	 */
	public abstract void weaveAllocation(WeavingInstruction weavingInstruction) throws ConcernWeavingException;

	/**
	 * Weaves adapters SEFF.
	 * 
	 * @param weavingInstruction
	 *            - The weaving instructions contains all informations necessary
	 *            to perform a proper weaving process.
	 * @throws ConcernWeavingException
	 *             - Will be thrown if there occurs any error during the weaving
	 *             process.
	 */
	public abstract void weaveServiceEffectSpecification(WeavingInstruction weavingInstruction) throws ConcernWeavingException;

	/**
	 * Weaves an adapter into the PCM usage model.
	 * 
	 * @param weavingInstruction
	 *            - The weaving instructions contains all informations necessary
	 *            to perform a proper weaving process.
	 * @throws ConcernWeavingException
	 *             - Will be thrown if there occurs any error during the weaving
	 *             process.
	 */
	public abstract void weaveUsageModel(WeavingInstruction weavingInstruction) throws ConcernWeavingException;

}
