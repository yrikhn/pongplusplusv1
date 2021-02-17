package pongplusplus.gui;

import pongplusplus.common.*;
import pongplusplus.game.Difficulty;
import pongplusplus.game.KeyEventHandler;
import pongplusplus.game.Score;
import pongplusplus.game.gameobjects.Board;

public class InGameScene extends BaseScene implements Initializable {

    private GodLikeAnimationTimer gameLoop;
    private Score score;
    private Difficulty difficulty;

    public InGameScene(Navigator navigator, Score score, Difficulty difficulty) {
        super(navigator);

        this.score = score;
        this.difficulty = difficulty;
    }
    @Override
    public void onInitialize() {

        score.resetScore();
        KeyEventHandler keyEventHandler = new KeyEventHandler();

        this.setOnKeyPressed(keyEventHandler);
        this.setOnKeyReleased(keyEventHandler);

        Board board = new Board(keyEventHandler, navigator,() -> gameLoop.stop(), score, difficulty);

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

