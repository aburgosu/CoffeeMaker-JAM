package main.java;

public abstract class Component implements IComponent{
	protected boolean status;
	
	Component(){
		status=false;
	}
	
	public void turnOn() {
		this.status=true;
		
	}

	public void turnOff() {
		this.status=false;
		
	}

	public boolean getStatus() {
		
		return status;
	}
}
