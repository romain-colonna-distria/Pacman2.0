package fr.univ_amu;

import fr.univ_amu.audio_engine.SoundEngine;
import fr.univ_amu.audio_engine.SoundLoader;
import fr.univ_amu.entity.Pacman;
import fr.univ_amu.graphic_engine.GraphicEngine;
import fr.univ_amu.graphic_engine.Window;
import fr.univ_amu.ia_engine.IA;
import fr.univ_amu.io_engine.InputsController;
import fr.univ_amu.physic_engine.PhysicEngine;
import fr.univ_amu.utils.Direction;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CoreKernel {
    private Direction desiredDirection = null;
    private IA ia;
    private int fps;

    private List<InputsController> inputsControls = new ArrayList<>();


    public void startGame() throws IOException {
        GraphicEngine.createStaticsElementsView();
        GraphicEngine.createDynamicsElementsView();
        GraphicEngine.refreshWindow();
        GraphicEngine.updateInteractableElements(); //pour les replacer au premier plan

        ia = new IA();

        SoundEngine.initSounds(new SoundLoader("src/main/resources/sound_config.conf"));


        GameLoop gameLoop = new GameLoop(this);

        SoundEngine.playSound("intro");
        gameLoop.startLoop();

        GraphicEngine.launchWindow();
    }

    public void updateGame() {
        if(Window.getViewsImage().size() < 1){
            System.err.println("Empty window. No elements. Exit.");
            System.exit(1);
        }
        if(inputsControls.size() < 1){
            System.err.println("No InputsController detected.");
        }

        if(Window.getStage() != null) {
            Window.getStage().setTitle(
                    "fps: " +
                            "    Pacman" +
                            "    Score: " + GameBoard.getInstance().getPacman().getScore() +
                            "    Vie: " + GameBoard.getInstance().getPacman().getLifes()
            );
        }

        Direction newDirection = inputsControls.get(0).getDirection();
        Direction currentDirection = GameBoard.getInstance().getPacman().getCurrentDirection();

        if(newDirection != null) {
            desiredDirection = newDirection;
            GameBoard.getInstance().getPacman().setCurrentDirection(newDirection);
        } else if(desiredDirection != null){
            GameBoard.getInstance().getPacman().setCurrentDirection(desiredDirection);
        }

        if(!PhysicEngine.updatePhysicElements()) {
            GraphicEngine.updateDynamicsElements();
        } else {
            GameBoard.getInstance().getPacman().setCurrentDirection(currentDirection);
            if(!PhysicEngine.updatePhysicElements()) {
                GraphicEngine.updateDynamicsElements();
            }
        }

        ia.run();
    }


    public void addInputsControl(InputsController inputsControl){
        inputsControls.add(inputsControl);
        Window.getScene().addEventHandler(inputsControl.getEventType(), inputsControl);
    }

    public void removeInputsControl(InputsController inputsControl){
        this.inputsControls.remove(inputsControl);
        Window.getScene().removeEventHandler(inputsControl.getEventType(), inputsControl);
    }
}
