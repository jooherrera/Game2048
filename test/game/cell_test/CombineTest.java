package game.cell_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import game.Cell;
import object_mother.CellObjectMother;

public class CombineTest {

	@Test
	public void combineEqualValuesTest() {
		Cell cellToCombine = CellObjectMother.createNoCombinedCellValue2();
		Cell cell = CellObjectMother.createNoCombinedCellValue2();

		int actualValue = cell.combine(cellToCombine);

		int expected = 4;
		assertEquals(expected, actualValue);
	}

	@Test
	public void combineWithOneCeroTest() {
		Cell cellToCombine = CellObjectMother.createNoCombinedCellValue2();
		Cell cell = CellObjectMother.createEmptyCell();

		int actualValue = cell.combine(cellToCombine);

		int expected = 0;
		assertEquals(expected, actualValue);
	}

	@Test
	public void combineWithOneCeroInverseTest() {
		Cell cellToCombine = CellObjectMother.createEmptyCell();
		Cell cell = CellObjectMother.createNoCombinedCellValue2();

		int actualValue = cell.combine(cellToCombine);

		int expected = 0;
		assertEquals(expected, actualValue);
	}

	@Test
	public void cantCombineDifferentsValuesTest() {
		Cell cellToCombine = CellObjectMother.createNoCombinedCellValue2();
		Cell cell = CellObjectMother.createNoCombinedCellValue4();

		int actualValue = cell.combine(cellToCombine);

		int expected = 0;
		assertEquals(expected, actualValue);
	}

	@Test
	public void cantCombineDifferentsValuesInverseTest() {
		Cell cellToCombine = CellObjectMother.createNoCombinedCellValue4();
		;
		Cell cell = CellObjectMother.createNoCombinedCellValue2();

		int actualValue = cell.combine(cellToCombine);

		int expected = 0;
		assertEquals(expected, actualValue);
	}

	@Test
	public void cantCombineWithACombinedCellTest() {
		Cell combinedCell = CellObjectMother.createCombinedCell();
		Cell cell = CellObjectMother.createNoCombinedCellValue2();

		int actualValue = combinedCell.combine(cell);

		int expected = 0;
		assertEquals(expected, actualValue);
	}

	@Test
	public void cantCombineWithACombinedCellInverseTest() {
		Cell cell = CellObjectMother.createNoCombinedCellValue2();
		Cell combinedCell = CellObjectMother.createCombinedCell();

		int actualValue = cell.combine(combinedCell);

		int expected = 0;
		assertEquals(expected, actualValue);
	}

	@Test
	public void cellSetValueToCeroAfterCombinedTest() {
		Cell cellToCombine = CellObjectMother.createNoCombinedCellValue2();
		Cell mainCell = CellObjectMother.createNoCombinedCellValue2();

		mainCell.combine(cellToCombine);

		boolean expected = cellToCombine.isEmpty();

		assertTrue(expected);
	}

}
