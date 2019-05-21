package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Container;
import main.java.IContainer;

public class IContainerTest {

	@Test
	public void getCapacityInUse_correctResult() {
		IContainer waterStrainer = new Container(12);
		assertEquals(0, waterStrainer.getCapacityInUse());
	}

	@Test
	public void setCapacityInUse_correctResult() {
		IContainer waterStrainer = new Container(12);
		waterStrainer.setCapacityInUse(7);
		assertEquals(7, waterStrainer.getCapacityInUse());
	}
}
