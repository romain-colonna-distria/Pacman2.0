package fr.univ_amu;

import fr.univ_amu.element.Element;
import fr.univ_amu.io_engine.Control;
import fr.univ_amu.io_engine.KeyboardControl;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class Window extends Application {
    private Group root = new Group();
    private Scene theScene = new Scene(root);
    private KeyboardControl keyboardControl = new KeyboardControl();

    @Override
    public void start(Stage primaryStage) throws Exception {

        boolean isFullscreen = false;
        primaryStage.setTitle("Pacman");

        primaryStage.setScene(theScene);
        primaryStage.sizeToScene();

        //System.out.println(GameBoard.getInstance());
        setElementsInStage(GameBoard.getInstance());

        EventHandler<KeyEvent> keyPressed = createKeyEvent(keyboardControl);
        theScene.addEventFilter(KeyEvent.KEY_PRESSED, keyPressed);

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        }.start();

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

    public void update() {
        move();
    }

    public void move() {
        if (keyboardControl.isLeft()) {
            System.out.println("LEFT");
        }
        if (keyboardControl.isRight()) {
            System.out.println("RIGHT");
        }
        if (keyboardControl.isUp()) {
            System.out.println("UP");
        }
        if (keyboardControl.isDown()) {
            System.out.println("DOWN");
        }
    }

    private EventHandler<KeyEvent> createKeyEvent(KeyboardControl keyboardControl) {
        EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                keyboardControl.keyPressed(keyEvent);
            }
        };
        return keyPressed;
    }

}
