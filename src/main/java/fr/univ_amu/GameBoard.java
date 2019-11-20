package fr.univ_amu;

import fr.univ_amu.element.Element;
import fr.univ_amu.entity.Pacman;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private static GameBoard instance;
    private List<Element> elements;

    private GameBoard(){
        this.elements = new ArrayList<>();
    }

    public void addElement(Element newElement){
        elements.add(newElement);
    }

    public Element getPacman(){
        return elements.parallelStream().filter(e ->
                e.getClass().equals(Pacman.class)
        ).findFirst().get();
    }

    public static GameBoard getInstance(){
        if(instance == null)
            return new GameBoard();
        else
            return instance;
    }
}
