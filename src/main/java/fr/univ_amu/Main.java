package fr.univ_amu;

import fr.univ_amu.audio_engine.SoundEngine;
import fr.univ_amu.element.Element;
import fr.univ_amu.entity.*;
import fr.univ_amu.graphic_engine.GraphicEngine;
import fr.univ_amu.io_engine.KeyboardController;
import fr.univ_amu.physic_engine.PhysicEngine;
import fr.univ_amu.utils.Shape2D;
import fr.univ_amu.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@SuppressWarnings("Duplicates")
public class Main {
    private static final double ELEMENT_WIDTH = 20d;
    private static final double ELEMENT_HEIGTH = 20d;
    private static final int NB_COLUMN = 28;
    private static final int NB_ROW = 31;
    //private static double DELTA_X_LEFT = 100d;
    //private static double DELTA_X_RIGHT = 100d;
    //private static double DELTA_Y_UP = 0d;
    //private static double DELTA_Y_DOWN = 0d;

    public static void main(String[] args) throws InterruptedException, IOException {
        GameBoard board = GameBoard.getInstance();

        /*-------------------------- Pacman --------------------------*/
        String imagePacman = "src/main/resources/img_15_15_black_background/pacman/pacman_eat_1.png";

        Shape2D graphicShapePacman = new Shape2D();
        graphicShapePacman.setWidth(ELEMENT_WIDTH);
        graphicShapePacman.setHeigth(ELEMENT_HEIGTH);
        graphicShapePacman.setxPosition(260d);
        graphicShapePacman.setyPosition(340d);

        Shape2D physicShapePacman = new Shape2D();
        physicShapePacman.setWidth(ELEMENT_WIDTH);
        physicShapePacman.setHeigth(ELEMENT_HEIGTH);
        physicShapePacman.setxPosition(260d);
        physicShapePacman.setyPosition(340d);

        Pacman pacman = new Pacman.PacmanBuilder(graphicShapePacman, physicShapePacman, imagePacman)
                .setSpeed(1)
                .setScore(0)
                .setLifes(3)
                .build();

        board.addElement(pacman);
        /*------------------------------------------------------------*/


        /*-------------------------- Ghosts --------------------------*/
        String imageBlinky = "src/main/resources/img_15_15_black_background/ghosts/blinky/blinky_L.png";
        String imageClyde = "src/main/resources/img_15_15_black_background/ghosts/clyde/clyde_L.png";
        String imageInky = "src/main/resources/img_15_15_black_background/ghosts/inky/inky_U.png";
        String imagePinky = "src/main/resources/img_15_15_black_background/ghosts/pinky/pinky_U.png";

        List<Element> ghosts = new ArrayList<>();
        List<Shape2D> graphicShape2Ds = new ArrayList<>(4);
        List<Shape2D> physicShape2Ds = new ArrayList<>(4);
        List<String> images = new ArrayList<>(4);


        for(int i = 0; i < 4; ++i){
            graphicShape2Ds.add(new Shape2D());
            graphicShape2Ds.get(i).setWidth(ELEMENT_WIDTH);
            graphicShape2Ds.get(i).setHeigth(ELEMENT_HEIGTH);
            graphicShape2Ds.get(i).setxPosition(280d);
            graphicShape2Ds.get(i).setyPosition(280d);

            physicShape2Ds.add(new Shape2D());
            physicShape2Ds.get(i).setWidth(ELEMENT_WIDTH);
            physicShape2Ds.get(i).setHeigth(ELEMENT_HEIGTH);
            physicShape2Ds.get(i).setxPosition(280d);
            physicShape2Ds.get(i).setyPosition(280d);
        }

        images.add(imageBlinky);
        images.add(imageClyde);
        images.add(imageInky);
        images.add(imagePinky);

        for(int i = 0; i < 4; ++i){
            Ghost tmp = new Ghost.GhostBuilder(graphicShape2Ds.get(i), physicShape2Ds.get(i), images.get(i)).build();
            ghosts.add(tmp);
        }

        board.addElements(ghosts);
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
            e.getPhysiqueShape().setxPosition(j * ELEMENT_WIDTH);
            e.getPhysiqueShape().setyPosition(k * ELEMENT_HEIGTH);

            ++j;
            if(j == NB_COLUMN){
                ++k;
                j = 0;
            }
        }

        board.addElements(elements);
        /*------------------------------------------------------------*/


        /*--------------------- init teleporters ---------------------*/
        List<Trail> trails = new ArrayList<>();
        for(Element e : elements){
            if(!(e instanceof Trail)) continue;
            trails.add((Trail) e);
        }

        Random random = new Random();
        int randdomPos = random.nextInt(trails.size() - 1);


        for(int i = 0; i < elements.size(); ++i){
            if(!(elements.get(i) instanceof Teleporter)) continue;
            ((Teleporter) elements.get(i)).bind(trails.get(randdomPos));
        }
        /*------------------------------------------------------------*/


        /*------------------------ init candy ------------------------*/
        List<Element> candies = new ArrayList<>();
        String imageCandy = "src/main/resources/empty_cross.png";
        for (Trail t : trails){
            candies.add(new Candy(t.getGraphicShape(), t.getPhysiqueShape(), imageCandy));
        }
        board.addElements(candies);
        /*------------------------------------------------------------*/


        /*----------------------- core kernel ------------------------*/
        PhysicEngine physicEngine = new PhysicEngine();
        GraphicEngine graphicEngine = new GraphicEngine();
        SoundEngine soundEngine = new SoundEngine(1);


        CoreKernel kernel = new CoreKernel(physicEngine, graphicEngine, soundEngine);
        try {
            KeyboardController keyControl = new KeyboardController();
            //MouseController mouseControl = new MouseController();

            kernel.addInputsControl(keyControl.getEventType(), keyControl);
            //kernel.addInputsControl(mouseControl.getEventType(), mouseControl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        kernel.startGame();
        /*------------------------------------------------------------*/
    }
}
