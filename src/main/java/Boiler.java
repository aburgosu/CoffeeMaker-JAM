package main.java;

public class Boiler {
	ISensor waterSensor;
	IComponent pressureValve;
	IComponent heatingElement;
	IContainer waterStrainer;

	Boiler() {
		waterSensor = new WaterSensor();
		pressureValve = new Valve();
		heatingElement = new HeatingElement();
		waterStrainer = new WaterStrainer(12, 0);// CoffeeMaker's totalCapacity is 12 cups
	}

	
	/**
	 * When the user pours water into the waterStrainer, waterStrainer capacityInUse is set, also waterSensor
	 * status is changed. 
	 */
	void pourWater(int cupsOfWater) {
		waterStrainer.setCapacityInUse(cupsOfWater);
		waterSensor.setStatus(1);
	}
	
	/**
	 * First there has to be water in the boiler, this is why there is a condition to get the waterSensor
	 * status, then the pressure valve should be closed and then heatingElement is turned on.
	 */
	void heatWater() {
		if (waterSensor.getStatus() == 1) {
			pressureValve.turnOff();
			heatingElement.turnOn();

		}
	}

	/**
	 * When it is necessary to stop the heating process, the pressureValve is opened and heatingElement is
	 * turned off.
	 */
	void stopHeatingWater() {
		pressureValve.turnOn();
		heatingElement.turnOff();
	}
}
