package fr.univ_amu.utils;

import fr.univ_amu.element.Element;
import fr.univ_amu.entity.Wall;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Element> initStaticElements(String mapFile, RectangularShape gs, RectangularShape ps){
        List<Element> elements = new ArrayList<>();
        BufferedReader reader = null;
        File config = new File(mapFile);

        try {
            reader = new BufferedReader(new FileReader(config));
        } catch (FileNotFoundException e) {
            System.err.println("Fichier de configuration introuvable.");
            System.exit(1);
        }

        String row = "";
        int i = 0;
        while (true){
            try {
                if ((row = reader.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            for(int j = 0; j < row.length(); ++j) {
                RectangularShape graphicShapeTmp = new RectangularShape(gs.getWidth(), gs.getHeigth());
                RectangularShape physicShapeTmp = new RectangularShape(ps.getWidth(), ps.getHeigth());

                Element element = getElementFromChar(row.charAt(j), graphicShapeTmp, physicShapeTmp, j, i);

                elements.add(element);
            }

            ++i;
        }

        return elements;
    }

    private static Element getElementFromChar(char character, RectangularShape gs, RectangularShape ps, int positionI, int positionJ){
        Element element;
        String imagePath;

        switch (character) {
            case 'a': //coin haut gauche
                imagePath = "src/main/resources/img_15_15_black_background/walls/corner_UL.png";
                element = new Wall.WallBuilder(gs, ps, imagePath)
                        .setgraphicPosition(positionI * gs.getWidth(), positionJ * gs.getHeigth())
                        .build();
                break;
            case 'p': //coin haut droit
                imagePath = "src/main/resources/img_15_15_black_background/walls/corner_UR.png";
                element = new Wall.WallBuilder(gs, ps, imagePath)
                        .setgraphicPosition(positionI * gs.getWidth(), positionJ * gs.getHeigth())
                        .build();
                break;
            case 'w': //coin bas gauche
                imagePath = "src/main/resources/img_15_15_black_background/walls/corner_DL.png";
                element = new Wall.WallBuilder(gs, ps, imagePath)
                        .setgraphicPosition(positionI * gs.getWidth(), positionJ * gs.getHeigth())
                        .build();
                break;
            case 'n': //coin bas droit
                imagePath = "src/main/resources/img_15_15_black_background/walls/corner_DR.png";
                element = new Wall.WallBuilder(gs, ps, imagePath)
                        .setgraphicPosition(positionI * gs.getWidth(), positionJ * gs.getHeigth())
                        .build();
                break;
            case 'h': //murs horizontales
                imagePath = "src/main/resources/img_15_15_black_background/walls/wall_H.png";
                element = new Wall.WallBuilder(gs, ps, imagePath)
                        .setgraphicPosition(positionI * gs.getWidth(), positionJ * gs.getHeigth())
                        .build();
                break;
            case 'v': //murs verticales
                imagePath = "src/main/resources/img_15_15_black_background/walls/wall_V.png";
                element = new Wall.WallBuilder(gs, ps, imagePath)
                        .setgraphicPosition(positionI * gs.getWidth(), positionJ * gs.getHeigth())
                        .build();
                break;
            case 't': //chemin Changer type
                imagePath = "src/main/resources/img_15_15_black_background/black.png";
                element = new Wall.WallBuilder(gs, ps, imagePath)
                        .setgraphicPosition(positionI * gs.getWidth(), positionJ * gs.getHeigth())
                        .build();
                break;

            case 'd': //porte Changer type
                imagePath = "src/main/resources/img_15_15_black_background/walls/wall_H.png";
                element = new Wall.WallBuilder(gs, ps, imagePath)
                        .setgraphicPosition(positionI * gs.getWidth(), positionJ * gs.getHeigth())
                        .build();
                break;
            default:
                System.err.println("conversion inconnu: " + character);
                imagePath = "src/main/resources/empty_cross.png";
                element = new Wall.WallBuilder(gs, ps, imagePath)
                        .setgraphicPosition(positionI * gs.getWidth(), positionJ * gs.getHeigth())
                        .build();
        }

        return element;
    }

}
