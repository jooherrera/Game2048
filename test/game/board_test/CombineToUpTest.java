package game.board_test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Board;
import game.Cell;

public class CombineToUpTest {

	@Test
	public void combineUpTodosCerosSumaTest() {
		Board b = new Board();
		assertEquals(0, b.combineToUp());
	}
	
	@Test
	public void combineUpValorYCerosSumaTest() {
		Board b = new Board();
		b.getBoardData().get(3).set(0, new Cell(2,false));
		assertEquals(0, b.combineToUp());
	}
	
	@Test
	public void combineUpDosValoresIgualesSumaTest() {
		Board b = new Board();
		b.getBoardData().get(3).set(0, new Cell(2,false));
		b.getBoardData().get(2).set(0, new Cell(2,false));
		assertEquals(4, b.combineToUp());
	}
	
	@Test
	public void combineUpCuatroValoresIgualesSumaTest() {
		Board b = new Board();
		b.getBoardData().get(3).set(0, new Cell(2,false));
		b.getBoardData().get(2).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(2,false));
		b.getBoardData().get(0).set(0, new Cell(2,false));
		assertEquals(8, b.combineToUp());
	}
	
	@Test
	public void combineUpDosValoresDiferentesSumaTest() {
		Board b = new Board();
		b.getBoardData().get(3).set(0, new Cell(2,false));
		b.getBoardData().get(2).set(0, new Cell(4,false));
		assertEquals(0, b.combineToUp());
	}
	
	@Test
	public void combineUpDosIgualesUnoDiferenteSumaTest() {
		Board b = new Board();
		b.getBoardData().get(3).set(0, new Cell(2,false));
		b.getBoardData().get(2).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(4,false));
		assertEquals(4, b.combineToUp());
	}
	
	@Test
	public void combineUpValorYCerosCellTest() {
		Board b = new Board();
		b.getBoardData().get(3).set(0, new Cell(2,false));
		
		b.combineToUp();
		assertEquals(0, b.getBoardData().get(3).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(2).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(1).get(0).getNumber());
		assertEquals(2, b.getBoardData().get(0).get(0).getNumber());
	}
	
	@Test
	public void combineUpDosValoresIgualesCellTest() {
		Board b = new Board();
		b.getBoardData().get(3).set(0, new Cell(2,false));
		b.getBoardData().get(2).set(0, new Cell(2,false));
		
		b.combineToUp();
		assertEquals(0, b.getBoardData().get(3).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(2).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(1).get(0).getNumber());
		assertEquals(4, b.getBoardData().get(0).get(0).getNumber());
	}
	
	@Test
	public void combineUpCuatroValoresIgualesCellTest() {
		Board b = new Board();
		b.getBoardData().get(3).set(0, new Cell(2,false));
		b.getBoardData().get(2).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(2,false));
		b.getBoardData().get(0).set(0, new Cell(2,false));
		
		b.combineToUp();
		assertEquals(0, b.getBoardData().get(3).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(2).get(0).getNumber());
		assertEquals(4, b.getBoardData().get(1).get(0).getNumber());
		assertEquals(4, b.getBoardData().get(0).get(0).getNumber());
	}
	
	@Test
	public void combineUpDosValoresDiferentesCellTest() {
		Board b = new Board();
		b.getBoardData().get(3).set(0, new Cell(2,false));
		b.getBoardData().get(2).set(0, new Cell(4,false));
		
		b.combineToUp();
		assertEquals(0, b.getBoardData().get(3).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(2).get(0).getNumber());
		assertEquals(2, b.getBoardData().get(1).get(0).getNumber());
		assertEquals(4, b.getBoardData().get(0).get(0).getNumber());
	}
	
	@Test
	public void combineUpDosIgualesUnoDiferenteCellTest() {
		Board b = new Board();
		b.getBoardData().get(3).set(0, new Cell(2,false));
		b.getBoardData().get(2).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(4,false));
		
		b.combineToUp();
		assertEquals(0, b.getBoardData().get(3).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(2).get(0).getNumber());
		assertEquals(4, b.getBoardData().get(1).get(0).getNumber());
		assertEquals(4, b.getBoardData().get(0).get(0).getNumber());
	}

}
