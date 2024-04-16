package game.board_test;

import static org.junit.Assert.*;

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
		Board b = new Board();
		b.getRow(3).set(0, new Cell(2));
		b.combineToUp();
		assertEquals(0, b.getScore());
	}
	
	@Test
	public void combineUpDosValoresIgualesSumaTest() {
		Board b = new Board();
		b.getRow(3).set(0, new Cell(2));
		b.getRow(2).set(0, new Cell(2));
		b.combineToUp();
		assertEquals(4, b.getScore());
	}
	
	@Test
	public void combineUpCuatroValoresIgualesSumaTest() {
		Board b = new Board();
		b.getRow(3).set(0, new Cell(2));
		b.getRow(2).set(0, new Cell(2));
		b.getRow(1).set(0, new Cell(2));
		b.getRow(0).set(0, new Cell(2));
		b.combineToUp();
		assertEquals(8, b.getScore());
	}
	
	@Test
	public void combineUpDosValoresDiferentesSumaTest() {
		Board b = new Board();
		b.getRow(3).set(0, new Cell(2));
		b.getRow(2).set(0, new Cell(4));
		b.combineToUp();
		assertEquals(0, b.getScore());
	}
	
	@Test
	public void combineUpValorYCerosCellTest() {
		Board b = new Board();
		b.getRow(3).set(0, new Cell(2));
		
		b.combineToUp();

		assertEquals(2, b.getRow(3).get(0).getNumber());
	}
	
	@Test
	public void combineUpDosValoresIgualesCellTest() {
		Board b = new Board();
		b.getRow(3).set(0, new Cell(2));
		b.getRow(2).set(0, new Cell(2));
		
		b.combineToUp();

		assertEquals(4, b.getRow(0).get(0).getNumber());
	}
	
	@Test
	public void combineUpCuatroValoresIgualesCellTest() {
		Board b = new Board();
		b.getRow(3).set(0, new Cell(2));
		b.getRow(2).set(0, new Cell(2));
		b.getRow(1).set(0, new Cell(2));
		b.getRow(0).set(0, new Cell(2));
		
		b.combineToUp();

		assertEquals(4, b.getRow(1).get(0).getNumber());
		assertEquals(4, b.getRow(0).get(0).getNumber());
	}
	
	@Test
	public void combineUpDosValoresDiferentesCellTest() {
		Board b = new Board();
		b.getRow(3).set(0, new Cell(2));
		b.getRow(2).set(0, new Cell(4));
		
		b.combineToUp();

		assertEquals(2, b.getRow(1).get(0).getNumber());
		assertEquals(4, b.getRow(0).get(0).getNumber());
	}
	
	@Test
	public void combineUpDosIgualesUnoDiferenteCellTest() {
		Board b = new Board();
		b.getRow(3).set(0, new Cell(2));
		b.getRow(2).set(0, new Cell(2));
		b.getRow(1).set(0, new Cell(4));
		
		b.combineToUp();

		
		
		assertEquals(4, b.getRow(1).get(0).getNumber());
		assertEquals(4, b.getRow(0).get(0).getNumber());
	}

}
