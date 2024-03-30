package game.cell_test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import game.Cell;
import object_mother.CellObjectMother;

public class RandomValueTest {

	@Test
	public void emptyCellCanGenerateRandomValueTest() {
		Cell cell = CellObjectMother.createEmptyCell();

		cell.generateRandomValue();

		int value = cell.getNumber();

		assertTrue(value == 2 || value == 4);
	}

	@Test(expected = RuntimeException.class)
	public void cellWithValueCantGenerateRandomValueTest() {
		Cell cell = CellObjectMother.createNoCombinedCellValue2();

		cell.generateRandomValue();
	}

}
