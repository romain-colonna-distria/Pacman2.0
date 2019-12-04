package fr.univ_amu.game_engine.behavior;

import fr.univ_amu.game_engine.io_engine.InputsController;

public interface Playable extends Interactable {
    int getScore();
    void addPoints(int points);
    void retrievePoints(int points);
    InputsController getInputControl();
    void setInputControl(InputsController inputsController);
    void updateDirectionFromInput();
    void undoUpdateDirection();
}
