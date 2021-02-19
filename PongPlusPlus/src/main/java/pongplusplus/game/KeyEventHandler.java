package pongplusplus.game;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyEventHandler implements EventHandler<KeyEvent> {

    private boolean isUpKeyPressed = false;
    private boolean isDownKeyPressed = false;
    private boolean isLeftKeyPressed = false;
    private boolean isWKeyPressed = false;
    private boolean isSKeyPressed = false;
    private boolean isAKeyPressed = false;

    @Override
    public void handle(KeyEvent event) {
        boolean pressed = event.getEventType() == KeyEvent.KEY_PRESSED;

        switch (event.getCode()) {
            case DOWN:
                isDownKeyPressed = pressed;
                break;
            case UP:
                isUpKeyPressed = pressed;
                break;
            case LEFT:
                isLeftKeyPressed = pressed;
                break;
            case S:
                isSKeyPressed = pressed;
                break;
            case W:
                isWKeyPressed = pressed;
                break;
            case A:
                isAKeyPressed = pressed;
                break;

        }
    }

    public boolean isUpKeyPressed() {
        return isUpKeyPressed;
    }

    public boolean isDownKeyPressed() {
        return isDownKeyPressed;
    }

    public boolean isLeftKeyPressed() {
        return isLeftKeyPressed;
    }

    public boolean isWKeyPressed() {
        return isWKeyPressed;
    }

    public boolean isSKeyPressed() {
        return isSKeyPressed;
    }

    public boolean isAKeyPressed() {
        return isAKeyPressed;
    }
}
