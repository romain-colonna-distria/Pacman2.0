package fr.univ_amu;

import fr.univ_amu.element.Element;
import fr.univ_amu.entity.Ghost;
import fr.univ_amu.entity.Pacman;
import fr.univ_amu.utils.Direction;
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
        
        Shape2D graphicShapeGhost1 = new Shape2D();
        graphicShapeGhost1.setWidth(ELEMENT_WIDTH);
        graphicShapeGhost1.setHeigth(ELEMENT_HEIGTH);

        Shape2D physicShapeGhost1 = new Shape2D();
        physicShapeGhost1.setWidth(ELEMENT_WIDTH);
        physicShapeGhost1.setHeigth(ELEMENT_HEIGTH);
        
        Shape2D graphicShapeGhost2 = new Shape2D();
        graphicShapeGhost2.setWidth(ELEMENT_WIDTH);
        graphicShapeGhost2.setHeigth(ELEMENT_HEIGTH);

        Shape2D physicShapeGhost2 = new Shape2D();
        physicShapeGhost2.setWidth(ELEMENT_WIDTH);
        physicShapeGhost2.setHeigth(ELEMENT_HEIGTH);
        
        Shape2D graphicShapeGhost3 = new Shape2D();
        graphicShapeGhost3.setWidth(ELEMENT_WIDTH);
        graphicShapeGhost3.setHeigth(ELEMENT_HEIGTH);

        Shape2D physicShapeGhost3 = new Shape2D();
        physicShapeGhost3.setWidth(ELEMENT_WIDTH);
        physicShapeGhost3.setHeigth(ELEMENT_HEIGTH);
        
        Shape2D graphicShapeGhost4 = new Shape2D();
        graphicShapeGhost4.setWidth(ELEMENT_WIDTH);
        graphicShapeGhost4.setHeigth(ELEMENT_HEIGTH);

        Shape2D physicShapeGhost4 = new Shape2D();
        physicShapeGhost4.setWidth(ELEMENT_WIDTH);
        physicShapeGhost4.setHeigth(ELEMENT_HEIGTH);

        String imagePath = "src/main/resources/img_15_15_black_background/pacman/pacman_eat_1.png";      
        String imagePath2 = "src/main/resources/img_15_15_black_background/ghosts/blinky/blinky_L.png";    
        String imagePath3 = "src/main/resources/img_15_15_black_background/ghosts/clyde/clyde_L.png";
        String imagePath4 = "src/main/resources/img_15_15_black_background/ghosts/inky/inky_U.png";
        String imagePath5 = "src/main/resources/img_15_15_black_background/ghosts/pinky/pinky_U.png";
        
        Pacman pacman = new Pacman.PacmanBuilder(graphicShapePacman, physicShapePacman, imagePath).build();
        Ghost ghost1 = new Ghost.GhostBuilder(graphicShapeGhost1, physicShapeGhost1, imagePath2).build();
        Ghost ghost2 = new Ghost.GhostBuilder(graphicShapeGhost2, physicShapeGhost2, imagePath3).build();
        Ghost ghost3 = new Ghost.GhostBuilder(graphicShapeGhost3, physicShapeGhost3, imagePath4).build();
        Ghost ghost4 = new Ghost.GhostBuilder(graphicShapeGhost4, physicShapeGhost4, imagePath5).build();
        
        
        pacman.getGraphicShape().setxPosition(100d);
        pacman.getGraphicShape().setyPosition(100d);
        board.addElement(pacman);
        
        ghost1.getGraphicShape().setxPosition(250d);
        ghost1.getGraphicShape().setyPosition(250d);
        board.addElement(ghost1);
        
        ghost2.getGraphicShape().setxPosition(150d);
        ghost2.getGraphicShape().setyPosition(50d);
        board.addElement(ghost2);
        
        ghost3.getGraphicShape().setxPosition(50d);
        ghost3.getGraphicShape().setyPosition(250d);
        board.addElement(ghost3);
        
        ghost4.getGraphicShape().setxPosition(50d);
        ghost4.getGraphicShape().setyPosition(550d);
        board.addElement(ghost4);
        
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
