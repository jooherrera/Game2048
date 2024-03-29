package game.cell_test;


import static org.junit.Assert.*;

import org.junit.Test;

import game.Cell;

public class CreateTest {

	@Test(expected = IllegalArgumentException.class)
	public void invalidArgumentTest() {
		Cell.create(3);
	}

	@Test
	public void value2IsValidArgumentTest() {
		Cell cell = Cell.create(2);
		assertFalse(cell.isEmpty());
	}

	@Test
	public void value4isValidArgumentTest() {
		Cell cell = Cell.create(4);
		assertFalse(cell.isEmpty());
	}

}
