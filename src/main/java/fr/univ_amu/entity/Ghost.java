package fr.univ_amu.entity;

import fr.univ_amu.behavior.Interactable;
import fr.univ_amu.element.Element;
import fr.univ_amu.utils.Direction;
import fr.univ_amu.utils.Shape2D;
import fr.univ_amu.behavior.Playable;
import fr.univ_amu.element.DynamicElement;

public class Ghost extends DynamicElement implements Playable, Interactable {
    private Shape2D graphicShape;
    private Shape2D physicShape;
    private String image;
    private int score;
    private int lifes;

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


    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
  
    @Override
    public int getScore() {
        return -1;
    }

    @Override
    public void addPoints(int points){
        this.score += points;
    }

    @Override
    public void retrievePoints(int points) {
        if(points >= this.score) this.score = 0;
        else this.score -= points;
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public void interact(Element element) {
        if(element instanceof Pacman) ((Pacman) element).retrievLife();
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
