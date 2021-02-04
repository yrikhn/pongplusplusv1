package pongplusplus.game.gameobjects;

import javafx.scene.canvas.GraphicsContext;
import pongplusplus.common.Navigator;
import pongplusplus.common.Util;
import pongplusplus.game.Images;
import pongplusplus.game.KeyEventHandler;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;


public class Board extends CopyOnWriteArrayList<Gameobject> {
    private KeyEventHandler keyEventHandler;
    private Navigator navigator;
    double randNumb = new Random().nextInt(539);


    public Board(Navigator navigator, KeyEventHandler keyEventHandler) {
        this.navigator = navigator;
        this.keyEventHandler = keyEventHandler;
    }
    public void load(){
        add(new Ball(493, randNumb + 61, Images.ball));
        add(new Plate(keyEventHandler, 970,280, Images.plate));
    }

    public void update(double deltaInSec){
        getBall().update(deltaInSec);
        getPlate().update(deltaInSec);
    }

    public void draw(GraphicsContext gc) {
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
