
public class board {
	
	private char[][] board = new char[10][10];
	
	public board(){
		
		//board Intialisation 
		
		char letters = 'A';
		char numbers = '1';
		board[0][0] = ' ';		
		for(int i =1; i<10; i++) {
			board[i][0] = letters++;
			board[0][i] = numbers++;
			for(int j=1; j<10; j++) {
				board[i][j] = '~';
			}
		}
	}
	
	//Prints the current board
	public void printBoard() {
		System.out.println("");
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				System.out.printf(" %c ", board[i][j]);
			}
			System.out.print("\n");
		}
	}
	//Method to change a given index on the board
	public void changeBoard(int move, char symbol) {
		int column = move / 10;	
		int row = move % 10;

		board[row][column] = symbol;
	}
	
	//changes the board to represent the ships
	public void placeShip(String move, int shipLength) {
		System.out.print("move: " +move);
		int column = move.charAt(0) - '0' ;
		int row = move.charAt(1) - '0';

		if(move.charAt(2) == 'h') {
			for(int i=0; i<shipLength; i++) {
				board[row][column] = '>';
				column++;
			}
		} else {
			for(int i=0; i<shipLength; i++) {
				board[row][column] = '^';
				row--;
			}
		}
	}
	
	public boolean checkSpace(int col, int row) {
		if(board[row][col] == '~') {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean checkForShip(int move) {
		int col;
		int row;
		col = move / 10;
		row = move % 10;
		if(board[row][col] == '>' || board[row][col] == '^' ) {
			return true;
		} else {
			return false;
		}
	}
}
