package fr.univ_amu.pacman;

import fr.univ_amu.game_engine.element.Element;
import fr.univ_amu.game_engine.graphic_engine.GraphicEngine;
import fr.univ_amu.pacman.entity.Ghost;
import fr.univ_amu.pacman.entity.Pacman;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class GameBoard {
    private static GameBoard instance;

    public Pacman getPacman(){
        for(int i = 0; i < GraphicEngine.getDynamicElements().size(); ++i) {
            if (GraphicEngine.getDynamicElements().get(i) instanceof Pacman) return (Pacman) GraphicEngine.getDynamicElements().get(i);
        }

        return null;
    }

    public List<Ghost> getGhosts() {
    	List <Ghost> tmp1 = new ArrayList<>();
        for(int i = 0; i < GraphicEngine.getDynamicElements().size(); ++i) {
            if (GraphicEngine.getDynamicElements().get(i) instanceof Ghost) tmp1.add((Ghost) GraphicEngine.getDynamicElements().get(i));
        }

        return tmp1;
    }


    public static GameBoard getInstance(){
        if(instance == null) {
            instance = new GameBoard();
        }
        return instance;
    }

    public void addElement(Element newElement){
        GraphicEngine.addElement(newElement);
    }
    
    public void addElements(Collection<Element> newElements){
        for(Element e : newElements) {
            GraphicEngine.addElement(e);
        }
    }

    public void retrieveElement(Element element){
        GraphicEngine.removeElement(element);
    }
}
	
