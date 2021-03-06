package pongplusplus.gui;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import pongplusplus.common.BaseScene;
import pongplusplus.common.Initializable;
import pongplusplus.game.*;
import pongplusplus.common.Navigator;


public class GameOverScene extends BaseScene implements Initializable {

    private static Scene gameOverScene;
    private Text announcement = new Text("");
    private Score score;
    private GameSetting gameSetting;

    public GameOverScene(Navigator navigator, Score score, GameSetting gameSetting) {
        super(navigator);
        this.score = score;
        this.gameSetting = gameSetting;
    }

    @Override
    public void onInitialize() {
        ImageView backgroundImage = new ImageView();
        backgroundImage.setImage(Images.GAMEOVER_SCENE);
        announceWinner(announcement, score);
        announcement.setStyle(Const.TEXT_STYLE);
        announcement.setLayoutX(410);
        announcement.setLayoutY(355);
        Button restart = new Button("RESTART");
        restart.setLayoutX(298);
        restart.setLayoutY(425);
        Button exit = new Button("EXIT");
        exit.setLayoutX(568);
        exit.setLayoutY(425);
        Style.changeStyle(restart, 135, 75);
        Style.changeStyle(exit, 135, 75);
        Group root = new Group();
        gameOverScene = new Scene(root);
        root.getChildren().addAll(backgroundImage, announcement, restart, exit);
        restart.setOnAction(e -> {
            navigator.goTo(SceneType.GAMEMODE_SELECTION);
            gameSetting.resetSingleplayer();
            Sound.play(SoundEffectType.ONCLICK);
        });
        exit.setOnAction(e -> {
            Sound.play(SoundEffectType.ONCLICK);
            Platform.exit();
        });
    }

    public static void announceWinner(Text text, Score point) {
        if (point.isPlayerWon()) {
            text.setText("you have won^^");
        } else {
            text.setText("you have lost...");
        }
    }

    public static Scene getScene() {
        return gameOverScene;
    }
}

