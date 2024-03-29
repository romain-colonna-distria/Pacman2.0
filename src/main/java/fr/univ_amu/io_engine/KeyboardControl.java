package fr.univ_amu.io_engine;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;

public class KeyboardControl extends Control implements KeyListener {

    private HashMap<String, KeyCode> directions = new HashMap<>();

    public KeyboardControl() {
        directions.put("Left", KeyCode.getKeyCode("Q"));
        directions.put("Right", KeyCode.getKeyCode("D"));
        directions.put("Up", KeyCode.getKeyCode("Z"));
        directions.put("Down", KeyCode.getKeyCode("S"));
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (directions.containsValue(keyEvent.getCode())) {
            if (keyEvent.getCode() == directions.get("Left")) {
                this.setAll(false);
                this.setLeft(true);
            }
            if (keyEvent.getCode() == directions.get("Right")) {
                this.setAll(false);
                this.setRight(true);
            }
            if (keyEvent.getCode() == directions.get("Up")) {
                this.setAll(false);
                this.setUp(true);
            }
            if (keyEvent.getCode() == directions.get("Down")) {
                this.setAll(false);
                this.setDown(true);
            }
        }

    }

}
