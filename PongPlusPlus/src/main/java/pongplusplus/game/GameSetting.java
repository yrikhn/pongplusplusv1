package pongplusplus.game;

import pongplusplus.common.Navigator;

public class GameSetting {
    private double difficulty;
    private boolean singleplayer;
    private boolean gamemodeSelected;

    public void setDifficulty(double speed, Navigator navigator) {
        this.difficulty = speed;
        navigator.goTo(SceneType.INGAME);
    }

    public double getDifficulty() {
        return this.difficulty;
    }

    public void setSingleplayer(boolean value) {
        this.singleplayer = value;
        this.gamemodeSelected = true;
    }
    public void resetSingleplayer(){
        this.singleplayer = false;
        this.gamemodeSelected = false;
    }

    public boolean isSingleplayer() {
        return singleplayer;
    }

    public boolean isGamemodeSelected() {
        return gamemodeSelected;
    }
}
