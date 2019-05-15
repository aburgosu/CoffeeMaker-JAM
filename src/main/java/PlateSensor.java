package main.java;

import java.util.ArrayList;
import java.util.List;

public class PlateSensor extends Sensor implements ISubject {
	static final int WARMER_EMPTY = 0;
	static final int POT_EMPTY = 1;
	static final int POT_NOT_EMPTY = 2;

	public PlateSensor() {
		status = WARMER_EMPTY;
	}

	private List<IObserver> observers = new ArrayList<>();

	public void attach(IObserver observer) {
		observers.add(observer);
	}

	public void detach(IObserver observer) {
		observers.remove(observer);
	}

	public void report() {
		for (IObserver observer : observers) {
			observer.update();
		}
	}
}
