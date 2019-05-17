package main.java;

public class WarmerPlate implements IObserver {
	private ISensor plateSensor;
	private IComponent heatingElement;
	private IContainer pot;

	public WarmerPlate() {
		plateSensor = new PlateSensor();
		heatingElement = new HeatingElement();
		pot = new Pot(12);// CoffeeMaker's totalCapacity is 12 cups
		((ISubject) plateSensor).attach(this);
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
		((ISubject) plateSensor).report();
	}

	/**
	 * Lifting the pot changes the sensor status to warmerEmpty.
	 */
	void liftPot() {
		plateSensor.setStatus(PlateSensor.WARMER_EMPTY);
		((ISubject) plateSensor).report();
	}

	/**
	 * Increment the liquid in pot cup by cup beginning in zero until the quantity
	 * required. Returns true if the qtyPreparedCups is equal to qtyCups.
	 * 
	 * @param qtyCups
	 * @throws InterruptedException
	 */
	int incrementLiquidInPot(int qtyCups) throws InterruptedException {
		int qtyPreparedCups = 0;
		plateSensor.setStatus(PlateSensor.POT_NOT_EMPTY);
		((ISubject) plateSensor).report();
		for (int i = 0; i < qtyCups; i++) {
			Thread.sleep(1000);
			qtyPreparedCups = i + 1;
			System.out.println("Coffee dripping " + qtyPreparedCups);
			pot.incrementCapacityInUse();
		}
		return qtyPreparedCups;
	}

	/**
	 * Override of IObserver's method. Update its state according a change in
	 * Subject. The update is reflected in the turn On/Off of the warmerPlate's
	 * heating element.
	 */
	public void update() {
		if (plateSensor.getStatus() == PlateSensor.WARMER_EMPTY || plateSensor.getStatus() == PlateSensor.POT_EMPTY) {
			heatingElement.turnOff();
			System.out.println("warmerPlate's heatingElement OFF");
		} else if (plateSensor.getStatus() == PlateSensor.POT_NOT_EMPTY) {
			heatingElement.turnOn();
			System.out.println("warmerPlate's heatingElement ON");
		}
	}

	/**
	 * @return true - if Pot is placed in warmerPlate.
	 */
	public boolean isPotInPlace() {
		return plateSensor.getStatus() == PlateSensor.POT_EMPTY;
	}
	
	public int getSensorStatus() {
		return plateSensor.getStatus();
	}
	
}
