package pongplusplus.game.gameobjects;

import pongplusplus.game.Const;
import pongplusplus.game.Images;

public class ComputerPlate extends Gameobject{
    private Board board;
    public ComputerPlate (double y, Board board){
        super(28, y, Images.plate);
        this.board = board;

    }

    @Override
    public void update(double deltaInSec) {
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
    }
}
