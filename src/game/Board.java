package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
	ArrayList<ArrayList<Cell>> matriz;
	ArrayList<Cell> emptyCellList;
	ArrayList<Cell> combinedCellList;
	Score score;
	boolean change_position;
	boolean initialized ;
	int max_combination;
	
	
	public Board() {
		this.emptyCellList = new ArrayList<Cell>();
		this.matriz = createAllZeroMatrix(4);
		this.combinedCellList = new ArrayList<Cell>();
		this.score = new Score();
		this.change_position = false;
		this.initialized = false;
		this.max_combination = 0;
		this.init();
	}
	
	public Board(ArrayList<ArrayList<Cell>> b) {
		this.matriz = b;
		this.emptyCellList = new ArrayList<Cell>();
		this.combinedCellList = new ArrayList<Cell>();
		this.score = new Score();
		this.change_position = false;
		this.initialized = false;
		this.max_combination = 0;
		this.init();
	}
	
	public void restart() {
		this.resetBoard();
		this.combinedCellList.clear();
		this.score.reset();
		this.change_position = false;
		this.initialized = false;
		this.max_combination = 0;
		this.init();
	}
	
	public void combineToRight(){
		for (int f = 0; f < matriz.size(); f++) {
			
			int position = matriz.get(f).size()-1;
			for (int c = matriz.get(f).size()-1; c >= 0; c--) {
				boolean isFirstElement = c == matriz.get(f).size()-1;
				
				Cell cell = matriz.get(f).get(c);
				
				if (isFirstElement || cell.isEmpty())
					continue;
				
				Cell cellPointer = matriz.get(f).get(position);
				
				if (cellPointer.isEmpty()) {
					cellPointer.combine(cell);
					this.change_position = true;
					continue;
				}
				
				if (cell.getNumber() != cellPointer.getNumber()) {
					position--;
					if (position == c)
						continue;
					
					Cell cellToCombine = matriz.get(f).get(position);
					cellToCombine.combine(cell);
					this.change_position = true;
					continue;
				}
				
				int points = cellPointer.combine(cell);
				score.add(points);

				combinedCellList.add(cellPointer);
				this.change_position = true;
				position--;
				
				this.max_combination = points > this.max_combination ?  points : this.max_combination;
				
				continue;
			}
		}
		
		resetCombinedCellList();
		findEmptyCells();
		generateRandomPosition();

	}
	
	public void combineToLeft(){
		
		for (int f = 0; f < matriz.size(); f++) {
			
			int position = 0;
			for (int c = 0; c < matriz.get(f).size(); c++) {
				boolean isFirstElement = c == 0;
				
				Cell cell = matriz.get(f).get(c);
				
				if (isFirstElement || cell.isEmpty())
					continue;
				
				Cell cellPointer = matriz.get(f).get(position);
				
				if (cellPointer.isEmpty()) {
					cellPointer.combine(cell);
					this.change_position = true;
					continue;
				}
				
				if (cell.getNumber() != cellPointer.getNumber()) {
					position++;
					if (position == c)
						continue;
					
					Cell cellToCombine = matriz.get(f).get(position);
					cellToCombine.combine(cell);
					this.change_position = true;
					continue;
				}
				
				int points = cellPointer.combine(cell);
				score.add(points);
				combinedCellList.add(cellPointer);
				this.change_position = true;
				position++;
				
				this.max_combination = points > this.max_combination ?  points : this.max_combination;
				
				continue;
			}
		}
		
		resetCombinedCellList();
		findEmptyCells();
		generateRandomPosition();
		
	}
	
	public void combineToUp(){
		
		for (int c = 0; c < matriz.get(0).size(); c++) {
			
			int position = 0;
			for (int f = 0; f < matriz.size(); f++) {
				boolean isFirstElement = f == 0;
				
				Cell cell = matriz.get(f).get(c);
				
				if (isFirstElement || cell.isEmpty())
					continue;
				
				Cell cellPointer = matriz.get(position).get(c);
				
				if (cellPointer.isEmpty()) {
					cellPointer.combine(cell);
					this.change_position = true;
					continue;
				}
				
				if (cell.getNumber() != cellPointer.getNumber()) {
					position++;
					if (position == f)
						continue;
					
					Cell cellToCombine = matriz.get(position).get(c);
					cellToCombine.combine(cell);
					this.change_position = true;
					continue;
				}
				
				int points = cellPointer.combine(cell);
				score.add(points);
				combinedCellList.add(cellPointer);
				this.change_position = true;
				position++;
				
				this.max_combination = points > this.max_combination ?  points : this.max_combination;

				continue;
			}
		}
		
		resetCombinedCellList();
		findEmptyCells();		
		generateRandomPosition();
	}
	
	public void combineToDown(){
		
		for (int c = 0; c < matriz.get(0).size(); c++) {
			
			int position = matriz.size()-1;
			for (int f = matriz.size()-1; f >= 0; f--) {
				boolean isFirstElement = f == matriz.size()-1;
				
				Cell cell = matriz.get(f).get(c);
				
				if (isFirstElement || cell.isEmpty())
					continue;
				
				Cell cellPointer = matriz.get(position).get(c);
				
				if (cellPointer.isEmpty()) {
					cellPointer.combine(cell);
					this.change_position = true;
					continue;
				}
				
				if (cell.getNumber() != cellPointer.getNumber()) {
					position--;
					if (position == f)
						continue;
					
					Cell cellToCombine = matriz.get(position).get(c);
					cellToCombine.combine(cell);
					this.change_position = true;
					continue;
				}
				
				int points = cellPointer.combine(cell);
				score.add(points);
				combinedCellList.add(cellPointer);
				this.change_position = true;
				position--;

				
				this.max_combination = points > this.max_combination ?  points : this.max_combination;
				
				continue;
			}
		}
		
		resetCombinedCellList();
		findEmptyCells();
		generateRandomPosition();
	}
	
	public void generateRandomPosition(){
		if((isBoardFull() || !this.change_position ) && this.initialized ) {
			return;
		}

		
		this.change_position = false;
		
		
		Random rand = new Random();

		int randomIndex = rand.nextInt(this.emptyCellList.size());

		Cell randomCell = this.emptyCellList.get(randomIndex);

		randomCell.generateRandomValue();

		this.emptyCellList.remove(randomIndex);
	}
	
	public List<List<Integer>> getBoardData(){
		List<List<Integer>> ret = new ArrayList<>();
		
		for (int i = 0; i < this.matriz.size(); i++) {
			ArrayList<Integer> newRow = new ArrayList<Integer>();
			ret.add(newRow);
			for (int j = 0; j < this.matriz.size(); j++) {
				int cellValue = this.matriz.get(i).get(j).getNumber();
				ret.get(i).add(cellValue);
			}
		}
		
		return ret;
	}
	
	public boolean isBoardFull(){
		return this.emptyCellList.isEmpty();
	}
	
	public boolean noHayMasMovimientos() {	//devuelve true si no hay mas movimientos
		return isBoardFull() && todosDistintosEnFila() && todosDistintosEnColumna(); //si el board esta lleno y todas las celdas son distintas, no hay mas movimientos
	}
	
	private boolean todosDistintosEnFila() {
		boolean ret = true;
		
		for (int f = 0; f < matriz.size(); f++) {
			
			boolean distintos = true;
			
			for (int c = 0; c < matriz.get(f).size()-1; c++) {
				distintos = distintos && matriz.get(f).get(c).getNumber() != matriz.get(f).get(c+1).getNumber();
			}
			
			ret = ret && distintos;
		}
		
		return ret;
	}
	
	private boolean todosDistintosEnColumna() {
		boolean ret = true;
		
		for (int c = 0; c < matriz.get(0).size(); c++) {
			
			boolean distintos = true;
			
			for (int f = 0; f < matriz.size()-1; f++) {
				distintos = distintos && matriz.get(f).get(c).getNumber() != matriz.get(f+1).get(c).getNumber();
			}
			
			ret = ret && distintos;
		}
		
		return ret;
	}
	
	private void resetCombinedCellList() {
		for (Cell cell : this.combinedCellList) {
			cell.resetCombined();
		}
		
		combinedCellList.clear();
	}
	
	private void findEmptyCells() {
		this.emptyCellList.clear();
		
		for (ArrayList<Cell> row : this.matriz)
			for (Cell cell : row) {
				if (cell.isEmpty())
					this.emptyCellList.add(cell);
			}
	}
	
	private void init() {
		this.generateRandomPosition();
		this.generateRandomPosition();
		this.initialized = true;
	}
	
	private ArrayList<ArrayList<Cell>> createAllZeroMatrix(int size) {
		ArrayList<ArrayList<Cell>> cells = new ArrayList<ArrayList<Cell>>();
		
		for (int i = 0; i < size; i++) {
			ArrayList<Cell> cellRow = new ArrayList<Cell>();
			cells.add(cellRow);
			for (int j = 0; j < size; j++) {
				Cell cell = Cell.create(0);
				cells.get(i).add(cell);
				emptyCellList.add(cell);
			}
		}
		return cells;
	}
	
	private void resetBoard() {
		this.emptyCellList.clear();
		
		for (int i = 0; i < this.matriz.size(); i++) {
			for (int j = 0; j < this.matriz.get(i).size(); j++) {
				Cell cell = this.matriz.get(i).get(j);
				cell.reset();
				emptyCellList.add(cell);
			}
		}
	}
	
	public ArrayList<Cell> getRow(int row) {	//cambiar
		return this.matriz.get(row);
	}
	
	public int getScore() {
		return this.score.getValue();
	}
	
	public boolean checkMaxValue(int value) {
		return this.max_combination >= value;
	}
}
