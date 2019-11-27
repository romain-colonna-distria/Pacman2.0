package fr.univ_amu;

import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.element.Element;
import fr.univ_amu.element.StaticElement;
import fr.univ_amu.entity.Pacman;
import fr.univ_amu.io_engine.KeyboardControl;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyEvent.*;

public class GameBoard {
    private static GameBoard instance;
    private List<Element> elements;

    private GameBoard(){
        this.elements = new ArrayList<>();
    }

    public Element getPacman(){
        for(int i = 0; i < elements.size(); ++i) {
            if (elements.get(i) instanceof Pacman) return elements.get(i);
        }

        return null;
        /*
        return elements.parallelStream().filter(e ->
                e.getClass().equals(Pacman.class)
        ).findFirst().get();
        */
    }

    public List<Element> getStaticElements(){
        List<Element> tmp = new ArrayList<>();
        for(int i = 0; i < elements.size(); ++i) {
            if (elements.get(i) instanceof StaticElement) tmp.add(elements.get(i));
        }

        return tmp;
    }

    public List<Element> getDynamicElements() {
        List<Element> tmp = new ArrayList<>();
        for(int i = 0; i < elements.size(); ++i) {
            if (elements.get(i) instanceof DynamicElement) tmp.add(elements.get(i));
        }

        return tmp;
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
    public void addElements(List<Element> newElements){
        elements.addAll(newElements);
    }

    @Override
    public String toString() {
        return "GameBoard{" +
                "elements=" + elements +
                '}';
    }

}
