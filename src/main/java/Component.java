package main.java;


public class Component implements IComponent {
	protected boolean status;

	public Component() {
		status = false;
	}

	public void turnOn() {
		this.status = true;
	}

	public void turnOff() {
		this.status = false;
	}

	public boolean getStatus() {
		return status;
	}
}