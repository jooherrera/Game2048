package game.board_test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Board;
import game.Cell;

public class CombineToLeftTest {

	@Test
	public void combineLeftTodosCerosSumaTest() {
		Board b = new Board();
		assertEquals(0, b.combineToLeft());
	}
	
	@Test
	public void combineLeftValorYCerosSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(3, new Cell(2,false));
		assertEquals(0, b.combineToLeft());
	}
	
	@Test
	public void combineLeftDosValoresIgualesSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(3, new Cell(2,false));
		b.getBoardData().get(0).set(2, new Cell(2,false));
		assertEquals(4, b.combineToLeft());
	}
	
	@Test
	public void combineLeftCuatroValoresIgualesSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(3, new Cell(2,false));
		b.getBoardData().get(0).set(2, new Cell(2,false));
		b.getBoardData().get(0).set(1, new Cell(2,false));
		b.getBoardData().get(0).set(0, new Cell(2,false));
		assertEquals(8, b.combineToLeft());
	}
	
	@Test
	public void combineLeftDosValoresDiferentesSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(3, new Cell(2,false));
		b.getBoardData().get(0).set(2, new Cell(4,false));
		assertEquals(0, b.combineToLeft());
	}
	
	@Test
	public void combineLeftDosIgualesUnoDiferenteSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(3, new Cell(2,false));
		b.getBoardData().get(0).set(2, new Cell(2,false));
		b.getBoardData().get(0).set(1, new Cell(4,false));
		assertEquals(4, b.combineToLeft());
	}
	
	@Test
	public void combineLeftValorYCerosCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(3, new Cell(2,false));
		
		b.combineToLeft();
		assertEquals(0, b.getBoardData().get(0).get(3).getNumber());
		assertEquals(0, b.getBoardData().get(0).get(2).getNumber());
		assertEquals(0, b.getBoardData().get(0).get(1).getNumber());
		assertEquals(2, b.getBoardData().get(0).get(0).getNumber());
	}
	
	@Test
	public void combineLeftDosValoresIgualesCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(3, new Cell(2,false));
		b.getBoardData().get(0).set(2, new Cell(2,false));
		
		b.combineToLeft();
		assertEquals(0, b.getBoardData().get(0).get(3).getNumber());
		assertEquals(0, b.getBoardData().get(0).get(2).getNumber());
		assertEquals(0, b.getBoardData().get(0).get(1).getNumber());
		assertEquals(4, b.getBoardData().get(0).get(0).getNumber());
	}
	
	@Test
	public void combineLeftCuatroValoresIgualesCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(3, new Cell(2,false));
		b.getBoardData().get(0).set(2, new Cell(2,false));
		b.getBoardData().get(0).set(1, new Cell(2,false));
		b.getBoardData().get(0).set(0, new Cell(2,false));
		
		b.combineToLeft();
		assertEquals(0, b.getBoardData().get(0).get(3).getNumber());
		assertEquals(0, b.getBoardData().get(0).get(2).getNumber());
		assertEquals(4, b.getBoardData().get(0).get(1).getNumber());
		assertEquals(4, b.getBoardData().get(0).get(0).getNumber());
	}
	
	@Test
	public void combineLeftDosValoresDiferentesCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(3, new Cell(2,false));
		b.getBoardData().get(0).set(2, new Cell(4,false));
		
		b.combineToLeft();
		assertEquals(0, b.getBoardData().get(0).get(3).getNumber());
		assertEquals(0, b.getBoardData().get(0).get(2).getNumber());
		assertEquals(2, b.getBoardData().get(0).get(1).getNumber());
		assertEquals(4, b.getBoardData().get(0).get(0).getNumber());
	}
	
	@Test
	public void combineLeftDosIgualesUnoDiferenteCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(3, new Cell(2,false));
		b.getBoardData().get(0).set(2, new Cell(2,false));
		b.getBoardData().get(0).set(1, new Cell(4,false));
		
		b.combineToLeft();
		assertEquals(0, b.getBoardData().get(0).get(3).getNumber());
		assertEquals(0, b.getBoardData().get(0).get(2).getNumber());
		assertEquals(4, b.getBoardData().get(0).get(1).getNumber());
		assertEquals(4, b.getBoardData().get(0).get(0).getNumber());
	}

}
