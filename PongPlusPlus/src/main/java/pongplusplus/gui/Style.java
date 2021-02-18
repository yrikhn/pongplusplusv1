package pongplusplus.gui;

import javafx.scene.control.Button;
import pongplusplus.game.Const;

public class Style {
    public static void changeStyle(Button button) {
        button.setStyle(Const.BUTTON_STYLE);
        button.setOnMouseEntered(e -> button.setStyle(Const.HOVERED_BUTTON_STYLE));
        button.setOnMouseExited(e -> button.setStyle(Const.BUTTON_STYLE));
        button.setPrefSize(135, 70);
    }

    public static void changeInfoStyle(Button button) {
        button.setStyle(Const.BUTTON_STYLE);
        button.setOnMouseEntered(e -> button.setStyle(Const.HOVERED_BUTTON_STYLE));
        button.setOnMouseExited(e -> button.setStyle(Const.BUTTON_STYLE));
        button.setPrefSize(95, 50);
    }
}
