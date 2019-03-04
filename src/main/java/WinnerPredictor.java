public class WinnerPredictor {

    private Board.player prePredictWinner;
    private int[] preState;


    public WinnerPredictor(){

    }

    public WinnerPredictor(int[] testState1, Board.player a) {
        preState = testState1;
        prePredictWinner = PredictWinner(testState1, a);
    }

    public boolean checkState(int[] state){
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
        if(checkState(testState1)){
            newState = new int[testState1.length];
            for (int j=1 ;j < testState1.length ;++j){
                newState[j] = testState1[j];
            }
            newState[0] -= 1;
        }
        else{
            newState = new int[testState1.length];
            for (int j=1 ;j < testState1.length ;++j){
                newState[j] = testState1[j];
            }
            for (int i=0 ;i<testState1.length; ++i){

                //deep copy
                newState = new int[testState1.length];
                for (int j=1 ;j < testState1.length ;++j){
                    newState[j] = testState1[j];
                }

                for (int j=1 ;j < testState1[i];++j){
                    newState[i] = testState1[i]-j;
                    if(checkState(newState)) return newState;
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

}
