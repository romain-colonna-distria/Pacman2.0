package fr.univ_amu;

import fr.univ_amu.element.Element;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class Window extends Application {
    private Group root = new Group();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene theScene = new Scene(root);

        boolean isFullscreen = false;
        primaryStage.setTitle("Pacman");

        primaryStage.setScene(theScene);
        primaryStage.sizeToScene();

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


    private void setElementsInStage(GameBoard board){
        ImageView a = new ImageView();
        Element pacman = board.getPacman();
        a.setImage(new Image(pacman.getImage()));
        a.setX(pacman.getGraphicPositionX());
        a.setY(pacman.getGraphicPositionY());

        root.getChildren().add(a);
    }
}
