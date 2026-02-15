import org.vosk.Model;
import org.vosk.Recognizer;

import javax.sound.sampled.*;

public class SpeechToText {

    public static String listen() {

        String finalText = "";

        try {
            Model model = new Model("model");
            Recognizer recognizer = new Recognizer(model, 16000);

            AudioFormat format = new AudioFormat(16000, 16, 1, true, false);

            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            TargetDataLine microphone = (TargetDataLine) AudioSystem.getLine(info);

            microphone.open(format);
            microphone.start();

            System.out.println("🎤 Speak now...");

            byte[] buffer = new byte[4096];
            long startTime = System.currentTimeMillis();

            while (true) {

                int bytesRead = microphone.read(buffer, 0, buffer.length);

                if (recognizer.acceptWaveForm(buffer, bytesRead)) {

                    String json = recognizer.getResult();

                    // ✅ Only text
                    finalText = extractText(json);

                    break;
                }

                // Auto stop after 3 seconds
                if (System.currentTimeMillis() - startTime > 3000) {

                    String json = recognizer.getFinalResult();

                    // ✅ Only text
                    finalText = extractText(json);

                    break;
                }
            }

            microphone.stop();
            microphone.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return finalText;
    }

    // ✅ Remove {} JSON completely
    private static String extractText(String json) {

        int start = json.indexOf("\"text\"");

        if (start == -1) return "";

        start = json.indexOf(":", start) + 1;

        String textPart = json.substring(start)
                .replaceAll("[\"{}]", "")
                .trim();

        return textPart;
    }
}