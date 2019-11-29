package fr.univ_amu.io_engine;

import fr.univ_amu.utils.Direction;

public abstract class Controller {
    private Direction direction = null;

    public Direction getDirection() {
        Direction tmp = this.direction;
        this.direction = null;
        return tmp;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
