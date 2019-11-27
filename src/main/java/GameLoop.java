import fr.univ_amu.CoreKernel;
import javafx.animation.AnimationTimer;


public class GameLoop extends AnimationTimer {
    private CoreKernel kernel;

    public GameLoop(CoreKernel kernel) {
        this.kernel = kernel;
    }

    @Override
    public void handle(long now) {
        kernel.updateGame();
    }
}
