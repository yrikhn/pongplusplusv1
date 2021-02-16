package pongplusplus.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import pongplusplus.common.BaseScene;
import pongplusplus.common.Initializable;
import pongplusplus.common.Navigator;
import pongplusplus.game.Difficulty;

public class WelcomeScene extends BaseScene implements Initializable{
    private static Scene welcomeScene;
    private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #000000;-fx-text-fill:white;-fx-border-color: red;-fx-border-radius: 8;-fx-background-radius: 8;";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #757575;-fx-text-fill:white;-fx-border-color: red;-fx-border-radius: 8;-fx-background-radius: 8;";
    Difficulty difficulty;

    public WelcomeScene(Navigator navigator, Difficulty difficulty) {
        super(navigator);
        this.difficulty = difficulty;

        }

    @Override
    public void onInitialize() {


        Button easy = new Button("EASY");
        easy.setOnAction(e -> difficulty.setDifficulty(3, navigator));
        Button medium = new Button("MEDIUM");
        medium.setOnAction(e -> difficulty.setDifficulty(4.5, navigator));
        Button hard = new Button("HARD");
        hard.setOnAction(e -> difficulty.setDifficulty(6, navigator));

        changeStyle(easy);
        changeStyle(medium);
        changeStyle(hard);

        VBox vbox = new VBox();
        vbox.setPrefSize(1000, 600);
        welcomeScene = new Scene(vbox);
        vbox.getChildren().addAll(easy, medium, hard);
    }

    public static void changeStyle(Button button){
        button.setStyle(IDLE_BUTTON_STYLE);
        button.setOnMouseEntered(e -> button.setStyle(HOVERED_BUTTON_STYLE));
        button.setOnMouseExited(e -> button.setStyle(IDLE_BUTTON_STYLE));
    }
    public static Scene getScene() {
        return welcomeScene;
    }


}
