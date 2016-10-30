package ChapterEleven.ExceptionApprovalLoggingAndDebugging.Logging;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.*;

public class LoggingImageViewer {
    public static void main(String[] args) {

        if (System.getProperty("java.logging.config.class") == null
                && System.getProperty("java.util.logging.config.file") == null) {
            try {
                Logger.getLogger("kz.zhelezyaka").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                Handler handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("kz.zhelezyaka").addHandler(handler);
            } catch (IOException e) {
                Logger.getLogger("kz.zhelezyaka").log(Level.SEVERE, "can't create log file handler", e);
            }
        }
        EventQueue.invokeLater(() -> {
            Handler windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("kz.zhelezyaka").addHandler(windowHandler);

            JFrame frame = new ImageViewerFrame();
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            Logger.getLogger("kz.zhelezyaka").fine("Showing frame");
            frame.setVisible(true);
        });
    }
}
