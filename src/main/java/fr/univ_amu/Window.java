package fr.univ_amu;

import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.element.Element;

import fr.univ_amu.entity.Pacman;
import fr.univ_amu.io_engine.Control;
import fr.univ_amu.io_engine.KeyboardControl;
import fr.univ_amu.utils.Direction;
import javafx.animation.AnimationTimer;

import fr.univ_amu.entity.Ghost;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Window extends Application {
    private Group root = new Group();
    private Scene theScene = new Scene(root);
    private KeyboardControl keyboardControl = new KeyboardControl();
    private HashMap<DynamicElement, ImageView> dynamicElementImageViewHashMap = new HashMap<>();

    @Override
    public void start(Stage primaryStage) throws Exception {

        boolean isFullscreen = false;
        primaryStage.setTitle("Pacman");

        primaryStage.setScene(theScene);
        primaryStage.sizeToScene();

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

        dynamicElementImageViewHashMap.put((DynamicElement) pacman, iv);
    }

    public void update() {
        move();
    }

    public void move() {
        //MoveTo()
        int step = 3;
        GameBoard board = GameBoard.getInstance();
        Pacman pacman = (Pacman) board.getPacman();
        double x = pacman.getPhysiqueShape().getxPosition();
        double y = pacman.getPhysiqueShape().getyPosition();

        if (keyboardControl.isLeft()) {
            pacman.setCurrentDirection(Direction.LEFT);
            System.out.println("LEFT");
        }
        if (keyboardControl.isRight()) {
            pacman.setCurrentDirection(Direction.RIGHT);
            System.out.println("RIGHT");
        }
        if (keyboardControl.isUp()) {
            pacman.setCurrentDirection(Direction.UP);
            System.out.println("UP");
        }
        if (keyboardControl.isDown()) {
            pacman.setCurrentDirection(Direction.DOWN);
            System.out.println("DOWN");
        }

        pacman.moveTo();
        moveImageViews();

    }

    public void moveImageViews() {
        for (Map.Entry<DynamicElement, ImageView> entry : dynamicElementImageViewHashMap.entrySet()) {
            entry.getValue().setX(entry.getKey().getGraphicShape().getxPosition());
            entry.getValue().setY(entry.getKey().getGraphicShape().getyPosition());
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
