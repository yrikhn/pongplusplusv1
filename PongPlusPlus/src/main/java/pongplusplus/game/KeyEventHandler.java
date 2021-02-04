package pongplusplus.game;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyEventHandler implements EventHandler<KeyEvent> {

    private boolean isUpKeyPressed = false;
    private boolean isDownKeyPressed = false;
    private boolean isSpaceKeyPressed = false;

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
            case SPACE:
                isSpaceKeyPressed = pressed;
                break;
        }
    }

    public boolean isUpKeyPressed() {
        return isUpKeyPressed;
    }

    public boolean isDownKeyPressed() {
        return isDownKeyPressed;
    }

    public boolean isSpaceKeyPressed() {
        return isSpaceKeyPressed;
    }
}
