package main.java;

public class Button {
	private boolean status;

	public Button() {
		status = false;
	}

	public boolean isPressed() {
		return status;
	}

	public void press() {
		status = true;
	}

}
