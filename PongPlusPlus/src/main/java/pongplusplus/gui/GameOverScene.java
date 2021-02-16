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
import pongplusplus.common.Initializable;
import pongplusplus.common.SceneType;
import pongplusplus.game.Images;
import pongplusplus.common.Navigator;
import pongplusplus.game.Points;


public class GameOverScene extends BaseScene implements Initializable{

    private static Scene gameOverScene;
    private Text announcement = new Text("");
    private Points points;

    public GameOverScene(Navigator navigator, Points points) {
        super(navigator, Images.GAMEOVER_SCENE);
        this.points = points;


    }


    @Override
    public void onInitialize() {
        announceWinner(announcement, points);
        points.resetPoint();
        Button restart = new Button("RESTART GAME");
        Button exit = new Button("EXIT GAME");

        VBox vbox = new VBox();
        vbox.setPrefSize(1000, 600);
        gameOverScene = new Scene(vbox);

        vbox.getChildren().addAll(restart,exit, announcement);
        restart.setOnAction(e -> navigator.goTo(SceneType.WELCOME));
        exit.setOnAction(e -> Platform.exit());
    }


    public static void announceWinner(Text text, Points point){
        if (point.isPlayerWon()) {
            text.setText("you have won");
        }else{
            text.setText("you have lost");
        }
    }

    public static Scene getScene() {
        return gameOverScene;
    }
}

