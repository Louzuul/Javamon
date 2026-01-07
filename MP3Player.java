import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MP3Player
{
    private static MediaPlayer player;
    private static boolean fxInitialized = false;

    // JavaFX einmal starten
    private static void initFX()
    {
        if (!fxInitialized) {
            Platform.startup(() -> {});
            fxInitialized = true;
        }
    }

    // MP3 abspielen
    public static void play(String path)
    {
        initFX();

        if (player != null) {
            player.stop();
        }

        File file = new File(path);
        Media media = new Media(file.toURI().toString());
        player = new MediaPlayer(media);
        player.play();
    }

    // MP3 stoppen
    public static void stop()
    {
        if (player != null) {
            player.stop();
        }
    }

    // Loop
    public static void loop(String path)
    {
        initFX();

        if (player != null) {
            player.stop();
        }

        File file = new File(path);
        Media media = new Media(file.toURI().toString());
        player = new MediaPlayer(media);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();
    }
}
