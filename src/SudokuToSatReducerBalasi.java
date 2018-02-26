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
	Writer  writer;
	writer= new PrintWriter(tempFileName);
	boolean compare;
	 
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
		atleastOneInRow(boardCells);
		atmostOneInRow(boardCells);
		atLeastOneInCol(boardCells);
		atleastOneInBox(boardCells);
		atmostOneInBox(boardCells);
		timer.stop();//call timer stop
		System.out.println("This ran for "+timer.getDuration()+"ms.");
	}
	
	
	public boolean atleastOneInRow(int[] boardCells) {
		return compare;
	}
	
	
	public boolean atmostOneInRow(int[] boardCells) {
	
		return compare;
	}
	
	public boolean atLeastOneInCol(int[] boardCells) {
		return compare;
	}
	
	public boolean atleastOneInBox(int[] boardCells) {
		return compare;
	}
	
	public boolean atmostOneInBox(int[] boardCells) {
		return compare;
	}	
	
	  void write (String str) {

          try {

               writer.write(str);
               writer.flush();
         }  catch(IOException  e)  { }

  }
	
}
