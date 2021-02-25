package pongplusplus.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import pongplusplus.common.BaseScene;
import pongplusplus.common.Initializable;
import pongplusplus.common.Navigator;
import pongplusplus.game.*;

public class InfoScene extends BaseScene implements Initializable {
    private static Scene infoScene;
    private GameSetting gameSetting;

    public InfoScene(Navigator navigator, GameSetting gameSetting) {
        super(navigator);
        this.gameSetting = gameSetting;
    }

    @Override
    public void onInitialize() {
        ImageView backgroundImage = new ImageView();
        backgroundImage.setImage(Images.INFO_SCENE);
        Group root = new Group();
        infoScene = new Scene(root);
        Button returnButton = new Button("RETURN");
        returnButton.setLayoutX(433);
        returnButton.setLayoutY(475);
        Style.changeStyle(returnButton, 135, 75);
        root.getChildren().addAll(backgroundImage, returnButton);
        returnButton.setOnAction(e -> {
            if (gameSetting.isGamemodeSelected()) {
                navigator.goTo(SceneType.DIFFICULTY_SELECTION);
                Sound.play(SoundEffectType.ONCLICK);
            } else {
                navigator.goTo(SceneType.GAMEMODE_SELECTION);
                Sound.play(SoundEffectType.ONCLICK);
            }
        });
    }

    public static Scene getScene() {
        return infoScene;
    }
}
