package pongplusplus.game.gameobjects;

import pongplusplus.game.*;

public class RemotablePlate_WASD extends Gameobject {

    private KeyEventHandler keyEventHandler;
    private double SPEED = 250;
    private AbilityOne abilityOne;
    private Board board;

    public RemotablePlate_WASD(KeyEventHandler keyEventHandler, double x, double y, Board board) {
        super(x, y, Images.plate);
        this.keyEventHandler = keyEventHandler;
        this.board = board;
        abilityOne = new AbilityOne(board.getBall(), pos_x);
    }


    @Override
    public void update(double deltaInSec) {
        if (keyEventHandler.isWKeyPressed() && pos_y > 61) {
            pos_y -= deltaInSec * SPEED;
        } else if (keyEventHandler.isSKeyPressed() && pos_y < 541) {
            pos_y += deltaInSec * SPEED;
        }
        if (keyEventHandler.isAKeyPressed() && abilityOne.getCooldown() <= 0 && !abilityOne.isActive()) {
            if (board.getArrowRemotablePlate().getAbilityOne().isActive()) {
                board.getArrowRemotablePlate().getAbilityOne().deactivate();
                abilityOne.setCooldown(25);
            } else {
                abilityOne.activate();
                abilityOne.setCooldown(25);
                board.getBall().setImage(Images.whileAbilityBall);
            }
        }
        abilityOne.update(deltaInSec);
    }

    public AbilityOne getAbilityOne() {
        return abilityOne;
    }
}
