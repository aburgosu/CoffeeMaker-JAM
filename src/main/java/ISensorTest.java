package main.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class ISensorTest {

	@Test
	public void getStatus_waterSensor_correctResult() {
		ISensor waterSensor= new WaterSensor();
		assertEquals(1, waterSensor.getStatus());
	}
	
	@Test
	public void getStatus_plateSensor_correctResult() {
		ISensor plateSensor= new PlateSensor();
		assertEquals(2, plateSensor.getStatus());
	}
 
	@Test
	public void setStatus_waterSensor_correctResult() {
		ISensor waterSensor= new WaterSensor();
		waterSensor.setStatus(0);
		assertEquals(0, waterSensor.getStatus() );
	}
	
	@Test
	public void setStatus_plateSensor_correctResult() {
		ISensor plateSensor= new PlateSensor();
		plateSensor.setStatus(0);
		assertEquals(0, plateSensor.getStatus());
	}
}
