package fr.univ_amu.element;

import fr.univ_amu.utils.Shape2D;

public interface GraphicElement {
    Shape2D getGraphicShape();
    String getImage();
    void setImage(String image);
}
