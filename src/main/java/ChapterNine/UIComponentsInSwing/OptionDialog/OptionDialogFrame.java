package ChapterNine.UIComponentsInSwing.OptionDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class OptionDialogFrame extends JFrame {
    private ButtonPanel typePanel;
    private ButtonPanel messagePanel;
    private ButtonPanel messageTypePanel;
    private ButtonPanel optionTypePanel;
    private ButtonPanel optionPanel;
    private ButtonPanel inputPanel;
    private String messageString = "Message";
    private Icon messageIcon = new ImageIcon("resources/blue-ball.gif");
    private Object messageObject = new Date();
    private Component messageComponent = new SampleComponent();

    public OptionDialogFrame() {
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridBagLayout());

        typePanel = new ButtonPanel("Type", "Message", "Confirm", "Option", "Input");
        messageTypePanel = new ButtonPanel("Message Type", "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE");
        messagePanel = new ButtonPanel("Message", "String", "Icon", "Component", "Other", "Object[]");
        optionTypePanel = new ButtonPanel("Confirm", "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION");
        optionPanel = new ButtonPanel("Option", "String[]", "Icon[]", "Object[]", "Icon[]", "Object[]");
        inputPanel = new ButtonPanel("Input", "Text field", "Combo box");

        gridPanel.add(typePanel);
        gridPanel.add(messageTypePanel);
        gridPanel.add(messagePanel);
        gridPanel.add(optionTypePanel);
        gridPanel.add(optionPanel);
        gridPanel.add(inputPanel);

        JPanel showPanel = new JPanel();
        JButton showButton = new JButton("Show");
        showButton.addActionListener(new ShowAction());
        showPanel.add(showButton);

        add(gridPanel, BorderLayout.CENTER);
        add(showPanel, BorderLayout.SOUTH);
        pack();
    }

    public Object getMessage() {
        String s = messagePanel.getSelection();
        switch (s) {
            case "String":
                return messageString;
            case "Icon":
                return messageIcon;
            case "Component":
                return messageComponent;
            case "Object[]":
                return new Object[]{
                        messageString, messageIcon, messageComponent, messageObject
                };
            case "Other":
                return messageObject;
            default:
                return null;
        }
    }

    public Object[] getOptions() {
        String s = optionPanel.getSelection();
        switch (s) {
            case "String[]":
                return new String[]{
                        "Yellow", "Blue", "Red"
                };
            case "Icon[]":
                return new Icon[]{
                        new ImageIcon("resources/yellow-ball.gif"),
                        new ImageIcon("resources/blue-ball.gif"),
                        new ImageIcon("resources/red-ball.gif")
                };
            case "Object[]":
                return new Object[]{
                        messageString, messageIcon, messageComponent, messageObject
                };
            default:
                return null;
        }
    }

    public int getType(ButtonPanel panel) {
        String s = panel.getSelection();
        try {
            return JOptionPane.class.getField(s).getInt(null);
        } catch (Exception e) {
            return -1;
        }
    }

    private class ShowAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (typePanel.getSelection().equals("Confirm"))
                JOptionPane.showConfirmDialog(OptionDialogFrame.this,
                        getMessage(), "Title", getType(optionTypePanel),
                        getType(messageTypePanel));
            else if (typePanel.getSelection().equals("Input")) {
                if (inputPanel.getSelection().equals("Text field"))
                    JOptionPane.showInputDialog(
                            OptionDialogFrame.this, getMessage(), "Title",
                            getType(messageTypePanel)
                    );
                else JOptionPane.showInputDialog(OptionDialogFrame.this,
                        getMessage(), "Title", getType(messageTypePanel), null,
                        new String[]{"Yellow", "Blue", "Red"}, "Blue");
            } else if (typePanel.getSelection().equals("Message"))
                JOptionPane.showMessageDialog(OptionDialogFrame.this,
                        getMessage(), "Title", getType(messageTypePanel));
            else if (typePanel.getSelection().equals("Option"))
                JOptionPane.showOptionDialog(OptionDialogFrame.this,
                        getMessage(), "Title", getType(optionTypePanel),
                        getType(messageTypePanel), null, getOptions(), getOptions()[0]);
        }
    }
}
