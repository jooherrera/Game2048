package game;

public class Cell {
	private int value;
	private boolean isCombined;

	public static Cell create(int value) {
		boolean isCombined = false;
		return new Cell(value, isCombined);
	}

	public Cell(int value, boolean isCombined) {

		if (value != 2 && value != 4 && value != 0)
			throw new IllegalArgumentException(
					"Valor para celda inválido. Solo se permite los valores 2 y 4: " + value);

		this.value = value;
		this.isCombined = isCombined;
	}

	public int combine(Cell cell) {

		if (this.isCombined)
			return 0;

		int valueToAdd = cell.transferValue();

		boolean combined = this.sum(valueToAdd);

		if (!combined)
			return 0;

		cell.clear();
		return this.value;
	}

	public int transferValue() {
		if (this.isCombined)
			return 0;
		return this.value;
	}

	public void clear() {
		if (this.isCombined)
			return;

		this.value = 0;
	}

	private boolean sum(int valueToSum) {

		if (valueToSum == 0 || this.value == 0) {
			this.value += valueToSum;
			return false;
		}

		if (valueToSum != this.value)
			return false;

		this.value += valueToSum;
		this.isCombined = true;
		return true;
	}

	public boolean isEmpty() {
		return this.value == 0;
	}

}
