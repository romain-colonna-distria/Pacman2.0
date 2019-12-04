package fr.univ_amu.game_engine.physic_engine;


import fr.univ_amu.game_engine.behavior.Impassable;
import fr.univ_amu.game_engine.behavior.Interactable;
import fr.univ_amu.game_engine.element.DynamicElement;
import fr.univ_amu.game_engine.element.Element;


import fr.univ_amu.game_engine.graphic_engine.GraphicEngine;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class PhysicEngine {

    /**
     * Renvoi les collisions avec les éléments possédant une intéraction
     * @return Liste des élément
     */
    public static HashMap<DynamicElement, Set<Element>> getNextCollisions() {
        HashMap<DynamicElement, Set<Element>> collisions = new HashMap<>();

        for(DynamicElement de : GraphicEngine.getDynamicElements()){
            Set<Element> nextCollisions = getNextElementCollisions(de);

            if(nextCollisions.size() < 1) continue;
            collisions.put(de, nextCollisions);
        }

       return collisions;
    }

    public static Set<Element> getNextElementCollisions(DynamicElement dynamicElement){
        dynamicElement.movePhysicShape();

        Set<Element> elementsInCollisions = new HashSet<>();
        for(Element element : GraphicEngine.getElements()) {
            if(dynamicElement == element) continue;
            if (Collision.checkCollision(dynamicElement.getPhysiqueShape(), element.getPhysiqueShape())) {
                if(element instanceof Impassable || element instanceof Interactable) {
                    elementsInCollisions.add(element);
                }
            }
        }

        dynamicElement.undoMovePhysicShape();
        return elementsInCollisions;
    }
}
