package fr.univ_amu;

import fr.univ_amu.element.Element;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class Window extends Application {
    private Group root = new Group();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene theScene = new Scene(root);

        boolean isFullscreen = false;
        primaryStage.setTitle("Pacman");

        primaryStage.setScene(theScene);
        primaryStage.sizeToScene();

        //System.out.println(GameBoard.getInstance());
        setElementsInStage(GameBoard.getInstance());

        /*
        new AnimationTimer() {
            @Override
            public void handle(long now) {

            }
        };

*/
        //primaryStage.getIcons().add(new Image("file:src/main/resources/img/icon.png"));
        primaryStage.setFullScreen(isFullscreen);

        primaryStage.show();
    }


    private void setElementsInStage(GameBoard board) throws FileNotFoundException {
        ImageView iv = new ImageView();
        /*------------- Pacman -------------*/
        Element pacman = board.getPacman();
        iv.setImage(new Image(new FileInputStream(pacman.getImage()), pacman.getGraphicShape().getWidth(),
                        pacman.getGraphicShape().getHeigth(), false, false));
        iv.setX(pacman.getGraphicShape().getxPosition());
        iv.setY(pacman.getGraphicShape().getyPosition());



        /*--------- Static elements ---------*/
        List<Element> elements = board.getStaticElements();
        Element staticElement;
        List<ImageView> ivs = new ArrayList<>();
        Image image;
        for(int i = 0; i < elements.size(); ++i){
            ivs.add(new ImageView());
        }

        for(int i = 0; i < elements.size(); ++i){
            staticElement = elements.get(i);

            image = new Image(new FileInputStream(staticElement.getImage()), staticElement.getGraphicShape().getWidth(),
                    staticElement.getGraphicShape().getHeigth(), false, false);
            ivs.get(i).setImage(image);
            ivs.get(i).setX(staticElement.getGraphicShape().getxPosition());
            ivs.get(i).setY(staticElement.getGraphicShape().getyPosition());
        }


        root.getChildren().addAll(ivs);
        root.getChildren().add(iv);
    }
}
