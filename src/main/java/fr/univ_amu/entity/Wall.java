package fr.univ_amu.entity;

import fr.univ_amu.behavior.Impassable;
import fr.univ_amu.element.StaticElement;
import fr.univ_amu.utils.Shape2D;

public class Wall extends StaticElement implements Impassable {
    private Shape2D graphicShape;
    private Shape2D physicShape;
    private String image;


    public Wall(Shape2D graphicShape, Shape2D physicShape, String image){
        this.graphicShape = graphicShape;
        this.physicShape = physicShape;
        this.image = image;
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
    public Shape2D getPhysiqueShape() {
        return physicShape;
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "graphicX=" + graphicShape.getxPosition() +
                "graphicY=" + graphicShape.getyPosition() +
                "physicX=" + physicShape.getxPosition() +
                "physicY=" + physicShape.getyPosition() +
                '}';
    }
}
