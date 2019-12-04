package fr.univ_amu.pacman.entity;

import fr.univ_amu.game_engine.behavior.Interactable;
import fr.univ_amu.game_engine.behavior.Playable;
import fr.univ_amu.game_engine.element.Element;
import fr.univ_amu.game_engine.element.StaticElement;
import fr.univ_amu.game_engine.utils.Shape2D;
import fr.univ_amu.pacman.GameBoard;

public class Candy extends StaticElement implements Interactable {
    private static int nbCandy = 0;
    private Shape2D graphicShape;
    private Shape2D physicShape;
    private String image;
    private int points = 10;

    public Candy(Shape2D graphicShape, Shape2D physicShape, String image) {
        this.graphicShape = graphicShape;
        this.physicShape = physicShape;
        this.image = image;
        ++nbCandy;
    }

    @Override
    public Shape2D getGraphicShape() {
        return graphicShape;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public Shape2D getPhysiqueShape() {
        return physicShape;
    }

    @Override
    public void interact(Element element) {
        if(element instanceof Playable){
            ((Playable) element).addPoints(this.points);
            GameBoard.getInstance().retrieveElement(this);
            --nbCandy;
            //GraphicEngine.updateDynamicsElements();
            //if(nbCandy < 290) CoreKernel.restartGame();
        }
    }
}
