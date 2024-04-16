package game;

import java.util.Random;

public class Cell {
	private int value;

	public static Cell create(int value) {
		return new Cell(value);
	}

	public Cell(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("Valor para celda inválido. No se permite negativos: " + value);
		}
		boolean isPowerOfTwo = (value & (value - 1)) == 0;
		if (!isPowerOfTwo) {
			throw new IllegalArgumentException("Valor para celda inválido. No se permite negativos: " + value);
		}
		this.value = value;
	}

	public int combine(Cell cell) {
		if (this.value == 0 || cell.getNumber() == 0) {
			this.value += cell.transferValue();
			return 0;
		}
		if (this.value != cell.getNumber()) {
			return 0;
		}
			
		int valueToAdd = cell.transferValue();
		this.value += valueToAdd;
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

	public int getNumber() {
		return this.value;
	}

	public void reset() {
		this.value = 0;
	}

}
