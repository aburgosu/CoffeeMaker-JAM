package main.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class IComponentTest {

	@Test
	public void turnOn_newComponentLightIndicator_correctResult() {
		IComponent interruptor = new LightIndicator();
		interruptor.turnOn();
		assertEquals(true, interruptor.getStatus());
	}

	@Test
	public void turnOn_newComponentValve_correctResult() {
		IComponent valve = new Valve();
		valve.turnOn();
		assertEquals(true, valve.getStatus());
	}
	
	@Test
	public void turnOn_newComponentHeatingElement_correctResult() {
		IComponent heater = new HeatingElement();
		heater.turnOn();
		assertEquals(true, heater.getStatus());
	}

}
