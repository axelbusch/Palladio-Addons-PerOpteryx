package de.uka.ipd.sdq.dsexplore.tools.primitives;

import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * Encapsulation-class for two elements.
 *
 * @author Max Scheerer
 *
 * @param <T>
 *            - First element of the pair.
 * @param <U>
 *            - Second element of the pair.
 */
public final class Pair<T, U> extends EObjectImpl {

	public final T first;
	public final U second;

	/**
	 * The constructor.
	 *
	 * @param first
	 *            - First element of the pair.
	 * @param second
	 *            - Second element of the pair.
	 */
	public Pair(T first, U second) {
		this.first = first;
		this.second = second;
	}

	/**
	 * Getter for the first element.
	 *
	 * @return The first element.
	 */
	public T getFirst() {
		return this.first;
	}

	/**
	 * Getter for the second element.
	 *
	 * @return The second element.
	 */
	public U getSecond() {
		return this.second;
	}

	public static <T, U> Pair<T, U> of(T first, U second) {
		return new Pair<>(first, second);
	}

	@Override
	public String toString() {
		return "Pair [first=" + this.first + ", second=" + this.second + "]";
	}

}
