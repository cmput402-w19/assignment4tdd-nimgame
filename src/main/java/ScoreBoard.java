

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
		if (player == Player.A){
			return scoreBoard[0][0];
		} 
		else if (player == Player.B){
			return scoreBoard[1][0];

		} else{
			return 0;
		}
	}

	public int getNumOfLoses(Player player){
		return -1;
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