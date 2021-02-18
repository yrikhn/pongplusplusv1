package pongplusplus.game.gameobjects;

import pongplusplus.game.*;

import java.util.Random;


public class ComputerPlate extends Gameobject {
    private Board board;
    private double randomNumb;
    private Random random = new Random();
    private BallSpeedAbility ballSpeedAbility;
    private RemoveEnemyScoreAbility removeEnemyScoreAbility;

    public ComputerPlate(double y, Board board) {
        super(28, y, Images.plate);
        this.board = board;
        ballSpeedAbility = new BallSpeedAbility(board.getBall(), pos_x);
        removeEnemyScoreAbility = new RemoveEnemyScoreAbility(board, this);
    }

    @Override
    public void update(double deltaInSec) {

        randomNumb = random.nextInt(500);

        if (board.getBall().getPos_x() <= Const.SCREEN_WIDTH / 4 * 3) {

            if (board.getBall().getPos_y() == pos_y) {

            } else if (board.getBall().getPos_y() - 26 > pos_y && pos_y < 600) {
                pos_y += deltaInSec * 250;
            } else if (board.getBall().getPos_y() - 26 < pos_y + 57 && pos_y > 61) {
                pos_y -= deltaInSec * 250;
            }
        }
        if (randomNumb == 1 && ballSpeedAbility.getCooldown() <= 0) {
            if (board.getRemotablePlate().getBallSpeedAbility().isActive()) {
                board.getRemotablePlate().getBallSpeedAbility().deactivate();
                ballSpeedAbility.setCooldown(25);
            } else {
                ballSpeedAbility.activate();
                ballSpeedAbility.setCooldown(25);
                board.getBall().setImage(Images.whileAbilityBall);
            }
        }

        if (randomNumb == 265 && removeEnemyScoreAbility.getCooldown() <= 0) {
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
