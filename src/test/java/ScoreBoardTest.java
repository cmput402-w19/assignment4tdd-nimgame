import exceptions.InvalidPickException;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

public class ScoreBoardTest {
    private ScoreBoard scoreBoard;
  

    @Test
    public void testGetNumOfWins(){
        int[][] scores = new int[2][3];
        scores[0][0] = 1;
        scores[1][0] = 1;
        scoreBoard = new ScoreBoard(scores);

        assert(scoreBoard.getNumOfWins(ScoreBoard.Player.A) == 1);
        assert(scoreBoard.getNumOfWins(ScoreBoard.Player.B) == 1);
    }
}