package fr.univ_amu.graphic_engine;


import fr.univ_amu.GameBoard;
import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.element.Element;
import fr.univ_amu.element.StaticElement;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.HashMap;


public class GraphicEngine {
    public static HashMap<Element, ImageView> elementImageViewHashMap = new HashMap<>();

    public void loadStaticsElements() throws IOException {
        GameBoard board = GameBoard.getInstance();
        if(elementImageViewHashMap == null) elementImageViewHashMap = new HashMap<>();

        for (StaticElement e : board.getStaticElements()) {
            ImageView view = getElementImageView(e);
            setImageViewPositionFromElementPosition(view, e);
            view.toBack(); //marche pas je sais pas pourquoi

            elementImageViewHashMap.put(e, view);
        }
    }


    public void loadDynamicsElements() throws IOException {
        GameBoard board = GameBoard.getInstance();
        if(elementImageViewHashMap == null) elementImageViewHashMap = new HashMap<>();

        for (DynamicElement e : board.getDynamicElements()) {
            ImageView view = getElementImageView(e);
            setImageViewPositionFromElementPosition(view, e);
            view.toFront();//marche pas je sais pas pourquoi

            elementImageViewHashMap.put(e, view);
        }
    }

    public static void displayElements(Group root){
        root.getChildren().clear();
        for(ImageView iv : elementImageViewHashMap.values()){
            root.getChildren().add(iv);
        }
    }

    public void updateDynamicsElements(){
        GameBoard board = GameBoard.getInstance();

        for (DynamicElement e : board.getDynamicElements()) {
            //supprime pour replacer les éléments dynamiques au premier plan
            Window.root.getChildren().remove(elementImageViewHashMap.get(e));

            setImageViewPositionFromElementPosition(elementImageViewHashMap.get(e), e);
            Window.root.getChildren().add(elementImageViewHashMap.get(e));
        }
    }

    public void updateInteractableElements(){
        GameBoard board = GameBoard.getInstance();

        for (Element e : board.getInteractableElements()) {
            //supprime pour replacer les éléments dynamiques au premier plan
            Window.root.getChildren().remove(elementImageViewHashMap.get(e));

            setImageViewPositionFromElementPosition(elementImageViewHashMap.get(e), e);
            Window.root.getChildren().add(elementImageViewHashMap.get(e));
        }
    }


    private void setImageViewPositionFromElementPosition(ImageView view, Element element){
        view.setX(element.getGraphicShape().getxPosition());
        view.setY(element.getGraphicShape().getyPosition());
    }


    public static void removeElement(Element element){
        GameBoard.getInstance().retrieveElement(element, elementImageViewHashMap.get(element));
        elementImageViewHashMap.remove(element);
        //System.out.println("Suprimé");
    }


    private ImageView getElementImageView(Element element) throws IOException {
        FileInputStream imageElementInputStream = new FileInputStream(element.getImage());
        Image elementImage = new Image(imageElementInputStream, element.getGraphicShape().getWidth(),
                element.getGraphicShape().getHeigth(), false, false);
        imageElementInputStream.close();

        return new ImageView(elementImage);
    }
}
