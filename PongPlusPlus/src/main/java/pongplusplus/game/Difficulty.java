package pongplusplus.game;

import pongplusplus.common.Navigator;
import pongplusplus.common.SceneType;

public class Difficulty {
    private static double difficulty;

    public static void setDifficulty(double speed, Navigator navigator) {
        difficulty = speed;
        navigator.goTo(SceneType.INGAME);
    }

    public static double getDifficulty() {
        return difficulty;
    }
}
