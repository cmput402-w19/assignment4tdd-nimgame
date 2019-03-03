public class Board {

    //fundmentally the game has to have three heaps and two fixed players
    // number of stones in each heap should be decided by user
    //there is no draw, but I want to predict the possible winner
    //I will wirte the member function and vars before test.
    public enum player {A, B, NONE};
    private int heap[];
    private player currPlayer;

    public Board(int[] heapArray){

    }

    public void PlayPick(int heapNum, int numOfStones){

    }

    public void print(){

    }

    public player getCurrPlayer() {return currPlayer;}

    public player getWinner(){return player.NONE;}

    public int getNumAtHeap(int heapIndex){return 0;}

}
