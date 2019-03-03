import exceptions.InvalidPickException;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private Board board;

    @Before
    public void setup() {
        int a[] = new int [3];
        a[0] = 3; a[1] = 4; a[2] = 5;
        board = new Board(a);
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
    public void testPlayPick() throws InvalidPickException {
        assert(board.getNumAtHeap(1) == 4);
        board.PlayPick(1, 2);
        assert(board.getNumAtHeap(1) == 2);

        assert(board.getNumAtHeap(0) == 3);
        assert(board.getNumAtHeap(2) == 5);
    }

    @Test(expected = InvalidPickException.class)
    public void testZeroPick() throws InvalidPickException{
        board.PlayPick(1, 0);
    }

    @Test(expected = InvalidPickException.class)
    public void testAdd() throws InvalidPickException{
        board.PlayPick(1, -1);
    }

    @Test(expected = InvalidPickException.class)
    public void testTooBigPick() throws InvalidPickException{
        assert (board.getNumAtHeap(1) == 4);
        board.PlayPick(1, 5);
    }

    @Test(expected = InvalidPickException.class)
    public void testNegHeapIndex() throws InvalidPickException{
        board.PlayPick(-1, 2);
    }

    @Test(expected = InvalidPickException.class)
    public void testTooBigHeapIndex() throws InvalidPickException{
        board.PlayPick(3, 2);
    }

    @Test
    public void printTest() throws InvalidPickException{
        board.print();
    }

}
