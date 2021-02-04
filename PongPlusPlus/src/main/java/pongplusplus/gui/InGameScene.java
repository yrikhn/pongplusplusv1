package pongplusplus.gui;

import javafx.scene.paint.Paint;
import pongplusplus.common.BaseScene;
import pongplusplus.common.GodLikeAnimationTimer;
import pongplusplus.common.Navigator;
import pongplusplus.game.KeyEventHandler;
import pongplusplus.game.gameobjects.Board;

public class InGameScene extends BaseScene {

    private GodLikeAnimationTimer gameLoop;

    public InGameScene(Navigator navigator) {
        super(navigator);
        onInitialize();
    }

    public void onInitialize() {
        gc.setFill(Paint.valueOf("#000000"));
        gc.fillRect(0,0,1000,600);
        gc.setFill(Paint.valueOf("#FFFFFF"));
        gc.fillRect(494.5,0,11,600);
        gc.fillRect(0,50,1000,11);


        KeyEventHandler keyEventHandler = new KeyEventHandler();
        this.setOnKeyPressed(keyEventHandler);
        this.setOnKeyReleased(keyEventHandler);

        Board board = new Board(navigator, keyEventHandler);
        board.load();
        gameLoop = new GodLikeAnimationTimer() {
            @Override
            public void doHandle(double deltaInSec) {
                board.update(deltaInSec);
                board.draw(gc);
            }
        };
        gameLoop.start();

    }


}

