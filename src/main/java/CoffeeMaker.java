package main.java;

import java.util.Scanner;

public class CoffeeMaker {
	private Button button;
	private IComponent lightIndicator;
	private Boiler boiler;
	private WarmerPlate warmerPlate;

	/**
	 * CoffeeMaker creation with all its components, button, lightIndicator, boiler
	 * and warmerPlate
	 */
	public CoffeeMaker() {
		button = new Button();
		lightIndicator = new LightIndicator();
		boiler = new Boiler();
		warmerPlate = new WarmerPlate();
	}

	/**
	 * Once the button is pressed the CoffeeMaker starts with the brewing process
	 * 
	 * @param qtyCups - To start the process it is needed to give the quantity of
	 *                coffee cups
	 * @throws InterruptedException
	 */
	public void startProcess(int qtyCups) throws InterruptedException {
		startBrewing();
		if (coffeeDripping(qtyCups)) {
			lightIndicator.turnOn();
			System.out.println("Coffee ready");
		}
	}

	/**
	 * CoffeMaker starts the brewing process by heating the water
	 * 
	 * @throws InterruptedException
	 */
	public void startBrewing() throws InterruptedException {
		System.out.println("startBrewing...");
		boiler.heatWater();

	}

	/**
	 * After the water is boiling the coffee starts dripping in the pot. Once the
	 * dripping is finished the boiler stops its processes.
	 * 
	 * @param qtyCups
	 * @return
	 * @throws InterruptedException
	 */
	public boolean coffeeDripping(int qtyCups) throws InterruptedException {
		System.out.println("Coffee in delivery pipe");
		warmerPlate.incrementLiquidInPot(qtyCups);
		stopFlowOfWater();
		return true;
	}

	/**
	 * Boiler turn off its heating element and open the valve to relief the
	 * pressure.
	 */
	public void stopFlowOfWater() {
		boiler.stopHeatingWater();
	}

	/**
	 * Ground coffee is filled in the receptacle.
	 */
	public void fillGroundCoffee() {
		boiler.fillReceptacle();
	}
	
	/**
	 * Pour water in the boiler.
	 * @param qtyCups - Quantity of water cups that are poured in the boiler
	 */
	public void pourWaterInBoiler(int qtyCups) {
		boiler.pourWater(qtyCups);
	}
	
	/**
	 * Place the pot in warmerPlater.
	 */
	public void placePotInWarmerPlate() {
		warmerPlate.placePot();
	}
}
