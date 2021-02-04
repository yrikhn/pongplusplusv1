package pongplusplus.game.gameobjects;

import javafx.scene.canvas.GraphicsContext;
import pongplusplus.game.Images;

public abstract class Gameobject {

    protected double pos_x;
    protected double pos_y;


    public Gameobject(double x, double y){
        this.pos_x = x;
        this.pos_y = y;
    }

    public abstract void update(double deltaInSec);
    public void draw(GraphicsContext gc){
        gc.drawImage(Images.ball,pos_x,pos_y);
    }
}
