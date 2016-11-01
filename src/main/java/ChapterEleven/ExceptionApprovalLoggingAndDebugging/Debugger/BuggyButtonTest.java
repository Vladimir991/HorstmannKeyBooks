package ChapterEleven.ExceptionApprovalLoggingAndDebugging.Debugger;

import javax.swing.*;
import java.awt.*;

public class BuggyButtonTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BuggyButtonFrame();
            frame.setTitle("BuggyButtonTest");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
