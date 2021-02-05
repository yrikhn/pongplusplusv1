package pongplusplus.common;

import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;

public class Navigator {

    private Stage stage;
    private Map<SceneType, Scene> sceneMap = new HashMap<>();
    public Navigator(Stage stage) {
        this.stage = stage;
    }
    public void registerScene(SceneType enumScene, Scene scene) {
        sceneMap.put(enumScene, scene);
    }
    public void goTo(SceneType scene) {
        Scene activeScene = sceneMap.get(scene);
        stage.setScene(activeScene);
    }

    }
