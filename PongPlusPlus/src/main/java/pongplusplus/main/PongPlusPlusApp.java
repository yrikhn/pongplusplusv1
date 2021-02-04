package pongplusplus.main;

import javafx.application.Application;
import javafx.stage.Stage;
import pongplusplus.common.Navigator;
import pongplusplus.common.SceneType;
import pongplusplus.gui.GameOverScene;
import pongplusplus.gui.InGameScene;
import pongplusplus.gui.WelcomeScene;

public class PongPlusPlusApp extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("PONG++");

        Navigator navigator = new Navigator(stage);
        navigator.registerScene(SceneType.WELCOME, new WelcomeScene(navigator));
        navigator.registerScene(SceneType.INGAME, new InGameScene(navigator));
        navigator.registerScene(SceneType.GAMEOVER, new GameOverScene(navigator));
        navigator.goTo(SceneType.WELCOME);
        stage.setMinHeight(400);
        stage.setMaxHeight(400);
        stage.setMinWidth(700);
        stage.setMaxWidth(700);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
