package main.java;

public class PlateSensor extends Sensor {
	static final int WARMER_EMPTY = 0;
	static final int POT_EMPTY = 1;
	static final int POT_NOT_EMPTY = 2;

	public PlateSensor() {
		status = WARMER_EMPTY;
	}
}
