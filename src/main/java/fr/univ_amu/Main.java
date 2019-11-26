package fr.univ_amu;

import fr.univ_amu.element.Element;
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

        String imagePath = "src/main/resources/img_15_15_black_background/pacman/pacman_eat_1.png";

        Pacman.PacmanBuilder pacmanBuilder = new Pacman.PacmanBuilder(graphicShapePacman, physicShapePacman, imagePath);
        pacmanBuilder.setSpeed(2);
        Pacman pacman = pacmanBuilder.build();
        pacman.getGraphicShape().setxPosition(100d);
        pacman.getGraphicShape().setyPosition(100d);

        board.addElement(pacman);
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
