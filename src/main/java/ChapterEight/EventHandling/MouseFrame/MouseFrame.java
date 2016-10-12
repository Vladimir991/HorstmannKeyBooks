package ChapterEight.EventHandling.MouseFrame;

import javax.swing.*;

public class MouseFrame extends JFrame {
    public MouseFrame() {
        add(new MouseComponent());
        pack();
    }
}
