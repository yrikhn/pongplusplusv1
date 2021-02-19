package pongplusplus.game.gameobjects;

import pongplusplus.game.*;

public class RemotablePlate_WASD extends Gameobject {

    private KeyEventHandler keyEventHandler;
    private double SPEED = 250;
    private BallSpeedAbility ballSpeedAbility;
    private RemoveEnemyScoreAbility removeEnemyScoreAbility;
    private Board board;

    public RemotablePlate_WASD(KeyEventHandler keyEventHandler, double x, double y, Board board) {
        super(x, y, Images.plate);
        this.keyEventHandler = keyEventHandler;
        this.board = board;
        ballSpeedAbility = new BallSpeedAbility(board.getBall(), pos_x);
        removeEnemyScoreAbility = new RemoveEnemyScoreAbility(board, this);
    }


    @Override
    public void update(double deltaInSec) {
        if (keyEventHandler.isWKeyPressed() && pos_y > 61) {
            pos_y -= deltaInSec * SPEED;
        } else if (keyEventHandler.isSKeyPressed() && pos_y < 541) {
            pos_y += deltaInSec * SPEED;
        }
        if (keyEventHandler.isAKeyPressed() && ballSpeedAbility.getCooldown() <= 0 && !ballSpeedAbility.isActive()) {
            if (board.getArrowRemotablePlate().getBallSpeedAbility().isActive()) {
                board.getArrowRemotablePlate().getBallSpeedAbility().deactivate();
                ballSpeedAbility.setCooldown(25);
            } else {
                ballSpeedAbility.activate();
                ballSpeedAbility.setCooldown(25);
                board.getBall().setImage(Images.whileAbilityBall);
            }
        }
        if (keyEventHandler.isDKeyPressed() && removeEnemyScoreAbility.getCooldown() <= 0 && board.getScore().getPlayerScore() != 0){
            removeEnemyScoreAbility.activate();
            removeEnemyScoreAbility.setCooldown(25);
        }
        ballSpeedAbility.update(deltaInSec);
        removeEnemyScoreAbility.update(deltaInSec);
    }

    public BallSpeedAbility getBallSpeedAbility() {
        return ballSpeedAbility;
    }

    public RemoveEnemyScoreAbility getRemoveEnemyScoreAbility() {
        return removeEnemyScoreAbility;
    }
}
