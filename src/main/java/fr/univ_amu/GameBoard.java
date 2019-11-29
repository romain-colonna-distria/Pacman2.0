package fr.univ_amu;

import fr.univ_amu.behavior.Interactable;
import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.element.Element;
import fr.univ_amu.element.StaticElement;
import fr.univ_amu.entity.Pacman;
import fr.univ_amu.entity.Ghost;
import fr.univ_amu.entity.Wall;

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


    @Override
    public String toString() {
        return "GameBoard{" +
                "elements=" + elements +
                '}';
    }

}
	
