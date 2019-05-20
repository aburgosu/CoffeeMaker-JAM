package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Component;
import main.java.IComponent;


public class IComponentTest {

	@Test
	public void turnOn_correctResult() {
		IComponent interruptor = new Component();
		interruptor.turnOn();
		assertEquals(true, interruptor.getStatus());
	}

	@Test
	public void turnOff_correctResult() {
		IComponent valve = new Component();
		valve.turnOn();
		valve.turnOff();
		assertEquals(false, valve.getStatus());
	}
	
	@Test
	public void getStatus_on_correctResult() {
		IComponent heater = new Component();
		heater.turnOn();
		assertEquals(true, heater.getStatus());
	}
	
	@Test
	public void getStatus_off_correctResult() {
		IComponent heater = new Component();
		heater.turnOff();
		assertEquals(false, heater.getStatus());
	}
}
