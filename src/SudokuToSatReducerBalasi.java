import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SudokuToSatReducerBalasi {
	File file;
	TimerBalasi timer = new TimerBalasi();
	int width, height;
	String  tempFileName  = "temp.cnf";
//	try {
//		Writer  writer=new PrintWriter("SATFile.txt");
//	}catch(IOException e) {
//		
//	}
	
	int compare, row, column, value;
	int boardSize = 9;
	
	public  SudokuToSatReducerBalasi() {
		//for testing
	}
	 
	public SudokuToSatReducerBalasi(File file) {
		createBoard(file);
	}
	
	public void output() {
		
	}

	public void createBoard(File file) {
		try {
			Scanner scan = new Scanner(file);
			Pattern p = Pattern.compile("p cnf");
			Matcher m =p.matcher("p cnf");
			boolean b = m.matches();
			
			if(b == true) {
				
			while(scan.findInLine(p)==null) { 
			
				this.width = Integer.parseInt(scan.next());
				this.height = Integer.parseInt(scan.next());
				
				SudokuBoardBalasi board= new SudokuBoardBalasi(width, height);
				
				for(int i=0; i<board.boardCells.length; i++) {
					int num = Integer.parseInt(scan.next());
					board.boardCells[i]=num;
					
				}
				break;
				}	
			}
		}catch (Exception e) {
				System.out.println("There was an error "+e);
			}		
		
}
	

	public void reduceBoard() {
		timer.start();//call timer start 
//		atleastOneInRow();
//		atmostOneInRow();
//		atLeastOneInCol();
//		atMostOneInCol();
//		atleastOneInBox();
//		atmostOneInBox();
		timer.stop();//call timer stop
		System.out.println("This ran for "+timer.getDuration()+"ms.");
	}
	
	//i = row, j= column, k=value
	public void atleastOneInRow() {
		for(int k=1; k<=boardSize; k++) {
			for(int i=0; i<boardSize; i++) {
				for(int j=0; j<boardSize; j++) {
					System.out.print(String.valueOf(encode(i,j,k)) + " ");
				}
				System.out.print(" 0");
				System.out.println("");
			}
		}
	}
	
	
	public void atmostOneInRow() {						//check this
			for(int i=0; i<boardSize; i++) {
				for(int j=0; j<boardSize; j++) {
					for(int k=9; k>0; k--) {
						System.out.print(String.valueOf(encode(i,j,k))+" ");
				}
				System.out.print(" 0");
				System.out.println("");	
			}
		}
	}
	
	public void atLeastOneInCol() {
		for(int k=1; k<boardSize; k++) {
			for(int j=0; j<boardSize; j++) {
				for(int i=0; i<boardSize; i++) {
					System.out.print(String.valueOf(encode(i,j,k)));
				}
				System.out.print(" 0");
				System.out.println("");
			}
		}
	}
	
	public void atMostOneInCol() {				//check this
		for(int j=0; j<boardSize; j++) {
			for(int i=0; i<boardSize; i++) {
				for(int k=9; k>0; k--) {
					System.out.print(String.valueOf(encode(i,j,k))+" ");
			}
			System.out.print(" 0");
			System.out.println("");	
		}
	}
	}
	
	public void atleastOneInBox() {
	
	}
	
	public void atmostOneInBox() {
	
	}	
	
	private int encode(int i, int j, int k) {
		return (i*boardSize*boardSize) +(j*boardSize)+k;
	}
	
//	  void write (String str) {
//
//          try {
//
//               writer.write(str);
//               writer.flush();
//         }  catch(IOException  e)  { }

  public static void main(String[]args) {
	  SudokuToSatReducerBalasi board = new SudokuToSatReducerBalasi();
	 
	 // board.atmostOneInRow();
	 // board.atMostOneInCol();
	 // board.atleastOneInRow();
	 // board.atLeastOneInCol();
  }
	
}
