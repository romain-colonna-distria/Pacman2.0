package fr.univ_amu.io_engine;

import fr.univ_amu.utils.ConfigurationsFile;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;

import java.io.IOException;

public abstract class InputsController<T extends Event> extends Controller implements EventHandler<T> {
    private ConfigurationsFile configurationsFile;

    public InputsController(String configFile) throws IOException {
        configurationsFile = new ConfigurationsFile(configFile);
    }

    public ConfigurationsFile getConfigurationsFile() {
        return configurationsFile;
    }

    public void changeConfigsFile(String configFileName) throws IOException {
        configurationsFile = new ConfigurationsFile(configFileName);
    }

    public abstract EventType getEventType();
}
