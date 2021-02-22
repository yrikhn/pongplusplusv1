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
    public void checkMovement(double deltaInSec){
        if (board.getBall().getPos_x() <= Const.SCREEN_WIDTH / 4 * 3) {

            if (board.getBall().getPos_y() - 26 > pos_y && pos_y + Const.PLATE_HEIGHT < 600) {
                pos_y += deltaInSec * 250;
            } else if (board.getBall().getPos_y() - 26 < pos_y + 57 && pos_y > 61) {
                pos_y -= deltaInSec * 250;
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
            pointStealer.activate();
            pointStealer.setCooldown(25);
        }
    }

}
