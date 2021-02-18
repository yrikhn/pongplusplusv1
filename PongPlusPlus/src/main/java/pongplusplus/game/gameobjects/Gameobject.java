package pongplusplus.game.gameobjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Gameobject {

    protected Image image;
    protected double pos_x;
    protected double pos_y;


    public Gameobject(double x, double y, Image image) {
        this.pos_x = x;
        this.pos_y = y;
        this.image = image;
    }

    public abstract void update(double deltaInSec);

    public void draw(GraphicsContext gc) {
        gc.drawImage(image, pos_x, pos_y);
    }

    public double getPos_x() {
        return pos_x;
    }

    public double getPos_y() {
        return pos_y;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
