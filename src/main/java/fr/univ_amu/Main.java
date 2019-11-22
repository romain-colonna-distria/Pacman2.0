package fr.univ_amu;

import fr.univ_amu.element.Element;
import fr.univ_amu.entity.Pacman;
import fr.univ_amu.utils.RectangularShape;
import fr.univ_amu.utils.Utils;
import javafx.application.Application;

import java.util.List;


public class Main {
    private static final double ELEMENT_WIDTH = 20d;
    private static final double ELEMENT_HEIGTH = 20d;
    //private static double DELTA_X_LEFT = 100d;
    //private static double DELTA_X_RIGHT = 100d;
    //private static double DELTA_Y_UP = 0d;
    //private static double DELTA_Y_DOWN = 0d;

    public static void main(String[] args) {
        GameBoard board = GameBoard.getInstance();

        /*-------------------------- Pacman --------------------------*/
        RectangularShape graphicShapePacman = new RectangularShape(ELEMENT_WIDTH, ELEMENT_HEIGTH);
        RectangularShape physicShapePacman = new RectangularShape(ELEMENT_WIDTH, ELEMENT_HEIGTH);
        String imagePath = "src/main/resources/img_15_15_black_background/pacman/pacman_eat_1.png";
        //Position2D graphicPosition = new Position2D(100d, 100d);
        //Position2D physicPosition = new Position2D(100d, 100d);
        Pacman pacman = new Pacman.PacmanBuilder(graphicShapePacman, physicShapePacman, imagePath)
                .setgraphicPosition(100d, 100d)
                .setphysicPosition(100d, 100d)
                .build();

        board.addElement(pacman);
        /*------------------------------------------------------------*/


        /*--------------------- static elements ----------------------*/
        RectangularShape graphicShapeElements = new RectangularShape(ELEMENT_WIDTH, ELEMENT_HEIGTH);
        RectangularShape physicShapeElements = new RectangularShape(ELEMENT_WIDTH, ELEMENT_HEIGTH);
        String mapFilePath = "src/main/resources/map.txt";
        //Position2D graphicPositionStatic = new Position2D(100d, 100d);
        //Position2D physicPositionStatic = new Position2D(100d, 100d);

        List<Element> elements = Utils.initStaticElements(mapFilePath, graphicShapeElements, physicShapeElements);

        board.addElements(elements);
        /*------------------------------------------------------------*/


        Application.launch(Window.class);
    }
}
