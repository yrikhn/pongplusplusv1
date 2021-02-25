package pongplusplus.game;

public class Score {
    private int enemyScore;
    private int playerScore;
    private boolean playerWon = false;
    private boolean enemyWon = false;

    public void addPlayerPoints() {
        playerScore++;
    }

    public void addGegnerPoints() {
        enemyScore++;
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

    public void removeEnemyPoint() {
        enemyScore--;
    }

    public void addEnemyPoint() {
        enemyScore++;
    }

    public void removePlayerPoint() {
        playerScore--;
    }

    public void addPlayerPoint() {
        playerScore++;
    }

}
