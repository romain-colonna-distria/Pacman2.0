package fr.univ_amu.audio_engine;

import javafx.scene.media.AudioClip;
import java.io.File;

public class SoundClip {

    private String url;
    private AudioClip clip;

    public SoundClip(String url) {
        this.url = url;
        createClip();
    }

    public void createClip(){
        clip = new AudioClip(new File(url).toURI().toString());
    }

    public void play(){
        if(!clip.isPlaying()) this.clip.play();
    }

    public void stop(){
        this.clip.stop();
    }
}
