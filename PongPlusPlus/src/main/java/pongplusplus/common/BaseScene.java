package pongplusplus.common;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import pongplusplus.game.Const;

public abstract class BaseScene extends Scene {

    protected final Navigator navigator;
    protected final Canvas canvas;
    protected final GraphicsContext gc;

    public BaseScene(Navigator navigator) {
        super(new Group());
        this.navigator = navigator;
        canvas = new Canvas(Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        gc = canvas.getGraphicsContext2D();
        ((Group) getRoot()).getChildren().add(canvas);
    }
}
