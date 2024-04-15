package game.board_test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import game.Board;
import game.Cell;

public class CombineToLeftTest {

	@Test
	public void combineLeftTodosCerosSumaTest() {
		Board b = new Board();
		b.combineToLeft();
		assertEquals(0, b.getScore() );
	}
	
	@Test
	public void combineLeftValorYCerosSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(3, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToLeft();
		assertEquals(0, b.getScore());
	}
	
	@Test
	public void combineLeftDosValoresIgualesSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(3, new Cell(2,false));
		cells.get(0).set(2, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToLeft();
		assertEquals(4, b.getScore());
	}
	
	@Test
	public void combineLeftCuatroValoresIgualesSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(3, new Cell(2,false));
		cells.get(0).set(2, new Cell(2,false));
		cells.get(0).set(1, new Cell(2,false));
		cells.get(0).set(0, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToLeft();
		assertEquals(8, b.getScore());
	}
	
	@Test
	public void combineLeftDosValoresDiferentesSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(3, new Cell(2,false));
		cells.get(0).set(2, new Cell(4,false));
		Board b = new Board(cells);
		
		b.combineToLeft();
		assertEquals(0, b.getScore());
	}
	
	@Test
	public void combineLeftDosIgualesUnoDiferenteSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(3, new Cell(2,false));
		cells.get(0).set(2, new Cell(2,false));
		cells.get(0).set(1, new Cell(4,false));
		Board b = new Board(cells);
		
		b.combineToLeft();
		assertEquals(4, b.getScore());
	}
	
	@Test
	public void combineLeftValorYCerosCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(3, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToLeft();
		assertEquals(2, b.getBoardData().get(0).get(0).intValue());
	}
	
	@Test
	public void combineLeftDosValoresIgualesCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(3, new Cell(2,false));
		cells.get(0).set(2, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToLeft();
		assertEquals(4, b.getBoardData().get(0).get(0).intValue());
	}
	
	@Test
	public void combineLeftCuatroValoresIgualesCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(3, new Cell(2,false));
		cells.get(0).set(2, new Cell(2,false));
		cells.get(0).set(1, new Cell(2,false));
		cells.get(0).set(0, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToLeft();
		assertEquals(4, b.getBoardData().get(0).get(1).intValue());
		assertEquals(4, b.getBoardData().get(0).get(0).intValue());
	}
	
	@Test
	public void combineLeftDosValoresDiferentesCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(3, new Cell(2,false));
		cells.get(0).set(2, new Cell(4,false));
		Board b = new Board(cells);
		
		b.combineToLeft();
		assertEquals(2, b.getBoardData().get(0).get(1).intValue());
		assertEquals(4, b.getBoardData().get(0).get(0).intValue());
	}
	
	@Test
	public void combineLeftDosIgualesUnoDiferenteCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(3, new Cell(2,false));
		cells.get(0).set(2, new Cell(2,false));
		cells.get(0).set(1, new Cell(4,false));
		Board b = new Board(cells);
		
		b.combineToLeft();
		assertEquals(4, b.getBoardData().get(0).get(1).intValue());
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