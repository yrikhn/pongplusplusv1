package pongplusplus.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pongplusplus.common.BaseScene;
import pongplusplus.common.Initializable;
import pongplusplus.common.Navigator;
import pongplusplus.game.Images;
import pongplusplus.game.SceneType;
import pongplusplus.game.Sound;
import pongplusplus.game.SoundFXType;

public class InfoScene extends BaseScene implements Initializable {
    private static Scene infoScene;

    public InfoScene(Navigator navigator){
        super(navigator);

    }



    @Override
    public void onInitialize() {
        ImageView backgroundImage = new ImageView();
        Image image = new Image(Images.INFO_SCENE);
        backgroundImage.setImage(image);
        Group root = new Group();
        infoScene = new Scene(root);
        Button returnButton = new Button("RETURN");
        returnButton.setLayoutX(433);
        returnButton.setLayoutY(475);
        Style.changeStyle(returnButton);

        root.getChildren().addAll(backgroundImage, returnButton);
        returnButton.setOnAction(e -> {navigator.goTo(SceneType.WELCOME); Sound.play(SoundFXType.ONCLICK); });
    }

    public static Scene getScene() {
        return infoScene;
    }
}
