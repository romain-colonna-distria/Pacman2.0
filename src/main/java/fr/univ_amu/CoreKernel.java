package fr.univ_amu;

import fr.univ_amu.audio_engine.SoundEngine;
import fr.univ_amu.graphic_engine.GraphicEngine;
import fr.univ_amu.graphic_engine.Window;
import fr.univ_amu.io_engine.IOEngine;
import fr.univ_amu.physic_engine.PhysicEngine;
import javafx.application.Application;

import java.io.IOException;

public class CoreKernel {
    private PhysicEngine physicEngine;
    private GraphicEngine graphicEngine;
    private IOEngine ioEngine;
    private SoundEngine soundEngine;


    public CoreKernel(PhysicEngine physicEngine, GraphicEngine graphicEngine, IOEngine ioEngine, SoundEngine soundEngine) {
        this.physicEngine = physicEngine;
        this.graphicEngine = graphicEngine;
        this.ioEngine = ioEngine;
        this.soundEngine = soundEngine;
    }

    public void updateGame() {
        try {
            //ioEngine.getInput();
            if(physicEngine.updatePhysicElements())
                graphicEngine.updateView(Window.root);
            //soundEngine.playSound();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void startGame(){
        GameLoop gameLoop = new GameLoop(this);
        gameLoop.start();
  
        Application.launch(Window.class);
    }
}
