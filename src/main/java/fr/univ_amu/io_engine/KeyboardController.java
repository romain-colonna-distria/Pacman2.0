package fr.univ_amu.io_engine;

import fr.univ_amu.utils.Direction;
import fr.univ_amu.utils.QwertyToAzerty;
import javafx.event.EventType;
import javafx.scene.input.KeyEvent;

import java.io.IOException;


public class KeyboardController extends InputsController<KeyEvent> {

    public KeyboardController() throws IOException {
        super("src/main/resources/keyboard_commands.conf");
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        String key = QwertyToAzerty.getAzertyFromQwerty(keyEvent.getCode().toString());
        String action = this.getConfigurationsFile().getAssociatedKey(key.toLowerCase());

        if(action == null) {
            System.out.println(key + " n'est pas une touche de jeu.");
            return;
        }

        action = action.toLowerCase();
        switch (action){
            case "left":
                this.setDirection(Direction.LEFT);
                break;
            case "right":
                this.setDirection(Direction.RIGHT);
                break;
            case "up":
                this.setDirection(Direction.UP);
                break;
            case "down":
                this.setDirection(Direction.DOWN);
                break;
            default:
                System.out.println(keyEvent.getCode() + " n'est pas une touche de jeu.");
        }
    }

    @Override
    public EventType getEventType(){
        return KeyEvent.KEY_PRESSED;
    }
}
