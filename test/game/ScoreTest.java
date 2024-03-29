package game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScoreTest {

	Score score;
	
	
	@Before
	public void init() {
		score = new Score();
	}
	
	@Test(expected = IllegalArgumentException.class )
	public void noAddNegativeValueTest() {		
		score.add(-1);
	}

	@Test
	public void addCeroValueTest() {		
		score.add(0);

		int expected = 0;		
		int actual = score.getValue();
		assertEquals(expected, actual);
	}

	@Test
	public void addValuePositiveTest() {		
		score.add(1);
		
		int expected = 1;		
		int actual = score.getValue();
		assertEquals(expected, actual);
	}

	
	@Test
	public void sumValuesTest() {		
		score.add(8);
		
		score.add(2);
		
		int expected = 10 ;		
		int actual = score.getValue();
		assertEquals(expected, actual);
	}
	

}
