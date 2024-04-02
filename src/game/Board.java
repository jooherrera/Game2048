package game;

import java.util.ArrayList;

public class Board {
	Cell[][] board;
	ArrayList<Cell> emptyCellList;
	ArrayList<Cell> combinedCellList;
	
	public Board() {
		this.board = new Cell[4][4];
		
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[i].length; j++) {
				this.board[i][j] = Cell.create(0);
			}
		}
		
		emptyCellList = new ArrayList<Cell>();
		combinedCellList = new ArrayList<Cell>();
	}
	
	public Board(Cell[][] b) {
		this.board = b;
		
		emptyCellList = new ArrayList<Cell>();
		combinedCellList = new ArrayList<Cell>();
	}
	
	public int combineToRight(){
		int acum = 0;
		
//		
		
		return acum;
	}
	
	public int combineToLeft(){
		int acum = 0;
		
//		imprimirBoard();
		for (int i = 0; i < this.board.length; i++) {	//recorremos cada fila
			
			int k = 0;
			
			for (int j = 0; j < board[i].length; j++) { //recorremos la fila de izquierda a derecha
				if (this.board[i][j].isEmpty()) {
					k++;						//contamos las cells vacias
				}
			}
			
			if (k == 4 || k == 0) {
				k = 1;
			}
			for (int c = 0; c <= k; c++) {
				System.out.println("c: "+c);
				for (int j = 0; j < board[i].length; j++) {	//recorremos la fila de derecha a izquierda
					
					int combValue = 0;
					
					combValue = this.board[i][j].combine(this.board[i][j+1]);
					acum += combValue;
					
					if (combValue != 0) {
						combinedCellList.add(this.board[i][j]);
						k++;
					}else if (!sonDistintosValoresMayorQueCero(this.board[i][j].getNumber(), this.board[i][j+1].getNumber())){
//						this.board[i][j+1].clear();
					}					
//					imprimirBoard();
				}
			}
		}
		
		return acum;
	}
	
	public int combineToUp(){
		return 0;
	}
	
	public int combineToDown(){
		return 0;
	}
	
	public void generateRandomPosition(){
		
	}
	
	public boolean isBoardFull(){
		return false;
	}
	
	private void resetCombinedCellList() {
		
	}
	
	private void imprimirBoard() {
		for (int i = 0; i < this.board.length; i++) {
			System.out.println("Fila: "+i+"\n");
			for (int j = 0; j < this.board[i].length; j++) {
				System.out.println("Cell: ["+i+","+j+"] value: "+this.board[i][j].getNumber()+" combinado: "+isInCombineList(this.board[i][j]));
			}
			System.out.println("");
		}
	}
	
	private boolean sonDistintosValoresMayorQueCero(int a, int b) {
		return (a > 0 && b > 0) &&  a != b;
	}
	
	private boolean algunoEsCero(int a, int b) {
		return a == 0 || b == 0;
	}
	
	private boolean algunoFueCombinado(Cell c1, Cell c2) {
		int a = c1.getNumber();
		int b = c1.getNumber();
		
		return isInCombineList(c1) || isInCombineList(c2);
	}
	
	private boolean isInCombineList(Cell c) {
		return combinedCellList.contains(c);
	}
}
