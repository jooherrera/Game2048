package game.board_test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import game.Board;
import game.Cell;

public class CombineToDownTest {
	
	@Test
	public void combineDownTodosCerosSumaTest() {
		Board b = new Board();
		
		b.combineToDown();
		assertEquals(0,b.getScore());
	}
	
	@Test
	public void combineDownValorYCerosSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToDown();
		assertEquals(0, b.getScore());
	}
	
	@Test
	public void combineDownDosValoresIgualesSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(2).set(0, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToDown();
		assertEquals(4, b.getScore());
	}
	
	@Test
	public void combineDownCuatroValoresIgualesSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(1).set(0, new Cell(2,false));
		cells.get(2).set(0, new Cell(2,false));
		cells.get(3).set(0, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToDown();
		assertEquals(8, b.getScore());
	}
	
	@Test
	public void combineDownDosValoresDiferentesSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(1).set(0, new Cell(4,false));
		Board b = new Board(cells);
		
		b.combineToDown();
		assertEquals(0, b.getScore());
	}
	
	@Test
	public void combineDownDosIgualesUnoDiferenteSumaTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(1).set(0, new Cell(2,false));
		cells.get(2).set(0, new Cell(4,false));
		Board b = new Board(cells);
		
		b.combineToDown();
		assertEquals(4, b.getScore());
	}
	
	@Test
	public void combineDownValorYCerosCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToDown();
		assertEquals(2, b.getBoardData().get(3).get(0).intValue());
	}
	
	@Test
	public void combineDownDosValoresIgualesCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(1).set(0, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToDown();
		assertEquals(4, b.getBoardData().get(3).get(0).intValue());
	}
	
	@Test
	public void combineDownCuatroValoresIgualesCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(1).set(0, new Cell(2,false));
		cells.get(2).set(0, new Cell(2,false));
		cells.get(3).set(0, new Cell(2,false));
		Board b = new Board(cells);
		
		b.combineToDown();
		assertEquals(4, b.getBoardData().get(2).get(0).intValue());
		assertEquals(4, b.getBoardData().get(3).get(0).intValue());
	}
	
	@Test
	public void combineDownDosValoresDiferentesCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(1).set(0, new Cell(4,false));
		Board b = new Board(cells);
		
		b.combineToDown();
		assertEquals(2, b.getBoardData().get(2).get(0).intValue());
		assertEquals(4, b.getBoardData().get(3).get(0).intValue());
	}
	
	@Test
	public void combineDownDosIgualesUnoDiferenteCellTest() {
		ArrayList<ArrayList<Cell>> cells = createEmptyCellMatrix(4);
		
		cells.get(0).set(0, new Cell(2,false));
		cells.get(1).set(0, new Cell(2,false));
		cells.get(3).set(0, new Cell(4,false));
		Board b = new Board(cells);
		
		b.combineToDown();
		assertEquals(4, b.getBoardData().get(2).get(0).intValue());
		assertEquals(4, b.getBoardData().get(3).get(0).intValue());
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