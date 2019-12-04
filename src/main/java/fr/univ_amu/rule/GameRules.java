package fr.univ_amu.rule;

import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.element.Element;

import java.util.ArrayList;
import java.util.List;

public class GameRules {
    List<Rule> rules;

    public GameRules(){
        this.rules = new ArrayList<>();
    }

    public void add(Rule rule){
        rules.add(rule);
    }

    public void applyRules(DynamicElement dynamicElement, Element element){
        for(Rule rule : rules)
            rule.applyRule(dynamicElement, element);
    }
}
