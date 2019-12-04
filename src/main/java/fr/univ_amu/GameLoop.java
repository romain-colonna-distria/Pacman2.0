package fr.univ_amu;

import javafx.animation.AnimationTimer;


public class GameLoop extends AnimationTimer {
    private CoreKernel kernel;

    public GameLoop(CoreKernel kernel) {
        this.kernel = kernel;
    }

    public void startLoop(){
        this.start();
    }

    @Override
    public void handle(long now) {
        kernel.updateGame();
    }
}
