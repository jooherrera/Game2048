package object_mother;

import game.Cell;

public class CellObjectMother {

	public static Cell createEmptyCell() {
		return Cell.create(0);
	}

	public static Cell createNoCombinedCellValue2() {
		return Cell.create(2);
	}

	public static Cell createNoCombinedCellValue4() {
		return Cell.create(4);
	}

	public static Cell createCombinedCell() {
		return new Cell(2, true);
	}

}
