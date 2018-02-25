import java.io.File;

public class SudokuBoardBalasi {
	
	private int width, height, size, numberOfCells, value,totalWidth,totalHeight, boardSize,row, column;
	File file;
	
	public SudokuBoardBalasi(File file){
		int [] boardCells= new int[size(width, height)];
	}

	
	//done this works correctly
	public int size(int boxWidth, int boxHeight) {
		int boardSize= (boxWidth*boxHeight)*(boxWidth * boxHeight);
		return boardSize;
		
	}
	//done this works correctly
	public int row(int cellNumber) {//the row to which the cell belongs in the 2d form of the sudoku board
		int row=0,j=0;
		if(cellNumber <0) {
			cellNumberError();
		}else if(j>(totalWidth)) {
			cellNumberError();
		}else {
			while(row<=cellNumber) {
				row= row +(totalWidth);
				j++;
			}
		}
		row=j;
		return row;
	}
	//done this works correctly
	public int column(int cellNumber) {//the column to which the cell belongs in the 2d form of the soduku board
		if(cellNumber <0) {
			cellNumberError();
		}else if(column >= totalHeight) {
			cellNumberError();
		}else {	
			int column= (1+cellNumber%totalHeight);
		}
		return column;
	}
	
	//done this works correctly
	public int value(int row, int column) {//the value in the cell at row, column
		int value= ((row-1)*9)+(column-1);
		return value;
	}
	//done
	public int box(int row, int column) {//the box in which the cell lies in the 2d form of the soduku board???
		int box=0;
		if(row<=3) {
			if(column <=3) {
			box = 1;
			}else if(column>3 && column <=6) {
				box=2;
			}else if(column>6 && column<=9) {
				box=3;
			}
		}else if(row>3 && row<=6) {
			if(column<=3) {
				box=4;
			}else if(column>3 && column <=6) {
				box=5;
			}else if(column>6 && column<=9) {
				box=6;
			}
		}else if(row>6 && row<=9) {
			if(column<=3) {
				box=7;
			}else if(column>3 && column <=6) {
				box=8;
			}else if(column>6 && column<=9) {
				box=9;
			}
		}
		return box;
	}
	
	//getters, setters and print
	public int getBoxWidth() {
		return totalWidth;
	}
	
	public int getBoxHeight() {
		return totalHeight;
	}
	
	public int getBoardSize() {
		return size;
	}
	
	public int getnumberOfCells() {
		return numberOfCells;
	}
	//done
	public int setBoardCells(int row, int column, int givenInt) {
		int value=((row-1)*9)+(column-1);
		return givenInt;
	}
	
	//done this works correctly when it is in the file with the array
	 public void toString(int[] boardCells) {//print the board in 2d format
		 int j=0,i=0,x=0;
		 while(i<totalWidth) {
			 while(j<9){
				 System.out.print(boardCells[x]);
				 j++;
				 x++;
			 }
			 j=0;
			 i++;
			 System.out.println("\n");
		 }
	}
	 //needed this to make sure a negative or a number larger than the grid size was not entered
	 public void cellNumberError() {
			System.out.println("That is not a valid cell number for the grid");
			System.exit(0);
	 }
	
}
