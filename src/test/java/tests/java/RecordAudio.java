/**
 * Ref:
 *  1. https://www.java-tips.org/java-se-tips-100019/120-javax-sound/917-capturing-audio-with-java-sound-api.html
 *  2. https://gist.github.com/fedor-rusak/2294168
 *  3. https://stackoverflow.com/questions/4826169/record-voice-with-java
 */

package tests.java;

import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class RecordAudio {
    public static void main(String args[]) {
        int timeOut = 50;
        ByteArrayOutputStream out  = new ByteArrayOutputStream();

        AudioFormat format = new AudioFormat(44100, 16, 2, true, true);
        DataLine.Info targetInfo = new DataLine.Info(TargetDataLine.class, format);     // record fro
        DataLine.Info sourceInfo = new DataLine.Info(SourceDataLine.class, format);     // play

        try {
            // TargetDataLine interface consists of a read method to get audio from the mixer
            TargetDataLine targetLine = (TargetDataLine) AudioSystem.getLine(targetInfo);
            targetLine.open(format);
            targetLine.start();

            // SourceDataLine interface consists of a write method to send audio to the mixer
            SourceDataLine sourceLine = (SourceDataLine) AudioSystem.getLine(sourceInfo);
            sourceLine.open(format);
            sourceLine.start();

            int numBytesRead;
            byte[] targetData = new byte[targetLine.getBufferSize() / 5];

            while (timeOut > 0) {
                numBytesRead = targetLine.read(targetData, 0, targetData.length);

                if (numBytesRead == -1)	break;

                // Save this chunk of data.
                out.write(targetData, 0, numBytesRead);

                // Play record to speaker
                sourceLine.write(targetData, 0, numBytesRead);

                // Timeout runs
                timeOut = --timeOut;
                System.out.println(timeOut);
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
        //

    }
}
