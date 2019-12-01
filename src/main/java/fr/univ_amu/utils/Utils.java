package fr.univ_amu.utils;

import fr.univ_amu.element.Element;
import fr.univ_amu.entity.Door;
import fr.univ_amu.entity.Teleporter;
import fr.univ_amu.entity.Trail;
import fr.univ_amu.entity.Wall;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Element> initStaticElements(String mapFile, Shape2D graphicShape, Shape2D physiqcShape){
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
                Shape2D graphicShapeTmp = new Shape2D();
                graphicShapeTmp.setWidth(graphicShape.getWidth());
                graphicShapeTmp.setHeigth(graphicShape.getHeigth());

                Shape2D physicShapeTmp = new Shape2D();
                physicShapeTmp.setWidth(physiqcShape.getWidth());
                physicShapeTmp.setHeigth(physiqcShape.getHeigth());

                Element element = getElementFromChar(row.charAt(j), graphicShapeTmp, physicShapeTmp, j, i);

                elements.add(element);
            }

            ++i;
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return elements;
    }

    private static Element getElementFromChar(char character, Shape2D gs, Shape2D ps, int positionI, int positionJ){
        Element element;
        String imagePath;

        switch (character) {
            case 'a': //coin haut gauche
                imagePath = "src/main/resources/img_15_15_black_background/walls/corner_UL.png";
                element = new Wall(gs, ps, imagePath);
                break;
            case 'p': //coin haut droit
                imagePath = "src/main/resources/img_15_15_black_background/walls/corner_UR.png";
                element = new Wall(gs, ps, imagePath);
                break;
            case 'w': //coin bas gauche
                imagePath = "src/main/resources/img_15_15_black_background/walls/corner_DL.png";
                element = new Wall(gs, ps, imagePath);
                break;
            case 'n': //coin bas droit
                imagePath = "src/main/resources/img_15_15_black_background/walls/corner_DR.png";
                element = new Wall(gs, ps, imagePath);
                break;
            case 'h': //murs horizontales
                imagePath = "src/main/resources/img_15_15_black_background/walls/wall_H.png";
                element = new Wall(gs, ps, imagePath);
                break;
            case 'v': //murs verticales
                imagePath = "src/main/resources/img_15_15_black_background/walls/wall_V.png";
                element = new Wall(gs, ps, imagePath);
                break;
            case 't': //chemin
                imagePath = "src/main/resources/img_15_15_black_background/black.png";
                element = new Trail(gs, ps, imagePath);
                break;

            case 'd': //porte
                imagePath = "src/main/resources/img_15_15_black_background/walls/wall_H.png";
                element = new Door(gs, ps, imagePath);
                break;
            case 'm': //teleporteur ///Changer image
                imagePath = "src/main/resources/red.png";
                element = new Teleporter(gs, ps, imagePath);
                break;
            case 'i': //mur plein
                imagePath = "src/main/resources/img_15_15_black_background/black.png";
                element = new Wall(gs, ps, imagePath);
                break;
            default:
                System.err.println("conversion inconnu: " + character);
                imagePath = "src/main/resources/empty_cross.png";
                element = new Wall(gs, ps, imagePath);
        }

        return element;
    }

}
