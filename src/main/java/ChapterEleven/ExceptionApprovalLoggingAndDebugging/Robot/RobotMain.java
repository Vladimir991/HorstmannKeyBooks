package ChapterEleven.ExceptionApprovalLoggingAndDebugging.Robot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class RobotMain {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ButtonFrame frame = new ButtonFrame();
            frame.setTitle("ButtonMain");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice screen = environment.getDefaultScreenDevice();

        try {
            final Robot robot = new Robot(screen);
            robot.waitForIdle();
            new Thread(){
                public void run(){
                    runTest(robot);
                }
            }.start();
        }catch (AWTException e){
            e.printStackTrace();
        }
    }
    public static void runTest(Robot robot){
        robot.keyPress(' ');
        robot.keyRelease(' ');

        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(' ');
        robot.keyRelease(' ');

        robot.delay(2000);
        robot.mouseMove(220, 40);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        robot.delay(2000);
        BufferedImage image = robot.createScreenCapture(new Rectangle(0, 0, 400, 300));

        ImageFrame frame = new ImageFrame(image);
        frame.setVisible(true);
    }
}
