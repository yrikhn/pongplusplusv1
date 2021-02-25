package pongplusplus.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import pongplusplus.common.Navigator;
import pongplusplus.common.Util;
import pongplusplus.game.gameobjects.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Board extends CopyOnWriteArrayList<Gameobject> {
    private KeyEventHandler keyEventHandler;
    private Navigator navigator;
    private Runnable gameLoopStopper;
    private Score score;
    private GameSetting gameSetting;
    private PlateObject enemyPlate;

    public Board(KeyEventHandler keyEventHandler, Navigator navigator, Runnable gameLoopStopper, Score score, GameSetting gameSetting) {
        this.keyEventHandler = keyEventHandler;
        this.gameLoopStopper = gameLoopStopper;
        this.navigator = navigator;
        this.score = score;
        this.gameSetting = gameSetting;
    }

    public void generateObject() {
        add(new Ball(Const.SCREEN_WIDTH / 2, Const.SCREEN_WIDTH / 2, this, gameSetting.getDifficulty(), score));
        add(new ControllablePlate_Arrow(keyEventHandler, 970, 280, this));
        decideGamemode();

    }

    public void decideGamemode() {
        if (gameSetting.isSingleplayer()) {
            add(new ComputerPlate(280, this, getControllablePlate_Arrow()));
            getControllablePlate_Arrow().setEnemyPlate(getComputerPlate());
            enemyPlate = getComputerPlate();
        } else {
            add(new ControllablePlate_WASD(keyEventHandler, 28, 280, this, getControllablePlate_Arrow()));
            getControllablePlate_Arrow().setEnemyPlate(getControllablePlate_WASD());
            enemyPlate = getControllablePlate_WASD();
        }
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
        gc.clearRect(0, 0, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        gc.setFill(Paint.valueOf("#000000"));
        gc.fillRect(0, 0, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        gc.setFill(Paint.valueOf("#FFFFFF"));
        gc.fillRect(494.5, 0, 11, Const.SCREEN_HEIGHT);
        gc.fillRect(0, 50, Const.SCREEN_WIDTH, 11);
        gc.setFont(new Font(30));
        gc.fillText("A : ", 23, 35);
        gc.fillText("D : ", 167, 35);
        gc.fillText("<- : ", 718, 35);
        gc.fillText("-> : ", 887, 35);
        displayAbilityAvailability(gc);
        gc.setFont(new Font(40));
        gc.fillText("" + score.getEnemyScore(), 445, 35);
        gc.fillText("" + score.getPlayerScore(), 529, 35);
        for (Gameobject object : this) {
            object.draw(gc);
        }
    }

    private void displayAbilityAvailability(GraphicsContext gc) {
        if (Math.round(getControllablePlate_Arrow().getBallSpeedManipulator().getCooldown()) > 0) {
            gc.fillText(Math.round(getControllablePlate_Arrow().getBallSpeedManipulator().getCooldown()) + " S", 768, 35);
        } else {
            gc.drawImage(Images.readyIcon, 772, 15);
        }
        if (Math.round(getControllablePlate_Arrow().getPointStealer().getCooldown()) > 0) {
            gc.fillText(Math.round(getControllablePlate_Arrow().getPointStealer().getCooldown()) + " S", 935, 35);
        } else {
            gc.drawImage(Images.readyIcon, 939, 15);
        }
        if (Math.round(enemyPlate.getBallSpeedManipulator().getCooldown()) > 0) {
            gc.fillText(Math.round(enemyPlate.getBallSpeedManipulator().getCooldown()) + " S", 65, 35);
        } else {
            gc.drawImage(Images.readyIcon, 69, 15);
        }
        if (Math.round(enemyPlate.getPointStealer().getCooldown()) > 0) {
            gc.fillText(Math.round(enemyPlate.getPointStealer().getCooldown()) + " S", 218, 35);
        } else {
            gc.drawImage(Images.readyIcon, 213, 15);
        }
    }


    public Ball getBall() {
        return Util.getAllObjectsFromType(Ball.class, this).get(0);
    }

    public ControllablePlate_Arrow getControllablePlate_Arrow() {
        return Util.getAllObjectsFromType(ControllablePlate_Arrow.class, this).get(0);
    }

    public ControllablePlate_WASD getControllablePlate_WASD() {
        return Util.getAllObjectsFromType(ControllablePlate_WASD.class, this).get(0);
    }

    public ComputerPlate getComputerPlate() {
        return Util.getAllObjectsFromType(ComputerPlate.class, this).get(0);
    }

    public PlateObject getEnemyPlate() {
        return enemyPlate;
    }

    public Score getScore() {
        return score;
    }

    private void stop() {
        gameLoopStopper.run();
        clear();
    }
}
