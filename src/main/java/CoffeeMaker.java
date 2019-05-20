package main.java;

import java.util.Scanner;

public class CoffeeMaker {
	private IComponent lightIndicator;
	private Boiler boiler;
	private WarmerPlate warmerPlate;

	/**
	 * CoffeeMaker creation with all its components, button, lightIndicator, boiler
	 * and warmerPlate
	 */
	public CoffeeMaker() {
		lightIndicator = new Component();
		boiler = new Boiler();
		warmerPlate = new WarmerPlate();
	}

	/**
	 * Once the button is pressed the CoffeeMaker starts with the brewing process
	 * First boils water Then starts coffee dripping.
	 * 
	 * @param qtyCups - To start the process it is needed to give the quantity of
	 *                coffee cups
	 * @throws InterruptedException
	 */
	public void brewCoffee(int qtyCups) throws InterruptedException {
		if (warmerPlate.isPotInPlace()) {
			System.out.println("Starting brewing process");
			boiler.heatWater();
			if (coffeeDripping(qtyCups)) {
				lightIndicator.turnOn();
				System.out.println("Coffee ready");
				System.out.println("Coffee ready");
			}
		} else {
			System.out.println("Please place pot in warmerPlate");
		}
	}

	/**
	 * After the water is boiling the coffee starts dripping in the pot. Once the
	 * dripping is finished the boiler stops its processes.
	 * 
	 * @param qtyCups
	 * @return true if the cycle is finished
	 * @throws InterruptedException
	 */
	public boolean coffeeDripping(int qtyCups) throws InterruptedException {
		System.out.println("Coffee in delivery pipe");
		if (warmerPlate.incrementLiquidInPot(qtyCups) == qtyCups) {
			boiler.stopHeatingWater();
			return true;
		} else
			return false;
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
	 * 
	 * @param qtyCups - Quantity of water cups that are poured in the boiler.
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

	/**
	 * Lift the pot in warmerPlater.
	 */
	public void liftPot() {
		warmerPlate.liftPot();
	}

	/**
	 * Get the actual status of Warmer Plate.
	 */
	public int getWarmerPlateStatus() {
		return warmerPlate.getSensorStatus();
	}

	/**
	 * Get the actual status of Warmer Plate.
	 */
	public int getWaterOfBoiler() {
		return boiler.getCupsPouredIn();
	}

}
