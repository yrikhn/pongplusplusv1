package pongplusplus.game;

import pongplusplus.game.gameobjects.Gameobject;
import pongplusplus.game.gameobjects.ControllablePlate_Arrow;

public class PointStealer {
    private Board board;
    private double cooldown = 0;
    private boolean active = false;
    private Score score;
    private Gameobject player;


    public PointStealer(Board board, Gameobject player) {
        this.board = board;
        this.score = board.getScore();
        this.player = player;
    }


    public void update(double deltaInSec) {
        if (cooldown >= 0) {
            cooldown -= deltaInSec;
        }
        if (active) {
            if (player instanceof ControllablePlate_Arrow) {
                if (score.getEnemyScore() != 0) {
                    enemyPointStealer();
                    deactivate();
                }
            } else {
                if (score.getPlayerScore() != 0) {
                    playerPointStealer();
                    deactivate();
                }
            }
        }
    }

    public void deactivate() {
        active = false;
    }

    public void activate() {
        active = true;
    }

    public void setCooldown(double cooldown) {
        this.cooldown = cooldown;
    }

    public double getCooldown() {
        return cooldown;
    }

    public void enemyPointStealer() {
        score.removeEnemyPoint();
        score.addPlayerPoint();
    }

    public void playerPointStealer() {
        score.addEnemyPoint();
        score.removePlayerPoint();
    }
}
