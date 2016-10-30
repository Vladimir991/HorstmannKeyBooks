package ChapterEleven.ExceptionApprovalLoggingAndDebugging.EventTracer;

import javax.swing.*;
import java.awt.*;

public class EventTraceMain {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new EventTracerFrame();
            frame.setTitle("EventTraceMain");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
