package main.java;

public abstract class Sensor implements ISensor{
	protected int status;
	
	public Sensor(){
		status=0;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
