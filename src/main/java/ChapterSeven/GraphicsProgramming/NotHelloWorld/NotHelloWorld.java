package ChapterSeven.GraphicsProgramming.NotHelloWorld;

import javax.swing.*;
import java.awt.*;

public class NotHelloWorld {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new NotHelloWorldFrame();
            frame.setTitle("NotHelloWorld");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
