package fr.univ_amu.game_engine;

import fr.univ_amu.game_engine.element.Element;

import java.util.ArrayList;
import java.util.List;

public class GameState /*implements Serializable*/ {
    private List<Element> elementPositionMap;

    public GameState(List<Element> elements) {
        this.elementPositionMap = new ArrayList<>();
        for(int i = 0; i < elements.size(); ++i) {
            Element e = elements.get(i);
            //ImageView v = view.get(i);
            elementPositionMap.add(e);
        }
    }

    public List<Element> getElementPositionMap() {
        return elementPositionMap;
    }
}
