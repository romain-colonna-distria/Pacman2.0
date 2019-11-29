package fr.univ_amu.physic_engine;


import fr.univ_amu.GameBoard;
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

        if(!isCollision){
            pacman.moveGraphicShape();
        } else {
            pacman.undoMovePhysicShape();
        }

        return isCollision;
    }
}
