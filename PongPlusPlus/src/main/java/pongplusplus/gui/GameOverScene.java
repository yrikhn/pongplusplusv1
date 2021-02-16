package pongplusplus.gui;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import pongplusplus.common.BaseScene;
import pongplusplus.common.Initializable;
import pongplusplus.common.SceneType;
import pongplusplus.game.Const;
import pongplusplus.game.Images;
import pongplusplus.common.Navigator;
import pongplusplus.game.Points;


public class GameOverScene extends BaseScene implements Initializable {

    private static Scene gameOverScene;
    private Text announcement = new Text("");
    private Points points;

    public GameOverScene(Navigator navigator, Points points) {
        super(navigator, Images.GAMEOVER_SCENE);
        this.points = points;
    }

    @Override
    public void onInitialize() {

        ImageView backgroundImage = new ImageView();
        Image image = new Image("/gameoverscene.png");
        backgroundImage.setImage(image);

        announceWinner(announcement, points);
        announcement.setStyle(Const.TEXT_STYLE);

        announcement.setLayoutX(410);
        announcement.setLayoutY(355);
        points.resetPoint();

        Button restart = new Button("RESTART");
        restart.setLayoutX(298);
        restart.setLayoutY(425);

        Button exit = new Button("EXIT");
        exit.setLayoutX(568);
        exit.setLayoutY(425);

        Style.changeStyle(restart);
        Style.changeStyle(exit);

        Group root = new Group();
        gameOverScene = new Scene(root);

        root.getChildren().addAll(backgroundImage, announcement, restart, exit);
        restart.setOnAction(e -> navigator.goTo(SceneType.WELCOME));
        exit.setOnAction(e -> Platform.exit());
    }


    public static void announceWinner(Text text, Points point) {
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

