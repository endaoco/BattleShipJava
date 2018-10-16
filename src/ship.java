
public class ship {
	
	int shipLength;
	int hits;
	
	public ship(int mshipLength){
		shipLength = mshipLength;
		hits = mshipLength;
	}
	
	public static void placeShip(board playerBoard){
		for(int i=6; i>1; i--) {
			playerBoard.board[3][i] = '^';
		}
	}
	
}
