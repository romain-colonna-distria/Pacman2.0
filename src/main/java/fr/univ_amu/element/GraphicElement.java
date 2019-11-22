package fr.univ_amu.element;

public interface GraphicElement {
    double getGraphicPositionX();
    double getGraphicPositionY();
    double getGraphicWidth();
    double getGraphicHeigth();
    String getImage();

    void setGraphicPositionX(double x);
    void setGraphicPositionY(double y);
}
