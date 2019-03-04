import java.util.Scanner;



public class NIMgame {

	private Board board;
	private ScoreBoard scoreBoard;

	public NIMgame(){
		int[][] scores = new int[2][3];
		int[] heapArray = {2, 3, 4};

		board = new Board(heapArray);
		scoreBoard = new ScoreBoard(scores);
	}


	public void playGame(){
		int[] heapArray = {2, 3, 4};
		board = new Board(heapArray);
		Scanner keyboardScanner = new Scanner(System.in);

		while(!board.isGameOver()){
			board.print();

			String line = keyboardScanner.nextLine();
			String input[] = line.split(",");

			try {
                board.PlayPick(Integer.parseInt(input[0]), Integer.parseInt(input[1]));

            } catch (Exception InvalidPickException) {
                System.out.println("Invalid pick. Try again");
            }
			
		}

		if(board.getWinner() == Board.player.A) {
                scoreBoard.incrementNumOfWins(ScoreBoard.Player.A);
                scoreBoard.incrementNumOfLoses(ScoreBoard.Player.B);
        }
        if(board.getWinner() == Board.player.B) {
                scoreBoard.incrementNumOfWins(ScoreBoard.Player.A);
                scoreBoard.incrementNumOfLoses(ScoreBoard.Player.B);
        }

        System.out.println("Player " + board.getWinner() + " has won the game!");
        scoreBoard.print();
	}
	
	public void playGameMultiTime(){
        boolean stopGame = false;
        do{
            playGame();
            Scanner newscan = new Scanner(System.in);
            System.out.println("do you want to play again?\n"+"y for yes and n for no");
            String userInputForNextGame = newscan.nextLine();
            boolean accept = false;
            while(!accept){
                char inputchoice = userInputForNextGame.charAt(0);
                if(inputchoice == 'y'){
                    stopGame = false;
                    accept = true;
                }
                else if(inputchoice == 'n'){
                    scoreBoard.print();
                    stopGame = true;
                    accept = true;
                }
                else{
                    accept = false;
                    System.out.println("invalid input for play again or not, please try again.");
                    userInputForNextGame = newscan.nextLine();
                }
            }
        } while(!stopGame);
}

    public static void main(String args[]){
    	NIMgame nimGame = new NIMgame();
    	nimGame.playGameMultiTime();
    }
}

