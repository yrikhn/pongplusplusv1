package pongplusplus.game;


import pongplusplus.game.gameobjects.ComputerPlate;
import pongplusplus.game.gameobjects.Gameobject;
import pongplusplus.game.gameobjects.RemotablePlate;

public class RemoveEnemyScoreAbility {
    private Board board;
    private double cooldown = 0;
    private boolean active = false;
    private Score score;
    private Gameobject player;


    public RemoveEnemyScoreAbility(Board board, Gameobject player) {
        this.board = board;
        this.score = board.getScore();
        this.player = player;
    }

    public double getCooldown() {
        return cooldown;
    }

    public boolean isActive() {
        return active;
    }

    public void update(double deltaInSec) {
        if (cooldown >= 0) {
            cooldown -= deltaInSec;
        }

        if (active) {
            if (player instanceof RemotablePlate) {
                if (score.getEnemyScore() != 0) {
                    score.enemyPointStealer();
                    deactivate();
                }
            } else if (player instanceof ComputerPlate) {
                if (score.getPlayerScore() != 0) {
                    score.playerPointStealer();
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
}
