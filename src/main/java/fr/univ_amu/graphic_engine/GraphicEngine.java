package fr.univ_amu.graphic_engine;


import fr.univ_amu.GameBoard;
import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.element.Element;
import fr.univ_amu.element.StaticElement;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.HashMap;


public class GraphicEngine {
    public static HashMap<Element, ViewImage> elementImageViewHashMap = new HashMap<>();

    public void loadStaticsElements() throws IOException {
        GameBoard board = GameBoard.getInstance();
        if(elementImageViewHashMap == null) elementImageViewHashMap = new HashMap<>();

        for (StaticElement e : board.getStaticElements()) {
            ViewImage view = getElementImageView(e);
            setImageViewPositionFromElementPosition(view, e);

            elementImageViewHashMap.put(e, view);
        }
    }

    public void loadDynamicsElements() throws IOException {
        GameBoard board = GameBoard.getInstance();
        if(elementImageViewHashMap == null) elementImageViewHashMap = new HashMap<>();

        for (DynamicElement e : board.getDynamicElements()) {
            ViewImage view = getElementImageView(e);
            setImageViewPositionFromElementPosition(view, e);

            elementImageViewHashMap.put(e, view);
        }
    }

    public static void refreshElements(){
        Window.clearWindow();
        for(ViewImage iv : elementImageViewHashMap.values()){
            Window.addViewImage(iv);
        }
    }

    public void updateDynamicsElements(){
        GameBoard board = GameBoard.getInstance();

        for (DynamicElement e : board.getDynamicElements()) {
            //supprime pour replacer les éléments dynamiques au premier plan
            Window.removeViewImage(elementImageViewHashMap.get(e));

            setImageViewPositionFromElementPosition(elementImageViewHashMap.get(e), e);
            Window.addViewImage(elementImageViewHashMap.get(e));
        }
    }

    public void updateInteractableElements(){
        GameBoard board = GameBoard.getInstance();

        for (Element e : board.getInteractableElements()) {
            //supprime pour replacer les éléments dynamiques au premier plan
            Window.removeViewImage(elementImageViewHashMap.get(e));

            setImageViewPositionFromElementPosition(elementImageViewHashMap.get(e), e);
            Window.addViewImage(elementImageViewHashMap.get(e));
        }
    }

    private void setImageViewPositionFromElementPosition(ViewImage view, Element element){
        view.setX(element.getGraphicShape().getxPosition());
        view.setY(element.getGraphicShape().getyPosition());
    }

    public static void addElement(Element element){

    }

    public static void removeElement(Element element){
        GameBoard.getInstance().retrieveElement(element, elementImageViewHashMap.get(element));
        elementImageViewHashMap.remove(element);
        //System.out.println("Suprimé");
    }

    private ViewImage getElementImageView(Element element) throws IOException {

        FileInputStream imageElementInputStream = new FileInputStream(element.getImage());
        Image elementImage = new Image(imageElementInputStream, element.getGraphicShape().getWidth(),
                element.getGraphicShape().getHeigth(), false, false);
        imageElementInputStream.close();


        return new ViewImage(elementImage);
    }
}
