package fr.univ_amu.pacman.entity;

import fr.univ_amu.game_engine.element.Element;
import fr.univ_amu.game_engine.io_engine.InputsController;
import fr.univ_amu.game_engine.utils.Direction;
import fr.univ_amu.game_engine.utils.Shape2D;
import fr.univ_amu.game_engine.behavior.Playable;
import fr.univ_amu.game_engine.element.DynamicElement;

import java.util.concurrent.atomic.AtomicInteger;

public class Pacman extends DynamicElement implements Playable {
    private Shape2D graphicShape;
    private Shape2D physicShape;
    private String image;
    private AtomicInteger score;
    private int lifes;

    private double speed;
    private Direction currentDirection;
    private Direction saveDirection;
    private Direction desiredDirection;

    private InputsController inputsController;



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
    public InputsController getInputControl() {
        return inputsController;
    }

    @Override
    public void setInputControl(InputsController inputsController) {
        if(this.inputsController != null) return;
        this.inputsController = inputsController;
    }

    @Override
    public void updateDirectionFromInput() {
        if(this.inputsController == null) return;

        //setCurrentDirection(inputsController.getDirection());


        Direction input = inputsController.getDirection();
        if(this.currentDirection == input) return;

        this.saveDirection = this.currentDirection;
        if(input != null)
            this.desiredDirection = input;

        if(this.desiredDirection == this.currentDirection)
            this.desiredDirection = null;

        this.setCurrentDirection(this.desiredDirection == null ? this.currentDirection : this.desiredDirection);
        //System.out.println(this.saveDirection + " : " + this.currentDirection + " : " + this.desiredDirection);

        /*
        Direction input = inputsController.getDirection();

        if(input != null) {
            this.desiredDirection = input;
        }

        this.saveDirection = this.currentDirection;
        setCurrentDirection(desiredDirection);

        System.out.println(this.saveDirection + " : " + this.currentDirection + " : " + this.desiredDirection);
        */
    }

    @Override
    public void setCurrentDirection(Direction direction) {
        this.currentDirection = direction;
    }

    @Override
    public void undoUpdateDirection() {
        this.currentDirection = this.saveDirection;
        this.saveDirection = null;
    }


    @Override
    public void setImage(String image) {
        this.image = image;
    }

    public int getLifes() {
        return lifes;
    }

    public void retrievLife(int lifes){
        if(this.lifes == 0) return;
        this.lifes -= lifes;
    }

    @Override
    public String toString() {
        return "Pacman{" +
                "score=" + score +
                ", lifes=" + lifes +
                ", speed=" + speed +
                ", currentDirection=" + currentDirection +
                ", saveDirection=" + saveDirection +
                ", desiredDirection=" + desiredDirection +
                '}';
    }

    @Override
    public void interact(Element element) {
        System.out.println("Coucou: " + element);
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
