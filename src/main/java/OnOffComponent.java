package main.java;

public abstract class OnOffComponent implements IOnOffComponent{
	boolean status;
	
	OnOffComponent(){
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
