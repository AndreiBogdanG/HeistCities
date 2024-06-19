import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Sounds {
    static Long currentFrame;
    static Clip clip;
    static String filePath;
    String status;
    static AudioInputStream audioInputStream;

    // constructor to initialize streams and clip
    public Sounds(String soundFile) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        filePath = soundFile;
        // create AudioInputStream object using class loader
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new IOException("Could not find the file " + filePath);
        }
        // Wrap the InputStream with a BufferedInputStream
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        audioInputStream = AudioSystem.getAudioInputStream(bufferedInputStream);

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);
    }

    // method to play sounds
    static void playSound(String effectName) {
        try {
            // Close the previous clip if it's still open
            if (clip != null && clip.isOpen()) {
                clip.stop();
                clip.close();
            }

            filePath = effectName + ".wav"; // assume files are directly in the resources folder
            Sounds sound = new Sounds(filePath);
            sound.play();

        } catch (Exception ex) {
          //  ex.printStackTrace(); -> Do not print the error; pretend nothing happened :)
        }
    }

    public static void stop() {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    // Method to play the audio
    public void play() {
        // start the clip
        clip.start();
        status = "play";
    }
}