package main.java;

public class Boiler {
	private ISensor waterSensor;
	private ISensor receptacleSensor;
	private IComponent pressureValve;
	private IComponent heatingElement;
	private IContainer waterContainer;
	
	public Boiler() {
		waterSensor = new WaterSensor();
		pressureValve = new Valve();
		heatingElement = new HeatingElement();
		receptacleSensor = new ReceptacleSensor();
		waterContainer = new WaterContainer(12, 0);// CoffeeMaker's totalCapacity is 12 cups
	}

	/**
	 * When the user pours water into the waterStrainer, waterStrainer capacityInUse
	 * is set, also waterSensor status is changed.
	 */
	public void pourWater(int cupsOfWater) {
		waterContainer.setCapacityInUse(cupsOfWater);
		waterSensor.setStatus(WaterSensor.BOILER_NOT_EMPTY);
	}

	/**
	 * This methods returns the waterContainer capacity in use.
	 */
	public int getCupsPrepared() {
		return waterContainer.getCapacityInUse();
	}

	/**
	 * First there has to be water in the boiler, this is why there is a condition
	 * to get the waterSensor status, then the pressure valve should be closed and
	 * then heatingElement is turned on.
	 * 
	 * @throws InterruptedException
	 */
	public void heatWater() throws InterruptedException {
		if (waterSensor.getStatus() == WaterSensor.BOILER_NOT_EMPTY
				&& receptacleSensor.getStatus() == ReceptacleSensor.RECEPTACLE_NOT_EMPTY) {
			pressureValve.turnOff();
			System.out.println("pressureValve closed");
			heatingElement.turnOn();
			System.out.println("heatingElement turned On");
			for (int i = 0; i < waterContainer.getCapacityInUse(); i++) {
				Thread.sleep(1000);
				System.out.println("heating " + (i + 1));
			}
			System.out.println("<<boiling point>>");
		}
	}

	/**
	 * When it is necessary to stop the heating process, the pressureValve is opened
	 * and heatingElement is turned off.
	 */
	public void stopHeatingWater() {
		pressureValve.turnOn();
		heatingElement.turnOff();
	}

	/**
	 * Ground coffee is filled in the receptacle, sensor status is changed.
	 */
	public void fillReceptacle() {
		receptacleSensor.setStatus(ReceptacleSensor.RECEPTACLE_NOT_EMPTY);
	}

}
