package fr.univ_amu.behavior;

import fr.univ_amu.io_engine.InputsController;

public interface Playable extends Interactable {
    int getScore();
    void addPoints(int points);
    void retrievePoints(int points);
    InputsController getInputControl();
    void setInputControl(InputsController inputsController);
    void updateDirectionFromInput();
    void undoUpdateDirection();
}
