

public class ScoreBoard{

	public enum Player {A, B, NONE};
	private int[][] scoreBoard;

	public ScoreBoard(int[][] scoreBoard){
		this.scoreBoard = scoreBoard;
	}

	public void print(){
		System.out.println("\nScore:");
		System.out.println("Wins  (A, B): " + this.scoreBoard[0][0] + ", " + this.scoreBoard[1][0] + "; ");
		System.out.println("Loses (A, B): " + this.scoreBoard[0][1] + ", " + this.scoreBoard[1][1] + "; ");
		System.out.println("Draws (A, B): " + this.scoreBoard[0][2] + ", " + this.scoreBoard[1][2] + ";");
		System.out.println("\n");
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
		switch (player) {
			case A:
				return scoreBoard[0][2];
			case B:
				return scoreBoard[1][2];
			default:
				return 0;
		}
	}

	public void incrementNumOfWins(Player player){
		switch (player) {
			case A:
				scoreBoard[0][0] += 1;
				break;
			case B:
				scoreBoard[1][0] += 1;
				break;
		}
	}

	public void incrementNumOfLoses(Player player){
		switch (player) {
			case A:
				scoreBoard[0][1] += 1;
				break;
			case B:
				scoreBoard[1][1] += 1;
				break;
		}
	}

	public void incrementNumOfTies(Player player){
		switch (player) {
			case A:
				scoreBoard[0][2] += 1;
				break;
			case B:
				scoreBoard[1][2] += 1;
				break;
		}
	}

}