package main.java;

public class WarmerPlate {
	ISensor plateSensor;
	IComponent heatingElement;
	IContainer pot;

	WarmerPlate() {
		plateSensor = new PlateSensor();
		heatingElement = new HeatingElement();
		pot = new Pot(12, 0);// CoffeeMaker's totalCapacity is 12 cups
	}

	void warmPot() {
		if (plateSensor.getStatus() == 2) {
			heatingElement.turnOn();
			System.out.println("warming the pot");
		}
	}

	void stopWarmingPot() {
		heatingElement.turnOff();
	}

	void placePot() {
		plateSensor.setStatus(1);
	}

	void liftPot() {
		plateSensor.setStatus(0);
	}

	void incrementLiquidInPot(int qtyCups) throws InterruptedException {
		plateSensor.setStatus(2);
		warmPot();
		for (int i = 0; i < qtyCups; i++) {
			Thread.sleep(1000);
			System.out.println("Coffee dripping " + (i + 1));
			pot.incrementCapacityInUse();
		}

	}
}
