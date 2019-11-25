package fr.univ_amu.io_engine;

import javafx.scene.input.KeyEvent;

public class KeyboardControl extends Control implements KeyListener {

    public KeyboardControl() {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case LEFT:
                this.setLeft(true);
                break;
            case RIGHT:
                this.setRight(true);
                break;
            case UP:
                this.setUp(true);
                break;
            case DOWN:
                this.setDown(true);
                break;
        }
    }
}
