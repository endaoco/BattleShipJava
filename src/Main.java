import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		
		Player player1 = new Player("Enda");		
		board player1Board = new board();
	
		ship ship5 = new ship(5);

		//String placemnet = placement.validPlacement();
		player1Board.placeShip(validPlacement(ship5, player1Board, player1), ship5.shipLength);
		//player1Board.changeBoard(player1.makeMove(), '<');
		player1Board.printBoard();
		
		//Place ships
		
		
				
	}
	
	public static String validPlacement(ship currentShip, board playerBoard, Player thePlayer) {
		
		Scanner scan = new Scanner(System.in);
		String orientation;
		boolean incorrectInput = true;
		boolean isHorizontal = false;
		boolean invalidPlacement = true;
		
		System.out.printf("Where would you like to place your battleship of length %d? \n", currentShip.shipLength);
		int placeShip = thePlayer.makeMove();
		
		System.out.print("Do you want to place your ship vertically(v) or horizontally(h):");
		orientation = scan.nextLine();
		
		while(incorrectInput) {
			if((orientation.charAt(0) != 'v' && orientation.charAt(0) != 'h') || orientation.length() > 1) {
				System.out.println("Incorrect input please enter either v for vertical or h for horizontal:");
				orientation = scan.nextLine();
	
			} else {
				incorrectInput = false;
			}
		}
		
		if( orientation.charAt(0) == 'h') {
			isHorizontal = true;
		} 
		
		while(invalidPlacement) {
			if(isHorizontal && ((placeShip / 10) + currentShip.shipLength) <= 10) {
				invalidPlacement = false;		
			} else if (!isHorizontal && ((placeShip % 10) - currentShip.shipLength) >= 0) {
				invalidPlacement = false;
			} else {
				System.out.println("The ship doesn't fit try again somewhere else, make move: ");
				placeShip = thePlayer.makeMove();
			}
		}
		
		System.out.print("placeShip:" + placeShip + "\n");
		String moveOrientation = Integer.toString(placeShip);
		System.out.print("move orientation:" + moveOrientation + "\n");
		if( orientation.charAt(0) == 'h') {

			moveOrientation += 'h';
		} else {
			moveOrientation += 'v';
		}

		return moveOrientation;
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
