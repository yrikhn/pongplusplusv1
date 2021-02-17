package pongplusplus.game.gameobjects;

import pongplusplus.game.AbilityOne;
import pongplusplus.game.Const;
import pongplusplus.game.Images;

import java.util.Random;


public class ComputerPlate extends Gameobject{
    private Board board;
    private double randomNumb;
    private Random random = new Random();
    private AbilityOne abilityOne;

    public ComputerPlate (double y, Board board){
        super(28, y, Images.plate);
        this.board = board;
        abilityOne = new AbilityOne(board.getBall(), pos_x);
    }

    @Override
    public void update(double deltaInSec) {
        randomNumb = random.nextInt(50);
         if (board.getBall().getPos_x() <= Const.SCREEN_WIDTH/3*2){

            if(board.getBall().getPos_y() == pos_y)   {

            }else if (board.getBall().getPos_y() > pos_y){
                if(pos_y < Const.SCREEN_HEIGHT - 200) {
                    pos_y += deltaInSec * 250;
                }
            }else if(board.getBall().getPos_y() < pos_y+57){
                if(pos_y > 20) {
                    pos_y -= deltaInSec * 250;
                }
            }
         }
         if(randomNumb == 0 && abilityOne.getCooldown() <= 0){
             if (board.getRemotablePlate().getAbilityOne().isActive()){
                 board.getRemotablePlate().getAbilityOne().deactivate();
                 abilityOne.setCooldown(25);
             }else{
                 abilityOne.activate();
                 abilityOne.setCooldown(25);
             }
         }
        System.out.println("KI "+abilityOne.isActive());
        abilityOne.update(deltaInSec);
    }

    public AbilityOne getAbilityOne() {
        return abilityOne;
    }
}
