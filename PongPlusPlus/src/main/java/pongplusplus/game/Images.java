package pongplusplus.game;

import javafx.scene.image.Image;

public class Images {
    public final static String WELCOME_SCENE = "images/welcomescene.png";
    public final static String GAMEOVER_SCENE = "images/gameoverscene.png";
    public final static String INFO_SCENE = "images/InfoScene.png";
    public final static Image ball = getImage("images/ball.png");
    public final static Image plate = getImage("images/plate.png");
    public final static Image readyIcon = getImage("images/ready.png");
    public final static Image whileAbilityBall = getImage("images/whileAbility.png");


    private static Image getImage(String imagePath) {
        return new Image(imagePath);
    }
}
