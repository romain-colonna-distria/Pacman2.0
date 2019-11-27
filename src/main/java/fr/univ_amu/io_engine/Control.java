package fr.univ_amu.io_engine;

public class Control {

    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    public Control() {

    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public void setAll(boolean b) {
        setLeft(b);
        setRight(b);
        setUp(b);
        setDown(b);
    }
}
