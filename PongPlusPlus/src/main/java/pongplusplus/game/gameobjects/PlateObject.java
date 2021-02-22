package pongplusplus.game.gameobjects;

import javafx.scene.image.Image;
import pongplusplus.game.*;

public abstract class PlateObject extends Gameobject{
    protected PlateObject enemyPlate;
    protected Board board;
    protected BallSpeedManipulator ballSpeedManipulator;
    protected PointStealer pointStealer;

    public PlateObject(double x, double y, Image image, PlateObject enemyPlate, Board board) {
        super(x, y, image);
        this.enemyPlate = enemyPlate;
        this.board = board;
        ballSpeedManipulator = new BallSpeedManipulator(board.getBall(), pos_x);
        pointStealer = new PointStealer(board, this);
    }

    public PlateObject(int x, int y, Image image, Board board) {
        super(x, y, image);
        this.board = board;
        ballSpeedManipulator = new BallSpeedManipulator(board.getBall(), pos_x);
        pointStealer = new PointStealer(board, this);
    }


    public void activateBallSpeedManipulator(){
        if (enemyPlate.ballSpeedManipulator.isActive()) {
            enemyPlate.ballSpeedManipulator.deactivate();
            ballSpeedManipulator.setCooldown(25);
        } else {
            ballSpeedManipulator.activate();
            ballSpeedManipulator.setCooldown(25);
            board.getBall().setImage(Images.whileAbilityBall);
        }
    }
    @Override
    public void update(double deltaInSec) {
        checkMovement(deltaInSec);
        checkBallSpeedManipulatorActivation();
        checkPointStealerActivation();
        ballSpeedManipulator.update(deltaInSec);
        pointStealer.update(deltaInSec);
    }



    public abstract void checkMovement(double deltaInSec);

    public abstract void checkBallSpeedManipulatorActivation();

    public abstract void checkPointStealerActivation();

    public void setEnemyPlate(PlateObject enemyPlate){
        this.enemyPlate = enemyPlate;
    }

    public BallSpeedManipulator getBallSpeedManipulator() {
        return ballSpeedManipulator;
    }

    public PointStealer getPointStealer() {
        return pointStealer;
    }





}
