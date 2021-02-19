package pongplusplus.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import pongplusplus.common.BaseScene;
import pongplusplus.common.Initializable;
import pongplusplus.common.Navigator;
import pongplusplus.game.*;

public class GamemodeSelectionScene extends BaseScene implements Initializable {
    private static Scene gamemodeSelectionScene;
    private GameSetting gameSetting;

    public GamemodeSelectionScene(Navigator navigator, GameSetting gameSetting) {
        super(navigator);
        this.gameSetting = gameSetting;
    }

    @Override
    public void onInitialize() {
        ImageView backgroundImage = new ImageView();
        backgroundImage.setImage(Images.GAMEMODE_SELECTION_SCENE);
        Group root = new Group();
        gamemodeSelectionScene = new Scene(root);
        Button singleplayerBtn = new Button("SINGLEPLAYER");
        singleplayerBtn.setLayoutX(250);
        singleplayerBtn.setLayoutY(425);
        Button multiplayerBtn = new Button("MULTIPLAYER");
        multiplayerBtn.setLayoutX(550);
        multiplayerBtn.setLayoutY(425);
        Button info = new Button("INFO");
        info.setLayoutX(20);
        info.setLayoutY(20);
        Style.changeStyle(singleplayerBtn, 200, 75);
        Style.changeStyle(multiplayerBtn,200, 75);
        Style.changeStyle(info, 95, 50);
        root.getChildren().addAll(backgroundImage, singleplayerBtn, multiplayerBtn, info);
        singleplayerBtn.setOnAction(e -> {
            gameSetting.setSingleplayer(true);
            navigator.goTo(SceneType.DIFFICULTY_SELECTION);
            Sound.play(SoundEffectType.ONCLICK);

        });
        multiplayerBtn.setOnAction(e -> {
            navigator.goTo(SceneType.DIFFICULTY_SELECTION);
            Sound.play(SoundEffectType.ONCLICK);
        });
        info.setOnAction(e -> {
            navigator.goTo(SceneType.INFO);
            Sound.play(SoundEffectType.ONCLICK);
        });
    }

    public static Scene getScene() {
        return gamemodeSelectionScene;
    }
}
