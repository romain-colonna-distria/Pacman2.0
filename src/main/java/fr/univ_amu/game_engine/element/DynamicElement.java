package fr.univ_amu.game_engine.element;


import fr.univ_amu.game_engine.utils.Direction;

public abstract class DynamicElement implements Element {
    public abstract double getSpeed();
    public abstract Direction getCurrentDirection();
    public abstract void setCurrentDirection(Direction newDirection);

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

    public void undoMoveGraphicShape(){
        if (getCurrentDirection() != null) {
            switch (getCurrentDirection()) {
                case UP:
                    getGraphicShape().setyPosition(getGraphicShape().getyPosition() + getSpeed());
                    break;
                case DOWN:
                    getGraphicShape().setyPosition(getGraphicShape().getyPosition() - getSpeed());
                    break;
                case LEFT:
                    getGraphicShape().setxPosition(getGraphicShape().getxPosition() + getSpeed());
                    break;
                case RIGHT:
                    getGraphicShape().setxPosition(getGraphicShape().getxPosition() - getSpeed());
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

    public void move(){
        moveGraphicShape();
        movePhysicShape();
    }



    @Override
    public String toString() {
        return "de{" +
                "graphicX=" + getGraphicShape().getxPosition() +
                "graphicY=" + getGraphicShape().getyPosition() +
                "physicX=" + getPhysiqueShape().getxPosition() +
                "physicY=" + getPhysiqueShape().getyPosition() +
                '}';
    }
}
