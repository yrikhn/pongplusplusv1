package pongplusplus.game;

import javafx.scene.image.Image;

public class Images {
    public final static Image WELCOME_SCENE = getImage("welcomescene.png");
    public final static Image GAMEOVER_SCENE = getImage("dog.png");
    public final static Image ball = getImage("ball.png");
    public final static Image plate = getImage("plate.png");

    private static Image getImage(String imagePath) {
        return new Image(imagePath);
    }
}
