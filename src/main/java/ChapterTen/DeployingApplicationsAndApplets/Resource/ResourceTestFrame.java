package ChapterTen.DeployingApplicationsAndApplets.Resource;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class ResourceTestFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    public ResourceTestFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        URL aboutURL = getClass().getResource("resources/icon.gif");
        Image image = new ImageIcon(aboutURL).getImage();
        setIconImage(image);

        JTextArea textArea = new JTextArea();
        InputStream stream = getClass().getResourceAsStream("About.txt");
        Scanner in = new Scanner(stream);
        while (in.hasNext())
            textArea.append(in.nextLine() + "\n");
        add(textArea);
    }
}
