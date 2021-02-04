package pongplusplus.game.gameobjects;

import java.util.Random;

public class Ball extends Gameobject{
    protected double SPEED = 200;
    private double InitialDestinationY = new Random().nextInt(1001);
    double InitialDestinationX;

    public  Ball(double x, double y){
        super(x,y);
    }
    private void approachDestination(){
        InitialDestinationX = 0;
    }

    @Override
    public void update(double deltaInSec) {
        super.pos_x -= deltaInSec * SPEED;
        super.pos_y -= deltaInSec * SPEED;
    }
}
