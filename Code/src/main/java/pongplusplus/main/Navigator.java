package pongplusplus.main;

import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;

public class Navigator {

    private Stage stage;
    private Map<Scene, Scene> sceneMap = new HashMap<>();
    public Navigator(Stage stage) {
        this.stage = stage;
    }
    public void registerScene(Scene sceneType, Scene scene) {
        sceneMap.put(sceneType, scene);
    }
    public void navigateTo(Scene scene) {
        stage.setScene(sceneMap.get(scene));
        stage.show();
    }


}