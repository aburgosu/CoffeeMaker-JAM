package main.java;

public abstract class Container implements IContainer{
	int capacityInUse;
	int totalCapacity;

	Container(int totalCapacity, int capacityInUse) {
		this.capacityInUse = capacityInUse;
		this.totalCapacity = totalCapacity;
	}
	
	
	public void setCapacityInUse(int qty) {
		if(qty<=totalCapacity) {
			capacityInUse = qty;
		}
		//Needs exception in case input is more than totalCapacity
	}

	public int getCapacityInUse() {
		return capacityInUse;
	}
}