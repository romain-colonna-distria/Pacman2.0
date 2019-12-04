package fr.univ_amu.physic_engine;


import fr.univ_amu.behavior.Impassable;
import fr.univ_amu.behavior.Interactable;
import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.element.Element;


import fr.univ_amu.graphic_engine.GraphicEngine;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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

        /*
        for (DynamicElement de : GraphicEngine.getDynamicElements()){
            de.movePhysicShape();
        }

        for(DynamicElement de : GraphicEngine.getDynamicElements()) {
            Set<Element> tmp = new HashSet<>();
            for(Element e : GraphicEngine.getElements()) {
                if(de == e) continue;
                if (Collision.checkCollision(de.getPhysiqueShape(), e.getPhysiqueShape())) {
                    if(e instanceof Impassable){
                        de.undoMovePhysicShape();
                        tmp.add(e);
                    } else if(e instanceof Interactable) {
                        tmp.add(e);
                    }
                }
            }

            if(tmp.size() < 1) continue;
            collisions.put(de, tmp);
        }
*/

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
                /*if(element instanceof Interactable){
                    elementsInCollisions.add(element);
                } else if(!(element instanceof Impassable)) {
                    elementsInCollisions.add(element);
                }*/
            }
        }

        dynamicElement.undoMovePhysicShape();
        return elementsInCollisions;
    }
}
