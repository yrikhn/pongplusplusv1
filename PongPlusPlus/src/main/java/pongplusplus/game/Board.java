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


    public Board(KeyEventHandler keyEventHandler, Navigator navigator, Runnable gameLoopStopper, Score score, GameSetting gameSetting) {
        this.keyEventHandler = keyEventHandler;
        this.gameLoopStopper = gameLoopStopper;
        this.navigator = navigator;
        this.score = score;
        this.gameSetting = gameSetting;
    }


    public void generateObject() {
        add(new Ball(Const.SCREEN_WIDTH / 2, Const.SCREEN_WIDTH / 2, this, gameSetting.getDifficulty(), score));
        add(new RemotablePlate_Arrow(keyEventHandler, 970, 280, this));
        decideGamemode();

    }
    public void decideGamemode(){
        if (gameSetting.isSingleplayer()){
            add(new ComputerPlate(280, this));
        } else {
            add(new RemotablePlate_WASD(keyEventHandler, 28, 280, this));
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
        gc.clearRect(0, 0, pongplusplus.game.Const.SCREEN_WIDTH, pongplusplus.game.Const.SCREEN_HEIGHT);

        gc.setFill(Paint.valueOf("#000000"));
        gc.fillRect(0, 0, 1000, 600);
        gc.setFill(Paint.valueOf("#FFFFFF"));
        gc.fillRect(494.5, 0, 11, 600);
        gc.fillRect(0, 50, 1000, 11);

        gc.setFont(new Font(30));
        gc.fillText("Q : ", 35, 35);
        gc.fillText("Q : ", 870, 35);
        displayAbilityAvailability(gc);

        gc.fillText("" + score.getEnemyScore(), 440, 35);
        gc.fillText("" + score.getPlayerScore(), 540, 35);

        for (Gameobject object : this) {
            object.draw(gc);
        }

    }


    private void displayAbilityAvailability(GraphicsContext gc) {
        if (Math.round(getArrowRemotablePlate().getAbilityOne().getCooldown()) > 0) {
            gc.fillText(Math.round(getArrowRemotablePlate().getAbilityOne().getCooldown()) + " S", 915, 35);
        } else {
            gc.drawImage(Images.readyIcon, 915, 15);
        }
        if (gameSetting.isSingleplayer()) {
            if (Math.round(getComputerPlate().getAbilityOne().getCooldown()) > 0) {
                gc.fillText(Math.round(getComputerPlate().getAbilityOne().getCooldown()) + " S", 80, 35);
            } else {
                gc.drawImage(Images.readyIcon, 80, 15);
            }

        } else {
            if (Math.round(getWASDRemotablePlate().getAbilityOne().getCooldown()) > 0) {
                gc.fillText(Math.round(getWASDRemotablePlate().getAbilityOne().getCooldown()) + " S", 80, 35);
            } else {
                gc.drawImage(Images.readyIcon, 80, 15);
            }
        }
    }


    public Ball getBall() {
        return Util.getAllObjectsFromType(Ball.class, this).get(0);
    }


    public RemotablePlate_Arrow getArrowRemotablePlate() {
        return Util.getAllObjectsFromType(RemotablePlate_Arrow.class, this).get(0);
    }
    public RemotablePlate_WASD getWASDRemotablePlate() {
        return Util.getAllObjectsFromType(RemotablePlate_WASD.class, this).get(0);
    }

    public ComputerPlate getComputerPlate() {
        return Util.getAllObjectsFromType(ComputerPlate.class, this).get(0);
    }

    public GameSetting getGameSetting() {
        return gameSetting;
    }

    private void stop() {
        gameLoopStopper.run();
        clear();
    }

}
