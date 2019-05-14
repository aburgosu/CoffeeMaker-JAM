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

	/**
	 * To warm the pot, once is verified that the pot is in place and not empty
	 * (potNotEmpty), warmerPlate's heating element is turned on.
	 */
	void warmPot() {
		if (plateSensor.getStatus() == PlateSensor.POT_NOT_EMPTY) {
			heatingElement.turnOn();
			System.out.println("warming the pot");
		}
	}

	/**
	 * To stop warming the pot, the heating element is turned off.
	 */
	void stopWarmingPot() {
		heatingElement.turnOff();
	}

	/**
	 * Placing the pot changes the sensor status to potEmpty.
	 */
	void placePot() {
		plateSensor.setStatus(PlateSensor.POT_EMPTY);
	}

	/**
	 * Lifting the pot changes the sensor status to warmerEmpty.
	 */
	void liftPot() {
		plateSensor.setStatus(PlateSensor.WARMER_EMPTY);
	}

	/**
	 * Increment the liquid in pot cup by cup beginning in zero until the quantity
	 * required.
	 * 
	 * @param qtyCups
	 * @throws InterruptedException
	 */
	void incrementLiquidInPot(int qtyCups) throws InterruptedException {
		plateSensor.setStatus(PlateSensor.POT_NOT_EMPTY);
		warmPot();
		for (int i = 0; i < qtyCups; i++) {
			Thread.sleep(1000);
			System.out.println("Coffee dripping " + (i + 1));
			pot.incrementCapacityInUse();
		}

	}
}
