import org.junit.Before;
import org.junit.Test;

public class Boardtest {
    private Board board;

    @Before
    public void setup() {
        board = new Board(3, 4, 5);
    }

    @Test
    public void testInit() {
        for (int i = 0; i < 3; i++) {
                assert (board.getNumAtHeap(i) >= 0);
        }

        assert (board.getCurrPlayer().equals(Board.player.A));
        assert (board.getWinner() == null);
    }

    @Test
    public void testPlayPick() {
        assert(board.getNumAtHeap(1) == 4);
        board.PlayPick(1, 2);
        assert(board.getNumAtHeap(1) == 2);

        assert(board.getNumAtHeap(0) == 3);
        assert(board.getNumAtHeap(2) == 5);
    }

}
