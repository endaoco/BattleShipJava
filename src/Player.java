import java.util.Scanner;

public class Player {
	
	private String name;
	Scanner scan = new Scanner(System.in);

	public Player(String mName) {
		name = mName;
	}
	
	//Asks for input and verifies the input fits the parameters and returns it as a string
	public int makeMove() {
		
		String move = "";
		boolean incorrectInput = true;
		int row = 0;
		int col = 0;
		
			System.out.print("Enter column number followed by row (in the form 2b):");
			move = scan.nextLine();
			while(incorrectInput) {			
				if(move.charAt(0) < '0' || move.charAt(0) > '9' || move.charAt(1) < 'a'  || move.charAt(1) > 'i' ) {
					System.out.print("Incorrect input, please enter a number from 1-9 follwed by a lowercase letter from a-i \nPlease enter new move:");
					move = scan.nextLine();
				}else {
					incorrectInput = false;
				}
		}
		col = (move.charAt(0) - '0');
		col = (col) * 10;
		row = (move.charAt(1) - 'a');
		row++;

		return col+row;
	}
}
