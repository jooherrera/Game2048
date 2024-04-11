package game;

public class Score {

	private int value;
	
	public Score() {
		this.value = 0;
	}
	
	public void add(int value) {
		if(value < 0) {
			throw new IllegalArgumentException("No se puede agregar al score un valor negativo: " + value);
		}
		
		this.value += value;
		
	}
	
	public void reset() {
		this.value = 0;
	}
	
	public int getValue() {
		return this.value;
	}
}
