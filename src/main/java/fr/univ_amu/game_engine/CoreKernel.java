package fr.univ_amu.game_engine;

import fr.univ_amu.game_engine.behavior.Impassable;
import fr.univ_amu.game_engine.behavior.Interactable;
import fr.univ_amu.game_engine.behavior.Playable;
import fr.univ_amu.game_engine.element.DynamicElement;
import fr.univ_amu.game_engine.element.Element;
import fr.univ_amu.game_engine.graphic_engine.GraphicEngine;
import fr.univ_amu.game_engine.graphic_engine.Window;
import fr.univ_amu.game_engine.io_engine.InputsController;
import fr.univ_amu.game_engine.physic_engine.PhysicEngine;
import fr.univ_amu.game_engine.rule.GameRules;

import java.io.IOException;
import java.util.*;

public class CoreKernel {
    private boolean alreadyLaunch = false;
    private int fps;

    private static GameLoop gameLoop = new GameLoop();

    private GameRules gameRules;

    private static GameState saveGameState;
    private static GameState actualgameState;

    public CoreKernel(GameRules gameRules){
        this.gameRules = gameRules;
    }

    public static void startGame() throws IOException {
        GraphicEngine.createStaticsElementsView();
        GraphicEngine.createDynamicsElementsView();
        GraphicEngine.refreshWindow();
        GraphicEngine.updateInteractableElements(); //pour les replacer au premier plan

        List<Element> elements = new ArrayList<>(GraphicEngine.elementViewMap.keySet());
        //List<ImageView> views = new ArrayList<>(GraphicEngine.elementViewMap.values());

        saveGameState = new GameState(elements);

        for(Element e : GraphicEngine.getDynamicElements()){
            if(e instanceof Playable && ((Playable) e).getInputControl() != null) addInputsControl(((Playable) e).getInputControl());
        }

        gameLoop = new GameLoop();
        gameLoop.startLoop();

        GraphicEngine.launchWindow();
    }

    public static void restartGame(){
        //GraphicEngine.removeElements(saveGameState.getElementPositionMap());
        GraphicEngine.addElements(saveGameState.getElementPositionMap(), true);
        GraphicEngine.refreshWindow();

        //gameLoop = new GameLoop();
        //gameLoop.start();
    }

    public static void updateGame() throws IOException {
        if(Window.root.getChildren().size() < 1){
            System.err.println("Empty window. No elements. Exit.");
            System.exit(1);
        }

        //TODO: suppr l'appel a GameBoard
        /*
        if(Window.getStage() != null) {
            Window.getStage().setTitle(
                            "Pacman" +
                            "    fps: " +
                            "    Score: " + GameBoard.getInstance().getPacman().getScore() +
                            "    Vie: " + GameBoard.getInstance().getPacman().getLifes()
            );
        }*/

        HashMap<DynamicElement, Set<Element>> collisions;
        HashMap<DynamicElement, Set<Element>> collisionsAfterRules;
        Set<Element> secondCollisions = new HashSet<>();

        /* met a jout les direction de tout les éléments jouable a partir de l'input controller */
        for(Element p : GraphicEngine.getPlaybleElements()){
            ((Playable) p).updateDirectionFromInput();
        }



        if((collisions = PhysicEngine.getNextCollisions()).keySet().size() > 0) { //si collisions
            for(DynamicElement de : GraphicEngine.getDynamicElements()){
                boolean canMove = true;
                if(collisions.keySet().contains(de)) { //collisiosn contient tout élement impassable et/ou interactable
                    for (Element e : collisions.get(de)) {
                        if(e instanceof Impassable) canMove = false;
                        if(de instanceof Playable && e instanceof Impassable) {
                            ((Playable) de).undoUpdateDirection();
                        }
                        if (e instanceof Interactable) ((Interactable) e).interact(de);
                    }

                    if(!canMove){
                        canMove = true;
                        secondCollisions = PhysicEngine.getNextElementCollisions(de);
                        for (Element e : secondCollisions) {
                            if(e instanceof Impassable) canMove = false;
                            if (e instanceof Interactable) ((Interactable) e).interact(de);
                        }
                        if(!canMove) de.setCurrentDirection(null);
                        else de.move();
                    }
                } else {
                    de.move();
                }
            }
            GraphicEngine.updateDynamicsElements();
        } else {
            for(DynamicElement de : GraphicEngine.getDynamicElements()){
                de.move();
                GraphicEngine.updateElement(de);
            }
            //GraphicEngine.updateDynamicsElements();
        }
    }


    public static void addInputsControl(InputsController inputsControl){
        Window.theScene.addEventHandler(inputsControl.getEventType(), inputsControl);
    }

    public static void removeInputsControl(InputsController inputsControl){
        Window.theScene.removeEventHandler(inputsControl.getEventType(), inputsControl);
    }
}
