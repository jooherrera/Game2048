package game;

import java.util.Random;

public class Cell {
	private int value;
	private boolean combined;

	public static Cell create(int value) {
		boolean combined = false;
		return new Cell(value, combined);
	}

	public Cell(int value, boolean combined) {

//		if (value != 2 && value != 4 && value != 0)
//			throw new IllegalArgumentException(
//					"Valor para celda inválido. Solo se permite los valores 2 y 4: " + value);

		this.value = value;
		this.combined = combined;
	}

	public int combine(Cell cell) {

		if (this.isCombined() || cell.isCombined())
			return 0;

		if (this.value == 0 || cell.getNumber() == 0) {
			this.value += cell.transferValue();
			return 0;
		}

		if (this.value != cell.getNumber())
			return 0;

		int valueToAdd = cell.transferValue();
		this.value += valueToAdd;

		this.combined = true;
		return valueToAdd * 2;
	}

	private int transferValue() {
		int value = this.value;
		this.value = 0;
		return value;
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
		this.combined = false;
	}

	private boolean isCombined() {
		return this.combined;
	}

	public int getNumber() {
		return this.value;
	}

}
