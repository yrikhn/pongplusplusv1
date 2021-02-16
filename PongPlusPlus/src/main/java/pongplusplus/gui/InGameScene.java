package pongplusplus.gui;

import pongplusplus.common.*;
import pongplusplus.game.Difficulty;
import pongplusplus.game.KeyEventHandler;
import pongplusplus.game.Points;
import pongplusplus.game.gameobjects.Board;

public class InGameScene extends BaseScene implements Initializable {

    private GodLikeAnimationTimer gameLoop;
    private Points points;
    private Difficulty difficulty;

    public InGameScene(Navigator navigator, Points points, Difficulty difficulty) {
        super(navigator);

        this.points = points;
        this.difficulty = difficulty;
    }
    @Override
    public void onInitialize() {

        points.resetPoint();
        KeyEventHandler keyEventHandler = new KeyEventHandler();

        this.setOnKeyPressed(keyEventHandler);
        this.setOnKeyReleased(keyEventHandler);

        Board board = new Board(keyEventHandler, navigator,() -> gameLoop.stop(), points, difficulty);

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

