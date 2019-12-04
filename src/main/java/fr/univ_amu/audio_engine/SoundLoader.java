package fr.univ_amu.audio_engine;

import fr.univ_amu.utils.ConfigurationsFile;
import javafx.scene.media.AudioClip;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SoundLoader {
    private ConfigurationsFile configurationsFile;
    private Map<String, SoundClip> soundEffectsMap = new HashMap<>();

    public SoundLoader(String soundConfigFilePath) throws IOException {
        configurationsFile = new ConfigurationsFile(soundConfigFilePath);
    }

    public Map<String, SoundClip> loadSound() throws IOException {
        Map<String, String> configMap = configurationsFile.getConfigMap();
        for (HashMap.Entry<String, String> entry : configMap.entrySet()) {
            soundEffectsMap.put(entry.getKey(), new SoundClip(entry.getValue()));
        }
        return soundEffectsMap;
    }
}
