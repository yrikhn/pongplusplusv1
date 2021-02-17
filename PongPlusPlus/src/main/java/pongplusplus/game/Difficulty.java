package pongplusplus.game;

import pongplusplus.common.Navigator;

public class Difficulty {
    private double difficulty;

    public void setDifficulty(double speed, Navigator navigator) {
        this.difficulty = speed;
        navigator.goTo(SceneType.INGAME);
    }


    public double getDifficulty() {
        return this.difficulty;
    }
}
