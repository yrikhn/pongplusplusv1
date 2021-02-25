package pongplusplus.main;

import javafx.application.Application;
import javafx.stage.Stage;
import pongplusplus.common.Navigator;
import pongplusplus.game.SceneType;
import pongplusplus.game.Const;
import pongplusplus.game.GameSetting;
import pongplusplus.game.Score;
import pongplusplus.gui.*;
import javax.swing.*;

public class PongPlusPlusApp extends Application {
    @Override
    public void start(Stage stage) {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            // TODO: Logging
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Something goes wrong!");
        });
        stage.setTitle("PONG++");
        Navigator navigator = new Navigator(stage);
        Score score = new Score();
        GameSetting gameSetting = new GameSetting();
        navigator.registerScene(SceneType.DIFFICULTY_SELECTION, new DifficultySelectionScene(navigator, gameSetting));
        navigator.registerScene(SceneType.GAMEMODE_SELECTION, new GamemodeSelectionScene(navigator, gameSetting));
        navigator.registerScene(SceneType.INGAME, new InGameScene(navigator, score, gameSetting));
        navigator.registerScene(SceneType.GAMEOVER, new GameOverScene(navigator, score, gameSetting));
        navigator.registerScene(SceneType.INFO, new InfoScene(navigator, gameSetting));
        navigator.goTo(SceneType.GAMEMODE_SELECTION);
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
