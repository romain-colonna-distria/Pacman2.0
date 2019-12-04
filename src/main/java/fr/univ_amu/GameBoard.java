package fr.univ_amu;

import fr.univ_amu.behavior.Eatable;
import fr.univ_amu.behavior.Interactable;
import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.element.Element;
import fr.univ_amu.element.StaticElement;
import fr.univ_amu.entity.Pacman;
import fr.univ_amu.entity.Ghost;
import fr.univ_amu.entity.Trail;
import fr.univ_amu.entity.Wall;
import fr.univ_amu.graphic_engine.GraphicEngine;
import fr.univ_amu.graphic_engine.ViewImage;
import fr.univ_amu.graphic_engine.Window;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class GameBoard {
    private static GameBoard instance;
    private List<Element> elements;

    private GameBoard(){
        this.elements = new ArrayList<>();
    }

    public Pacman getPacman(){
        for(int i = 0; i < elements.size(); ++i) {
            if (elements.get(i) instanceof Pacman) return (Pacman) elements.get(i);
        }

        return null;
    }

    public List<Ghost> getGhosts() {
    	List <Ghost> tmp1 = new ArrayList<>();
        for(int i = 0; i < elements.size(); ++i) {
            if (elements.get(i) instanceof Ghost) tmp1.add((Ghost) elements.get(i));
        }

        return tmp1;
    }

    public List<Wall> getWalls(){
        List<Wall> tmp = new ArrayList<>();
        for(int i = 0; i < elements.size(); ++i) {
            if (elements.get(i) instanceof Wall) tmp.add((Wall) elements.get(i));
        }

        return tmp;
    }


    public List<Trail> getTrails() {
        List<Trail> tmp = new ArrayList<>();
        for(int i = 0; i < elements.size(); ++i) {
            if (elements.get(i) instanceof Trail) tmp.add((Trail) elements.get(i));
        }
        return tmp;
    }


    public List<Trail> getNeighborTrails(Trail current_trail) {
        List<Trail> neighbors = new ArrayList<>();
        double current_trail_x = current_trail.getPhysiqueShape().getxPosition();
        double current_trail_y = current_trail.getPhysiqueShape().getyPosition();
        for (Trail trail : getTrails()) {
            double trail_x = trail.getPhysiqueShape().getxPosition();
            double trail_y = trail.getPhysiqueShape().getyPosition();
            if (trail_x + trail.getPhysiqueShape().getWidth() == current_trail_x && trail_y == current_trail_y) {
                neighbors.add(trail);
            }
            if (trail_x - trail.getPhysiqueShape().getWidth() == current_trail_x && trail_y == current_trail_y) {
                neighbors.add(trail);
            }
            if (trail_y + trail.getPhysiqueShape().getHeigth() == current_trail_y && trail_x == current_trail_x) {
                neighbors.add(trail);
            }
            if (trail_y - trail.getPhysiqueShape().getHeigth() == current_trail_y && trail_x == current_trail_x) {
                neighbors.add(trail);
            }
        }
        return neighbors;
    }


    public List<Element> getElements(){
        return elements;
    }

    public static GameBoard getInstance(){
        if(instance == null) {
            instance = new GameBoard();
        }
        return instance;
    }

    public void addElement(Element newElement){
        elements.add(newElement);
        GraphicEngine.addElement(newElement);
    }
    
    public void addElements(Collection<Element> newElements){
        for(Element e : newElements)
            addElement(e);
    }

    public void retrieveElement(Element element){
        elements.remove(element);
        GraphicEngine.removeElement(element);
    }


    @Override
    public String toString() {
        return "GameBoard{" +
                "elements=" + elements +
                '}';
    }

}
	
