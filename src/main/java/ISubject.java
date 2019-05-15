package main.java;

public interface ISubject {

	public void report();

	public void attach(IObserver observer);

	public void detach(IObserver observer);
}
