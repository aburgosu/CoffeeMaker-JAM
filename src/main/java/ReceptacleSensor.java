package main.java;

public class ReceptacleSensor extends Sensor {
	static final int RECEPTACLE_EMPTY = 0;
	static final int RECEPTACLE_NOT_EMPTY = 1;

	public ReceptacleSensor() {
		status = RECEPTACLE_EMPTY;
	}
}
