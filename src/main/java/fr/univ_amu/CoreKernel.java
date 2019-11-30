package fr.univ_amu;

import fr.univ_amu.audio_engine.SoundEngine;
import fr.univ_amu.graphic_engine.GraphicEngine;
import fr.univ_amu.graphic_engine.Window;
import fr.univ_amu.io_engine.InputsController;
import fr.univ_amu.physic_engine.PhysicEngine;
import fr.univ_amu.utils.Direction;
import javafx.application.Application;
import javafx.event.EventType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CoreKernel {
    private PhysicEngine physicEngine;
    private GraphicEngine graphicEngine;
    private SoundEngine soundEngine;
    private Direction desiredDirection = null;
    private int fps;

    private List<InputsController> inputsControls = new ArrayList<>();


    public CoreKernel(PhysicEngine physicEngine, GraphicEngine graphicEngine, SoundEngine soundEngine) {
        this.physicEngine = physicEngine;
        this.graphicEngine = graphicEngine;
        this.soundEngine = soundEngine;
    }

    public void startGame() throws IOException {
        graphicEngine.loadStaticsElements();
        graphicEngine.loadDynamicsElements();
        GraphicEngine.displayElements(Window.root);
        graphicEngine.updateInteractableElements(); //pour les replacer au premier plan

        GameLoop gameLoop = new GameLoop(this);
        gameLoop.start();

        Application.launch(Window.class);
    }

    public void updateGame() {
        if(Window.root.getChildren().size() < 1){
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

        if(!physicEngine.updatePhysicElements()) {
            graphicEngine.updateDynamicsElements();
        } else {
            GameBoard.getInstance().getPacman().setCurrentDirection(currentDirection);
            if(!physicEngine.updatePhysicElements()) {
                graphicEngine.updateDynamicsElements();
            }
        }


        //soundEngine.playSound();
    }


    public void addInputsControl(EventType eventType, InputsController inputsControl){
        inputsControls.add(inputsControl);
        Window.theScene.addEventHandler(eventType, inputsControl);
    }

    public void removeInputsControl(EventType eventType, InputsController inputsControl){
        this.inputsControls.remove(inputsControl);
        Window.theScene.removeEventHandler(eventType, inputsControl);
    }
}
