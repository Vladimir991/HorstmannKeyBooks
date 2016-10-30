package ChapterEleven.ExceptionApprovalLoggingAndDebugging.EventTracer;

import javax.swing.*;
import java.awt.*;

public class EventTracerFrame extends JFrame {
    public EventTracerFrame() {
        add(new JSlider(), BorderLayout.NORTH);
        add(new JButton("Test"), BorderLayout.SOUTH);

        EventTracer tracer = new EventTracer();
        tracer.add(this);
        pack();
    }
}
