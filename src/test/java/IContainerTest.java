package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.IContainer;
import main.java.Pot;
import main.java.WaterContainer;

public class IContainerTest {

	@Test
	public void getCapacityInUse_waterStrainer_correctResult() {
		IContainer waterStrainer = new WaterContainer(12,6);
		assertEquals(6, waterStrainer.getCapacityInUse());
	}

	@Test
	public void getCapacityInUse_Pot_correctResult() {
		IContainer pot = new Pot(12,6);
		assertEquals(6, pot.getCapacityInUse());
	}
	
	@Test
	public void setCapacityInUse_waterStrainer_correctResult() {
		IContainer waterStrainer = new WaterContainer(12,6);
		waterStrainer.setCapacityInUse(7);
		assertEquals(7, waterStrainer.getCapacityInUse());
	}

	@Test
	public void setCapacityInUse_Pot_correctResult() {
		IContainer pot = new Pot(12,6);
		pot.setCapacityInUse(12);
		assertEquals(12, pot.getCapacityInUse());
	}
}
