package game.board_test;

import static org.junit.Assert.*;

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
		Board b = new Board();
		b.getRow(0).set(3, new Cell(2,false));
		b.combineToLeft();
		assertEquals(0, b.getScore());
	}
	
	@Test
	public void combineLeftDosValoresIgualesSumaTest() {
		Board b = new Board();
		b.getRow(0).set(3, new Cell(2,false));
		b.getRow(0).set(2, new Cell(2,false));
		b.combineToLeft();
		assertEquals(4,  b.getScore());
	}
	
	@Test
	public void combineLeftCuatroValoresIgualesSumaTest() {
		Board b = new Board();
		b.getRow(0).set(3, new Cell(2,false));
		b.getRow(0).set(2, new Cell(2,false));
		b.getRow(0).set(1, new Cell(2,false));
		b.getRow(0).set(0, new Cell(2,false));
		b.combineToLeft();
		assertEquals(8,  b.getScore());
	}
	
	@Test
	public void combineLeftDosValoresDiferentesSumaTest() {
		Board b = new Board();
		b.getRow(0).set(3, new Cell(2,false));
		b.getRow(0).set(2, new Cell(4,false));
		b.combineToLeft();
		assertEquals(0,  b.getScore());
	}
	
	@Test
	public void combineLeftDosIgualesUnoDiferenteSumaTest() {
		Board b = new Board();
		b.getRow(0).set(3, new Cell(2,false));
		b.getRow(0).set(2, new Cell(2,false));
		b.getRow(0).set(1, new Cell(4,false));
		b.combineToLeft();
		assertEquals(4,  b.getScore());
	}
	
	@Test
	public void combineLeftValorYCerosCellTest() {
		Board b = new Board();
		b.getRow(0).set(3, new Cell(2,false));
		
		b.combineToLeft();

		assertEquals(2, b.getRow(0).get(0).getNumber());
	}
	
	@Test
	public void combineLeftDosValoresIgualesCellTest() {
		Board b = new Board();
		b.getRow(0).set(3, new Cell(2,false));
		b.getRow(0).set(2, new Cell(2,false));
		
		b.combineToLeft();

		assertEquals(4, b.getRow(0).get(0).getNumber());
	}
	
	@Test
	public void combineLeftCuatroValoresIgualesCellTest() {
		Board b = new Board();
		b.getRow(0).set(3, new Cell(2,false));
		b.getRow(0).set(2, new Cell(2,false));
		b.getRow(0).set(1, new Cell(2,false));
		b.getRow(0).set(0, new Cell(2,false));
		
		b.combineToLeft();

		assertEquals(4, b.getRow(0).get(1).getNumber());
		assertEquals(4, b.getRow(0).get(0).getNumber());
	}
	
	@Test
	public void combineLeftDosValoresDiferentesCellTest() {
		Board b = new Board();
		b.getRow(0).set(3, new Cell(2,false));
		b.getRow(0).set(2, new Cell(4,false));
		
		b.combineToLeft();

		assertEquals(2, b.getRow(0).get(1).getNumber());
		assertEquals(4, b.getRow(0).get(0).getNumber());
	}
	
	@Test
	public void combineLeftDosIgualesUnoDiferenteCellTest() {
		Board b = new Board();
		b.getRow(0).set(3, new Cell(2,false));
		b.getRow(0).set(2, new Cell(2,false));
		b.getRow(0).set(1, new Cell(4,false));
		
		b.combineToLeft();

		assertEquals(4, b.getRow(0).get(1).getNumber());
		assertEquals(4, b.getRow(0).get(0).getNumber());
	}

}
