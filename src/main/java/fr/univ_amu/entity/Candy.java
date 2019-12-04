package fr.univ_amu.entity;

import fr.univ_amu.GameBoard;
import fr.univ_amu.behavior.Interactable;
import fr.univ_amu.behavior.Playable;
import fr.univ_amu.element.Element;
import fr.univ_amu.element.StaticElement;
import fr.univ_amu.graphic_engine.GraphicEngine;
import fr.univ_amu.utils.Shape2D;

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
