package main.java;

public class CoffeeMaker {
	Button button;
	IComponent lightIndicator;
	Boiler boiler;
	WarmerPlate warmerPlate;

	CoffeeMaker() {
		button = new Button();
		lightIndicator = new LightIndicator();
		boiler = new Boiler();
		warmerPlate = new WarmerPlate();
	}

	void startBrewing() {
		boiler.heatWater();
		warmerPlate.incrementLiquidInPot();
		warmerPlate.warmPot();
	}

	void stopFlowOfWater() {
		boiler.stopHeatingWater();
	}
}
