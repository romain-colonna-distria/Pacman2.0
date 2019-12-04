package fr.univ_amu.rule;

import fr.univ_amu.behavior.Impassable;
import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.element.Element;
import fr.univ_amu.entity.Pacman;

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
