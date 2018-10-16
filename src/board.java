
public class board {
	
	public static char[][] board = new char[10][10];
	
	public board(){
		
		//Board Intialisation 
		
		char letters = 'A';
		char numbers = '1';
				
		for(int i =1; i<10; i++) {
			board[i][0] = letters++;
			board[0][i] = numbers++;
			for(int j=1; j<10; j++) {
				board[i][j] = '~';
			}
		}
	}
	
	public static void printBoard() {
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				System.out.printf(" %c ", board[i][j]);
			}
			System.out.print("\n");
		}
	}
	
}
