package ChapterEleven.ExceptionApprovalLoggingAndDebugging.Debugger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuggyButtonPanel extends JPanel {
    public BuggyButtonPanel() {
        ActionListener listener = new ButtonListener();

        JButton yellowButton = new JButton("Yellow");
        add(yellowButton);
        yellowButton.addActionListener(listener);

        JButton blueButton = new JButton("Blue");
        add(blueButton);
        blueButton.addActionListener(listener);

        JButton redButton = new JButton("Red");
        add(redButton);
        redButton.addActionListener(listener);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String arg = e.getActionCommand();
            switch (arg) {
                case "Yellow":
                    setBackground(Color.YELLOW);
                    break;
                case "Blue":
                    setBackground(Color.BLUE);
                    break;
                case "Red":
                    setBackground(Color.RED);
                    break;
            }
        }
    }
}
