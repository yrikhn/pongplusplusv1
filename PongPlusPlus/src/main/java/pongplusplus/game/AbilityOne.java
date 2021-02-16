package pongplusplus.game;

import pongplusplus.game.gameobjects.Ball;

public class AbilityOne{
    private final double pos_x;
    private double cooldown;
    private Ball ball;

    public AbilityOne(Ball ball, double pos_x){
        this.ball = ball;
        this.pos_x = pos_x;
    }

    public void activate() {
        cooldown = 10;
        if (pos_x == 970) {
            if (ball.getPos_x() > Const.SCREEN_WIDTH/2+14){
                ball.setSPEED(2);
            }else if (ball.getPos_x() < Const.SCREEN_WIDTH/2+14){
                ball.setSPEED(5);
            }
        }else{
            if (ball.getPos_x() < Const.SCREEN_WIDTH/2+14){
                ball.setSPEED(2);
            }else if (ball.getPos_x() > Const.SCREEN_WIDTH/2+14){
                ball.setSPEED(5);
            }
        }
    }


}
