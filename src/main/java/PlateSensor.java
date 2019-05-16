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

	/**
	 * Override of ISubject's method.
	 * Attach one observer to observers list.
	 */
	public void attach(IObserver observer) {
		observers.add(observer);
	}

	/**
	 * Override of ISubject's method.
	 * Detach indicated observer from observers list.
	 */
	public void detach(IObserver observer) {
		observers.remove(observer);
	}

	/**
	 * Override of ISubject's method.
	 * Report to all observers about changes in Subject.
	 */
	public void report() {
		for (IObserver observer : observers) {
			observer.update();
		}
	}
}
