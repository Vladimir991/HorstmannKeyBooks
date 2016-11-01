package ChapterEleven.ExceptionApprovalLoggingAndDebugging.Debugger;

import javax.swing.*;

public class BuggyButtonFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public BuggyButtonFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        BuggyButtonPanel panel = new BuggyButtonPanel();
        add(panel);
    }
}
