package pongplusplus.common;

import javafx.scene.Scene;
import javafx.stage.Stage;
import pongplusplus.gui.GameOverScene;
import pongplusplus.gui.WelcomeScene;
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

    public void goTo(SceneType enumScene) {
        Scene activeScene = sceneMap.get(enumScene);
        if (activeScene instanceof Initializable){
            ((Initializable)activeScene).onInitialize();
        }
        if (activeScene instanceof GameOverScene){
            activeScene = GameOverScene.getScene();
        }else if (activeScene instanceof WelcomeScene){
            activeScene = WelcomeScene.getScene();
        }
        stage.setScene(activeScene);
    }

    }
