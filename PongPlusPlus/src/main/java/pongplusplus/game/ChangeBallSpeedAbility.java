package pongplusplus.game;


import pongplusplus.game.gameobjects.Ball;

public class ChangeBallSpeedAbility {
    private double pos_x;
    private double cooldown = 0;
    private Ball ball;
    private double startTime = 10;
    private boolean active = false;

    public ChangeBallSpeedAbility(Ball ball, double pos_x) {
        this.ball = ball;
        this.pos_x = pos_x;
    }


    public void update(double deltaInSec) {

        if (cooldown >= 0) {
            cooldown -= deltaInSec;
        }
        if (active) {
            startTime -= deltaInSec;
            if (startTime > 0) {
                if (pos_x == 970) {
                    if (ball.getPos_x() > Const.SCREEN_WIDTH / 2) {
                        ball.setSPEED(2);
                    } else if (ball.getPos_x() < Const.SCREEN_WIDTH / 2) {
                        ball.setSPEED(6);
                    }
                } else {
                    if (ball.getPos_x() < Const.SCREEN_WIDTH / 2) {
                        ball.setSPEED(2);
                    } else if (ball.getPos_x() > Const.SCREEN_WIDTH / 2) {
                        ball.setSPEED(6);
                    }
                }
            }
        }

        if (startTime <= 0) {
            deactivate();
        }

    }

    public void activate() {
        active = true;
    }

    public void deactivate() {
        active = false;
        startTime = 10;
        ball.resetSpeed();
        ball.setImage(Images.ball);
    }

    public boolean isActive() {
        return active;
    }

    public double getCooldown() {
        return cooldown;
    }

    public void setCooldown(double cooldown) {
        this.cooldown = cooldown;
    }


}
