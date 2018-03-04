import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SudokuToSatReducerBalasi {
	private BufferedWriter writer;
	TimerBalasi timer = new TimerBalasi();
	int width, height;
	SudokuBoardBalasi board;

	int compare, row, column, value;
	int boardSize = 9;
	 
	public SudokuToSatReducerBalasi(File file) {
		createBoard(file);
	}
	
	public void createBoard(File file) {
		try {
			Scanner scan = new Scanner(file);
			
				this.width = Integer.parseInt(scan.next());
				this.height = Integer.parseInt(scan.next());
				
				this.board= new SudokuBoardBalasi(width, height);
				
				for(int i=0; i<board.boardCells.length; i++) {
					int num = Integer.parseInt(scan.next());
					board.boardCells[i]=num;
					
				}
			
		}catch (Exception e) {
				System.out.println("There was an error "+e);
			}		
		
}
	

	public void reduceBoard() throws IOException {
		File output=new File("output.txt");
		writer = new BufferedWriter (new FileWriter(output));
		writer.write("p 729 11988");
		timer.start();//call timer start 
		atleastOneInRow();
		timer.stop();//call timer stop
		System.out.println("This ran for "+timer.getDuration()+"ms.");
		writer.close();
	}
	
	//i = row, j= column, k=value
	public void atleastOneInRow() throws IOException {
		writer.write(System.getProperty( "line.separator" ));
		int [] row = new int[9];
		int[] box = new int[9];
		for(int k=1; k<=boardSize; k++) {
			for(int i=0; i<boardSize; i++) {
				for(int j=0; j<boardSize; j++) {
					row[i]=(encode(i,j,k));
				}
			}
		}
		atmostOneInRow(row);
	}
	
	
	public void atmostOneInRow(int[] row) throws IOException {	
		row= new int[9];
		int[] box = new int[9];
			for(int i=0; i<boardSize; i++) {
				for(int j=0; j<boardSize; j++) {
					for(int k=1; k>9; k++) {
						row[i]=(encode(i,j,k));
				}
			}
		}atLeastOneInCol(row);
	}
	
	public void atLeastOneInCol(int[] row) throws IOException {
		row= new int[9];
		int[] box = new int[9];
		for(int k=1; k<boardSize; k++) {
			for(int j=0; j<boardSize; j++) {
				for(int i=0; i<boardSize; i++) {
					row[i]=(encode(i,j,k));
				}
			}
		}atMostOneInCol(row);
	}
	
	public void atMostOneInCol(int[] row) throws IOException {				//check this
		int[] arr= new int[9];
		int[] box = new int[9];
		for(int j=0; j<boardSize; j++) {
			for(int i=0; i<boardSize; i++) {
				for(int k=9; k>0; k--) {
					row[i]=(encode(i,j,k));
			}
		}
	}atleastOneInBox(row);
	}
	
	public void atleastOneInBox(int[] row) throws IOException {
		row =new int[9];
		int[] box = new int[9];
		for(int k=1; k<=9; k++) {
			for(int j=0; j<9; j++) {
				box= board.getBoxValues(j);
				for(int i=0; i<9; i++) {
					row[i]=(encode(i,j,k));
				}
			}
		}atmostOneInBox(row);
	}
	
	public void atmostOneInBox(int[] arr) throws IOException {
		int k=0;
		int []row =new int[9];
		int[] box = new int[9];
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				row[i]=(encode(i,j,k));
				writer.write(-row[i]+" "+-row[j]);
				writer.write(System.getProperty( "line.separator" ));
			}

		}
	}	
	 public void atLeastOneValue(int size) {
		 int[] row = new int[0];
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					for(int k=1; k<=size; k++) {
						row[k-1]=encode(i,j,k);
								writer.write(row[k-1]+" ");
					}
				}
			}atMostOneValue(row);
	 }
	 
	 public void atMostOneValue(int [] arr){
			for (int i=0; i<arr.length; i++){
				
			}
		}
	private int encode(int i, int j, int k) {
		return (i*boardSize*boardSize) +(j*boardSize)+k;
	}

	
}
