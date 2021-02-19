package pongplusplus.game.gameobjects;

import pongplusplus.game.*;

public class RemotablePlate_Arrow extends Gameobject {

    private KeyEventHandler keyEventHandler;
    private double SPEED = 250;
    private BallSpeedAbility ballSpeedAbility;
    private RemoveEnemyScoreAbility removeEnemyScoreAbility;
    private Board board;


    public RemotablePlate_Arrow(KeyEventHandler keyEventHandler, double x, double y, Board board) {
        super(x, y, Images.plate);
        this.keyEventHandler = keyEventHandler;
        this.board = board;
        ballSpeedAbility = new BallSpeedAbility(board.getBall(), pos_x);
        removeEnemyScoreAbility = new RemoveEnemyScoreAbility(board, this);
    }


    @Override
    public void update(double deltaInSec) {
        if (keyEventHandler.isUpKeyPressed() && pos_y > 61) {
            pos_y -= deltaInSec * SPEED;
        } else if (keyEventHandler.isDownKeyPressed() && pos_y < 541) {
            pos_y += deltaInSec * SPEED;
        }

        checkOponent();

        ballSpeedAbility.update(deltaInSec);
        removeEnemyScoreAbility.update(deltaInSec);
    }

    public void checkOponent() {
        if (keyEventHandler.isLeftKeyPressed() && ballSpeedAbility.getCooldown() <= 0) {
            if (board.getGameSetting().isSingleplayer()) {
                if (board.getComputerPlate().getBallSpeedAbility().isActive()) {
                    board.getComputerPlate().getBallSpeedAbility().deactivate();
                    ballSpeedAbility.setCooldown(25);
                } else {
                    ballSpeedAbility.activate();
                    ballSpeedAbility.setCooldown(25);
                    board.getBall().setImage(Images.whileAbilityBall);
                }

            } else {

                if (board.getWASDRemotablePlate().getBallSpeedAbility().isActive()) {
                    board.getWASDRemotablePlate().getBallSpeedAbility().deactivate();
                    ballSpeedAbility.setCooldown(25);
                } else {
                    ballSpeedAbility.activate();
                    ballSpeedAbility.setCooldown(25);
                    board.getBall().setImage(Images.whileAbilityBall);
                }
            }

        }
        if (keyEventHandler.isRightKeyPressed() && removeEnemyScoreAbility.getCooldown() <= 0){
            if (board.getGameSetting().isSingleplayer()) {
                if (keyEventHandler.isRightKeyPressed() && removeEnemyScoreAbility.getCooldown() <= 0 && board.getScore().getEnemyScore() != 0){
                    removeEnemyScoreAbility.activate();
                    removeEnemyScoreAbility.setCooldown(25);
                }
            }else{
                if (keyEventHandler.isRightKeyPressed() && removeEnemyScoreAbility.getCooldown() <= 0 && board.getScore().getEnemyScore() != 0){
                    removeEnemyScoreAbility.activate();
                    removeEnemyScoreAbility.setCooldown(25);
                }
            }

        }


    }


    public BallSpeedAbility getBallSpeedAbility() {
        return ballSpeedAbility;
    }

    public RemoveEnemyScoreAbility getRemoveEnemyScoreAbility() {
        return removeEnemyScoreAbility;
    }
}
