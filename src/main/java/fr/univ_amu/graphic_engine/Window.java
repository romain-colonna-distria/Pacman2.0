package fr.univ_amu.graphic_engine;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Window extends Application {
    public static Group root = new Group();
    private Scene theScene = new Scene(root);
    private boolean isFullScrean = false;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pacman");

        primaryStage.setScene(theScene);
        primaryStage.sizeToScene();

        //primaryStage.getIcons().add(new Image("file:src/main/resources/img/icon.png"));
        primaryStage.setFullScreen(isFullScrean);

        primaryStage.show();
    }
}
