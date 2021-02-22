package pongplusplus.game.gameobjects;

import pongplusplus.game.*;

public class ControllablePlate_Arrow extends PlateObject{

    private KeyEventHandler keyEventHandler;
    private double SPEED = 250;


    public ControllablePlate_Arrow(KeyEventHandler keyEventHandler, int x, int y, Board board) {
        super(x, y, Images.plate, board);
        this.keyEventHandler = keyEventHandler;
    }


    @Override
    public void checkMovement(double deltaInSec) {
        if (keyEventHandler.isUpKeyPressed() && pos_y > 61) {
            pos_y -= deltaInSec * SPEED;
        } else if (keyEventHandler.isDownKeyPressed() && pos_y < 541) {
            pos_y += deltaInSec * SPEED;
        }
    }

    @Override
    public void checkBallSpeedManipulatorActivation() {
        if (keyEventHandler.isLeftKeyPressed() && ballSpeedManipulator.getCooldown() <= 0 && !ballSpeedManipulator.isActive()) {
            activateBallSpeedManipulator();
        }
    }


    @Override
    public void checkPointStealerActivation() {
        if (keyEventHandler.isRightKeyPressed() && pointStealer.getCooldown() <= 0 && board.getScore().getEnemyScore() != 0){
            pointStealer.activate();
            pointStealer.setCooldown(25);
        }

    }
}
