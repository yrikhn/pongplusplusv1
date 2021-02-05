package pongplusplus.game.gameobjects;

import javafx.scene.image.Image;
import javafx.scene.text.Text;
import pongplusplus.game.Const;


public class Ball extends Gameobject{
    private Board board;
    private int balldirx = 3, balldiry = -3;


    public Ball(double x, double y, Image image, Board board){
        super(x,y, image);
        this.board = board;
    }


    @Override
    public void update(double deltaInSec) {
        pos_x += balldirx;
        pos_y += balldiry;

        board.getPoint().checkWon();

        if(pos_y + 14 >= Const.SCREEN_HEIGHT){
            balldiry = -3;
        }

        if(pos_y <= 61){
            balldiry = 3;
        }

        if(pos_x +20 >= Const.SCREEN_WIDTH){

            pos_x = Const.SCREEN_WIDTH /2 -10;
            pos_y = Const.SCREEN_HEIGHT /2 -10;

            balldirx = -3;
            board.getPoint().addGegnerPoints();


        }

        if(pos_x <= 0){

            pos_x = Const.SCREEN_WIDTH /2 -10;
            pos_y = Const.SCREEN_HEIGHT /2 -10;

            balldirx = 3;
            board.getPoint().addPlayerPoints();

        }
                

        if(pos_x < board.getPlate().pos_x && pos_x > board.getPlate().pos_x -20 && pos_y -20 < board.getPlate().pos_y + 57 && pos_y > board.getPlate().pos_y){
            balldirx = -3;
        }

    }
}
