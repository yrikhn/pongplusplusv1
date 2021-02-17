package pongplusplus.main;

import javafx.application.Application;
import javafx.stage.Stage;
import pongplusplus.common.Navigator;
import pongplusplus.common.SceneType;
import pongplusplus.game.Const;
import pongplusplus.game.Difficulty;
import pongplusplus.game.Score;
import pongplusplus.gui.GameOverScene;
import pongplusplus.gui.InGameScene;
import pongplusplus.gui.WelcomeScene;

public class  PongPlusPlusApp extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("PONG++");

        Navigator navigator = new Navigator(stage);
        Score score = new Score();
        Difficulty difficulty = new Difficulty();

        navigator.registerScene(SceneType.WELCOME, new WelcomeScene(navigator, difficulty));
        navigator.registerScene(SceneType.INGAME, new InGameScene(navigator, score, difficulty));
        navigator.registerScene(SceneType.GAMEOVER, new GameOverScene(navigator, score));
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
