package game.board_test;

import static org.junit.Assert.*;

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
		Board b = new Board();
		b.getRow(0).set(0, new Cell(2));
		b.combineToRight();
		assertEquals(0,b.getScore());
	}
	
	@Test
	public void combineRightDosValoresIgualesSumaTest() {
		Board b = new Board();
		b.getRow(0).set(0, new Cell(2));
		b.getRow(0).set(1, new Cell(2));
		b.combineToRight();
		assertEquals(4, b.getScore());
	}
	
	@Test
	public void combineRightCuatroValoresIgualesSumaTest() {
		Board b = new Board();
		b.getRow(0).set(0, new Cell(2));
		b.getRow(0).set(1, new Cell(2));
		b.getRow(0).set(2, new Cell(2));
		b.getRow(0).set(3, new Cell(2));
		b.combineToRight();
		assertEquals(8, b.getScore());
	}
	
	@Test
	public void combineRightDosValoresDiferentesSumaTest() {
		Board b = new Board();
		b.getRow(0).set(0, new Cell(2));
		b.getRow(0).set(1, new Cell(4));
		b.combineToRight();
		assertEquals(0, b.getScore());
	}
	
	@Test
	public void combineRightDosIgualesUnoDiferenteSumaTest() {
		Board b = new Board();
		b.getRow(0).set(0, new Cell(2));
		b.getRow(0).set(1, new Cell(2));
		b.getRow(0).set(2, new Cell(4));
		b.combineToRight();
		assertEquals(4, b.getScore());
	}
	
	@Test
	public void combineRightValorYCerosCellTest() {
		Board b = new Board();
		b.getRow(0).set(0, new Cell(2));
		
		b.combineToRight();

		assertEquals(2, b.getRow(0).get(3).getNumber());
	}
	
	@Test
	public void combineRightDosValoresIgualesCellTest() {
		Board b = new Board();
		b.getRow(0).set(0, new Cell(2));
		b.getRow(0).set(1, new Cell(2));
		
		b.combineToRight();
		
		assertEquals(4, b.getRow(0).get(3).getNumber());
	}
	
	@Test
	public void combineRightCuatroValoresIgualesCellTest() {
		Board b = new Board();
		b.getRow(0).set(0, new Cell(2));
		b.getRow(0).set(1, new Cell(2));
		b.getRow(0).set(2, new Cell(2));
		b.getRow(0).set(3, new Cell(2));
		
		b.combineToRight();

		assertEquals(4, b.getRow(0).get(2).getNumber());
		assertEquals(4, b.getRow(0).get(3).getNumber());
	}
	
	@Test
	public void combineRightDosValoresDiferentesCellTest() {
		Board b = new Board();
		b.getRow(0).set(0, new Cell(2));
		b.getRow(0).set(1, new Cell(4));
		
		b.combineToRight();

		assertEquals(2, b.getRow(0).get(2).getNumber());
		assertEquals(4, b.getRow(0).get(3).getNumber());
	}
	
	@Test
	public void combineRightDosIgualesUnoDiferenteCellTest() {
		Board b = new Board();
		b.getRow(0).set(0, new Cell(2));
		b.getRow(0).set(1, new Cell(2));
		b.getRow(0).set(2, new Cell(4));
		
		b.combineToRight();

		assertEquals(4, b.getRow(0).get(2).getNumber());
		assertEquals(4, b.getRow(0).get(3).getNumber());
	}

}
