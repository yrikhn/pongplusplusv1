package pongplusplus.game;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Sound {
    private final static Map<String, Media> cache = new HashMap<>();

    public static void play(SoundEffectType soundEffect) {
        MediaPlayer player = createMediaPlayer(getSoundFileName(soundEffect));
        player.play();
    }

    private static MediaPlayer createMediaPlayer(String filePath) {
        filePath = "/soundFX/" + filePath;
        if (!cache.containsKey(filePath)) {
            URL url = Sound.class.getResource(filePath);
            if (url == null) {
                throw new RuntimeException("Could not load file: " + filePath);
            }
            cache.put(filePath, new Media(url.toString()));
        }
        return new MediaPlayer(cache.get(filePath));
    }

    private static String getSoundFileName(SoundEffectType soundEffect) {
        return switch (soundEffect) {
            case ONHIT -> "onhitsound.mp3";
            case ONCLICK -> "onclicksound.mp3";
        };
    }
}
