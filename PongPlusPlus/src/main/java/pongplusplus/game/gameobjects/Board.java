package pongplusplus.game.gameobjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import pongplusplus.common.Navigator;
import pongplusplus.common.Util;
import pongplusplus.game.Const;
import pongplusplus.game.Images;
import pongplusplus.game.KeyEventHandler;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import pongplusplus.game.gameobjects.Ball;


public class Board extends CopyOnWriteArrayList<Gameobject> {
    private KeyEventHandler keyEventHandler;
    private Navigator navigator;
    double randNumb = new Random().nextInt(539);
    public int playerPoints;
    public int gegnerPoints;

    public Board(Navigator navigator, KeyEventHandler keyEventHandler) {
        this.navigator = navigator;
        this.keyEventHandler = keyEventHandler;
    }
    public void load(){
        add(new Ball(Const.SCREEN_WIDTH / 2, Const.SCREEN_WIDTH / 2, Images.ball, this));
        add(new Plate(keyEventHandler, 970,280, Images.plate));
        add(new Plate(keyEventHandler, 30,280, Images.plate));
    }

    public void update(double deltaInSec){
        getBall().update(deltaInSec);
        getPlate().update(deltaInSec);
    }

    public void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, pongplusplus.game.Const.SCREEN_WIDTH, pongplusplus.game.Const.SCREEN_HEIGHT);
        gc.setFill(Paint.valueOf("#000000"));
        gc.fillRect(0,0,1000,600);
        gc.setFill(Paint.valueOf("#FFFFFF"));
        gc.fillRect(494.5,0,11,600);
        gc.fillRect(0,50,1000,11);

        gc.setFont(new Font(40));
        gc.fillText("" + playerPoints, 460, 35);
        gc.fillText("" + gegnerPoints, 517, 35);


        getBall().draw(gc);
        getPlate().draw(gc);
    }
    public Ball getBall() {
        return Util.getAllObjectsFromType(Ball.class, this).get(0);
    }
    public Plate getPlate() {
        return Util.getAllObjectsFromType(Plate.class, this).get(0);
    }
}
