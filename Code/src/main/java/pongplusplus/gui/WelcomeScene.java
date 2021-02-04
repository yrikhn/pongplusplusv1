package pongplusplus.gui;

public class WelcomeScene {
    public WelcomeScene(Navigator navigator) {

            super(navigator, Images.WELCOME_BACKGROUND);

            setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.SPACE){
                    navigator.goTo(SceneType.INGAME);
                }
            });
        }
}
