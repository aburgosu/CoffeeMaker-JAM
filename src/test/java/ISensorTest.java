package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.ISensor;
import main.java.PlateSensor;
import main.java.WaterSensor;

public class ISensorTest {

	@Test
	public void getStatus_waterSensor_correctResult() {
		ISensor waterSensor= new WaterSensor();
		assertEquals(0, waterSensor.getStatus());
	}
	
	@Test
	public void getStatus_plateSensor_correctResult() {
		ISensor plateSensor= new PlateSensor();
		assertEquals(0, plateSensor.getStatus());
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
