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
    private MainFrame parentWindow;
    private StartServerFrame frame;
    private JLabel portLabel, JPEGPortLabel;
    private JTextField portField, JPEGPortField;
    private JButton okayButton, cancelButton;

    public StartServerFrame(MainFrame parentWindow) {
        super("Start Server");
        this.frame = this;
        this.parentWindow = parentWindow;
        this.add(createComponents());
        this.pack();
        this.setLocation((int) SecuritySystem.screenWidth / 2 - (this.getWidth() / 2), (int) SecuritySystem.screenHeight / 2 - (this.getHeight() / 2));
        this.setVisible(true);
    }

    public JPanel createComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel centrePanel = new JPanel();
        centrePanel.setLayout(new BorderLayout());
        JPanel southPanel = new JPanel();
        JPanel centreNorthPanel = new JPanel();
        JPanel centreSouthPanel = new JPanel();

        portLabel = new JLabel("Port:");
        portField = new JTextField(Configuration.getPort());
        JPEGPortLabel = new JLabel("Second Port:");
        JPEGPortField = new JTextField(Configuration.getJPEGPort());
        okayButton = new JButton("Okay");
        cancelButton = new JButton("Cancel");

        centreNorthPanel.add(portLabel);
        centreNorthPanel.add(portField);
        centreSouthPanel.add(JPEGPortLabel);
        centreSouthPanel.add(JPEGPortField);
        centrePanel.add(centreNorthPanel, BorderLayout.NORTH);
        centrePanel.add(centreSouthPanel, BorderLayout.SOUTH);
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
            Configuration.setJPEGPort(JPEGPortField.getText());
            parentWindow.getWebcamPanel().start();
            new InputHandler().start();
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
