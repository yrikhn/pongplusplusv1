package pongplusplus.game;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Sound {
    private final static Map<String, Media> cache = new HashMap<>();

    public static void play(SoundFXType soundEffect) {
        MediaPlayer player = createMediaPlayer(getSoundFileName(soundEffect));
        player.play();
    }

    private static MediaPlayer createMediaPlayer(String filePath){
        filePath = "/soundFX/" + filePath;

        if (!cache.containsKey(filePath)){
            URL url = Sound.class.getResource(filePath);
            if (url == null) {
                throw new RuntimeException("Could not load file: " + filePath);
            }

            cache.put(filePath, new Media(url.toString()));
        }

        return new MediaPlayer(cache.get(filePath));
    }

    private static String getSoundFileName(SoundFXType soundEffect) {
        switch (soundEffect) {
            case ONHIT:
                return "onhitsound.mp3";
            case ONCLICK:
                return "onclicksound.mp3";
            default:
                throw new RuntimeException("No Soundfilename set for this enum value:" + soundEffect);
        }
    }
}
