package main.java;

public class WarmerPlate {
	ISensor plateSensor;
	IComponent heatingElement;
	IContainer pot;

	WarmerPlate() {
		plateSensor = new PlateSensor();
		heatingElement = new HeatingElement();
		pot = new Pot(12, 0);
	}

	void warmPot() {
		if(plateSensor.getStatus()==2) {
			heatingElement.turnOn();
		}
	}

	void stopWarmingPot() {
		heatingElement.turnOff();
	}
	
	void placePot() {
		plateSensor.setStatus(1);
	}
	
	void takePot() {
		plateSensor.setStatus(0);
	}
	
	void incrementLiquidInPot() {
		pot.incrementCapacityInUse();
		plateSensor.setStatus(2);
	}
}
