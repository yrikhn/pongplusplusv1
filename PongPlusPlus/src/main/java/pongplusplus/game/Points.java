package pongplusplus.game;

public class Points {
    private int gegnerPoints;
    private int playerPoints;
    private boolean playerWon = false;
    private boolean gegnerWon = false;

    public void addPlayerPoints() {
        playerPoints += 1;
    }

    public void addGegnerPoints() {
        gegnerPoints += 1;
    }

    public void checkWon() {
        if (playerPoints == 2) {
            playerWon = true;
        }

        if (gegnerPoints == 2) {
            gegnerWon = true;
        }
    }

    public void resetPoint() {
        playerPoints = 0;
        gegnerPoints = 0;
        playerWon = false;
        gegnerWon = false;
    }

    public boolean isPlayerWon() {
        return playerWon;
    }

    public boolean isGegnerWon() {
        return gegnerWon;
    }

    public int getGegnerPoints() {
        return gegnerPoints;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }
}
