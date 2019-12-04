package fr.univ_amu.rule;

import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.element.Element;

public interface Rule {
    void applyRule(DynamicElement dynamicElement, Element element);
}
