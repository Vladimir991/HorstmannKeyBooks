package ChapterNine.UIComponentsInSwing.Dialog;

import javax.swing.*;
import java.awt.*;

public class AboutDialog extends JDialog {
    public AboutDialog(JFrame owner) {
        super(owner, "About DialogTest", true);

        add(new JLabel(
                "<html><h2><i>Briefly about me</i></h2><hr>" +
                        "My name is Vladimir Glinsky. I live in Kazakhstan.\n" +
                        "I work in a company specializing in laptop repair.\n\n\n" +
                        "Know and know how to repair the computer equipment. I'm Learning programming.\n" +
                        "Familiar with: Java, MySQL, PostgreSQL, Spring, Git, Maven.\n" +
                        "I will be glad to learn from You new technologies.\n" +
                        "Contact me: +77019321740   support@zhelezyaka.kz</html>"
        ), BorderLayout.CENTER);

        JButton ok = new JButton("Ok");
        ok.addActionListener(e -> setVisible(false));
        JPanel panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);
        pack();
    }
}
