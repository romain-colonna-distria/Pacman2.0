package fr.univ_amu.physic_engine;


import fr.univ_amu.GameBoard;
import fr.univ_amu.behavior.Interactable;
import fr.univ_amu.element.Element;
import fr.univ_amu.entity.Pacman;
import fr.univ_amu.entity.Wall;



public class PhysicEngine {
    public boolean updatePhysicElements(){
        GameBoard board = GameBoard.getInstance();
        Pacman pacman = board.getPacman();

        pacman.movePhysicShape();

        boolean isCollision = false;
        for(Wall w : board.getWalls()) {
            if (Collision.checkCollision(pacman.getPhysiqueShape(), w.getPhysiqueShape())) {
                isCollision = true;
                break;
            }
        }

        for(Element e : board.getInteractableElements()){
            if(Collision.checkCollision(pacman.getPhysiqueShape(), e.getPhysiqueShape())){
                ((Interactable)e).interact(pacman);
                return false;
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
