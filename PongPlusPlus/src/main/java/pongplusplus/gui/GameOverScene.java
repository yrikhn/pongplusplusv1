package pongplusplus.gui;


import javafx.scene.input.KeyCode;
import pongplusplus.common.BaseScene;
import pongplusplus.common.SceneType;
import pongplusplus.game.Images;
import pongplusplus.main.Navigator;

public class GameOverScene extends BaseScene {
    public GameOverScene(Navigator navigator) {
        super(navigator, Images.GAMEOVER_SCENE);
        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE){
                navigator.navigateTo(SceneType.INGAME);
            }
        });
    }
}
