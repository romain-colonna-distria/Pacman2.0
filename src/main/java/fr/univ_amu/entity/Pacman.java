package fr.univ_amu.entity;

import fr.univ_amu.utils.Direction;
import fr.univ_amu.behavior.Playable;
import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.utils.Shape2D;

import java.util.concurrent.atomic.AtomicInteger;

public class Pacman extends DynamicElement implements Playable {
    private Shape2D graphicShape;
    private Shape2D physicShape;
    private String image;
    private AtomicInteger score;
    private int lifes;

    private double speed;
    private Direction currentDirection;



    public Pacman(PacmanBuilder builder){
        this.graphicShape = builder.graphicShape;
        this.physicShape = builder.graphicShape;
        this.image = builder.image;
        this.score = builder.score;
        this.lifes = builder.lifes;


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
        return score.get();
    }

    @Override
    public void addPoints(int points){
        this.score.addAndGet(points);
    }

    @Override
    public void retrievePoints(int points) {
        if(points >= this.score.get()) this.score.set(0);
        else this.score.addAndGet(-points);
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }

    public int getLifes() {
        return lifes;
    }

    public void retrievLife(){
        if(this.lifes == 0) return;
        --lifes;
    }

    public static class PacmanBuilder {
        private Shape2D graphicShape;
        private Shape2D physicShape;
        private String image;

        private AtomicInteger score;
        private int lifes;
        private double speed;
        private Direction currentDirection;


        public PacmanBuilder(Shape2D graphicShape, Shape2D physicShape, String image){
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

        public PacmanBuilder setScore(int score){
            this.score = new AtomicInteger(score);
            return this;
        }

        public PacmanBuilder setLifes(int lifes){
            this.lifes = lifes;
            return this;
        }


        public Pacman build(){
            return new Pacman(this);
        }
    }
}
