package game;

import java.util.List;

public interface Game {

	void moveToRight();
	void moveToLeft();
	void moveToUp();
	void moveToDwn();
	
	int getScore();
	List<List<Integer>> getBoard();
	boolean hasPlayerWon();
	boolean hasPlayerLose();
}
