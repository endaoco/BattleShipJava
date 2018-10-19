import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		
		
		Player player1 = new Player("Enda");		
		board player1Board = new board();
		board player1OpponentBoard = new board();
		
		Player player2 = new Player("Clara");
		board player2Board = new board();
		board player2OpponentBoard = new board();
		
		boolean gameLoop = true;
		
		//Place ships
		
		int shipLength = 5;
		
		while(shipLength > 0) {
			player1Board.placeShip(validPlacement(shipLength, player1Board, player1), shipLength);
			player1Board.printBoard();
			shipLength--;
		}
		shipLength = 5;
		while(shipLength > 0) {
			player2Board.placeShip(validPlacement(shipLength, player2Board, player2), shipLength);
			player2Board.printBoard();
			shipLength--;
		}
		
		
		//Main game loop
		int player1Hits = 0;
		int player2Hits = 0;
		while(gameLoop) {
			boolean hit = true;
			int move;
			boolean player1Win = false;
			
				//Player 1's go
				System.out.printf("It is %s's go!", player1.name);
				while(hit) {
					player1OpponentBoard.printBoard();
					System.out.print("-------------------------------");
					player1Board.printBoard();
					
					move = player1.makeMove();
					if(player2Board.checkForShip(move)) {
						player1Hits++;
						System.out.print("It's a hit!\nGo again!");
						player1OpponentBoard.changeBoard(move, '+');
					} else if (!(player2Board.checkSpace((move/10), (move%10)))){
						System.out.print("Damn a miss!");
						player1OpponentBoard.changeBoard(move, 'x');
						hit = false;
					} else {
						System.out.print("Looks like we already hit there, Lets try again");
					}
					
					if(player1Hits == 15) {
						System.out.printf("Congradulations %s! You won!", player1.name);
						hit = false;
						gameLoop = false;
						player1Win = true;
					}
				}
				//Player 2's go
				if(!player1Win) {
					hit = true;
					System.out.printf("It is %s's go!", player2.name);
					while(hit) {
						player2OpponentBoard.printBoard();
						System.out.print("-------------------------------");
						player2Board.printBoard();
							
						move = player2.makeMove();
						if(player1Board.checkForShip(move)) {
							player2Hits++;
							System.out.print("It's a hit!\nGo again!");
							player2OpponentBoard.changeBoard(move, '+');
						} else if (!(player1Board.checkSpace((move/10), (move%10)))){
							System.out.print("Damn a miss!");
							player2OpponentBoard.changeBoard(move, 'x');
							hit = false;
						} else {
							System.out.print("Looks like we already hit there, Lets try again");
						}
							
						if(player2Hits == 15) {
							System.out.printf("Congradulations %s! You won!", player2.name);
							hit = false;
							gameLoop = false;
						}
					}
				}
			}
		}
		
		
		
		
		
		
		
				
	
	
	//Asks for the orientation adn validates that input, it also asks for placement of the ship
	//and then check given the orientation if it fits
	public static String validPlacement(int shipLength, board playerBoard, Player thePlayer) {
		
		Scanner scan = new Scanner(System.in);
		String orientation;
		boolean incorrectInput = true;
		boolean isHorizontal = false;
		boolean invalidPlacement = true;
		
		System.out.printf("Where would you like to place your battleship of length %d? \n", shipLength);
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
			if(isHorizontal && ((placeShip / 10) + shipLength) <= 10) {
				invalidPlacement = false;		
			} else if (!isHorizontal && ((placeShip % 10) - shipLength) >= 0) {
				invalidPlacement = false;
			} else {
				System.out.println("Oops make sure to place the ship on the board, try again: ");
				placeShip = thePlayer.makeMove();
			}
		}
		
		invalidPlacement = true;

		while(invalidPlacement) {
			 {
				int column = placeShip % 10;
				int row = placeShip / 10;
				boolean spaceFilled =false;
				
				if(isHorizontal){
					for(int i=0; i<shipLength; i++) {
						if(playerBoard.checkSpace(row, column)) {
							spaceFilled = true;
						}
						column++;
					}
				} else if(!isHorizontal) {
					for(int i=0; i<shipLength; i++) {
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

