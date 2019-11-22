package fr.univ_amu.entity;

import fr.univ_amu.utils.Direction;
import fr.univ_amu.behavior.Playable;
import fr.univ_amu.element.DynamicElement;

public class Ghost extends DynamicElement implements Playable {
    @Override
    public double getSpeed() {
        return 0;
    }

    @Override
    public Direction getCurrentDirection() {
        return null;
    }

    @Override
    public double getGraphicPositionX() {
        return 0;
    }

    @Override
    public double getGraphicPositionY() {
        return 0;
    }

    @Override
    public double getGraphicWidth() {
        return 0;
    }

    @Override
    public double getGraphicHeigth() {
        return 0;
    }

    @Override
    public String getImage() {
        return null;
    }

    @Override
    public void setGraphicPositionX(double x) {

    }

    @Override
    public void setGraphicPositionY(double y) {

    }

    @Override
    public double getPhysicPositionX() {
        return 0;
    }

    @Override
    public double getPhysicPositionY() {
        return 0;
    }

    @Override
    public double getPhysicWidth() {
        return 0;
    }

    @Override
    public double getPhysicHeigth() {
        return 0;
    }

    @Override
    public void setPhysicPositionX(double newX) {

    }

    @Override
    public void setPhysicPositionY(double newY) {

    }
}
