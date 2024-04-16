package game;

import java.util.List;

public interface Game {

	void moveToRight();
	void moveToLeft();
	void moveToUp();
	void moveToDwn();
	
	void newGame();
	
	int getScore();
	List<List<Integer>> getBoard();
	boolean hasPlayerWon();
	boolean hasPlayerLose();
	boolean wantPlayerContinue();
	void continueGaming();
}
