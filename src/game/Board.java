package game;

import java.util.ArrayList;
import java.util.Random;

public class Board {
	ArrayList<ArrayList<Cell>> board;
	ArrayList<Cell> emptyCellList;
	ArrayList<Cell> combinedCellList;
	Score score;
	
	public Board() {
		this.board = createAllZeroMatrix(4);
		this.emptyCellList = new ArrayList<Cell>();
		this.combinedCellList = new ArrayList<Cell>();
		this.score = new Score();
	}
	
	public Board(ArrayList<ArrayList<Cell>> b) {
		this.board = b;
		this.emptyCellList = new ArrayList<Cell>();
		this.combinedCellList = new ArrayList<Cell>();
		this.score = new Score();
	}
	
	public int combineToRight(){
		int sumaTotal = 0;
		
		for (int f = 0; f < board.size(); f++) {
			
			int position = board.get(f).size()-1;
			for (int c = board.get(f).size()-1; c >= 0; c--) {
				boolean isFirstElement = c == board.get(f).size()-1;
				
				Cell cell = board.get(f).get(c);
				
				if (isFirstElement || cell.isEmpty())
					continue;
				
				Cell cellPointer = board.get(f).get(position);
				
				if (cellPointer.isEmpty()) {
					cellPointer.combine(cell);
					continue;
				}
				
				if (cell.getNumber() != cellPointer.getNumber()) {
					position--;
					if (position == c)
						continue;
					
					Cell cellToCombine = board.get(f).get(position);
					cellToCombine.combine(cell);
					continue;
				}
				
				sumaTotal += cellPointer.combine(cell);
				score.add(sumaTotal);
				combinedCellList.add(cellPointer);
				position--;
				continue;
			}
		}
		
		resetCombinedCellList();
		findEmptyCells();

		return sumaTotal;
	}
	
	public int combineToLeft(){
		int sumaTotal = 0;
		
		for (int f = 0; f < board.size(); f++) {
			
			int position = 0;
			for (int c = 0; c < board.get(f).size(); c++) {
				boolean isFirstElement = c == 0;
				
				Cell cell = board.get(f).get(c);
				
				if (isFirstElement || cell.isEmpty())
					continue;
				
				Cell cellPointer = board.get(f).get(position);
				
				if (cellPointer.isEmpty()) {
					cellPointer.combine(cell);
					continue;
				}
				
				if (cell.getNumber() != cellPointer.getNumber()) {
					position++;
					if (position == c)
						continue;
					
					Cell cellToCombine = board.get(f).get(position);
					cellToCombine.combine(cell);
					continue;
				}
				
				sumaTotal += cellPointer.combine(cell);
				combinedCellList.add(cellPointer);
				position++;
				continue;
			}
		}
		
		resetCombinedCellList();
		findEmptyCells();
		
		return sumaTotal;
	}
	
	public int combineToUp(){
		int sumaTotal = 0;
		
		for (int c = 0; c < board.get(0).size(); c++) {
			
			int position = 0;
			for (int f = 0; f < board.size(); f++) {
				boolean isFirstElement = f == 0;
				
				Cell cell = board.get(f).get(c);
				
				if (isFirstElement || cell.isEmpty())
					continue;
				
				Cell cellPointer = board.get(position).get(c);
				
				if (cellPointer.isEmpty()) {
					cellPointer.combine(cell);
					continue;
				}
				
				if (cell.getNumber() != cellPointer.getNumber()) {
					position++;
					if (position == f)
						continue;
					
					Cell cellToCombine = board.get(position).get(c);
					cellToCombine.combine(cell);
					continue;
				}
				
				sumaTotal += cellPointer.combine(cell);
				combinedCellList.add(cellPointer);
				position++;
				continue;
			}
		}
		
		resetCombinedCellList();
		findEmptyCells();
		
		return sumaTotal;
	}
	
	public int combineToDown(){
		int sumaTotal = 0;
		
		for (int c = 0; c < board.get(0).size(); c++) {
			
			int position = board.size()-1;
			for (int f = board.size()-1; f >= 0; f--) {
				boolean isFirstElement = f == board.size()-1;
				
				Cell cell = board.get(f).get(c);
				
				if (isFirstElement || cell.isEmpty())
					continue;
				
				Cell cellPointer = board.get(position).get(c);
				
				if (cellPointer.isEmpty()) {
					cellPointer.combine(cell);
					continue;
				}
				
				if (cell.getNumber() != cellPointer.getNumber()) {
					position--;
					if (position == f)
						continue;
					
					Cell cellToCombine = board.get(position).get(c);
					cellToCombine.combine(cell);
					continue;
				}
				
				sumaTotal += cellPointer.combine(cell);
				combinedCellList.add(cellPointer);
				position--;
				continue;
			}
		}
		
		resetCombinedCellList();
		findEmptyCells();
		
		return sumaTotal;
	}
	
	public void generateRandomPosition(){
		Random rand = new Random();

		int randomIndex = rand.nextInt(this.emptyCellList.size());

		Cell randomCell = this.emptyCellList.get(randomIndex);

		randomCell.generateRandomValue();

		this.emptyCellList.remove(randomIndex);
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
	
	private void findEmptyCells() {
		for (ArrayList<Cell> row : this.board)
			for (Cell cell : row) {
				if (cell.isEmpty())
					this.emptyCellList.add(cell);
			}
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
