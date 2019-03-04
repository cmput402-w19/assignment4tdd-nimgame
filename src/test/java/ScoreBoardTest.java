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
        scores[1][0] = 2;
        scoreBoard = new ScoreBoard(scores);

        assert(scoreBoard.getNumOfWins(ScoreBoard.Player.A) == 1);
        assert(scoreBoard.getNumOfWins(ScoreBoard.Player.B) == 2);
        assert(scoreBoard.getNumOfLoses(ScoreBoard.Player.NONE) == 0);
    }

    @Test
    public void testGetNumOfLoses(){
        int[][] scores = new int[2][3];
        scores[0][1] = 1;
        scores[1][1] = 2;
        scoreBoard = new ScoreBoard(scores);

        assert(scoreBoard.getNumOfLoses(ScoreBoard.Player.A) == 1);
        assert(scoreBoard.getNumOfLoses(ScoreBoard.Player.B) == 2);
        assert(scoreBoard.getNumOfLoses(ScoreBoard.Player.NONE) == 0);
    }

    @Test
    public void testGetNumOfTies(){
        int[][] scores = new int[2][3];
        scores[0][2] = 1;
        scores[1][2] = 2;
        scoreBoard = new ScoreBoard(scores);

        assert(scoreBoard.getNumOfLoses(ScoreBoard.Player.A) == 1);
        assert(scoreBoard.getNumOfLoses(ScoreBoard.Player.B) == 2);
        assert(scoreBoard.getNumOfLoses(ScoreBoard.Player.NONE) == 0);
    }
}
