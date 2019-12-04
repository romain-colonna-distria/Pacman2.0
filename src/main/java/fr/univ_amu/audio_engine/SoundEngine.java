package fr.univ_amu.audio_engine;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Responsible for loading sound media to be played using an id or key.
 * Contains all sounds for use later.
 * </pre>
 * <pre> * User: cdea
 */
public class SoundEngine {
    private static Map<String, SoundClip> soundEffectsMap = new HashMap<>();

    public static void initSounds(SoundLoader soundLoader) throws IOException {
        soundEffectsMap = soundLoader.loadSound();
    }
    /**
     * Lookup a name resource to play sound based on the id.
     *
     * @param id identifier for a sound to be played.
     */
    public static void playSound(final String id) {
        if(soundEffectsMap == null){
            System.err.println("Aucun son chargés.");
            return;
        }
        soundEffectsMap.get(id).play();
    }

}