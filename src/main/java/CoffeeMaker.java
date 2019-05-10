package main.java;

import java.util.Scanner;

public class CoffeeMaker {
	private Button button;
	private IComponent lightIndicator;
	private Boiler boiler;
	private WarmerPlate warmerPlate;

	public CoffeeMaker() {
		button = new Button();
		lightIndicator = new LightIndicator();
		boiler = new Boiler();
		warmerPlate = new WarmerPlate();

		System.out.println("Coffeemaker created");
	}

	public void startProcess() throws InterruptedException {
		warmerPlate.placePot();
		System.out.println("How many cups of coffee do you want?");
		Scanner inputScan = new Scanner(System.in);
		int qtyCups = inputScan.nextInt();
		boiler.pourWater(qtyCups);

		System.out.println("Waiting for start Button...");
		int input = inputScan.nextInt();
		if (input == 1)
			button.press();

		if (button.isPressed()) {
			System.out.println("startButton pressed");
			startBrewing();
			coffeeDripping(qtyCups);
			lightIndicator.turnOn();
			System.out.println("LightIndicator ON, coffee ready");
		}

	}

	public void startBrewing() throws InterruptedException {
		System.out.println("startBrewing...");
		boiler.heatWater();

	}

	public void coffeeDripping(int qtyCups) throws InterruptedException {
		System.out.println("Coffee in delivery pipe");
		warmerPlate.incrementLiquidInPot(qtyCups);
		stopFlowOfWater();
		System.out.println("Boiler's heatingElement turned OFF, pressureValve opened");
	}

	public void stopFlowOfWater() {
		boiler.stopHeatingWater();
	}
}
