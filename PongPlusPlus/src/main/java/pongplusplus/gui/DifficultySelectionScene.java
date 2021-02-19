package pongplusplus.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import pongplusplus.common.BaseScene;
import pongplusplus.common.Initializable;
import pongplusplus.common.Navigator;
import pongplusplus.game.*;

public class DifficultySelectionScene extends BaseScene implements Initializable {
    private static Scene welcomeScene;
    private GameSetting gameSetting;

    public DifficultySelectionScene(Navigator navigator, GameSetting gameSetting) {
        super(navigator);
        this.gameSetting = gameSetting;
    }

    @Override
    public void onInitialize() {
        ImageView backgroundImage = new ImageView();
        backgroundImage.setImage(Images.DIFFICULTY_SELECTION_SCENE);
        Button easy = new Button("EASY");
        easy.setOnAction(e -> {
            gameSetting.setDifficulty(3, navigator);
            Sound.play(SoundEffectType.ONCLICK);
        });
        easy.setLayoutX(201);
        easy.setLayoutY(425);
        Button medium = new Button("MEDIUM");
        medium.setOnAction(e -> {
            gameSetting.setDifficulty(4.5, navigator);
            Sound.play(SoundEffectType.ONCLICK);
        });
        medium.setLayoutX(433);
        medium.setLayoutY(425);
        Button hard = new Button("HARD");
        hard.setOnAction(e -> {
            gameSetting.setDifficulty(6, navigator);
            Sound.play(SoundEffectType.ONCLICK);
        });
        hard.setLayoutX(665);
        hard.setLayoutY(425);

        Button info = new Button("INFO");
        info.setOnAction(e -> {
            navigator.goTo(SceneType.INFO);
            Sound.play(SoundEffectType.ONCLICK);
        });
        info.setLayoutX(20);
        info.setLayoutY(20);
        Style.changeStyle(easy, 135, 75);
        Style.changeStyle(medium, 135, 75);
        Style.changeStyle(hard,135,75);
        Style.changeStyle(info, 95, 50);
        Group root = new Group();
        welcomeScene = new Scene(root);
        root.getChildren().addAll(backgroundImage, easy, medium, hard, info);
    }

    public static Scene getScene() {
        return welcomeScene;
    }


}
