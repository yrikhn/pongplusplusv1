package pongplusplus.gui;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pongplusplus.common.BaseScene;
import pongplusplus.common.SceneType;
import pongplusplus.game.Images;
import pongplusplus.common.Navigator;
import pongplusplus.game.Points;


public class GameOverScene extends BaseScene {
    private static Scene gameOverScene;
    private Points point = new Points();
    private Text announcement = new Text("Hallo");

    public GameOverScene(Navigator navigator) {
        super(navigator, Images.GAMEOVER_SCENE);



        announcement.setText("Test");


        Button restart = new Button("RESTART GAME");
        Button exit = new Button("EXIT GAME");

        VBox vbox = new VBox();
        vbox.setPrefSize(1000, 600);// prefWidth, prefHeight
        gameOverScene = new Scene(vbox);

        vbox.getChildren().addAll(restart,exit, announcement);
        restart.setOnAction(e -> navigator.goTo(SceneType.WELCOME));
        exit.setOnAction(e -> Platform.exit());

    }

    public static Scene getScene() {
        return gameOverScene;
    }
}

