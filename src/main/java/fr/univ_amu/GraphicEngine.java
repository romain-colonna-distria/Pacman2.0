package fr.univ_amu;


import fr.univ_amu.element.Element;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.HashMap;


public class GraphicEngine {
    private Group root;
    private HashMap<Element, ImageView> elementImageViewHashMap = new HashMap<>();

    public GraphicEngine(Group root){
        this.root = root;
    }

    public void updateElementsInStage() throws FileNotFoundException {
        GameBoard board = GameBoard.getInstance();

        for (Element e : board.getElements()) {
            Image image = new Image(new FileInputStream(e.getImage()), e.getGraphicShape().getWidth(), e.getGraphicShape().getHeigth(), false, false);
            ImageView view = new ImageView(image);
            view.setX(e.getGraphicShape().getxPosition());
            view.setY(e.getGraphicShape().getyPosition());
            root.getChildren().add(view);
            elementImageViewHashMap.put(e, view);
        }


        root.getChildren().clear();
        for(ImageView iv : elementImageViewHashMap.values()){
            root.getChildren().add(iv);
        }

    }
}
