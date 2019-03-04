public class WinnerPredictor {

    private Board.player prePredictWinner;
    private int[] preState;


    public WinnerPredictor(){

    }

    public WinnerPredictor(int[] testState1, Board.player a) {
        preState = testState1;
        prePredictWinner = PredictWinner(testState1, a);
    }

    private boolean checkState(int[] state){
        int temp = 0;
        for (int i = 0; i < state.length; ++i) {
            temp ^= state[i];
        }
        if(temp == 0) return true;
        return false;
    }

    public Board.player PredictWinner(int[] heap, Board.player currPlayer){
        if(!checkState(heap)){
            return currPlayer;
        }
        else{
            if(currPlayer.equals(Board.player.A)){
                return Board.player.B;
            }
            else{
                return Board.player.A;
            }
        }
    }

    public boolean GoodMoveCheck(int[] heap) {

        if(checkState(heap)){
            return true;
        }
        if(checkState(preState)){
            return true;
        }

        return false;
    }

    public int[] GetGoodMove(int[] testState1) {
        int[] newState;
        newState = new int[testState1.length];
        for (int j=1 ;j < testState1.length ;++j){
            newState[j] = testState1[j];
        }
        if(checkState(testState1)){
            //deep copy and -1 for the first one.
            newState[0] -= 1;
        }
        else{
            for (int i = 0 ; i < testState1.length ; ++i){
                for (int j = 1 ;j <= testState1[i];++j){
                    newState[i] = testState1[i]-j;
                    if(checkState(newState)) return newState;
                    else newState[i] = testState1[i];
                }
            }
        }

        return newState;
    }

    public Board.player getPrePredictWinner() {
        return prePredictWinner;
    }

    public int[] getPreState() {
        return preState;
    }

    public void setPrePredictWinner(Board.player a) {
        prePredictWinner = a;
    }
    public void setPreState(int[] state) {
        preState = state;
    }



}
