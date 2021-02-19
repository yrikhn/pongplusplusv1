package pongplusplus.game;

import javafx.scene.image.Image;

public class Images {
    public final static Image DIFFICULTY_SELECTION_SCENE = getImage("images/difficulty_selection_scene.png");
    public final static Image GAMEMODE_SELECTION_SCENE = getImage("images/gamemode_selectinon_scene.png");
    public final static Image INFO_SCENE = getImage("images/InfoScene.png");
    public final static Image GAMEOVER_SCENE = getImage("images/gameover_scene.png");
    public final static Image ball = getImage("images/ball.png");
    public final static Image plate = getImage("images/plate.png");
    public final static Image readyIcon = getImage("images/ready.png");
    public final static Image whileAbilityBall = getImage("images/whileAbility.png");


    private static Image getImage(String imagePath) {
        return new Image(imagePath);
    }
}
