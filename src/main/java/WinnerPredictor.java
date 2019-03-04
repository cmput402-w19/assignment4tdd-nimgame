public class WinnerPredictor {

    private Board.player prePredictWinner;
    private int[] preState;


    public WinnerPredictor(){

    }

    public Board.player PredictWinner(int[] heap, Board.player currPlayer){
        return Board.player.A;
    }

    public Board.player getPrePredictWinner() {
        return prePredictWinner;
    }

    public int[] getPreState() {
        return preState;
    }

    public void setPrePredictWinner() {

    }


    public boolean GoodMoveCheck(int[] heap) {
        return true;
    }
}
