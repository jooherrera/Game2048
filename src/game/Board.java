package game;

import java.util.ArrayList;

public class Board {
	ArrayList<ArrayList<Cell>> board;
	ArrayList<Cell> emptyCellList;
	ArrayList<Cell> combinedCellList;
	
	public Board() {
		this.board = createAllZeroMatrix(4);
		emptyCellList = new ArrayList<Cell>();
		combinedCellList = new ArrayList<Cell>();
	}
	
	public Board(ArrayList<ArrayList<Cell>> b) {
		this.board = b;
		emptyCellList = new ArrayList<Cell>();
		combinedCellList = new ArrayList<Cell>();
	}
	
	public int combineToRight(){
		int acum = 0;
		
		for (int i = 0; i < board.size(); i++) {
			
			int position = board.get(i).size()-1;
			for (int j = board.get(i).size()-1; j >= 0; j--) {
				if (j == board.get(i).size()-1)
					continue;
				
				Cell cell = board.get(i).get(j);
				
				if (cell.isEmpty())
					continue;
				
				Cell cellPointer = board.get(i).get(position);
				
				if (cellPointer.isEmpty()) {
					cellPointer.combine(cell);
					continue;
				}
				
				if (cell.getNumber() != cellPointer.getNumber()) {
					
					if (position == j + 1)
						continue;
					
					position--;
					Cell cellToCombine = board.get(i).get(position);
					cellToCombine.combine(cell);
					continue;
				}
				
				acum += cellPointer.combine(cell);
				combinedCellList.add(cellPointer);
				position--;
				continue;
			}
		}
		
		resetCombinedCellList();
		
		return acum;
	}
	
	public int combineToLeft(){
		int acum = 0;
		
		for (int i = 0; i < board.size(); i++) {
			
			int position = 0;
			for (int j = 0; j < board.get(i).size(); j++) {
				if (j == 0)
					continue;
				
				Cell cell = board.get(i).get(j);
				
				if (cell.isEmpty())
					continue;
				
				Cell cellPointer = board.get(i).get(position);
				
				if (cellPointer.isEmpty()) {
					cellPointer.combine(cell);
					continue;
				}
				
				if (cell.getNumber() != cellPointer.getNumber()) {
					
					if (position == j - 1)
						continue;
					
					position++;
					Cell cellToCombine = board.get(i).get(position);
					cellToCombine.combine(cell);
					continue;
				}
				
				acum += cellPointer.combine(cell);
				combinedCellList.add(cellPointer);
				position++;
				continue;
			}
		}
		
		resetCombinedCellList();
		
		return acum;
	}
	
	public int combineToUp(){
		int acum = 0;
		
		for (int c = 0; c < board.get(0).size(); c++) {
			
			int position = 0;
			for (int f = 0; f < board.size(); f++) {
				if (f == 0)
					continue;
				
				Cell cell = board.get(f).get(c);
				
				if (cell.isEmpty())
					continue;
				
				Cell cellPointer = board.get(position).get(c);
				
				if (cellPointer.isEmpty()) {
					cellPointer.combine(cell);
					continue;
				}
				
				if (cell.getNumber() != cellPointer.getNumber()) {
					
					if (position == f - 1)
						continue;
					
					position++;
					Cell cellToCombine = board.get(position).get(c);
					cellToCombine.combine(cell);
					continue;
				}
				
				acum += cellPointer.combine(cell);
				combinedCellList.add(cellPointer);
				position++;
				continue;
				
			}
		}
		
		resetCombinedCellList();
		
		return acum;
	}
	
	public int combineToDown(){
		int acum = 0;
		
		for (int c = 0; c < board.get(0).size(); c++) {
			
			int position = board.size()-1;
			for (int f = board.size()-1; f >= 0; f--) {
				if (f == board.size()-1)
					continue;
				
				Cell cell = board.get(f).get(c);
				
				if (cell.isEmpty())
					continue;
				
				Cell cellPointer = board.get(position).get(c);
				
				if (cellPointer.isEmpty()) {
					cellPointer.combine(cell);
					continue;
				}
				
				if (cell.getNumber() != cellPointer.getNumber()) {
					
					if (position == f + 1)
						continue;
					
					position--;
					Cell cellToCombine = board.get(position).get(c);
					cellToCombine.combine(cell);
					continue;
				}
				
				acum += cellPointer.combine(cell);
				combinedCellList.add(cellPointer);
				position--;
				continue;
				
			}
		}
		
		resetCombinedCellList();
		
		return acum;
	}
	
	public void generateRandomPosition(){
		
	}
	
	public ArrayList<ArrayList<Cell>> getBoardData(){
		return this.board;
	}
	
	public boolean isBoardFull(){
		return false;
	}
	
	private void resetCombinedCellList() {
		for (Cell cell : this.combinedCellList) {
			cell.resetCombined();
		}
		
		combinedCellList.clear();
	}
	
	private void printBoard() {
		for (int i = 0; i < this.board.size(); i++) {
			for (int j = 0; j < this.board.get(i).size(); j++) {
				System.out.print("["+this.board.get(i).get(j).getNumber()+"] ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private boolean isInCombineList(Cell c) {
		return combinedCellList.contains(c);
	}
	
	private ArrayList<ArrayList<Cell>> createAllZeroMatrix(int size) {
		ArrayList<ArrayList<Cell>> cells = new ArrayList<ArrayList<Cell>>();
		
		for (int i = 0; i < size; i++) {
			ArrayList<Cell> cellRow = new ArrayList<Cell>();
			cells.add(cellRow);
			for (int j = 0; j < size; j++) {
				Cell cell = Cell.create(0);
				cells.get(i).add(cell);
			}
		}
		return cells;
	}
}
