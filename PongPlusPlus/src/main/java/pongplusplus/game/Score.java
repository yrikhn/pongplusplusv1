package pongplusplus.game;

public class Score {
    private int enemyScore = 9;
    private int playerScore;
    private boolean playerWon = false;
    private boolean enemyWon = false;

    public void addPlayerPoints() {
        playerScore += 1;
    }

    public void addGegnerPoints() {
        enemyScore += 1;
    }

    public void checkWon() {
        if (playerScore == 10) {
            playerWon = true;
        }

        if (enemyScore == 10) {
            enemyWon = true;
        }
    }

    public void resetScore() {
        playerScore = 0;
        enemyScore = 0;
        playerWon = false;
        enemyWon = false;
    }

    public boolean isPlayerWon() {
        return playerWon;
    }

    public boolean isEnemyWon() {
        return enemyWon;
    }

    public int getEnemyScore() {
        return enemyScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }
}
