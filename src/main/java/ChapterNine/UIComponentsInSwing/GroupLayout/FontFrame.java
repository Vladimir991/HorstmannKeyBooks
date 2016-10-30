package ChapterNine.UIComponentsInSwing.GroupLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

public class FontFrame extends JFrame {
    public static final int TEXT_ROWS = 10;
    public static final int TEXT_COLUMNS = 20;

    private JComboBox<String> face;
    private JComboBox<Integer> size;
    private JCheckBox bold;
    private JCheckBox italic;
    private JTextArea sample;

    public FontFrame() {
        ActionListener listener = EventHandler.create(ActionListener.class, this, "updateSample");

        JLabel faceLabel = new JLabel("Face: ");
        face = new JComboBox<>(new String[]{"Serif", "Sanserif",
                "Monospaced", "Dialog", "DialogInput"});

        face.addActionListener(listener);
        JLabel sizeLabel = new JLabel("Size: ");
        size = new JComboBox<>(new Integer[]{8, 10, 12, 15, 18, 24, 36, 48});

        size.addActionListener(listener);
        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);

        sample = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        sample.setText("I would like to learn programming from the company Codeborne.com");
        sample.setEditable(false);
        sample.setLineWrap(true);
        sample.setBorder(BorderFactory.createEtchedBorder());

        JScrollPane pane = new JScrollPane(sample);

        GroupLayout layout = new GroupLayout(getContentPane());
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup().addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(faceLabel).addComponent(sizeLabel)
                        ).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(size).addComponent(face)
                        )).addComponent(italic).addComponent(bold)
        ).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(pane)
                .addContainerGap()));

        layout.linkSize(SwingConstants.HORIZONTAL,new java.awt.Component[]{ face, size});

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap().addGroup(
                        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(pane, GroupLayout.Alignment.TRAILING).addGroup(
                                layout.createSequentialGroup().addGroup(
                                        layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(face).addComponent(faceLabel)
                                ).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(
                                                GroupLayout.Alignment.BASELINE
                                        ).addComponent(size).addComponent(sizeLabel)).addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED
                                ).addComponent(italic, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bold, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                        )
                ).addContainerGap()));
        pack();
    }

    public void updateSample() {
        String fontFace = (String) face.getSelectedItem();
        int fontStyle = (bold.isSelected() ? Font.BOLD : 0) +
                (italic.isSelected() ? Font.ITALIC : 0);
        int fontSize = size.getItemAt(size.getSelectedIndex());
        Font font = new Font(fontFace, fontStyle, fontSize);
        sample.setFont(font);
        sample.repaint();
    }
}
