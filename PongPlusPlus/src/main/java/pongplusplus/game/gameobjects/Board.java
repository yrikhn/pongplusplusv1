package pongplusplus.game.gameobjects;

import javafx.scene.canvas.GraphicsContext;
import pongplusplus.common.Navigator;


import java.util.Random;

public class Board {

    private Navigator navigator;
    double randNumb = new Random().nextInt(539);

    Ball ball = new Ball(493, randNumb + 61);

    public Board(Navigator navigator) {
        this.navigator = navigator;
    }
    public void update(double deltaInSec){
        ball.update(deltaInSec);
    }

    public void draw(GraphicsContext gc) {
        ball.draw(gc);
    }
}
