package pongplusplus.gui;

import pongplusplus.common.*;
import pongplusplus.game.KeyEventHandler;
import pongplusplus.game.gameobjects.Board;

public class InGameScene extends BaseScene implements Initializable {

    private GodLikeAnimationTimer gameLoop;

    public InGameScene(Navigator navigator) {
        super(navigator);

    }
    @Override
    public void onInitialize() {
        KeyEventHandler keyEventHandler = new KeyEventHandler();

        this.setOnKeyPressed(keyEventHandler);
        this.setOnKeyReleased(keyEventHandler);

        Board board = new Board(keyEventHandler, navigator,() -> gameLoop.stop());

        board.generateObject();

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

