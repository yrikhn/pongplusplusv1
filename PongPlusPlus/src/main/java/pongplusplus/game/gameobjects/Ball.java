package pongplusplus.game.gameobjects;

import pongplusplus.game.Const;
import pongplusplus.game.Images;


public class Ball extends Gameobject{
    private double SPEED;
    private Board board;
    private double balldirx;
    private double balldiry;


    public Ball(double x, double y, Board board, double speed){
        super(x,y, Images.ball);
        this.board = board;
        this.SPEED = speed;
        this.balldirx = speed;
        this.balldiry = -speed;
    }

    @Override
    public void update(double deltaInSec) {
        pos_x += balldirx;
        pos_y += balldiry;

        board.getPoint().checkWon();
        borderCollisionCheck();
        plateCollisionCheck();
        checkWin();

    }

    private void checkWin(){
        if(pos_x +20 >= Const.SCREEN_WIDTH){

            pos_x = Const.SCREEN_WIDTH /2 -10;
            pos_y = Const.SCREEN_HEIGHT /2 -10;

            balldirx = -SPEED;
            board.getPoint().addGegnerPoints();


        }

        if(pos_x <= 0){

            pos_x = Const.SCREEN_WIDTH /2 -10;
            pos_y = Const.SCREEN_HEIGHT /2 -10;

            balldirx = SPEED;
            board.getPoint().addPlayerPoints();

        }
    }


    private void borderCollisionCheck(){
        if(pos_y + 14 >= Const.SCREEN_HEIGHT){
            balldiry = -SPEED;
        }

        if(pos_y <= 52){
            balldiry = SPEED;
        }
    }
    private void plateCollisionCheck(){
        if(pos_x < board.getRemotablePlate().pos_x + 5 && pos_x > board.getRemotablePlate().pos_x -20 && pos_y - 14 < board.getRemotablePlate().pos_y + 57 && pos_y > board.getRemotablePlate().pos_y){
            balldirx = -SPEED;
        } else if(pos_x < board.getComputerPlate().pos_x && pos_x > board.getComputerPlate().pos_x - 20 && pos_y - 14 < board.getComputerPlate().pos_y + 57 && pos_y > board.getComputerPlate().pos_y){
            balldirx = SPEED;
        }
    }

}
