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
import fr.univ_amu.graphic_engine.Window;
import javafx.scene.image.ImageView;

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

    public List<Ghost>  getGhosts() {
    	List <Ghost> tmp1 = new ArrayList<>();
        for(int i = 0; i < elements.size(); ++i) {
            if (elements.get(i) instanceof Ghost) tmp1.add((Ghost) elements.get(i));
        }

        return tmp1;
    }


    public List<StaticElement> getStaticElements(){
        List<StaticElement> tmp = new ArrayList<>();
        for(int i = 0; i < elements.size(); ++i) {
            if (elements.get(i) instanceof StaticElement) tmp.add((StaticElement) elements.get(i));
        }

        return tmp;
    }


    public List<DynamicElement> getDynamicElements() {
        List<DynamicElement> tmp = new ArrayList<>();
        for(int i = 0; i < elements.size(); ++i) {
            if (elements.get(i) instanceof DynamicElement) tmp.add((DynamicElement) elements.get(i));
        }

        return tmp;
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
  
    public List<Element> getEatables(){
        List<Element> tmp = new ArrayList<>();
        for(int i = 0; i < elements.size(); ++i) {
            if (elements.get(i) instanceof Eatable) tmp.add(elements.get(i));
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
    public List<Element> getInteractableElements(){
        List<Element> tmp = new ArrayList<>();
        for(int i = 0; i < elements.size(); ++i) {
            if (elements.get(i) instanceof Interactable) tmp.add(elements.get(i));
        }
        return tmp;
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
    }
    
    public void addElements(Collection<Element> newElements){
        elements.addAll(newElements);
    }

    public void retrieveElement(Element element, ImageView view){
        elements.remove(element);
        Window.getRoot().getChildren().remove(view);
    }


    @Override
    public String toString() {
        return "GameBoard{" +
                "elements=" + elements +
                '}';
    }

}
	
