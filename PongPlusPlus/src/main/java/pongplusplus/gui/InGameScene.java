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

