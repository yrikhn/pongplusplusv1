package pongplusplus.game.gameobjects;

import pongplusplus.game.AbilityOne;
import pongplusplus.game.Board;
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

        randomNumb = random.nextInt(500);

         if (board.getBall().getPos_x() <= Const.SCREEN_WIDTH/4*3){

            if(board.getBall().getPos_y() == pos_y)   {

            }else if (board.getBall().getPos_y()-26 > pos_y && pos_y < 600){
                    pos_y += deltaInSec * 250;
            }else if(board.getBall().getPos_y()-26 < pos_y+57 && pos_y > 61){
                    pos_y -= deltaInSec * 250;
            }
         }
         if(randomNumb == 1 && abilityOne.getCooldown() <= 0 && !abilityOne.isActive()){
             if (board.getRemotablePlate().getAbilityOne().isActive()){
                 board.getRemotablePlate().getAbilityOne().deactivate();
                 abilityOne.setCooldown(25);
             }else{
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
