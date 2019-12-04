package fr.univ_amu.game_engine.graphic_engine;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Window extends Application {
    public static Group root = new Group();
    public static Scene theScene = new Scene(root);
    private boolean isFullScrean = false;
    private static Stage stage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        primaryStage.setScene(theScene);
        primaryStage.sizeToScene();

        //primaryStage.getIcons().add(new Image("file:src/main/resources/img/icon.png"));
        primaryStage.setFullScreen(isFullScrean);

        primaryStage.show();
    }

    public static Stage getStage() {
        return stage;
    }
}
