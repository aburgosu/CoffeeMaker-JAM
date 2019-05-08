package main.java;

public class Button {
	boolean status;

	Button() {
		status = false;
	}

	boolean isPressed() {
		return status;
	}

	void press() {
		status = true;
	}

}
