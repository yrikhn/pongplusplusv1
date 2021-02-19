package pongplusplus.gui;

import pongplusplus.common.*;
import pongplusplus.game.*;

public class InGameScene extends BaseScene implements Initializable {

    private GodLikeAnimationTimer gameLoop;
    private Score score;
    private GameSetting gameSetting;

    public InGameScene(Navigator navigator, Score score, GameSetting gameSetting) {
        super(navigator);
        this.score = score;
        this.gameSetting = gameSetting;
    }

    @Override
    public void onInitialize() {
        score.resetScore();
        KeyEventHandler keyEventHandler = new KeyEventHandler();
        this.setOnKeyPressed(keyEventHandler);
        this.setOnKeyReleased(keyEventHandler);
        Board board = new Board(keyEventHandler, navigator, () -> gameLoop.stop(), score, gameSetting);
        board.generateObject();
        gameLoop = new GodLikeAnimationTimer() {
            @Override
            public void doHandle(double deltaInSec) {
                board.draw(gc);
                board.update(deltaInSec);
            }
        };
        gameLoop.start();

    }


}

