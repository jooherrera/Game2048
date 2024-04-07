package game.board_test;

import static org.junit.Assert.*;

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
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.combineToDown();
		assertEquals(0, b.getScore());
	}
	
	@Test
	public void combineDownDosValoresIgualesSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(2,false));
		b.combineToDown();
		assertEquals(4, b.getScore());
	}
	
	@Test
	public void combineDownCuatroValoresIgualesSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(2,false));
		b.getBoardData().get(2).set(0, new Cell(2,false));
		b.getBoardData().get(3).set(0, new Cell(2,false));
		b.combineToDown();
		assertEquals(8, b.getScore());
	}
	
	@Test
	public void combineDownDosValoresDiferentesSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(4,false));
		b.combineToDown();
		assertEquals(0, b.getScore());
	}
	
	@Test
	public void combineDownDosIgualesUnoDiferenteSumaTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(2,false));
		b.getBoardData().get(2).set(0, new Cell(4,false));
		b.combineToDown();
		assertEquals(4, b.getScore());
	}
	
	@Test
	public void combineDownValorYCerosCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		
		b.combineToDown();

		assertEquals(2, b.getBoardData().get(3).get(0).getNumber());
	}
	
	@Test
	public void combineDownDosValoresIgualesCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(2,false));
		
		b.combineToDown();

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

		assertEquals(4, b.getBoardData().get(2).get(0).getNumber());
		assertEquals(4, b.getBoardData().get(3).get(0).getNumber());
	}
	
	@Test
	public void combineDownDosValoresDiferentesCellTest() {
		Board b = new Board();
		b.getBoardData().get(0).set(0, new Cell(2,false));
		b.getBoardData().get(1).set(0, new Cell(4,false));
		
		b.combineToDown();

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

		assertEquals(4, b.getBoardData().get(2).get(0).getNumber());
		assertEquals(4, b.getBoardData().get(3).get(0).getNumber());
	}

}