/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeSec;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lawley
 */
public class MainFrame extends JFrame {
    private MainFrame mainFrame;
    private WebcamPanel webcamPanel;
    private JTextField statusField;

    public MainFrame() {
        super("Security System");
        this.mainFrame = this;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setJMenuBar(createMenuBar());
        this.setLayout(new BorderLayout());
        this.add(createComponents(), BorderLayout.CENTER);
        this.setSize(900, 500);
        this.setLocation((int) SecuritySystem.screenWidth / 2 - (this.getWidth() / 2), (int) SecuritySystem.screenHeight / 2 - (this.getHeight() / 2));
        this.setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu webcamMenu = new JMenu("Webcam");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem startServerItem = new JMenuItem("Start Server");
        startServerItem.addActionListener(new StartServerListener());
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ExitItemListener());

        JMenuItem preferencesItem = new JMenuItem("Preferences");

        JMenuItem settingsItem = new JMenuItem("Settings");

        JMenuItem aboutMenuItem = new JMenuItem("About");

        fileMenu.add(startServerItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        editMenu.add(preferencesItem);

        webcamMenu.add(settingsItem);

        helpMenu.add(aboutMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(webcamMenu);
        menuBar.add(helpMenu);
        return menuBar;
    }

    private JPanel createComponents() {
        JPanel mainPanel = new JPanel();
        webcamPanel = new WebcamPanel();

        statusField = new JTextField();
        setStatusField("Not started.");
        statusField.setEditable(false);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(webcamPanel, BorderLayout.CENTER);
        mainPanel.add(statusField, BorderLayout.SOUTH);
        return mainPanel;
    }

    private MainFrame getFrame() {
        return this;
    }

    public WebcamPanel getWebcamPanel() {
        return webcamPanel;
    }

    public void setWebcamPanel(WebcamPanel webcamPanel) {
        this.webcamPanel = webcamPanel;
    }
    
    public void setStatusField(String text) {
        statusField.setText("Status: " + text);
    }

    private class StartServerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new StartServerFrame(mainFrame);
        }

    }

    private class SaveConfigListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new StartServerFrame(mainFrame);
        }

    }

    private class LoadConfigListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new StartServerFrame(mainFrame);
        }

    }

    private class ExitItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int n = JOptionPane.showConfirmDialog(
                    getFrame(),
                    "Are you sure you want to quit?",
                    "",
                    JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                System.exit(0);
            }
        }
    }

}
