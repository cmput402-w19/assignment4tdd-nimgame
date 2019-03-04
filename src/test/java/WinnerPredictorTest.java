import exceptions.InvalidPickException;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WinnerPredictorTest {

    private WinnerPredictor winnerPredictor;
    private WinnerPredictor winnerPredictorNull;

    @Before
    public void setup() {
        int[] testState1 = {0, 3, 2};
        Board.player A = Board.player.A;
        winnerPredictor = new WinnerPredictor(testState1, A);
        winnerPredictorNull = new WinnerPredictor();
    }

    @Test
    public void testInit(){
        assert (winnerPredictorNull.getPrePredictWinner() == null);
        assert (winnerPredictorNull.getPreState() == null);

        int[] testState1 = {0, 3, 2};
        assert (winnerPredictor.getPrePredictWinner().equals(Board.player.A));
        assert (Arrays.equals(winnerPredictor.getPreState(), testState1));
    }

    @Test
    public void testPredictWinner() throws InvalidPickException{
        int[] testState1 = {3, 4, 5};
        int[] testState2 = {1, 4, 5};
        Board playingBoard = mock(Board.class);
        when(playingBoard.getCurrPlayer()).thenReturn(Board.player.A);
        when(playingBoard.getHeap()).thenReturn(testState1).thenReturn(testState2);

        Board.player predictWinner = winnerPredictor.PredictWinner(playingBoard.getHeap(), playingBoard.getCurrPlayer());
        assert (predictWinner.equals(Board.player.A));

        predictWinner = winnerPredictor.PredictWinner(playingBoard.getHeap(), playingBoard.getCurrPlayer());
        assert (predictWinner.equals(Board.player.B));
    }

    @Test
    public void testGoodMoveChecker() throws InvalidPickException{
        // these are states after one move from [3,4,5]
        int[] testState1 = {2, 4, 5};
        int[] testState2 = {1, 4, 5};
        Board playingBoard = mock(Board.class);
        when(playingBoard.getCurrPlayer()).thenReturn(Board.player.B);
        when(playingBoard.getHeap()).thenReturn(testState1).thenReturn(testState2);

        assert (winnerPredictor.getPrePredictWinner().equals(Board.player.A));
        assert (!winnerPredictor.GoodMoveCheck(playingBoard.getHeap()));
        assert (winnerPredictor.GoodMoveCheck(playingBoard.getHeap()));

    }

    @Test
    public void testGetGoodMove() throws InvalidPickException{
        int[] testState1 = {0, 3, 2};
        int[] goalState = {0, 2, 2};

        assert (Arrays.equals(winnerPredictor.getPreState(), testState1));
        assert (Arrays.equals(winnerPredictor.GetGoodMove(testState1), goalState));
    }
}
