package pongplusplus.game.gameobjects;

import pongplusplus.game.*;

import java.util.Random;


public class ComputerPlate extends Gameobject implements PlateObject{
    private Board board;
    private double randomNumb;
    private Random random = new Random();
    private ChangeBallSpeedAbility changeBallSpeedAbility;
    private StealEnemyPointAbility stealEnemyPointAbility;

    public ComputerPlate(double y, Board board) {
        super(28, y, Images.plate);
        this.board = board;
        changeBallSpeedAbility = new ChangeBallSpeedAbility(board.getBall(), pos_x);
        stealEnemyPointAbility = new StealEnemyPointAbility(board, this);
    }

    @Override
    public void update(double deltaInSec) {

        randomNumb = random.nextInt(500);

        checkMovement(deltaInSec);
        checkChangeBallSpeedAbilityActivation();
        checkStealEnemyPointsAbilityActivation();



        changeBallSpeedAbility.update(deltaInSec);
        stealEnemyPointAbility.update(deltaInSec);
    }
    public void checkMovement(double deltaInSec){
        if (board.getBall().getPos_x() <= Const.SCREEN_WIDTH / 4 * 3) {

            if (board.getBall().getPos_y() - 26 > pos_y && pos_y + Const.PLATE_HEIGHT < 600) {
                pos_y += deltaInSec * 250;
            } else if (board.getBall().getPos_y() - 26 < pos_y + 57 && pos_y > 61) {
                pos_y -= deltaInSec * 250;
            }
        }
    }
    public void checkChangeBallSpeedAbilityActivation(){
        if (randomNumb == 1 && changeBallSpeedAbility.getCooldown() <= 0 && !changeBallSpeedAbility.isActive()) {
            if (board.getArrowRemotablePlate().getBallSpeedAbility().isActive()) {
                board.getArrowRemotablePlate().getBallSpeedAbility().deactivate();
                changeBallSpeedAbility.setCooldown(25);
            } else {
                changeBallSpeedAbility.activate();
                changeBallSpeedAbility.setCooldown(25);
                board.getBall().setImage(Images.whileAbilityBall);
            }
        }
    }
    public void checkStealEnemyPointsAbilityActivation(){
        if (randomNumb == 265 && stealEnemyPointAbility.getCooldown() <= 0 && board.getScore().getPlayerScore() != 0) {
            stealEnemyPointAbility.activate();
            stealEnemyPointAbility.setCooldown(25);
        }
    }

    public ChangeBallSpeedAbility getBallSpeedAbility() {
        return changeBallSpeedAbility;
    }

    public StealEnemyPointAbility getRemoveEnemyScoreAbility() {
        return stealEnemyPointAbility;
    }
}
