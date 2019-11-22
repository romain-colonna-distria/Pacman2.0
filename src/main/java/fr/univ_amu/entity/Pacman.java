package fr.univ_amu.entity;

import fr.univ_amu.utils.Direction;
import fr.univ_amu.behavior.Playable;
import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.utils.RectangularShape;

public class Pacman extends DynamicElement implements Playable {
    private RectangularShape graphicShape;
    private RectangularShape physicShape;
    private String image;

    private double speed;
    private Direction currentDirection;
    private double graphicPositionX;
    private double graphicPositionY;
    private double physicPositionX;
    private double physicPositionY;



    public Pacman(PacmanBuilder builder){
        this.graphicShape = builder.graphicShape;
        this.physicShape = builder.graphicShape;
        this.image = builder.image;


        this.speed = builder.speed;
        this.currentDirection = builder.currentDirection;
        this.graphicPositionX = builder.graphicPositionX;
        this.graphicPositionY = builder.graphicPositionY;
        this.physicPositionX = builder.physicPositionX;
        this.physicPositionY = builder.physicPositionY;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public Direction getCurrentDirection() {
        return currentDirection;
    }

    @Override
    public double getGraphicPositionX() {
        return graphicPositionX;
    }

    @Override
    public double getGraphicPositionY() {
        return graphicPositionY;
    }

    @Override
    public double getGraphicWidth() {
        return graphicShape.getWidth();
    }

    @Override
    public double getGraphicHeigth() {
        return graphicShape.getHeigth();
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public void setGraphicPositionX(double x) {
        graphicPositionX = x;
    }

    @Override
    public void setGraphicPositionY(double y) {
        graphicPositionY = y;
    }

    @Override
    public double getPhysicPositionX() {
        return physicPositionX;
    }

    @Override
    public double getPhysicPositionY() {
        return physicPositionY;
    }

    @Override
    public double getPhysicWidth() {
        return physicShape.getWidth();
    }

    @Override
    public double getPhysicHeigth() {
        return physicShape.getHeigth();
    }

    @Override
    public void setPhysicPositionX(double newX) {
        physicPositionX = newX;
    }

    @Override
    public void setPhysicPositionY(double newY) {
        physicPositionY = newY;
    }


    public static class PacmanBuilder {
        private RectangularShape graphicShape;
        private RectangularShape physicShape;
        private String image;

        private double speed;
        private Direction currentDirection;
        private double graphicPositionX;
        private double graphicPositionY;
        private double physicPositionX;
        private double physicPositionY;

        public PacmanBuilder(RectangularShape graphicShape, RectangularShape physicShape, String image){
            this.graphicShape = graphicShape;
            this.physicShape = physicShape;
            this.image = image;
        }

        public PacmanBuilder setSpeed(double speed){
            this.speed = speed;
            return this;
        }

        public PacmanBuilder setcurrentDirection(Direction currentDirection){
            this.currentDirection = currentDirection;
            return this;
        }

        public PacmanBuilder setgraphicPosition(double x, double y){
            this.graphicPositionX = x;
            this.graphicPositionY = y;
            return this;
        }
        public PacmanBuilder setphysicPosition(double x, double y){
            this.physicPositionX = x;
            this.physicPositionY = y;
            return this;
        }

        public Pacman build(){
            return new Pacman(this);
        }
    }
}
