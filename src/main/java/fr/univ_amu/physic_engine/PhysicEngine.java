package fr.univ_amu.physic_engine;


import fr.univ_amu.GameBoard;
import fr.univ_amu.element.StaticElement;
import fr.univ_amu.entity.Pacman;
import fr.univ_amu.utils.Shape2D;


public class PhysicEngine {
    public boolean updatePhysicElements(){
        GameBoard gb = GameBoard.getInstance();
        Pacman pacman = gb.getPacman();
        Shape2D save = pacman.getPhysiqueShape();

        pacman.movePhysicShape();

        boolean isCollision = false;
        for(StaticElement e : gb.getWalls()) {
            if (Collision.checkCollision(e.getPhysiqueShape(), pacman.getPhysiqueShape())) {
                isCollision = true;
                pacman.getPhysiqueShape().setxPosition(save.getxPosition());
                pacman.getPhysiqueShape().setyPosition(save.getyPosition());
            }
        }

        if(!isCollision){
            pacman.moveGraphicShape();
        }

        return isCollision;
    }
}
