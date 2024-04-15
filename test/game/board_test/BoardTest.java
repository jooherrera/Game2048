package game.board_test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import game.Board;
import game.Cell;

public class BoardTest {

	@Test
	public void noHayNingunMovimientoTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(0).set(1, new Cell(4,false));
		cells.get(0).set(2, new Cell(8,false));
		cells.get(0).set(3, new Cell(16,false));
		
		cells.get(1).set(0, new Cell(32,false));
		cells.get(1).set(1, new Cell(64,false));
		cells.get(1).set(2, new Cell(128,false));
		cells.get(1).set(3, new Cell(256,false));
		
		cells.get(2).set(0, new Cell(512,false));
		cells.get(2).set(1, new Cell(1024,false));
		cells.get(2).set(2, new Cell(2,false));
		cells.get(2).set(3, new Cell(4,false));
		
		cells.get(3).set(0, new Cell(8,false));
		cells.get(3).set(1, new Cell(16,false));
		cells.get(3).set(2, new Cell(32,false));
		cells.get(3).set(3, new Cell(64,false));
		Board b = new Board(cells);
		
		assertEquals(true, b.noHayMasMovimientos());
	}
	
	@Test
	public void hayMovimientoHorizontalSinVacioTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(0).set(1, new Cell(4,false));
		cells.get(0).set(2, new Cell(8,false));
		cells.get(0).set(3, new Cell(8,false));
		
		cells.get(1).set(0, new Cell(32,false));
		cells.get(1).set(1, new Cell(64,false));
		cells.get(1).set(2, new Cell(128,false));
		cells.get(1).set(3, new Cell(256,false));
		
		cells.get(2).set(0, new Cell(512,false));
		cells.get(2).set(1, new Cell(1024,false));
		cells.get(2).set(2, new Cell(2,false));
		cells.get(2).set(3, new Cell(4,false));
		
		cells.get(3).set(0, new Cell(8,false));
		cells.get(3).set(1, new Cell(16,false));
		cells.get(3).set(2, new Cell(32,false));
		cells.get(3).set(3, new Cell(64,false));
		Board b = new Board(cells);
		
		assertEquals(false, b.noHayMasMovimientos());
	}
	
	@Test
	public void hayMovimientoVerticalSinVacioTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(0).set(1, new Cell(4,false));
		cells.get(0).set(2, new Cell(8,false));
		cells.get(0).set(3, new Cell(16,false));
		
		cells.get(1).set(0, new Cell(32,false));
		cells.get(1).set(1, new Cell(64,false));
		cells.get(1).set(2, new Cell(128,false));
		cells.get(1).set(3, new Cell(256,false));
		
		cells.get(2).set(0, new Cell(512,false));
		cells.get(2).set(1, new Cell(1024,false));
		cells.get(2).set(2, new Cell(2,false));
		cells.get(2).set(3, new Cell(4,false));
		
		cells.get(3).set(0, new Cell(8,false));
		cells.get(3).set(1, new Cell(16,false));
		cells.get(3).set(2, new Cell(2,false));
		cells.get(3).set(3, new Cell(64,false));
		Board b = new Board(cells);
		
		assertEquals(false, b.noHayMasMovimientos());
	}
	
	@Test
	public void hayMovimientoHorizontalConVacioTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(0).set(1, new Cell(4,false));
		cells.get(0).set(2, new Cell(0,false));
		cells.get(0).set(3, new Cell(16,false));
		
		cells.get(1).set(0, new Cell(32,false));
		cells.get(1).set(1, new Cell(64,false));
		cells.get(1).set(2, new Cell(128,false));
		cells.get(1).set(3, new Cell(256,false));
		
		cells.get(2).set(0, new Cell(512,false));
		cells.get(2).set(1, new Cell(1024,false));
		cells.get(2).set(2, new Cell(2,false));
		cells.get(2).set(3, new Cell(4,false));
		
		cells.get(3).set(0, new Cell(8,false));
		cells.get(3).set(1, new Cell(16,false));
		cells.get(3).set(2, new Cell(32,false));
		cells.get(3).set(3, new Cell(64,false));
		Board b = new Board(cells);
		
		assertEquals(false, b.noHayMasMovimientos());
	}
	
	@Test
	public void hayMovimientoVerticalConVacioTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(0).set(1, new Cell(4,false));
		cells.get(0).set(2, new Cell(8,false));
		cells.get(0).set(3, new Cell(16,false));
		
		cells.get(1).set(0, new Cell(0,false));
		cells.get(1).set(1, new Cell(64,false));
		cells.get(1).set(2, new Cell(128,false));
		cells.get(1).set(3, new Cell(256,false));
		
		cells.get(2).set(0, new Cell(512,false));
		cells.get(2).set(1, new Cell(1024,false));
		cells.get(2).set(2, new Cell(2,false));
		cells.get(2).set(3, new Cell(4,false));
		
		cells.get(3).set(0, new Cell(8,false));
		cells.get(3).set(1, new Cell(16,false));
		cells.get(3).set(2, new Cell(32,false));
		cells.get(3).set(3, new Cell(64,false));
		Board b = new Board(cells);
		
		assertEquals(false, b.noHayMasMovimientos());
	}

	private ArrayList<ArrayList<Cell>> createEmptyCellMatrix(int size) {
		ArrayList<ArrayList<Cell>> cells = new ArrayList<ArrayList<Cell>>();
		
		for (int i = 0; i < size; i++) {
			ArrayList<Cell> cellRow = new ArrayList<Cell>();
			cells.add(cellRow);
			for (int j = 0; j < size; j++) {
				Cell cell = Cell.create(0);
				cells.get(i).add(cell);
			}
		}
		
		return cells;
	}
}