package pongplusplus.game.gameobjects;

import javafx.scene.image.Image;
import pongplusplus.game.KeyEventHandler;

public class Plate extends Gameobject{

    private KeyEventHandler keyEventHandler;
    private double SPEED = 250;

    public Plate(KeyEventHandler keyEventHandler, double x, double y, Image image){
        super(x,y,image);
        this.keyEventHandler = keyEventHandler;
    }


    @Override
    public void update(double deltaInSec) {
        handleAction(deltaInSec);
    }

    private void handleAction(double deltaInSec){
        if (keyEventHandler.isUpKeyPressed() && pos_y > 61 ) {
            pos_y -= deltaInSec*SPEED;
        }else if (keyEventHandler.isDownKeyPressed() && pos_y < 543){
            pos_y += deltaInSec*SPEED;
        }
    }
}
