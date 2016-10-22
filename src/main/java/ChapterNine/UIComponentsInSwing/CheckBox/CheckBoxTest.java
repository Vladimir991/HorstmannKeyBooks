package ChapterNine.UIComponentsInSwing.CheckBox;

import javax.swing.*;
import java.awt.*;

public class CheckBoxTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new CheckBoxFrame();
            frame.setSize(750, 100);
            frame.setTitle("CheckBoxFrame");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
