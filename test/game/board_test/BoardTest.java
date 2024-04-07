package game.board_test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Board;
import game.Cell;

public class BoardTest {

	@Test
	public void isBoardFullNingunMovimientoTest() {
		Board b = new Board();
		b.getRow(0).set(0, Cell.create(2));
		b.getRow(0).set(1, Cell.create(4));
		b.getRow(0).set(2, Cell.create(8));
		b.getRow(0).set(3, Cell.create(16));
		
		b.getRow(1).set(0, Cell.create(32));
		b.getRow(1).set(1, Cell.create(64));
		b.getRow(1).set(2, Cell.create(128));
		b.getRow(1).set(3, Cell.create(256));
		
		b.getRow(2).set(0, Cell.create(512));
		b.getRow(2).set(1, Cell.create(1024));
		b.getRow(2).set(2, Cell.create(2));
		b.getRow(2).set(3, Cell.create(4));
		
		b.getRow(3).set(0, Cell.create(8));
		b.getRow(3).set(1, Cell.create(16));
		b.getRow(3).set(2, Cell.create(32));
		b.getRow(3).set(3, Cell.create(64));
		
		assertEquals(true, b.isBoardFull());
	}
	
	@Test
	public void isBoardFullHayMovimientoHorizontalSinVacioTest() {
		Board b = new Board();
		b.getRow(0).set(0, Cell.create(2));
		b.getRow(0).set(1, Cell.create(4));
		b.getRow(0).set(2, Cell.create(8));
		b.getRow(0).set(3, Cell.create(8));
		
		b.getRow(1).set(0, Cell.create(32));
		b.getRow(1).set(1, Cell.create(64));
		b.getRow(1).set(2, Cell.create(128));
		b.getRow(1).set(3, Cell.create(256));
		
		b.getRow(2).set(0, Cell.create(512));
		b.getRow(2).set(1, Cell.create(1024));
		b.getRow(2).set(2, Cell.create(2));
		b.getRow(2).set(3, Cell.create(4));
		
		b.getRow(3).set(0, Cell.create(8));
		b.getRow(3).set(1, Cell.create(16));
		b.getRow(3).set(2, Cell.create(32));
		b.getRow(3).set(3, Cell.create(64));
		
		assertEquals(false, b.isBoardFull());
	}
	
	@Test
	public void isBoardFullHayMovimientoVerticalSinVacioTest() {
		Board b = new Board();
		b.getRow(0).set(0, Cell.create(2));
		b.getRow(0).set(1, Cell.create(4));
		b.getRow(0).set(2, Cell.create(8));
		b.getRow(0).set(3, Cell.create(16));
		
		b.getRow(1).set(0, Cell.create(32));
		b.getRow(1).set(1, Cell.create(64));
		b.getRow(1).set(2, Cell.create(128));
		b.getRow(1).set(3, Cell.create(256));
		
		b.getRow(2).set(0, Cell.create(512));
		b.getRow(2).set(1, Cell.create(1024));
		b.getRow(2).set(2, Cell.create(2));
		b.getRow(2).set(3, Cell.create(4));
		
		b.getRow(3).set(0, Cell.create(8));
		b.getRow(3).set(1, Cell.create(16));
		b.getRow(3).set(2, Cell.create(2));
		b.getRow(3).set(3, Cell.create(64));
		
		assertEquals(false, b.isBoardFull());
	}
	
	@Test
	public void isBoardFullHayMovimientoHorizontalConVacioTest() {
		Board b = new Board();
		b.getRow(0).set(0, Cell.create(2));
		b.getRow(0).set(1, Cell.create(4));
		b.getRow(0).set(2, Cell.create(0));
		b.getRow(0).set(3, Cell.create(16));
		
		b.getRow(1).set(0, Cell.create(32));
		b.getRow(1).set(1, Cell.create(64));
		b.getRow(1).set(2, Cell.create(128));
		b.getRow(1).set(3, Cell.create(256));
		
		b.getRow(2).set(0, Cell.create(512));
		b.getRow(2).set(1, Cell.create(1024));
		b.getRow(2).set(2, Cell.create(2));
		b.getRow(2).set(3, Cell.create(4));
		
		b.getRow(3).set(0, Cell.create(8));
		b.getRow(3).set(1, Cell.create(16));
		b.getRow(3).set(2, Cell.create(32));
		b.getRow(3).set(3, Cell.create(64));
		
		assertEquals(false, b.isBoardFull());
	}
	
	@Test
	public void isBoardFullHayMovimientoVerticalConVacioTest() {
		Board b = new Board();
		b.getRow(0).set(0, Cell.create(2));
		b.getRow(0).set(1, Cell.create(4));
		b.getRow(0).set(2, Cell.create(8));
		b.getRow(0).set(3, Cell.create(16));
		
		b.getRow(1).set(0, Cell.create(0));
		b.getRow(1).set(1, Cell.create(64));
		b.getRow(1).set(2, Cell.create(128));
		b.getRow(1).set(3, Cell.create(256));
		
		b.getRow(2).set(0, Cell.create(512));
		b.getRow(2).set(1, Cell.create(1024));
		b.getRow(2).set(2, Cell.create(2));
		b.getRow(2).set(3, Cell.create(4));
		
		b.getRow(3).set(0, Cell.create(8));
		b.getRow(3).set(1, Cell.create(16));
		b.getRow(3).set(2, Cell.create(32));
		b.getRow(3).set(3, Cell.create(64));
		
		assertEquals(false, b.isBoardFull());
	}

}
