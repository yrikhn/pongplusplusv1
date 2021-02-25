package pongplusplus.game.gameobjects;

import pongplusplus.game.*;

public class ControllablePlate_WASD extends PlateObject {

    private KeyEventHandler keyEventHandler;

    public ControllablePlate_WASD(KeyEventHandler keyEventHandler, double x, double y, Board board, PlateObject enemyPlate) {
        super(x, y, Images.plate, enemyPlate, board);
        this.keyEventHandler = keyEventHandler;

    }

    @Override
    public void checkMovement(double deltaInSec){
        if (keyEventHandler.isWKeyPressed() && pos_y > Const.TOP_BORDER_Y_POSITION) {
            pos_y -= deltaInSec * SPEED;
        } else if (keyEventHandler.isSKeyPressed() && pos_y < Const.BOTTOM_BORDER_Y_POSITION) {
            pos_y += deltaInSec * SPEED;
        }
    }

    @Override
    public void checkBallSpeedManipulatorActivation() {
        if (keyEventHandler.isAKeyPressed() && ballSpeedManipulator.getCooldown() <= 0 && !ballSpeedManipulator.isActive()) {
            activateBallSpeedManipulator();
        }
    }

    @Override
    public void checkPointStealerActivation() {
        if (keyEventHandler.isDKeyPressed() && pointStealer.getCooldown() <= 0 && board.getScore().getPlayerScore() != 0){
            activatePointStealer();
        }
    }
}
