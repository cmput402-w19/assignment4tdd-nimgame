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
        return true;
    }

    public Board.player PredictWinner(int[] heap, Board.player currPlayer){
        int temp = 0;
        for (int i = 0; i < heap.length; ++i) {
            temp ^= heap[i];
        }
        if(temp != 0){
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
        int preXor = 0;
        for (int i = 0; i < preState.length; ++i) {
            preXor ^= preState[i];
        }
        int afterXor = 0;
        for (int i = 0; i < heap.length; ++i) {
            afterXor ^= heap[i];
        }

        if(afterXor == 0){
            return true;
        }
        if(preXor == 0){
            return true;
        }

        return false;
    }

    public int[] GetGoodMove(int[] testState1) {
        int[] newState;
        int temp = 0;
        for (int i = 0; i < testState1.length; ++i) {
            temp ^= testState1[i];
        }
        if(temp == 0){
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
                    temp = 0;
                    for (int k = 0; k < newState.length; ++k) {
                        temp ^= newState[k];
                    }
                    if(temp == 0) return newState;
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
