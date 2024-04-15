package game.board_test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import game.Board;
import game.Cell;

public class CombineToRightTest {

	@Test
	public void combineRightTodosCerosSumaTest() {
		Board b = new Board();
		b.combineToRight();
		assertEquals(0, b.getScore());
	}
	
	@Test
	public void combineRightValorYCerosSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToRight();
		assertEquals(0, b.getScore());
	}
	
	@Test
	public void combineRightDosValoresIgualesSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(0).set(1, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToRight();
		assertEquals(4, b.getScore());
	}
	
	@Test
	public void combineRightCuatroValoresIgualesSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(0).set(1, new Cell(2,false));
		cells.get(0).set(2, new Cell(2,false));
		cells.get(0).set(3, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToRight();
		assertEquals(8, b.getScore());
	}
	
	@Test
	public void combineRightDosValoresDiferentesSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(0).set(1, new Cell(4,false));
		Board b = new Board(cells);
		
		b.combineToRight();
		assertEquals(0, b.getScore());
	}
	
	@Test
	public void combineRightDosIgualesUnoDiferenteSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(0).set(1, new Cell(2,false));
		cells.get(0).set(2, new Cell(4,false));
		Board b = new Board(cells);
		
		b.combineToRight();
		assertEquals(4, b.getScore());
	}
	
	@Test
	public void combineRightValorYCerosCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToRight();
		assertEquals(2, b.getBoardData().get(0).get(3).intValue());
	}
	
	@Test
	public void combineRightDosValoresIgualesCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(0).set(1, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToRight();
		assertEquals(4, b.getBoardData().get(0).get(3).intValue());
	}
	
	@Test
	public void combineRightCuatroValoresIgualesCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(0).set(1, new Cell(2,false));
		cells.get(0).set(2, new Cell(2,false));
		cells.get(0).set(3, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToRight();
		assertEquals(4, b.getBoardData().get(0).get(2).intValue());
		assertEquals(4, b.getBoardData().get(0).get(3).intValue());
	}
	
	@Test
	public void combineRightDosValoresDiferentesCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(0).set(1, new Cell(4,false));
		Board b = new Board(cells);
		
		b.combineToRight();
		assertEquals(2, b.getBoardData().get(0).get(2).intValue());
		assertEquals(4, b.getBoardData().get(0).get(3).intValue());
	}
	
	@Test
	public void combineRightDosIgualesUnoDiferenteCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(0).set(1, new Cell(2,false));
		cells.get(0).set(2, new Cell(4,false));
		Board b = new Board(cells);
		
		b.combineToRight();
		assertEquals(4, b.getBoardData().get(0).get(2).intValue());
		assertEquals(4, b.getBoardData().get(0).get(3).intValue());
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