package pongplusplus.game.gameobjects;

import pongplusplus.game.AbilityOne;
import pongplusplus.game.Images;
import pongplusplus.game.KeyEventHandler;

import java.sql.SQLOutput;

public class RemotablePlate extends Gameobject {

    private KeyEventHandler keyEventHandler;
    private double SPEED = 250;
    private AbilityOne abilityOne;
    private Board board;

    public RemotablePlate(KeyEventHandler keyEventHandler, double x, double y, Board board) {
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
        if (keyEventHandler.isQKeyPressed() && abilityOne.getCooldown() <= 0) {
            if (board.getComputerPlate().getAbilityOne().isActive()){
                board.getComputerPlate().getAbilityOne().deactivate();
                abilityOne.setCooldown(25);
            }else{
                abilityOne.activate();
                abilityOne.setCooldown(25);
            }
        }
        System.out.println("ME "+abilityOne.isActive());
        abilityOne.update(deltaInSec);
    }

    public AbilityOne getAbilityOne() {
        return abilityOne;
    }
}
