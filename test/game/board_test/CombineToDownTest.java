package game.board_test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Board;
import game.Cell;

public class CombineToDownTest {

	@Test
	public void combineDownTodosCerosSumaTest() {
		Board b = new Board();
		assertEquals(0, b.combineToDown());
	}
	
	@Test
	public void combineDownValorYCerosSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		assertEquals(0, b.combineToDown());
	}
	
	@Test
	public void combineDownDosValoresIgualesSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(2,false));
		assertEquals(4, b.combineToDown());
	}
	
	@Test
	public void combineDownCuatroValoresIgualesSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(2,false));
		b.getBoardData().get(2).set(0, new Cell(2,false));
		b.getBoardData().get(3).set(0, new Cell(2,false));
		assertEquals(8, b.combineToDown());
	}
	
	@Test
	public void combineDownDosValoresDiferentesSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(4,false));
		assertEquals(0, b.combineToDown());
	}
	
	@Test
	public void combineDownDosIgualesUnoDiferenteSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(2,false));
		b.getBoardData().get(2).set(0, new Cell(4,false));
		assertEquals(4, b.combineToDown());
	}
	
	@Test
	public void combineDownValorYCerosCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		
		b.combineToDown();
		assertEquals(0, b.getBoardData().get(0).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(1).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(2).get(0).getNumber());
		assertEquals(2, b.getBoardData().get(3).get(0).getNumber());
	}
	
	@Test
	public void combineDownDosValoresIgualesCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(2,false));
		
		b.combineToDown();
		assertEquals(0, b.getBoardData().get(0).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(1).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(2).get(0).getNumber());
		assertEquals(4, b.getBoardData().get(3).get(0).getNumber());
	}
	
	@Test
	public void combineDownCuatroValoresIgualesCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(2,false));
		b.getBoardData().get(2).set(0, new Cell(2,false));
		b.getBoardData().get(3).set(0, new Cell(2,false));
		
		b.combineToDown();
		assertEquals(0, b.getBoardData().get(0).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(1).get(0).getNumber());
		assertEquals(4, b.getBoardData().get(2).get(0).getNumber());
		assertEquals(4, b.getBoardData().get(3).get(0).getNumber());
	}
	
	@Test
	public void combineDownDosValoresDiferentesCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(4,false));
		
		b.combineToDown();
		assertEquals(0, b.getBoardData().get(0).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(1).get(0).getNumber());
		assertEquals(2, b.getBoardData().get(2).get(0).getNumber());
		assertEquals(4, b.getBoardData().get(3).get(0).getNumber());
	}
	
	@Test
	public void combineDownDosIgualesUnoDiferenteCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(2,false));
		b.getBoardData().get(3).set(0, new Cell(4,false));
		
		b.combineToDown();
		assertEquals(0, b.getBoardData().get(0).get(0).getNumber());
		assertEquals(0, b.getBoardData().get(1).get(0).getNumber());
		assertEquals(4, b.getBoardData().get(2).get(0).getNumber());
		assertEquals(4, b.getBoardData().get(3).get(0).getNumber());
	}

}
