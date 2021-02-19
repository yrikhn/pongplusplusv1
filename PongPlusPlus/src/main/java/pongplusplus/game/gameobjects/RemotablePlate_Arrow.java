package pongplusplus.game.gameobjects;

import pongplusplus.game.*;

public class RemotablePlate_Arrow extends Gameobject {

    private KeyEventHandler keyEventHandler;
    private double SPEED = 250;
    private AbilityOne abilityOne;
    private Board board;

    public RemotablePlate_Arrow(KeyEventHandler keyEventHandler, double x, double y, Board board) {
        super(x, y, Images.plate);
        this.keyEventHandler = keyEventHandler;
        this.board = board;
        abilityOne = new AbilityOne(board.getBall(), pos_x);
    }


    @Override
    public void update(double deltaInSec) {
        if (keyEventHandler.isUpKeyPressed() && pos_y > 61) {
            pos_y -= deltaInSec * SPEED;
        } else if (keyEventHandler.isDownKeyPressed() && pos_y < 541) {
            pos_y += deltaInSec * SPEED;
        }

        checkOponent();
        abilityOne.update(deltaInSec);
    }

    public void checkOponent() {
        if (keyEventHandler.isLeftKeyPressed() && abilityOne.getCooldown() <= 0) {
            if (board.getGameSetting().isSingleplayer()) {
                if (board.getComputerPlate().getAbilityOne().isActive()) {
                    board.getComputerPlate().getAbilityOne().deactivate();
                    abilityOne.setCooldown(25);
                } else {
                    abilityOne.activate();
                    abilityOne.setCooldown(25);
                    board.getBall().setImage(Images.whileAbilityBall);
                }
            } else {

                if (board.getWASDRemotablePlate().getAbilityOne().isActive()) {
                    board.getWASDRemotablePlate().getAbilityOne().deactivate();
                    abilityOne.setCooldown(25);
                } else {
                    abilityOne.activate();
                    abilityOne.setCooldown(25);
                    board.getBall().setImage(Images.whileAbilityBall);
                }
            }
        }

    }


    public AbilityOne getAbilityOne() {
        return abilityOne;
    }
}
