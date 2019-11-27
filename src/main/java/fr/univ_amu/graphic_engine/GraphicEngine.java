package fr.univ_amu.graphic_engine;


import fr.univ_amu.GameBoard;
import fr.univ_amu.element.Element;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;


public class GraphicEngine {
    private HashMap<Element, ImageView> elementImageViewHashMap = new HashMap<>();

    /*
    public GraphicEngine(Group root){
        this.root = root;
    }
    */

    public void updateView(Group root) throws IOException {
        GameBoard board = GameBoard.getInstance();
        FileInputStream fis;
        for (Element e : board.getElements()) {
            fis = new FileInputStream(e.getImage());
            Image image = new Image(fis, e.getGraphicShape().getWidth(),
                    e.getGraphicShape().getHeigth(), false, false);
            ImageView view = new ImageView(image);

            view.setX(e.getGraphicShape().getxPosition());
            view.setY(e.getGraphicShape().getyPosition());
            root.getChildren().add(view);
            elementImageViewHashMap.put(e, view);
            fis.close();
        }


        root.getChildren().clear();
        for(ImageView iv : elementImageViewHashMap.values()){
            root.getChildren().add(iv);
        }
    }
}
