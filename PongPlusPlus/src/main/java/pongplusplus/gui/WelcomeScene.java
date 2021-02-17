package pongplusplus.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pongplusplus.common.BaseScene;
import pongplusplus.common.Initializable;
import pongplusplus.common.Navigator;
import pongplusplus.game.Difficulty;
import pongplusplus.game.Images;
import pongplusplus.game.Sound;
import pongplusplus.game.SoundFXType;

public class WelcomeScene extends BaseScene implements Initializable{
    private static Scene welcomeScene;
    Difficulty difficulty;

    public WelcomeScene(Navigator navigator, Difficulty difficulty) {
        super(navigator);
        this.difficulty = difficulty;
    }

    @Override
    public void onInitialize() {
        ImageView backgroundImage = new ImageView();
        Image image = new Image(Images.WELCOME_SCENE);
        backgroundImage.setImage(image);

        Button easy = new Button("EASY");
        easy.setOnAction(e -> { difficulty.setDifficulty(3, navigator);Sound.play(SoundFXType.ONCLICK); });
        easy.setLayoutX(201);
        easy.setLayoutY(425);

        Button medium = new Button("MEDIUM");
        medium.setOnAction(e -> {difficulty.setDifficulty(4.5, navigator);Sound.play(SoundFXType.ONCLICK); });
        medium.setLayoutX(433);
        medium.setLayoutY(425);

        Button hard = new Button("HARD");
        hard.setOnAction(e -> {difficulty.setDifficulty(6, navigator);Sound.play(SoundFXType.ONCLICK); });
        hard.setLayoutX(665);
        hard.setLayoutY(425);

        Style.changeStyle(easy);
        Style.changeStyle(medium);
        Style.changeStyle(hard);

        Group root = new Group();
        welcomeScene = new Scene(root);
        root.getChildren().addAll(backgroundImage, easy, medium, hard );
    }

    public static Scene getScene() {
        return welcomeScene;
    }


}
