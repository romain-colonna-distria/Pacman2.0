package fr.univ_amu.element;

import fr.univ_amu.utils.Direction;

public abstract class DynamicElement implements Element {
    public abstract double getSpeed();
    public abstract Direction getCurrentDirection();

    public void movePhysicShape(){
        if (getCurrentDirection() != null) {
            switch (getCurrentDirection()) {
                case UP:
                    getPhysiqueShape().setyPosition(getPhysiqueShape().getyPosition() - getSpeed());
                    break;
                case DOWN:
                    getPhysiqueShape().setyPosition(getPhysiqueShape().getyPosition() + getSpeed());
                    break;
                case LEFT:
                    getPhysiqueShape().setxPosition(getPhysiqueShape().getxPosition() - getSpeed());
                    break;
                case RIGHT:
                    getPhysiqueShape().setxPosition(getPhysiqueShape().getxPosition() + getSpeed());
                    break;
                default:
                    ;
            }
        }
    }

    public void undoMovePhysicShape(){
        if (getCurrentDirection() != null) {
            switch (getCurrentDirection()) {
                case UP:
                    getPhysiqueShape().setyPosition(getPhysiqueShape().getyPosition() + getSpeed());
                    break;
                case DOWN:
                    getPhysiqueShape().setyPosition(getPhysiqueShape().getyPosition() - getSpeed());
                    break;
                case LEFT:
                    getPhysiqueShape().setxPosition(getPhysiqueShape().getxPosition() + getSpeed());
                    break;
                case RIGHT:
                    getPhysiqueShape().setxPosition(getPhysiqueShape().getxPosition() - getSpeed());
                    break;
                default:
                    ;
            }
        }
    }

    public void moveGraphicShape(){
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
