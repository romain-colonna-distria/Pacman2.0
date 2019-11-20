package fr.univ_amu.element;

import fr.univ_amu.utils.Direction;

public abstract class DynamicElement implements Element {
    public abstract double getSpeed();
    public abstract Direction getCurrentDirection();

    void moveTo(){
        switch (getCurrentDirection()){
            case UP:
                setPhysicPositionX(getPhysicPositionX() - getSpeed());
                break;
            case DOWN:
                setPhysicPositionX(getPhysicPositionX() + getSpeed());
                break;
            case LEFT:
                setPhysicPositionY(getPhysicPositionY() - getSpeed());
                break;
            case RIGHT:
                setPhysicPositionY(getPhysicPositionY() + getSpeed());
                break;
        }
    }
}
