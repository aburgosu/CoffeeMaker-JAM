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
		if()
	}

	void stopWarmingPot() {

	}
}
