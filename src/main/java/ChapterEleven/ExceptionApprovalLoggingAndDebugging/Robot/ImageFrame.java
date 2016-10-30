package ChapterEleven.ExceptionApprovalLoggingAndDebugging.Robot;

import javax.swing.*;
import java.awt.*;

public class ImageFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;

    public ImageFrame(Image image) {
        setTitle("Capture");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JLabel label = new JLabel(new ImageIcon(image));
        add(label);
    }
}
