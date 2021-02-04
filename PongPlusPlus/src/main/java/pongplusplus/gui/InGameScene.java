package pongplusplus.gui;



import javafx.scene.paint.Paint;
import pongplusplus.common.BaseScene;
import pongplusplus.common.Navigator;

public class InGameScene extends BaseScene {
    public InGameScene(Navigator navigator) {
        super(navigator);
        gc.setFill(Paint.valueOf("#000000"));
        gc.fillRect(0,0,1000,600);
        gc.setFill(Paint.valueOf("#FFFFFF"));
        gc.fillRect(492.5,0,15,600);
        gc.fillRect(0,50,1000,15);
    }
}

