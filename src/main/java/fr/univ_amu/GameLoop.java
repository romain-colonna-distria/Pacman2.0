package fr.univ_amu;

import javafx.animation.AnimationTimer;

import java.io.IOException;


public class GameLoop extends AnimationTimer {

    public void startLoop(){
        this.start();
    }

    @Override
    public void handle(long now) {
        try {
            CoreKernel.updateGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
