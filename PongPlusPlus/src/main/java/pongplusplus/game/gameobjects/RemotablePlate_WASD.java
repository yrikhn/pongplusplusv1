package pongplusplus.game.gameobjects;

import pongplusplus.game.*;

public class RemotablePlate_WASD extends Gameobject implements PlateObject {

    private KeyEventHandler keyEventHandler;
    private double SPEED = 250;
    private ChangeBallSpeedAbility changeBallSpeedAbility;
    private StealEnemyPointAbility stealEnemyPointAbility;
    private Board board;

    public RemotablePlate_WASD(KeyEventHandler keyEventHandler, double x, double y, Board board) {
        super(x, y, Images.plate);
        this.keyEventHandler = keyEventHandler;
        this.board = board;
        changeBallSpeedAbility = new ChangeBallSpeedAbility(board.getBall(), pos_x);
        stealEnemyPointAbility = new StealEnemyPointAbility(board, this);
    }


    @Override
    public void update(double deltaInSec) {
        checkMovement(deltaInSec);
        checkChangeBallSpeedAbilityActivation();
        checkStealEnemyPointsAbilityActivation();
        changeBallSpeedAbility.update(deltaInSec);
        stealEnemyPointAbility.update(deltaInSec);
    }

    public void checkMovement(double deltaInSec){
        if (keyEventHandler.isWKeyPressed() && pos_y > 61) {
            pos_y -= deltaInSec * SPEED;
        } else if (keyEventHandler.isSKeyPressed() && pos_y < 541) {
            pos_y += deltaInSec * SPEED;
        }
    }


    public void checkChangeBallSpeedAbilityActivation(){
        if (keyEventHandler.isAKeyPressed() && changeBallSpeedAbility.getCooldown() <= 0 && !changeBallSpeedAbility.isActive()) {
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
        if (keyEventHandler.isDKeyPressed() && stealEnemyPointAbility.getCooldown() <= 0 && board.getScore().getPlayerScore() != 0){
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
