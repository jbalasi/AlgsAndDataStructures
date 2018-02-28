import java.io.File;

//Jen Balasi
//CSC406
//A2P1

public class MainBalasi {
	
	public static void main (String [] args) {
		if(args.length == 0) {
			System.out.println("The file entered was not valid.");
			System.exit(1);
		}
		else {
			
			File file = new File(args[0]);
			SudokuToSatReducerBalasi sudBoard = new SudokuToSatReducerBalasi(file);
			sudBoard.createBoard(file);
			sudBoard.reduceBoard();
		}
	}
}
