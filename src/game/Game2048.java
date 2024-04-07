package game;

import java.util.List;

public class Game2048 implements Game {
	
	Board board = new Board();

	@Override
	public void moveToRight() {
		board.combineToRight();
	}

	@Override
	public void moveToLeft() {
		board.combineToLeft();
		
	}

	@Override
	public void moveToUp() {
		board.combineToUp();
	}

	@Override
	public void moveToDwn() {
		board.combineToDown();	
	}

	@Override
	public int getScore() {
		return board.getScore();
	}

	@Override
	public List<List<Integer>> getBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasPlayerWon() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPlayerLose() {
		// TODO Auto-generated method stub
		return false;
	}

}
