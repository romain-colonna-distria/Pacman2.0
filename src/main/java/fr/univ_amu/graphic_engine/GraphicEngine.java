package fr.univ_amu.graphic_engine;



import fr.univ_amu.behavior.Interactable;
import fr.univ_amu.behavior.Playable;
import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.element.Element;
import fr.univ_amu.element.StaticElement;


import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GraphicEngine {
    public static Map<Element, ImageView> elementViewMap = new HashMap<>();

    public static void launchWindow(){
        Application.launch(Window.class);
    }

    public static void addElement(Element element){
        if(elementViewMap == null) elementViewMap = new HashMap<>();
        elementViewMap.put(element, null);
    }

    public static void addElements(List<Element> elements, boolean clear){
        if(elementViewMap == null) elementViewMap = new HashMap<>();
        if(clear) elementViewMap = new HashMap<>();
        for(Element e : elements)
            addElement(e);
    }

    public static void removeElement(Element element){
        Window.root.getChildren().remove(elementViewMap.get(element));
        elementViewMap.remove(element);
    }

    public static void removeElements(List<Element> elements){
        for(Element e : elements) {
            Window.root.getChildren().remove(elementViewMap.get(e));
            elementViewMap.remove(e);
        }
    }

    public static void createStaticsElementsView() throws IOException {
        if(elementViewMap == null) {
            System.err.println("No elements to load.");
            return;
        }

        for (StaticElement e : getStaticElements()) {
            ImageView view = createElementImageView(e);
            setImageViewPositionFromElementPosition(view, e);
            view.toBack(); //marche pas je sais pas pourquoi

            elementViewMap.put(e, view);
        }
    }

    public static void createDynamicsElementsView() throws IOException {
        if(elementViewMap == null) {
            System.err.println("No elements to load.");
            return;
        }

        for (DynamicElement e : getDynamicElements()) {
            ImageView view = createElementImageView(e);
            setImageViewPositionFromElementPosition(view, e);
            view.toFront();//marche pas je sais pas pourquoi

            elementViewMap.put(e, view);
        }
    }


    public static void refreshWindow(){
        Window.root.getChildren().clear();
        for(ImageView iv : elementViewMap.values()){
            //System.out.println(iv);
            Window.root.getChildren().add(iv);
        }
    }


    public static void updateDynamicsElements(){
        for (DynamicElement e : getDynamicElements()) {
            updateElement(e);
        }
    }

    public static void updateInteractableElements(){
        for (Element e : getInteractableElements()) {
            //supprime pour replacer les éléments dynamiques au premier plan
            Window.root.getChildren().remove(elementViewMap.get(e));

            setImageViewPositionFromElementPosition(elementViewMap.get(e), e);
            Window.root.getChildren().add(elementViewMap.get(e));
        }
    }

    public static void updateElement(Element element){
        //supprime pour replacer les éléments dynamiques au premier plan
        Window.root.getChildren().remove(elementViewMap.get(element));

        setImageViewPositionFromElementPosition(elementViewMap.get(element), element);
        Window.root.getChildren().add(elementViewMap.get(element));
    }


    public static List<Element> getElements(){
        return new ArrayList<>(elementViewMap.keySet());
    }

    public static List<StaticElement> getStaticElements(){
        List<Element> keys = new ArrayList<>(elementViewMap.keySet());
        List<StaticElement> result = new ArrayList<>();

        for(int i = 0; i < keys.size(); ++i) {
            if (keys.get(i) instanceof StaticElement) result.add((StaticElement) keys.get(i));
        }

        return result;
    }

    public static List<DynamicElement> getDynamicElements() {
        List<Element> keys = new ArrayList<>(elementViewMap.keySet());
        List<DynamicElement> result = new ArrayList<>();

        for(int i = 0; i < keys.size(); ++i) {
            if (keys.get(i) instanceof DynamicElement) result.add((DynamicElement) keys.get(i));
        }

        return result;
    }

    public static List<Element> getInteractableElements(){
        List<Element> keys = new ArrayList<>(elementViewMap.keySet());
        List<Element> result = new ArrayList<>();

        for(int i = 0; i < keys.size(); ++i) {
            if (keys.get(i) instanceof Interactable) result.add(keys.get(i));
        }

        return result;
    }

    public static List<Element> getPlaybleElements() {
        List<Element> keys = new ArrayList<>(elementViewMap.keySet());
        List<Element> result = new ArrayList<>();

        for(int i = 0; i < keys.size(); ++i) {
            if (keys.get(i) instanceof Playable) result.add(keys.get(i));
        }

        return result;
    }



    /*-------------------------------- PRIVATE --------------------------------*/
    private static void setImageViewPositionFromElementPosition(ImageView view, Element element){
        view.setX(element.getGraphicShape().getxPosition());
        view.setY(element.getGraphicShape().getyPosition());
    }

    private static ImageView createElementImageView(Element element) throws IOException {
        FileInputStream imageElementInputStream = new FileInputStream(element.getImage());
        Image elementImage = new Image(imageElementInputStream, element.getGraphicShape().getWidth(),
                element.getGraphicShape().getHeigth(), false, false);
        imageElementInputStream.close();

        return new ImageView(elementImage);
    }
}
