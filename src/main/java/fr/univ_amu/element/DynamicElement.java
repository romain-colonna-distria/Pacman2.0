package fr.univ_amu.element;

import fr.univ_amu.utils.Direction;

public abstract class DynamicElement implements Element {
    public abstract double getSpeed();
    public abstract Direction getCurrentDirection();

    public void moveTo(){
        if (getCurrentDirection() != null) {
            switch (getCurrentDirection()) {
                case UP:
                    getGraphicShape().setyPosition(getGraphicShape().getyPosition() - getSpeed());
                    break;
                case DOWN:
                    getGraphicShape().setyPosition(getGraphicShape().getyPosition() + getSpeed());
                    break;
                case LEFT:
                    getGraphicShape().setxPosition(getGraphicShape().getxPosition() - getSpeed());
                    break;
                case RIGHT:
                    getGraphicShape().setxPosition(getGraphicShape().getxPosition() + getSpeed());
                    break;
                default:
                    ;
            }
        }
    }
}
