package pongplusplus.main;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pongplusplus.common.Navigator;
import pongplusplus.common.SceneType;
import pongplusplus.game.Const;
import pongplusplus.game.Difficulty;
import pongplusplus.game.Points;
import pongplusplus.gui.GameOverScene;
import pongplusplus.gui.InGameScene;
import pongplusplus.gui.WelcomeScene;

public class  PongPlusPlusApp extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("PONG++");

        Navigator navigator = new Navigator(stage);
        Points points = new Points();
        Difficulty difficulty = new Difficulty();

        navigator.registerScene(SceneType.WELCOME, new WelcomeScene(navigator, difficulty));
        navigator.registerScene(SceneType.INGAME, new InGameScene(navigator, points, difficulty));
        navigator.registerScene(SceneType.GAMEOVER, new GameOverScene(navigator,points));
        navigator.goTo(SceneType.WELCOME);
        stage.setMinHeight(Const.SCREEN_HEIGHT);
        stage.setMaxHeight(Const.SCREEN_HEIGHT);
        stage.setMinWidth(Const.SCREEN_WIDTH);
        stage.setMaxWidth(Const.SCREEN_WIDTH);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
