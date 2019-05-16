package main.java;

public abstract class Container implements IContainer {
	protected int capacityInUse;
	protected int totalCapacity;

	/**
	 * Constructor requires one parameter to create the instance.
	 * 
	 * @param totalCapacity
	 */
	public Container(int totalCapacity) {
		this.capacityInUse = 0;
		this.totalCapacity = totalCapacity;
	}

	/**
	 * Set the capacity in use sending as parameter the new capacity in use.
	 */
	public void setCapacityInUse(int qty) {
		if (qty <= totalCapacity) {
			capacityInUse = qty;
		}
		// Needs exception in case input is more than totalCapacity
	}

	/**
	 * Returns the current capacity in use.
	 */
	public int getCapacityInUse() {
		return capacityInUse;
	}

	/**
	 * Increment the capacity in use by one cup.
	 */
	public void incrementCapacityInUse() {
		capacityInUse = capacityInUse + 1;
	}
}
