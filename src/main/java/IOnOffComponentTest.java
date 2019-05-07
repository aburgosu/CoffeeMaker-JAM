package main.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class IOnOffComponentTest {

	@Test
	public void turnOn_newComponentLightIndicator_correctResult() {
		IOnOffComponent interruptor = new LightIndicator();
		interruptor.turnOn();
		assertEquals(true, interruptor.getStatus());
	}

	@Test
	public void turnOn_newComponentValve_correctResult() {
		IOnOffComponent valve = new Valve();
		valve.turnOn();
		assertEquals(true, valve.getStatus());
	}
	
	@Test
	public void turnOn_newComponentHeatingElement_correctResult() {
		IOnOffComponent heater = new HeatingElement();
		heater.turnOn();
		assertEquals(true, heater.getStatus());
	}

}
