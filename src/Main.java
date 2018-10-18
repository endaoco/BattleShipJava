import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		
		Player player1 = new Player("Enda");		
		board player1Board = new board();
	
		//int col =2, row=2;
		//System.out.print(player1Board.checkSpace(col, row));
		
		ship ship5 = new ship(5);
		ship ship4 = new ship(4);
		ship ship3 = new ship(3);
		ship ship2 = new ship(2);
		ship ship1 = new ship(1);

		//String placemnet = placement.validPlacement();
		player1Board.placeShip(validPlacement(ship5, player1Board, player1), ship5.shipLength);
		player1Board.printBoard();
		player1Board.placeShip(validPlacement(ship4, player1Board, player1), ship4.shipLength);
		player1Board.printBoard();
		player1Board.placeShip(validPlacement(ship3, player1Board, player1), ship3.shipLength);
		player1Board.printBoard();
		player1Board.placeShip(validPlacement(ship2, player1Board, player1), ship2.shipLength);
		player1Board.printBoard();
		player1Board.placeShip(validPlacement(ship1, player1Board, player1), ship1.shipLength);
		player1Board.printBoard();
		//player1Board.changeBoard(player1.makeMove(), '<');
		
		
		//Place ships
		
		
				
	}
	
	//Asks for the orientation adn validates that input, it also asks for placement of the ship
	//and then check given the orientation if it fits
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
				System.out.println("Oops make sure to place the ship on the board, try again: ");
				placeShip = thePlayer.makeMove();
			}
		}
		
		invalidPlacement = true;
		boolean checkRow = true;
		while(invalidPlacement) {
			 {
				int column = placeShip / 10;
				int row = placeShip % 10;
				boolean spaceFilled =false;
				
				if(isHorizontal){
					for(int i=0; i<currentShip.shipLength; i++) {
						if(playerBoard.checkSpace(row, column)) {
							spaceFilled = true;
						}
						column++;
					}
				} else if(!isHorizontal) {
					for(int i=0; i<currentShip.shipLength; i++) {
						if(playerBoard.checkSpace(row, column)) {
							spaceFilled = true;
						}
						row--;
					}
				}
				
				if(spaceFilled) {
					System.out.println("Looks like theres a ship in the way, try again: ");
					placeShip = thePlayer.makeMove();
				}
				else {
					invalidPlacement = false;
				}	 
			}
		}
		
		String moveOrientation = Integer.toString(placeShip);

		if( orientation.charAt(0) == 'h') {

			moveOrientation += 'h';
		} else {
			moveOrientation += 'v';
		}

		return moveOrientation;
	}	
}

