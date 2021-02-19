package pongplusplus.game.gameobjects;

import pongplusplus.game.*;

public class RemotablePlate_Arrow extends Gameobject implements PlateObject{

    private KeyEventHandler keyEventHandler;
    private double SPEED = 250;
    private ChangeBallSpeedAbility changeBallSpeedAbility;
    private StealEnemyPointAbility stealEnemyPointAbility;
    private Board board;


    public RemotablePlate_Arrow(KeyEventHandler keyEventHandler, double x, double y, Board board) {
        super(x, y, Images.plate);
        this.keyEventHandler = keyEventHandler;
        this.board = board;
        changeBallSpeedAbility = new ChangeBallSpeedAbility(board.getBall(), pos_x);
        stealEnemyPointAbility = new StealEnemyPointAbility(board, this);
    }

    @Override
    public void update(double deltaInSec) {
        checkMovement(deltaInSec);
        checkOponent();
        changeBallSpeedAbility.update(deltaInSec);
        stealEnemyPointAbility.update(deltaInSec);
    }

    public void checkOponent() {
        if (keyEventHandler.isLeftKeyPressed() && changeBallSpeedAbility.getCooldown() <= 0) {
            if (board.getGameSetting().isSingleplayer()) {
                checkChangeBallSpeedAbilityActivation();
            } else {
                checkChangeBallSpeedAbilityActivationMultiplayer();
            }
        }
        if (keyEventHandler.isRightKeyPressed() && stealEnemyPointAbility.getCooldown() <= 0){
            if (board.getGameSetting().isSingleplayer()) {
                checkStealEnemyPointsAbilityActivation();
            }else{
                checkStealEnemyPointsAbilityActivationMultiplayer();
            }
        }
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
    public void checkChangeBallSpeedAbilityActivation() {
        if (board.getComputerPlate().getBallSpeedAbility().isActive()) {
            board.getComputerPlate().getBallSpeedAbility().deactivate();
            changeBallSpeedAbility.setCooldown(25);
        } else {
            changeBallSpeedAbility.activate();
            changeBallSpeedAbility.setCooldown(25);
            board.getBall().setImage(Images.whileAbilityBall);
        }

    }
    public void checkChangeBallSpeedAbilityActivationMultiplayer(){
        if (board.getWASDRemotablePlate().getBallSpeedAbility().isActive()) {
            board.getWASDRemotablePlate().getBallSpeedAbility().deactivate();
            changeBallSpeedAbility.setCooldown(25);
        } else {
            changeBallSpeedAbility.activate();
            changeBallSpeedAbility.setCooldown(25);
            board.getBall().setImage(Images.whileAbilityBall);
        }
    }

    @Override
    public void checkStealEnemyPointsAbilityActivation() {
        if (keyEventHandler.isRightKeyPressed() && stealEnemyPointAbility.getCooldown() <= 0 && board.getScore().getEnemyScore() != 0){
            stealEnemyPointAbility.activate();
            stealEnemyPointAbility.setCooldown(25);
        }

    }
    public void checkStealEnemyPointsAbilityActivationMultiplayer() {
        if (keyEventHandler.isRightKeyPressed() && stealEnemyPointAbility.getCooldown() <= 0 && board.getScore().getEnemyScore() != 0){
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
