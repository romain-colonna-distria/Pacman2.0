package fr.univ_amu.entity;

import fr.univ_amu.element.StaticElement;
import fr.univ_amu.utils.Shape2D;

public class Teleporter extends StaticElement {
    private Shape2D graphicShape;
    private Shape2D physicShape;
    private String image;

    public Teleporter(Shape2D graphicShape, Shape2D physicShape, String image) {
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
}
