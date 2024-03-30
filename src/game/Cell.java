package game;

import java.util.Random;

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
		this.isCombined = true;
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

	public boolean isEmpty() {
		return this.value == 0;
	}

	public void generateRandomValue() {

		if (!this.isEmpty()) {
			throw new RuntimeException("Una celda con valor no puede generar otro valor");
		}

		Random random = new Random();

		int randomNumber = random.nextInt(2); // Genera un número aleatorio entre 0 (incluido) y 2 (excluido)

		int resultado = (randomNumber == 0) ? 2 : 4;

		this.value = resultado;
	}

	public void resetCombined() {
		this.isCombined = false;
	}

	public int getNumber() {
		return this.value;
	}

	private boolean sum(int valueToSum) {

		if (valueToSum == 0 || this.value == 0) {
			this.value += valueToSum;
			return false;
		}

		if (valueToSum != this.value)
			return false;

		this.value += valueToSum;

		return true;
	}
}
