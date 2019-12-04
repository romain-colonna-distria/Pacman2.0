package fr.univ_amu.game_engine.rule;

import fr.univ_amu.game_engine.element.DynamicElement;
import fr.univ_amu.game_engine.element.Element;

public class PacmanRule implements Rule {
    @Override
    public void applyRule(DynamicElement dynamicElement, Element element) {
        /*
        if(dynamicElement instanceof Pacman) {
            if(element instanceof Impassable) {
                ((Pacman) dynamicElement).setCurrentDirection(((Pacman) dynamicElement).getBeforeDirection());
            }
            dynamicElement.move();
        }
        */
    }
}
