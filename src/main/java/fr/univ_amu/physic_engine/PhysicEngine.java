package fr.univ_amu.physic_engine;


import fr.univ_amu.GameBoard;
import fr.univ_amu.behavior.Interactable;
import fr.univ_amu.behavior.Playable;
import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.element.Element;
import fr.univ_amu.entity.Pacman;
import fr.univ_amu.entity.Wall;
import fr.univ_amu.graphic_engine.GraphicEngine;


public class PhysicEngine {

    /**
     * Met a jours la positions des éléments dynamiques.
     * @return Liste des élément
     */
    public static boolean updatePhysicElements(){
        GameBoard board = GameBoard.getInstance();
        Pacman pacman = board.getPacman();

        pacman.movePhysicShape();

        boolean isCollision = false;
        for(DynamicElement de : GraphicEngine.getDynamicElements()) {
            for(Wall w : board.getWalls()) {
                if (Collision.checkCollision(de.getPhysiqueShape(), w.getPhysiqueShape())) {
                    isCollision = true;
                    System.out.println("collision");
                    break;
                }
            }
        }

        if(!isCollision) {
            for (DynamicElement de : GraphicEngine.getDynamicElements()) {
                for (Element e : GraphicEngine.getInteractableElements()) {
                    if (!(de instanceof Playable)) continue;
                    if (!Collision.checkCollision(de.getPhysiqueShape(), e.getPhysiqueShape())) continue;
                    ((Interactable) e).interact(de);
                }
            }
        }

        if(!isCollision){
            pacman.moveGraphicShape();
        } else {
            pacman.undoMovePhysicShape();
        }

        return isCollision;
    }
}
