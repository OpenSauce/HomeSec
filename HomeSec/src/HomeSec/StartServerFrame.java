/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeSec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lawley
 */
public class StartServerFrame extends JFrame {

    private StartServerFrame frame;
    private JLabel portLabel;
    private JTextField portField;
    private JButton okayButton, cancelButton;

    public StartServerFrame() {
        this.frame = this;
        this.add(createComponents());
        this.pack();
        this.setLocation((int) SecuritySystem.screenWidth / 2 - (this.getWidth() / 2), (int) SecuritySystem.screenHeight / 2 - (this.getHeight() / 2));
        this.setVisible(true);
    }

    public JPanel createComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel centrePanel = new JPanel();
        JPanel southPanel = new JPanel();

        portLabel = new JLabel("Port:");
        portField = new JTextField(Configuration.getPort());
        okayButton = new JButton("Okay");
        cancelButton = new JButton("Cancel");

        centrePanel.add(portLabel);
        centrePanel.add(portField);
        southPanel.add(okayButton);
        southPanel.add(cancelButton);

        okayButton.addActionListener(new OkayButtonListener());
        cancelButton.addActionListener(new CancelButtonListener());

        mainPanel.add(centrePanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        return mainPanel;
    }

    private class OkayButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Configuration.setPort(portField.getText());
            frame.setVisible(false);
            dispose();
        }

    }

    private class CancelButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            dispose();
        }

    }

}
