package fr.univ_amu.entity;

import fr.univ_amu.utils.Direction;
import fr.univ_amu.utils.Shape2D;
import fr.univ_amu.behavior.Playable;
import fr.univ_amu.element.DynamicElement;

public class Ghost extends DynamicElement implements Playable {
    private Shape2D graphicShape;
    private Shape2D physicShape;
    private String image;

    private double speed;
    private Direction currentDirection;



    public Ghost(GhostBuilder builder){
        this.graphicShape = builder.graphicShape;
        this.physicShape = builder.graphicShape;
        this.image = builder.image;


        this.speed = builder.speed;
        this.currentDirection = builder.currentDirection;
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
    public Shape2D getGraphicShape() {
        return graphicShape;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public Shape2D getPhysiqueShape() {
        return physicShape;
    }


    public static class GhostBuilder {
        private Shape2D graphicShape;
        private Shape2D physicShape;
        private String image;

        private double speed;
        private Direction currentDirection;


        public GhostBuilder(Shape2D graphicShape, Shape2D physicShape, String image){
            this.graphicShape = graphicShape;
            this.physicShape = physicShape;
            this.image = image;
        }

        public GhostBuilder setSpeed(double speed){
            this.speed = speed;
            return this;
        }

        public GhostBuilder setcurrentDirection(Direction currentDirection){
            this.currentDirection = currentDirection;
            return this;
        }


        public Ghost build(){
            return new Ghost(this);
        }
    }
}
