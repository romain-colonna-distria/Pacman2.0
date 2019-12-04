package fr.univ_amu.entity;

import fr.univ_amu.element.StaticElement;
import fr.univ_amu.utils.Shape2D;

public class Trail extends StaticElement {
    private Shape2D graphicShape;
    private Shape2D physicShape;
    private String image;
    private double distance;

    public Trail(Shape2D graphicShape, Shape2D physicShape, String image) {
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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public void setImage(String image) {
        this.image = image;

    }
}

