package pongplusplus.game;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class ScoreTest {
    @Test
    public void checkWonPlayerWonTest(){
        Score score = new Score();
        score.setPlayerScore(10);
        score.checkWon();
        Assertions.assertTrue(score.isPlayerWon());
    }

    @Test
    public void checkWonEnemyWonTest(){
        Score score = new Score();
        score.setEnemyScore(10);
        score.checkWon();
        Assertions.assertTrue(score.isEnemyWon());
    }

    @Test
    public void checkWonPlayerNotWonTest(){
        Score score = new Score();
        score.setEnemyScore(6);
        score.checkWon();
        Assertions.assertFalse(score.isPlayerWon());
    }

    @Test
    public void checkWonEnemyNotWonTest(){
        Score score = new Score();
        score.setEnemyScore(5);
        score.checkWon();
        Assertions.assertFalse(score.isEnemyWon());
    }

    @Test
    public void resetScoreTest(){
        Score score = new Score();
        score.setEnemyScore(5);
        score.setPlayerScore(2);
        score.resetScore();
        Assertions.assertEquals(0, score.getPlayerScore());
    }

}
