package game.cell_test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import game.Cell;
import object_mother.CellObjectMother;

public class TransferValueTest {

	@Test
	public void cellNoCombinedTransfersItsValueTest() {
		Cell cell = CellObjectMother.createNoCombinedCellValue4();
		assertEquals(4, cell.transferValue());
	}

	@Test
	public void cellCombinedCantTransfersItsValueTest() {
		Cell cell = CellObjectMother.createCombinedCell();
		assertEquals(0, cell.transferValue());
	}
}
