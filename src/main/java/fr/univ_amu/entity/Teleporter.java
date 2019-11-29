package fr.univ_amu.entity;

import fr.univ_amu.behavior.Interactable;
import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.element.Element;
import fr.univ_amu.element.StaticElement;
import fr.univ_amu.utils.Shape2D;

public class Teleporter extends StaticElement implements Interactable {
    private Shape2D graphicShape;
    private Shape2D physicShape;
    private String image;

    private Element boundElement;

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

    @Override
    public void interact(DynamicElement element) {
        element.getPhysiqueShape().setxPosition(boundElement.getPhysiqueShape().getxPosition());
        element.getPhysiqueShape().setyPosition(boundElement.getPhysiqueShape().getyPosition());
        element.getGraphicShape().setxPosition(boundElement.getGraphicShape().getxPosition());
        element.getGraphicShape().setyPosition(boundElement.getGraphicShape().getyPosition());
    }

    public void bind(Element element){
        boundElement = element;
    }
}
