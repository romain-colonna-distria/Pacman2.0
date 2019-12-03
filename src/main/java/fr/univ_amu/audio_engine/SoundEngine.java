package fr.univ_amu.audio_engine;

import javafx.scene.media.AudioClip;

import java.io.File;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Responsible for loading sound media to be played using an id or key.
 * Contains all sounds for use later.
 * </pre>
 * <pre> * User: cdea
 */
public class SoundEngine {
    static Map<String, SoundClip> soundEffectsMap = new HashMap<>();
    SoundLoader soundLoader;

    public SoundEngine() throws IOException {
        soundEffectsMap = SoundLoader.loadSound("src/main/resources/sound_config.conf");
    }
    /**
     * Lookup a name resource to play sound based on the id.
     *
     * @param id identifier for a sound to be played.
     */
    public static void playSound(final String id) {
        soundEffectsMap.get(id).play();
    }

}