package fr.univ_amu.game_engine.rule;

import fr.univ_amu.game_engine.element.DynamicElement;
import fr.univ_amu.game_engine.element.Element;

public interface Rule {
    void applyRule(DynamicElement dynamicElement, Element element);
}
