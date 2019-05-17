package main.java;

public class LightIndicator extends Component {
	public void turnOn() {
		this.status = true;
		System.out.println("LightIndicator ON");
	}

	public void turnOff() {
		this.status = false;
		System.out.println("LightIndicator OFF");
	}
}
