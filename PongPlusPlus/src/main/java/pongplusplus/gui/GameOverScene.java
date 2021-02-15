package pongplusplus.gui;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import pongplusplus.common.BaseScene;
import pongplusplus.common.SceneType;
import pongplusplus.game.Images;
import pongplusplus.common.Navigator;


public class GameOverScene extends BaseScene {
    private static Scene gameOverScene;

    public GameOverScene(Navigator navigator) {
        super(navigator, Images.GAMEOVER_SCENE);
        Button restart = new Button("RESTART GAME");
        Button exit = new Button("EXIT GAME");
        VBox vbox = new VBox();
        gameOverScene = new Scene(vbox);
        vbox.getChildren().addAll(restart,exit);
        restart.setOnAction(e -> navigator.goTo(SceneType.WELCOME));
        exit.setOnAction(e -> Platform.exit());

    }

    public static Scene getScene() {
        return gameOverScene;
    }
}

