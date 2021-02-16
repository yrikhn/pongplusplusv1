package pongplusplus.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import pongplusplus.game.gameobjects.Ball;

import java.util.Timer;
import java.util.TimerTask;

public class AbilityOne {
    private final double pos_x;
    private double cooldown;
    private Ball ball;
    private double startTime = 10;
    private boolean active = false;

    public AbilityOne(Ball ball, double pos_x) {
        this.ball = ball;
        this.pos_x = pos_x;
    }

    public void activate() {
        active = true;
    }

    public double getStartTime() {
        return startTime;
    }

    public boolean isActive() {
        return active;
    }

    public void update(double deltaTime) {
        System.out.println(startTime - deltaTime);
        startTime -= deltaTime;

        if (startTime > 0) {
            System.out.println("test");
            if (pos_x == 970) {
                if (ball.getPos_x() > Const.SCREEN_WIDTH / 2 + 14) {
                    ball.setSPEED(2);
                } else if (ball.getPos_x() < Const.SCREEN_WIDTH / 2 + 14) {
                    ball.setSPEED(5);
                }
            } else {
                if (ball.getPos_x() < Const.SCREEN_WIDTH / 2 + 14) {
                    ball.setSPEED(2);
                } else if (ball.getPos_x() > Const.SCREEN_WIDTH / 2 + 14) {
                    ball.setSPEED(5);
                }
            }
        }
        if (startTime <= 0) {
            ball.resetSpeed();
            active = false;
            startTime = 10;
        }

    }

}
