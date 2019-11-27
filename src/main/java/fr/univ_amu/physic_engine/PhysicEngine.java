package fr.univ_amu.physic_engine;


import fr.univ_amu.GameBoard;
import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.element.StaticElement;
import fr.univ_amu.entity.Pacman;
import fr.univ_amu.utils.Shape2D;


public class PhysicEngine {
    public boolean move(DynamicElement element){
        GameBoard gb = GameBoard.getInstance();
        Pacman pacman = gb.getPacman();


        Shape2D save = element.getPhysiqueShape();

        element.movePhysicShape();


        boolean isCollision = true;
        for(StaticElement e : gb.getWalls())
            if(Collision.checkCollision(e.getPhysiqueShape(), pacman.getPhysiqueShape())){
                isCollision = false;
                element.getPhysiqueShape().setxPosition(save.getxPosition());
                element.getPhysiqueShape().setyPosition(save.getyPosition());
            }

        return isCollision;
    }
}
