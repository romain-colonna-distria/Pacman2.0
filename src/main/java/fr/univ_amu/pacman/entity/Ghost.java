package fr.univ_amu.pacman.entity;

import fr.univ_amu.game_engine.element.Element;
import fr.univ_amu.game_engine.io_engine.InputsController;
import fr.univ_amu.game_engine.behavior.Playable;
import fr.univ_amu.game_engine.element.DynamicElement;
import fr.univ_amu.game_engine.utils.Direction;
import fr.univ_amu.game_engine.utils.Shape2D;

public class Ghost extends DynamicElement implements Playable {
    private Shape2D graphicShape;
    private Shape2D physicShape;
    private String image;
    private int score;
    private int lifes;

    private double speed;
    private Direction currentDirection;
    private InputsController inputsController;



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
    public void setCurrentDirection(Direction newDirection) {
        this.currentDirection = newDirection;
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
    public InputsController getInputControl() {
        return inputsController;
    }

    @Override
    public void setInputControl(InputsController inputsController) {
        this.inputsController = inputsController;
    }

    @Override
    public void updateDirectionFromInput() {
        if(inputsController == null) return;
        this.currentDirection = inputsController.getDirection() == null ? this.currentDirection : inputsController.getDirection();
    }

    @Override
    public void undoUpdateDirection() {

    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public void interact(Element element) {
        if(element instanceof Pacman) {
            ((Pacman) element).retrievLife(1);
            element.getGraphicShape().setxPosition(260d);
            element.getGraphicShape().setyPosition(340d);
            element.getPhysiqueShape().setxPosition(260d);
            element.getPhysiqueShape().setyPosition(340d);
            ((Pacman) element).setCurrentDirection(null);
        }
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
