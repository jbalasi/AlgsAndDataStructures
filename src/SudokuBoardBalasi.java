import java.io.File;

public class SudokuBoardBalasi {
	
	private int width, height, size, numberOfCells, value, boardSize,row, column;
	int[] boardCells;
	
	public SudokuBoardBalasi(int width, int height){
		this.width=width;
		this.height=height;
		this.boardSize=width*height;
		this.numberOfCells=boardSize*boardSize;
		this.boardCells= new int[numberOfCells];
	}

	public int row(int cellNumber) {//the row to which the cell belongs in the 2d form of the sudoku board
		return cellNumber/boardSize;
	}
	
	public int column(int cellNumber) {//the column to which the cell belongs in the 2d form of the soduku board
		return cellNumber%boardSize;
	}
	
	//done this works correctly
	public int value(int cellNumber) {//the value in the cell 
		return boardCells[cellNumber];
	}
	//done
	public int box(int cellNumber) {//the box in which the cell lies in the 2d form of the soduku board???
		int box=0;
		
		return box;
	}
	
	//getters, setters and print
	public int getBoxWidth() {
		return width;
	}
	
	public int getBoxHeight() {
		return height;
	}
	
	public int getBoardSize() {
		return boardSize;
	}
	
	public int getnumberOfCells() {
		return numberOfCells;
	}
	
	public void setBoardCells(int cellNumber, int givenInt) {
		boardCells[cellNumber]=givenInt;
	}
	
	 public String toString(int boardCells) {
		 StringBuilder sb = new StringBuilder();
		 int size=this.width;
		for(int i=0; i<this.boardCells.length; i++) {
			sb.append(boardCells[i]);
			if(i%size==0)
				sb.append("\n");
		}
		 return sb.toString();
	}
	
}
