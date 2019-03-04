

public class ScoreBoard{

	public enum Player {A, B, NONE};
	private int[][] scoreBoard;

	public ScoreBoard(int[][] scoreBoard){
		this.scoreBoard = scoreBoard;
	}

	public int getNumOfWins(Player player){
		switch (player) {
			case A:
				return scoreBoard[0][0];
			case B:
				return scoreBoard[1][0];
			default:
				return 0;
		}
	}

	public int getNumOfLoses(Player player){
		switch (player) {
			case A:
				return scoreBoard[0][1];
			case B:
				return scoreBoard[1][1];
			default:
				return 0;
		}
	}


	public int getNumOfTies(Player player){
		if(player == Player.A){
			return scoreBoard[0][2];
		}
		else if(player == Player.B){
			return scoreBoard[1][2];
		}
		else{
			return 0;
		}
	}

	public void incrementNumOfWins(Player player){

	}

	public void incrementNumOfLoses(Player player){
		
	}

	public void incrementNumOfTies(Player player){
		
	}

}