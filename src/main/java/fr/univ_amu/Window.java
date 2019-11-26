package fr.univ_amu;

import fr.univ_amu.element.Element;
import fr.univ_amu.entity.Ghost;
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

        
        /*------------- Ghost -------------*/
        
        List<Ghost> elements1 = board.getGhosts();
        Ghost ghost;
        List<ImageView> iv2 = new ArrayList<>();
        Image image1;
        for(int i = 0; i < elements1.size(); ++i){
        	iv2.add(new ImageView());
        }

        for(int i = 0; i < elements1.size(); ++i){
        	ghost = elements1.get(i);

        	image1 = new Image(new FileInputStream(ghost.getImage()), ghost.getGraphicShape().getWidth(),
            		ghost.getGraphicShape().getHeigth(), false, false);
            iv2.get(i).setImage(image1);
            iv2.get(i).setX(ghost.getGraphicShape().getxPosition());
            iv2.get(i).setY(ghost.getGraphicShape().getyPosition());
        }
        
        
        
       
        
        

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
        root.getChildren().addAll(iv2);
        root.getChildren().add(iv);
       
    }
}
