package pongplusplus.game;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyEventHandler implements EventHandler<KeyEvent> {

    private boolean isUpKeyPressed = false;
    private boolean isDownKeyPressed = false;
    private boolean isLeftKeyPressed = false;
    private boolean isRightKeyPressed = false;
    private boolean isWKeyPressed = false;
    private boolean isSKeyPressed = false;
    private boolean isAKeyPressed = false;
    private boolean isDKeyPressed = false;

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
            case RIGHT:
                isRightKeyPressed = pressed;
            case S:
                isSKeyPressed = pressed;
                break;
            case W:
                isWKeyPressed = pressed;
                break;
            case A:
                isAKeyPressed = pressed;
                break;
            case D:
                isDKeyPressed = pressed;
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

    public boolean isRightKeyPressed() {
        return isRightKeyPressed;
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
    public boolean isDKeyPressed() {
        return isDKeyPressed;
    }
}
