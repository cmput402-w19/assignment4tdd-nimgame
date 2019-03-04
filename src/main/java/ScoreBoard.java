

public class ScoreBoard{

	public enum Player {A, B};
	private int[][] scoreBoard;

	public ScoreBoard(){
		scoreBoard = new int[2][3];
	}

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
		if (player == Player.A){
			return scoreBoard[0][1];
		}
		else if (player == Player.B){
			return scoreBoard[1][1];
		}
		else{
			return 0;
		}
	}


	public int getNumOfTies(Player player){
		return -1;
	}

	public void incrementNumOfWins(Player player){

	}

	public void incrementNumOfLoses(Player player){
		
	}

	public void incrementNumOfTies(Player player){
		
	}

}