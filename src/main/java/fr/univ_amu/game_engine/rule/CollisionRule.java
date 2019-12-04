package fr.univ_amu.game_engine.rule;

import fr.univ_amu.game_engine.behavior.Interactable;
import fr.univ_amu.game_engine.element.DynamicElement;
import fr.univ_amu.game_engine.element.Element;

public class CollisionRule implements Rule {
    @Override
    public void applyRule(DynamicElement dynamicElement, Element element) {
        if(element instanceof Interactable) ((Interactable) element).interact(dynamicElement);
        //if(element instanceof Impassable) dynamicElement.di
    }
}
