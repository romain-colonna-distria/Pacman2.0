package fr.univ_amu.io_engine.new_engine.dispatcher;

import fr.univ_amu.io_engine.new_engine.KeyboardInputObserver;

import java.util.ArrayList;
import java.util.List;

public class KeyboardInputs implements UserInputs {
    List<KeyboardInputObserver> observers = new ArrayList<>();

    public void addObserver(KeyboardInputObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(KeyboardInputObserver observer) {

        this.observers.remove(observer);
    }

    @Override
    public void dispatch(String key) {
        for(KeyboardInputObserver o : observers)
            o.update(key);
    }
}
