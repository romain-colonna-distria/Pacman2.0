package fr.univ_amu.entity;

import fr.univ_amu.element.StaticElement;
import fr.univ_amu.utils.RectangularShape;

public class Wall extends StaticElement {
    private RectangularShape graphicShape;
    private RectangularShape physicShape;
    private String image;

    private double graphicPositionX;
    private double graphicPositionY;
    private double physicPositionX;
    private double physicPositionY;

    public Wall(WallBuilder builder){
        this.graphicShape = builder.graphicShape;
        this.physicShape = builder.physicShape;
        this.image = builder.image;

        this.graphicPositionX = builder.graphicPositionX;
        this.graphicPositionY = builder.graphicPositionY;
        this.physicPositionX = builder.physicPositionX;
        this.physicPositionY = builder.physicPositionY;
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
        return physicPositionX;
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

    public static class WallBuilder{
        private RectangularShape graphicShape;
        private RectangularShape physicShape;
        private String image;

        private double graphicPositionX;
        private double graphicPositionY;
        private double physicPositionX;
        private double physicPositionY;


        public WallBuilder(RectangularShape graphicShape, RectangularShape physicShape, String image){
            this.graphicShape = graphicShape;
            this.physicShape = physicShape;
            this.image = image;
        }

        public WallBuilder setgraphicPosition(double x, double y){
            this.graphicPositionX = x;
            this.graphicPositionY = y;
            return this;
        }

        public WallBuilder setphysicPosition(double x, double y){
            this.physicPositionX = x;
            this.physicPositionY = y;
            return this;
        }

        public Wall build(){
            return new Wall(this);
        }
    }


    @Override
    public String toString() {
        return "Wall{" +
                "image='" + image + '\'' +
                '}';
    }
}