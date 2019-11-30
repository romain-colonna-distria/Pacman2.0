package fr.univ_amu.entity;

import fr.univ_amu.behavior.Interactable;
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
    public void interact(Element element) {
        element.getPhysiqueShape().setxPosition(260d);
        element.getPhysiqueShape().setyPosition(340);
        element.getGraphicShape().setxPosition(260d);
        element.getGraphicShape().setyPosition(340);

//        element.getPhysiqueShape().setxPosition(GraphicEngine.elementImageViewHashMap.get(boundElement).getX());
//        element.getPhysiqueShape().setyPosition(GraphicEngine.elementImageViewHashMap.get(boundElement).getY());
//        element.getGraphicShape().setxPosition(GraphicEngine.elementImageViewHashMap.get(boundElement).getX());
//        element.getGraphicShape().setyPosition(GraphicEngine.elementImageViewHashMap.get(boundElement).getY());
    }

    public void bind(Element element){
        boundElement = element;
    }

    public Element getBoundElement() {
        return boundElement;
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }
}
