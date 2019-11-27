package fr.univ_amu;

import fr.univ_amu.element.Element;
import fr.univ_amu.entity.Ghost;
import fr.univ_amu.entity.Pacman;
import fr.univ_amu.utils.Shape2D;
import fr.univ_amu.utils.Utils;

import javafx.application.Application;

import java.util.List;


public class Main {
    private static final double ELEMENT_WIDTH = 20d;
    private static final double ELEMENT_HEIGTH = 20d;
    private static final int NB_COLUMN = 28;
    private static final int NB_ROW = 31;
    //private static double DELTA_X_LEFT = 100d;
    //private static double DELTA_X_RIGHT = 100d;
    //private static double DELTA_Y_UP = 0d;
    //private static double DELTA_Y_DOWN = 0d;

    public static void main(String[] args) {
        GameBoard board = GameBoard.getInstance();

        
        
        /*-------------------------- Pacman --------------------------*/
        Shape2D graphicShapePacman = new Shape2D();
        graphicShapePacman.setWidth(ELEMENT_WIDTH);
        graphicShapePacman.setHeigth(ELEMENT_HEIGTH);
        
        Shape2D physicShapePacman = new Shape2D();
        physicShapePacman.setWidth(ELEMENT_WIDTH);
        physicShapePacman.setHeigth(ELEMENT_HEIGTH);
                
        /*------------------------------------------------------------*/
        
        
        /*-------------------------- Ghosts --------------------------*/
        
        Shape2D graphicShapeBlinky = new Shape2D();
        graphicShapeBlinky.setWidth(ELEMENT_WIDTH);
        graphicShapeBlinky.setHeigth(ELEMENT_HEIGTH);

        Shape2D physicShapeBlinky = new Shape2D();
        physicShapeBlinky.setWidth(ELEMENT_WIDTH);
        physicShapeBlinky.setHeigth(ELEMENT_HEIGTH);
        
        Shape2D graphicShapeClyde = new Shape2D();
        graphicShapeClyde.setWidth(ELEMENT_WIDTH);
        graphicShapeClyde.setHeigth(ELEMENT_HEIGTH);

        Shape2D physicShapeClyde = new Shape2D();
        physicShapeClyde.setWidth(ELEMENT_WIDTH);
        physicShapeClyde.setHeigth(ELEMENT_HEIGTH);
        
        Shape2D graphicShapeInky = new Shape2D();
        graphicShapeInky.setWidth(ELEMENT_WIDTH);
        graphicShapeInky.setHeigth(ELEMENT_HEIGTH);

        Shape2D physicShapeInky = new Shape2D();
        physicShapeInky.setWidth(ELEMENT_WIDTH);
        physicShapeInky.setHeigth(ELEMENT_HEIGTH);
        
        Shape2D graphicShapePinky = new Shape2D();
        graphicShapePinky.setWidth(ELEMENT_WIDTH);
        graphicShapePinky.setHeigth(ELEMENT_HEIGTH);

        Shape2D physicShapePinky = new Shape2D();
        physicShapePinky.setWidth(ELEMENT_WIDTH);
        physicShapePinky.setHeigth(ELEMENT_HEIGTH);
        
        /*------------------------------------------------------------*/

        String imagePacman = "src/main/resources/img_15_15_black_background/pacman/pacman_eat_1.png";  
        String imageBlinky = "src/main/resources/img_15_15_black_background/ghosts/blinky/blinky_L.png";    
        String imageClyde = "src/main/resources/img_15_15_black_background/ghosts/clyde/clyde_L.png";
        String imageInky = "src/main/resources/img_15_15_black_background/ghosts/inky/inky_U.png";
        String imagePinky = "src/main/resources/img_15_15_black_background/ghosts/pinky/pinky_U.png";

        Pacman.PacmanBuilder pacmanBuilder = new Pacman.PacmanBuilder(graphicShapePacman, physicShapePacman, imagePacman);
        pacmanBuilder.setSpeed(2);
        Pacman pacman = pacmanBuilder.build();
        
        Ghost blinky = new Ghost.GhostBuilder(graphicShapeBlinky, physicShapeBlinky, imageBlinky).build();
        Ghost clyde = new Ghost.GhostBuilder(graphicShapeClyde, physicShapeClyde, imageClyde).build();
        Ghost inky = new Ghost.GhostBuilder(graphicShapeInky, physicShapeInky, imageInky).build();
        Ghost pinky = new Ghost.GhostBuilder(graphicShapePinky, physicShapePinky, imagePinky).build();

        
        
        pacman.getGraphicShape().setxPosition(100d);
        pacman.getGraphicShape().setyPosition(100d);
        board.addElement(pacman);
        
        blinky.getGraphicShape().setxPosition(255d);
        blinky.getGraphicShape().setyPosition(255d);
        board.addElement(blinky);
        
        clyde.getGraphicShape().setxPosition(280d);
        clyde.getGraphicShape().setyPosition(255d);
        board.addElement(clyde);
        
        inky.getGraphicShape().setxPosition(280d);
        inky.getGraphicShape().setyPosition(285d);
        board.addElement(inky);
        
        pinky.getGraphicShape().setxPosition(255d);
        pinky.getGraphicShape().setyPosition(285d);
        board.addElement(pinky);
        
        /*------------------------------------------------------------*/


        /*--------------------- static elements ----------------------*/
        String mapFilePath = "src/main/resources/map.txt";
        Shape2D graphicShapeStaticElements = new Shape2D();
        graphicShapeStaticElements.setWidth(ELEMENT_WIDTH);
        graphicShapeStaticElements.setHeigth(ELEMENT_HEIGTH);

        Shape2D physicShapeStaticElements = new Shape2D();
        physicShapeStaticElements.setWidth(ELEMENT_WIDTH);
        physicShapeStaticElements.setHeigth(ELEMENT_HEIGTH);

        List<Element> elements = Utils.initStaticElements(mapFilePath, graphicShapeStaticElements, physicShapeStaticElements);


        int j = 0;
        int k = 0;
        for(Element e : elements){
            e.getGraphicShape().setxPosition(j * ELEMENT_WIDTH);
            e.getGraphicShape().setyPosition(k * ELEMENT_HEIGTH);

            ++j;
            if(j == NB_COLUMN){
                ++k;
                j = 0;
            }
        }

        board.addElements(elements);
        /*------------------------------------------------------------*/

        Application.launch(Window.class);
    }
}
