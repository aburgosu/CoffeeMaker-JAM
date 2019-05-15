package main.java;

public class HeatingElement extends Component {
	public void turnOn() {
		this.status = true;
		System.out.println("HeatingElement ON");
	}

	public void turnOff() {
		this.status = false;
		System.out.println("HeatingElement OFF");
	}
}
