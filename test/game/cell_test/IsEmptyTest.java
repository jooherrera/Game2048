package game.cell_test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import game.Cell;
import object_mother.CellObjectMother;

public class IsEmptyTest {

	@Test
	public void cellIsEmpty() {
		Cell cell = CellObjectMother.createEmptyCell();
		assertTrue(cell.isEmpty());
	}
	
	@Test
	public void cellIsNotEmpty() {
		Cell cell = CellObjectMother.createNoCombinedCellValue2();
		assertFalse(cell.isEmpty());
	}
}
