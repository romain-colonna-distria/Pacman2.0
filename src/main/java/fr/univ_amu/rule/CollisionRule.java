package fr.univ_amu.rule;

import fr.univ_amu.behavior.Impassable;
import fr.univ_amu.behavior.Interactable;
import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.element.Element;

public class CollisionRule implements Rule {
    @Override
    public void applyRule(DynamicElement dynamicElement, Element element) {
        if(element instanceof Interactable) ((Interactable) element).interact(dynamicElement);
        //if(element instanceof Impassable) dynamicElement.di
    }
}
