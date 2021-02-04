package pongplusplus.game.gameobjects;

import javafx.scene.image.Image;

import java.util.Random;

public class Ball extends Gameobject{
    protected double SPEED = 200;
    private double InitialDestinationY = new Random().nextInt(1001);


    public  Ball(double x, double y, Image image){
        super(x,y, image);
    }


    @Override
    public void update(double deltaInSec) {
        super.pos_x -= deltaInSec * SPEED;
        super.pos_y -= deltaInSec * SPEED;
    }
}
