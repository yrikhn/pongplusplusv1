package pongplusplus.game.gameobjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import pongplusplus.common.Navigator;
import pongplusplus.common.SceneType;
import pongplusplus.common.Util;
import pongplusplus.game.Const;
import pongplusplus.game.Difficulty;
import pongplusplus.game.KeyEventHandler;
import pongplusplus.game.Points;

import java.util.concurrent.CopyOnWriteArrayList;

public class Board extends CopyOnWriteArrayList<Gameobject> {
    private KeyEventHandler keyEventHandler;
    private Navigator navigator;
    private Runnable gameLoopStopper;
    private Points points;
    private Difficulty difficulty;


    public Board(KeyEventHandler keyEventHandler, Navigator navigator, Runnable gameLoopStopper, Points points, Difficulty difficulty) {
        this.keyEventHandler = keyEventHandler;
        this.gameLoopStopper = gameLoopStopper;
        this.navigator = navigator;
        this.points = points;
        this.difficulty = difficulty;
    }

    public void generateObject(){
        add(new Ball(Const.SCREEN_WIDTH / 2, Const.SCREEN_WIDTH / 2, this, difficulty.getDifficulty(), points));
        add(new RemotablePlate(keyEventHandler, 970,280, this));
        add(new ComputerPlate(280, this));

    }

    public void update(double deltaInSec){
        getBall().update(deltaInSec);
        getRemotablePlate().update(deltaInSec);
        getComputerPlate().update(deltaInSec);
        if (points.isPlayerWon()) {
            navigator.goTo(SceneType.GAMEOVER);
            stop();
        } else if(points.isGegnerWon()) {
            navigator.goTo(SceneType.GAMEOVER);
            stop();
        }
    }

    public void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, pongplusplus.game.Const.SCREEN_WIDTH, pongplusplus.game.Const.SCREEN_HEIGHT);
        gc.setFill(Paint.valueOf("#000000"));
        gc.fillRect(0,0,1000,600);
        gc.setFill(Paint.valueOf("#FFFFFF"));
        gc.fillRect(494.5,0,11,600);
        gc.fillRect(0,50,1000,11);

        gc.setFont(new Font(40));
        gc.fillText("" + points.getGegnerPoints(), 440, 35);
        gc.fillText("" + points.getPlayerPoints(), 530, 35);

        for (Gameobject object : this) {
            object.draw(gc);
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
