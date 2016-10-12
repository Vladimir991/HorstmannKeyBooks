package ChapterEight.EventHandling.MouseFrame;

import javax.swing.*;

public class MouseMain {
    public static void main(String[] args) {
        JFrame frame = new MouseFrame();
        frame.setTitle("MouseFrame");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
