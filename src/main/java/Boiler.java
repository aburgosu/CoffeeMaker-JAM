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
		waterStrainer = new WaterStrainer(12, 0);// CoffeeMaker totalCapacity is 12 cups
	}

	void heatWater() {
		if (waterSensor.getStatus() == 1) {
			pressureValve.turnOff();
			heatingElement.turnOn();

		}

	}

	void stopHeatingWater() {
		pressureValve.turnOn();
		heatingElement.turnOff();
	}
}
