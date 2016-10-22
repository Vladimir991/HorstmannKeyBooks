package ChapterNine.UIComponentsInSwing.Slider;

import javax.swing.*;
import java.awt.*;

public class SliderMain {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SliderFrame frame = new SliderFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setTitle("SliderFrame");
            frame.setVisible(true);
        });
    }
}
