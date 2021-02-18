package pongplusplus.game;

import javafx.scene.image.Image;

public class Images {
    public final static Image WELCOME_SCENE = getImage("images/welcomescene.png");
    public final static Image GAMEOVER_SCENE = getImage("images/gameoverscene.png");
    public final static Image INFO_SCENE = getImage("images/InfoScene.png");
    public final static Image ball = getImage("images/ball.png");
    public final static Image plate = getImage("images/plate.png");
    public final static Image readyIcon = getImage("images/ready.png");
    public final static Image whileAbilityBall = getImage("images/whileAbility.png");


    private static Image getImage(String imagePath) {
        return new Image(imagePath);
    }
}
