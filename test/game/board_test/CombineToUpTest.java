package game.board_test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import game.Board;
import game.Cell;

public class CombineToUpTest {

	@Test
	public void combineUpTodosCerosSumaTest() {
		Board b = new Board();
		
		b.combineToUp();
		assertEquals(0, b.getScore());
	}
	
	@Test
	public void combineUpValorYCerosSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(3).set(0, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToUp();
		assertEquals(0, b.getScore());
	}
	
	@Test
	public void combineUpDosValoresIgualesSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(3).set(0, new Cell(2,false));
		cells.get(2).set(0, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToUp();
		assertEquals(4, b.getScore());
	}
	
	@Test
	public void combineUpCuatroValoresIgualesSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(3).set(0, new Cell(2,false));
		cells.get(2).set(0, new Cell(2,false));
		cells.get(1).set(0, new Cell(2,false));
		cells.get(0).set(0, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToUp();
		assertEquals(8, b.getScore());
	}
	
	@Test
	public void combineUpDosValoresDiferentesSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(3).set(0, new Cell(2,false));
		cells.get(2).set(0, new Cell(4,false));
		Board b = new Board(cells);
		
		b.combineToUp();
		assertEquals(0, b.getScore());
	}
	
	@Test
	public void combineUpDosIgualesUnoDiferenteSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(3).set(0, new Cell(2,false));
		cells.get(2).set(0, new Cell(2,false));
		cells.get(1).set(0, new Cell(4,false));
		Board b = new Board(cells);
		
		b.combineToUp();
		assertEquals(4, b.getScore());
	}
	
	@Test
	public void combineUpValorYCerosCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(3).set(0, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToUp();
		assertEquals(2, b.getBoardData().get(0).get(0).intValue());
	}
	
	@Test
	public void combineUpDosValoresIgualesCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(3).set(0, new Cell(2,false));
		cells.get(2).set(0, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToUp();
		assertEquals(4, b.getBoardData().get(0).get(0).intValue());
	}
	
	@Test
	public void combineUpCuatroValoresIgualesCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(3).set(0, new Cell(2,false));
		cells.get(2).set(0, new Cell(2,false));
		cells.get(1).set(0, new Cell(2,false));
		cells.get(0).set(0, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToUp();
		assertEquals(4, b.getBoardData().get(1).get(0).intValue());
		assertEquals(4, b.getBoardData().get(0).get(0).intValue());
	}
	
	@Test
	public void combineUpDosValoresDiferentesCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(3).set(0, new Cell(2,false));
		cells.get(2).set(0, new Cell(4,false));
		Board b = new Board(cells);
		
		b.combineToUp();
		assertEquals(2, b.getBoardData().get(1).get(0).intValue());
		assertEquals(4, b.getBoardData().get(0).get(0).intValue());
	}
	
	@Test
	public void combineUpDosIgualesUnoDiferenteCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(3).set(0, new Cell(2,false));
		cells.get(2).set(0, new Cell(2,false));
		cells.get(1).set(0, new Cell(4,false));
		Board b = new Board(cells);
		
		b.combineToUp();
		assertEquals(4, b.getBoardData().get(1).get(0).intValue());
		assertEquals(4, b.getBoardData().get(0).get(0).intValue());
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