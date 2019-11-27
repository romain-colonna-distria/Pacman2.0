package fr.univ_amu;

import fr.univ_amu.audio_name.SoundEngine;
import fr.univ_amu.io_engine.IOEngine;
import fr.univ_amu.physic_engine.PhysicEngine;

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
            boolean canMove = physicEngine.updatePhysicElements();
            if(canMove)
                graphicEngine.updateElementsInStage();
            //soundEngine.playSound();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
