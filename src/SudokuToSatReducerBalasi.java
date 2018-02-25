import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SudokuToSatReducerBalasi {
	File file;
	TimerBalasi timer = new TimerBalasi();
	public int [] boardCells;
	boolean compare=false;
	public int width, height,totalWidth,totalHeight,row, column,numberOfCells;
	SudokuBoardBalasi board= new SudokuBoardBalasi(file);
	
	
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
			
				width = Integer.parseInt(scan.next());
				height = Integer.parseInt(scan.next());
				totalWidth=width*width;
				totalHeight=height*height;
				
				boardCells = new int [board.size(width,height)];
				
				for(int i=0; i<boardCells.length; i++) {
					int num = Integer.parseInt(scan.next());
					boardCells[i]=num;
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
		int i=0, j=0, x=1;
		if(board.value(i, j)== board.value(i, x)) {//compare 1st with 2nd then 3rd ......
			compare= true;
		}
		
		
		System.out.println(compare);
		System.out.println(Arrays.toString(boardCells));
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
	
	
}
