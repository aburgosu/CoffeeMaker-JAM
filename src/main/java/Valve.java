package main.java;

public class Valve extends Component {
	public void turnOn() {
		this.status = true;
		System.out.println("Valve OPEN");
	}

	public void turnOff() {
		this.status = false;
		System.out.println("Valve CLOSED");
	}
}
