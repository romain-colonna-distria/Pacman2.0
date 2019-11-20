package fr.univ_amu;

import javafx.application.Application;


public class Main {
    private static final double CELL_WIDTH  = 20d;
    private static final double CELL_HEIGTH = 20d;
    private static final int NB_COLUMN = 28;
    private static final int NB_ROW = 31;
    private static double DELTA_X_LEFT = 100d;
    private static double DELTA_X_RIGHT = 100d;
    private static double DELTA_Y_UP = 0d;
    private static double DELTA_Y_DOWN = 0d;

    public static void main(String[] args) {
        Application.launch(Window.class);
    }
}
