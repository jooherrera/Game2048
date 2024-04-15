package game;

import java.util.List;

public class Game2048 implements Game {
	
	Board board = new Board();
	int WIN_POINTS = 2048;
	
	public Game2048() {
		
	}
	
	
	
	@Override
	public void moveToRight() {
		if(!this.hasPlayerLose()) {
			board.combineToRight();
		}
	}

	@Override
	public void moveToLeft() {
		if(!this.hasPlayerLose()) {
		board.combineToLeft();
		}
	}

	@Override
	public void moveToUp() {
		if(!this.hasPlayerLose()) {
		board.combineToUp();
		}
	}

	@Override
	public void moveToDwn() {
		if(!this.hasPlayerLose()) {
		board.combineToDown();	
		}
	}

	@Override
	public int getScore() {
		return board.getScore();
	}

	@Override
	public List<List<Integer>> getBoard() {
		return board.getBoardData();
	}

	@Override
	public boolean hasPlayerWon() {
		return board.checkMaxValue(WIN_POINTS);
	}

	@Override
	public boolean hasPlayerLose() {
		return board.noHayMasMovimientos();
	}

	@Override
	public void newGame() {
		board.restart();
	}

}
