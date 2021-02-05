package pongplusplus.game;

public class Points {
    public int gegnerPoints = 9;
    public int playerPoints;
    public boolean playerWon = false;
    public boolean gegnerWon = false;

    public void addPlayerPoints() {
        playerPoints += 1;
    }

    public void addGegnerPoints() {
        gegnerPoints += 1;
    }

    public void checkWon() {
        if (playerPoints == 10) {
            playerWon = true;
        }

        if (gegnerPoints == 10) {
            gegnerWon = true;
        }
    }
}
