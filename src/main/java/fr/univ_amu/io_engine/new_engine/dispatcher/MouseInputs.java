package fr.univ_amu.io_engine.new_engine.dispatcher;

import fr.univ_amu.io_engine.new_engine.MouseInputObserver;

import java.util.ArrayList;
import java.util.List;

public class MouseInputs implements UserInputs {
    List<MouseInputObserver> observers = new ArrayList<>();


    public void addObserver(MouseInputObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(MouseInputObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void dispatch(String key) {
        for(MouseInputObserver o : observers)
            o.update(key);
    }
}
