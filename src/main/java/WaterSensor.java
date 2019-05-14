package main.java;

public class WaterSensor extends Sensor {
	static final int BOILER_EMPTY = 0;
	static final int BOILER_NOT_EMPTY = 1;
	public WaterSensor() {
		status = WaterSensor.BOILER_EMPTY;
	}
}
