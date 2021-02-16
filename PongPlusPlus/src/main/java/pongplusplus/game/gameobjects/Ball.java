package pongplusplus.game.gameobjects;

import pongplusplus.game.Const;
import pongplusplus.game.Images;
import pongplusplus.game.Points;


public class Ball extends Gameobject {
    private double SPEED;
    private Board board;
    private double balldirx;
    private double balldiry;
    private Points points;
    private double originalSpeed;


    public Ball(double x, double y, Board board, double speed, Points points) {
        super(x, y, Images.ball);
        this.board = board;
        this.SPEED = speed;
        this.balldirx = speed;
        this.balldiry = -speed;
        this.points = points;
        this.originalSpeed = speed;
    }

    @Override
    public void update(double deltaInSec) {

        points.checkWon();
        borderCollisionCheck();
        plateCollisionCheck();
        checkWin();
        pos_x += balldirx;
        pos_y += balldiry;
    }

    public void resetSpeed() {
        SPEED = originalSpeed;
    };

    private void checkWin() {
        if (pos_x + 20 >= Const.SCREEN_WIDTH) {

            pos_x = Const.SCREEN_WIDTH / 2 - 10;
            pos_y = Const.SCREEN_HEIGHT / 2 - 10;

            balldirx = -SPEED;
            points.addGegnerPoints();


        }

        if (pos_x <= 0) {

            pos_x = Const.SCREEN_WIDTH / 2 - 10;
            pos_y = Const.SCREEN_HEIGHT / 2 - 10;

            balldirx = SPEED;
            points.addPlayerPoints();

        }
    }


    private void borderCollisionCheck() {
        if (pos_y + 14 >= Const.SCREEN_HEIGHT) {
            balldiry = -SPEED;
        }

        if (pos_y <= 52) {
            balldiry = SPEED;
        }
    }

    private void plateCollisionCheck() {
        if (pos_x < board.getRemotablePlate().pos_x + 5 && pos_x > board.getRemotablePlate().pos_x - 20 && pos_y - 14 < board.getRemotablePlate().pos_y + 57 && pos_y > board.getRemotablePlate().pos_y) {
            balldirx = -SPEED;
        } else if (pos_x < board.getComputerPlate().pos_x && pos_x > board.getComputerPlate().pos_x - 10 && pos_y - 14 < board.getComputerPlate().pos_y + 57 && pos_y > board.getComputerPlate().pos_y) {
            balldirx = SPEED;
        }
    }

    public void setSPEED(double SPEED) {
        this.SPEED = SPEED;
        if (balldirx < 0) {
            balldirx = -1 * SPEED;
        } else if (balldirx > 0) {
            balldirx = SPEED;
        }
        if (balldiry < 0) {
            balldiry = -1 * SPEED;
        } else if (balldiry > 0) {
            balldiry = SPEED;
        }
    }
}
