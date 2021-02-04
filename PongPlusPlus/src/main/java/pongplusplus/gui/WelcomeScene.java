package pongplusplus.gui;

import javafx.scene.input.KeyCode;
import pongplusplus.common.BaseScene;
import pongplusplus.common.SceneType;
import pongplusplus.game.Images;
import pongplusplus.common.Navigator;

public class WelcomeScene extends BaseScene {
    public WelcomeScene(Navigator navigator) {
            super(navigator, Images.WELCOME_SCENE);
            setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.SPACE){
                    navigator.goTo(SceneType.INGAME);
                }
            });
        }
}