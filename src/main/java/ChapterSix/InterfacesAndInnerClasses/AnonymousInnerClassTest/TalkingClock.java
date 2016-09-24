package ChapterSix.InterfacesAndInnerClasses.AnonymousInnerClassTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;

public class TalkingClock {
    public void start(int interval, final boolean beep) {
        ActionListener listener = event -> {
            Date now = new Date();
            System.out.println("At the tone, the time is " + now);
            if (beep) Toolkit.getDefaultToolkit().beep();
        };
        Timer t = new Timer(interval, listener);
        t.start();
    }
}
