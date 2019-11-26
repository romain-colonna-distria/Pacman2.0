package fr.univ_amu.element;

import fr.univ_amu.utils.Direction;

public abstract class DynamicElement implements Element {
    public abstract double getSpeed();
    public abstract Direction getCurrentDirection();

    void moveTo(){
        switch (getCurrentDirection()){
            case UP:
                getGraphicShape().setxPosition(getGraphicShape().getxPosition() - getSpeed());
                break;
            case DOWN:
                getGraphicShape().setxPosition(getGraphicShape().getxPosition() + getSpeed());
                break;
            case LEFT:
                getGraphicShape().setyPosition(getGraphicShape().getyPosition() - getSpeed());
                break;
            case RIGHT:
                getGraphicShape().setyPosition(getGraphicShape().getyPosition() + getSpeed());
                break;
        }
    }
}
