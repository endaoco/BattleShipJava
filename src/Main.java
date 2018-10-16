import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		board player1Board = new board();
	
		player1Board.printBoard();
		
		//Place ships
		ship ship5 = new ship(5);
		/*ship ship4 = new ship(4);
		ship ship3_1 = new ship(3);
		ship ship3_2 = new ship(3);
		ship ship2 = new ship(2);*/
		
		ship5.placeShip(player1Board);
		player1Board.printBoard();
		
		
		
	}
	
	/*public static void placeShips(ship currentShip, board playerBoard) {
		
		boolean isVertical=false, correctInput=true;
		int row, column;
		
		String input;
		Scanner scan = new Scanner(System.in);
		
		
		
		while(correctInput) {
			
			System.out.printf("You are placing a battleship of length %d %n "
					+ "Would you like to place it horizontally or verticaly? (h for horizontal or v for verticaly):", currentShip.shipLength);
			input = scan.nextLine();
			
			char charInput = input.charAt(0);
			
			if(charInput == 'v') {
				isVertical = true;
				correctInput = false;
			}
			else if (charInput == 'h'){
				isVertical = false;
				correctInput = false;
			}
			else {
				System.out.println("Incorrect input");
			}
		}
		
		System.out.print("Now place your ship! Enter a number from 1-9");
		column = scan.nextInt();
		System.out.print("Enter a letter from A-I");
		char rowChar = scan.next().charAt(0);
		rowChar = Character.toLowerCase(rowChar);
		row = rowChar - 'b';
		
		if(isVertical && row > 6 ) {
			for(int i=currentShip.shipLength; i>1; i--) {
				playerBoard.board[column][i] = '^';
			}
		}
	}*/
	
	
}
