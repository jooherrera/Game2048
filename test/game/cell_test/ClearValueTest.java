package game.cell_test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import game.Cell;
import object_mother.CellObjectMother;

public class ClearValueTest {
	@Test
	public void cellNoCombinedCanClearItsValueTest() {
		Cell cell = CellObjectMother.createNoCombinedCellValue2();

		cell.clear();

		assertTrue(cell.isEmpty());
	}

	@Test
	public void cellCombinedCantClearItsValueTest() {
		Cell cell = CellObjectMother.createCombinedCell();

		cell.clear();

		assertFalse(cell.isEmpty());
	}

}
