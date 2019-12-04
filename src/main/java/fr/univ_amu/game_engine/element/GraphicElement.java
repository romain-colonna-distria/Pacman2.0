package fr.univ_amu.game_engine.element;


import fr.univ_amu.game_engine.utils.Shape2D;

public interface GraphicElement {
    Shape2D getGraphicShape();
    String getImage();
    void setImage(String image);
}
