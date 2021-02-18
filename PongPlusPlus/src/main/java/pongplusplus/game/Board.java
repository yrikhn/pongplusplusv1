package pongplusplus.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import pongplusplus.common.Navigator;
import pongplusplus.common.Util;
import pongplusplus.game.gameobjects.Ball;
import pongplusplus.game.gameobjects.ComputerPlate;
import pongplusplus.game.gameobjects.Gameobject;
import pongplusplus.game.gameobjects.RemotablePlate;

import java.util.concurrent.CopyOnWriteArrayList;

public class Board extends CopyOnWriteArrayList<Gameobject> {
    private KeyEventHandler keyEventHandler;
    private Navigator navigator;
    private Runnable gameLoopStopper;
    private Score score;
    private Difficulty difficulty;

    public Score getScore() {
        return score;
    }

    public Board(KeyEventHandler keyEventHandler, Navigator navigator, Runnable gameLoopStopper, Score score, Difficulty difficulty) {
        this.keyEventHandler = keyEventHandler;
        this.gameLoopStopper = gameLoopStopper;
        this.navigator = navigator;
        this.score = score;
        this.difficulty = difficulty;
    }


    public void generateObject() {
        add(new Ball(Const.SCREEN_WIDTH / 2, Const.SCREEN_WIDTH / 2, this, difficulty.getDifficulty(), score));
        add(new RemotablePlate(keyEventHandler, 970, 280, this));
        add(new ComputerPlate(280, this));
    }


    public void update(double deltaInSec) {
        if (score.isPlayerWon()) {
            navigator.goTo(SceneType.GAMEOVER);
            stop();
        } else if (score.isEnemyWon()) {
            navigator.goTo(SceneType.GAMEOVER);
            stop();
        }

        for (Gameobject object : this) {
            object.update(deltaInSec);
        }

    }


    public void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, pongplusplus.game.Const.SCREEN_WIDTH, pongplusplus.game.Const.SCREEN_HEIGHT);

        gc.setFill(Paint.valueOf("#000000"));
        gc.fillRect(0, 0, 1000, 600);
        gc.setFill(Paint.valueOf("#FFFFFF"));
        gc.fillRect(494.5, 0, 11, 600);
        gc.fillRect(0, 50, 1000, 11);

        gc.setFont(new Font(30));
        gc.fillText("LEFT : ", 15, 35);
        gc.fillText("LEFT : ", 585, 35);

        gc.fillText("RIGHT : ", 230, 35);
        gc.fillText("RIGHT : ", 830, 35);

        displayAbilityAvailability(gc);

        gc.fillText("" + score.getEnemyScore(), 440, 35);
        gc.fillText("" + score.getPlayerScore(), 540, 35);

        for (Gameobject object : this) {
            object.draw(gc);
        }

    }


    private void displayAbilityAvailability(GraphicsContext gc) {
        //LEFT arrow key ability
        if (Math.round(getComputerPlate().getBallSpeedAbility().getCooldown()) > 0) {
            gc.fillText(Math.round(getComputerPlate().getBallSpeedAbility().getCooldown()) + " S", 90, 35);
        } else {
            gc.drawImage(Images.readyIcon, 95, 15);
        }
        if (Math.round(getRemotablePlate().getBallSpeedAbility().getCooldown()) > 0) {
            gc.fillText(Math.round(getRemotablePlate().getBallSpeedAbility().getCooldown()) + " S", 665, 35);
        } else {
            gc.drawImage(Images.readyIcon, 665, 15);
        }

        //RIGHT arrow key ability
        if (Math.round(getComputerPlate().getRemoveEnemyScoreAbility().getCooldown()) > 0) {
            gc.fillText(Math.round(getComputerPlate().getRemoveEnemyScoreAbility().getCooldown()) + " S", 345, 35);
        } else {
            gc.drawImage(Images.readyIcon, 345, 15);
        }
        if (Math.round(getRemotablePlate().getRemoveEnemyScoreAbility().getCooldown()) > 0) {
            gc.fillText(Math.round(getRemotablePlate().getRemoveEnemyScoreAbility().getCooldown()) + " S", 940, 35);
        } else {
            gc.drawImage(Images.readyIcon, 945, 15);
        }

    }


    public Ball getBall() {
        return Util.getAllObjectsFromType(Ball.class, this).get(0);
    }


    public RemotablePlate getRemotablePlate() {
        return Util.getAllObjectsFromType(RemotablePlate.class, this).get(0);
    }


    public ComputerPlate getComputerPlate() {
        return Util.getAllObjectsFromType(ComputerPlate.class, this).get(0);
    }


    private void stop() {
        gameLoopStopper.run();
        clear();
    }

}
