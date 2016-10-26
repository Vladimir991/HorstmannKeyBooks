package ChapterNine.UIComponentsInSwing.ColorChooser;

import javax.swing.*;

public class ColorChooserFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ColorChooserFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        ColorChooserPanel panel = new ColorChooserPanel();
        add(panel);
    }
}
