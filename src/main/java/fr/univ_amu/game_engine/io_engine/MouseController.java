package fr.univ_amu.game_engine.io_engine;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MouseController extends InputsController<MouseEvent> {

    public MouseController() throws IOException {
        super("src/main/resources/mouse_commands.conf");
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("????");
        System.out.println("---Mouse: " + mouseEvent);
    }

    @Override
    public EventType getEventType() {
        return MouseEvent.MOUSE_PRESSED;
    }
}
