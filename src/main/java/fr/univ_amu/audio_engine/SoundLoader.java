package fr.univ_amu.audio_engine;

import fr.univ_amu.utils.ConfigurationsFile;
import javafx.scene.media.AudioClip;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SoundLoader {
    ConfigurationsFile configurationsFile;
    Map<String, SoundClip> soundEffectsMap = new HashMap<>();

    static Map<String, SoundClip> loadSound(String soundConfigFilePath) throws IOException {
        ConfigurationsFile configurationsFile;
        Map<String, SoundClip> soundEffectsMap = new HashMap<>();
        configurationsFile = new ConfigurationsFile(soundConfigFilePath);
        Map<String, String> configMap = configurationsFile.getConfigMap();

        for (HashMap.Entry<String, String> entry : configMap.entrySet()) {
            soundEffectsMap.put(entry.getKey(), new SoundClip(entry.getValue()));
        }
        return soundEffectsMap;
    }
}
