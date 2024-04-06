package game.board_test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Board;
import game.Cell;

public class CombineToRightTest {

	@Test
	public void combineRightTodosCerosSumaTest() {
		Board b = new Board();
		assertEquals(0, b.combineToRight());
	}
	
	@Test
	public void combineRightValorYCerosSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		assertEquals(0, b.combineToRight());
	}
	
	@Test
	public void combineRightDosValoresIgualesSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(0).set(1, new Cell(2,false));
		assertEquals(4, b.combineToRight());
	}
	
	@Test
	public void combineRightCuatroValoresIgualesSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(0).set(1, new Cell(2,false));
		b.getBoardData().get(0).set(2, new Cell(2,false));
		b.getBoardData().get(0).set(3, new Cell(2,false));
		assertEquals(8, b.combineToRight());
	}
	
	@Test
	public void combineRightDosValoresDiferentesSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(0).set(1, new Cell(4,false));
		assertEquals(0, b.combineToRight());
	}
	
	@Test
	public void combineRightDosIgualesUnoDiferenteSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(0).set(1, new Cell(2,false));
		b.getBoardData().get(0).set(2, new Cell(4,false));
		assertEquals(4, b.combineToRight());
	}
	
	@Test
	public void combineRightValorYCerosCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		
		b.combineToRight();
		assertEquals(0, b.getBoardData().get(0).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(0).get(1).getNumber());
		assertEquals(0, b.getBoardData().get(0).get(2).getNumber());
		assertEquals(2, b.getBoardData().get(0).get(3).getNumber());
	}
	
	@Test
	public void combineRightDosValoresIgualesCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(0).set(1, new Cell(2,false));
		
		b.combineToRight();
		assertEquals(0, b.getBoardData().get(0).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(0).get(1).getNumber());
		assertEquals(0, b.getBoardData().get(0).get(2).getNumber());
		assertEquals(4, b.getBoardData().get(0).get(3).getNumber());
	}
	
	@Test
	public void combineRightCuatroValoresIgualesCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(0).set(1, new Cell(2,false));
		b.getBoardData().get(0).set(2, new Cell(2,false));
		b.getBoardData().get(0).set(3, new Cell(2,false));
		
		b.combineToRight();
		assertEquals(0, b.getBoardData().get(0).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(0).get(1).getNumber());
		assertEquals(4, b.getBoardData().get(0).get(2).getNumber());
		assertEquals(4, b.getBoardData().get(0).get(3).getNumber());
	}
	
	@Test
	public void combineRightDosValoresDiferentesCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(0).set(1, new Cell(4,false));
		
		b.combineToRight();
		assertEquals(0, b.getBoardData().get(0).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(0).get(1).getNumber());
		assertEquals(2, b.getBoardData().get(0).get(2).getNumber());
		assertEquals(4, b.getBoardData().get(0).get(3).getNumber());
	}
	
	@Test
	public void combineRightDosIgualesUnoDiferenteCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(0).set(1, new Cell(2,false));
		b.getBoardData().get(0).set(2, new Cell(4,false));
		
		b.combineToRight();
		assertEquals(0, b.getBoardData().get(0).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(0).get(1).getNumber());
		assertEquals(4, b.getBoardData().get(0).get(2).getNumber());
		assertEquals(4, b.getBoardData().get(0).get(3).getNumber());
	}

}
