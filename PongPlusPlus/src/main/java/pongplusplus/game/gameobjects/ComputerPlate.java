package pongplusplus.game.gameobjects;

import pongplusplus.game.*;
import java.util.Random;


public class ComputerPlate extends PlateObject {
    private double randomNumb;
    private Random random = new Random();

    public ComputerPlate(double y, Board board, PlateObject enemyPlate) {
        super(28, y, Images.plate, enemyPlate, board);
    }

    @Override
    public void update(double deltaInSec) {
        randomNumb = random.nextInt(500);
        checkMovement(deltaInSec);
        checkBallSpeedManipulatorActivation();
        checkPointStealerActivation();
        ballSpeedManipulator.update(deltaInSec);
        pointStealer.update(deltaInSec);
    }

    @Override
    public void checkMovement(double deltaInSec) {
        if (board.getBall().getPos_x() <= Const.SCREEN_WIDTH * 0.75) {
            if (board.getBall().getPos_y() - Const.PLATE_HEIGHT / 2 > pos_y && pos_y + Const.PLATE_HEIGHT < Const.SCREEN_HEIGHT) {
                pos_y += deltaInSec * SPEED;
            } else if (board.getBall().getPos_y() - Const.PLATE_HEIGHT / 2 < pos_y + Const.PLATE_HEIGHT && pos_y > Const.TOP_BORDER_Y_POSITION) {
                pos_y -= deltaInSec * SPEED;
            }
        }
    }

    @Override
    public void checkBallSpeedManipulatorActivation() {
        if (randomNumb == 1 && ballSpeedManipulator.getCooldown() <= 0 && !ballSpeedManipulator.isActive()) {
            activateBallSpeedManipulator();
        }
    }

    @Override
    public void checkPointStealerActivation() {
        if (randomNumb == 265 && pointStealer.getCooldown() <= 0 && board.getScore().getPlayerScore() != 0) {
            activatePointStealer();
        }
    }
}
