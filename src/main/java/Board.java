import exceptions.InvalidPickException;

public class Board {


    //fundmentally the game has to have three heaps and two fixed players
    // number of stones in each heap should be decided by user
    //there is no draw, but I want to predict the possible winner
    //I will wirte the member function and vars before test.
    public enum player {A, B, NONE};
    private int heap[];
    private int heaplen;
    private player currPlayer;
    private player winner;

    public Board(int[] heapArray){
        heaplen = heapArray.length;
        heap = heapArray;
        currPlayer = player.A;
    }

    public void PlayPick(int heapNum, int numOfStones) throws InvalidPickException {
        if(heapNum < 0)
            throw new InvalidPickException("Less than 0 input of number of heap!!");
        if(heapNum >= heaplen)
            throw new InvalidPickException("too big input of number of heap!!");
        if(numOfStones <= 0)
            throw new InvalidPickException("too small or minus picking stones!!");
        if(numOfStones > heap[heapNum])
            throw new InvalidPickException("too big picking stones!!");
        heap[heapNum] -= numOfStones;
    }

    public void print(){
        StringBuilder outputMsg = new StringBuilder();
        outputMsg.append("current heap state:   ");
        for(int i=0; i < heaplen;++i){
            outputMsg.append(heap[i]);
            outputMsg.append("   ");
        }
        System.out.println(outputMsg.toString());
        outputMsg = new StringBuilder();
        outputMsg.append("next player is: ");
        outputMsg.append(getCurrPlayer());
        System.out.println(outputMsg.toString());
    }

    public player getCurrPlayer() {return currPlayer;}

    public player getWinner(){return winner;}

    public int getNumAtHeap(int heapIndex){return heap[heapIndex];}

}
