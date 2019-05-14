package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.HeatingElement;
import main.java.IComponent;
import main.java.LightIndicator;
import main.java.Valve;

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
	
	@Test
	public void turnOff_newComponentLightIndicator_correctResult() {
		IComponent interruptor = new LightIndicator();
		interruptor.turnOn();
		interruptor.turnOff();
		assertEquals(false, interruptor.getStatus());
	}

	@Test
	public void turnOff_newComponentValve_correctResult() {
		IComponent valve = new Valve();
		valve.turnOn();
		valve.turnOff();
		assertEquals(false, valve.getStatus());
	}
	
	@Test
	public void turnOff_newComponentHeatingElement_correctResult() {
		IComponent heater = new HeatingElement();
		heater.turnOn();
		heater.turnOff();
		assertEquals(false, heater.getStatus());
	}


}
