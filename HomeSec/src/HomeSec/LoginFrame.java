/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeSec;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Lawley
 */
public class LoginFrame extends JFrame {

    LoginFrame frame;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton okayButton, cancelButton, disabledUserButton;
    JLabel usernameLabel, passwordLabel, statusLabel;
    JPanel southPanel, centrePanel, usernamePanel, passwordPanel, mainPanel, southNorthPanel, southSouthPanel;
    Configuration config;
    DatabaseHandler database;

    public LoginFrame() {
        super("HomeSec");

        config = new Configuration().startupConfiguration();
        database = new DatabaseHandler(new File("Database.db"));

        frame = this;
        this.add(createPanel());
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel createPanel() {
        frame = this;

        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        usernameField = new JTextField(20);
        usernameLabel = new JLabel("Username:");
        passwordField = new JPasswordField(20);
        passwordLabel = new JLabel("Password:");
        okayButton = new JButton("Login");
        cancelButton = new JButton("Cancel");
        statusLabel = new JLabel("Please enter your details above.", SwingConstants.CENTER);
        southPanel = new JPanel();
        centrePanel = new JPanel();
        mainPanel = new JPanel();
        southNorthPanel = new JPanel();

        mainPanel.setLayout(new BorderLayout());
        centrePanel.setLayout(new BorderLayout());
        southPanel.setLayout(new BorderLayout());
        usernamePanel = new JPanel();
        passwordPanel = new JPanel();

        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        JPanel imagePanel = new JPanel(new BorderLayout());
        ImageIcon imageIcon = new ImageIcon("resources/images/login_images/Software_Logo.PNG");
        JLabel imageLabel = new JLabel(imageIcon);

        centrePanel.add(imageLabel, BorderLayout.NORTH);
        centrePanel.add(usernamePanel, BorderLayout.CENTER);
        centrePanel.add(passwordPanel, BorderLayout.SOUTH);

        southNorthPanel.add(okayButton);
        southNorthPanel.add(cancelButton);

        southPanel.add(southNorthPanel, BorderLayout.NORTH);
        southPanel.add(statusLabel, BorderLayout.SOUTH);

        mainPanel.add(centrePanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        okayButton.addActionListener(new LoginListener());
        cancelButton.addActionListener(new CancelListener());

        passwordField.addKeyListener(new EnterKeyListener());
        usernameField.addKeyListener(new EnterKeyListener());

        setLocation((int) SecuritySystem.screenWidth / 2 - (this.getWidth() / 2), (int) SecuritySystem.screenHeight / 2 - (this.getHeight() / 2));

        setVisible(true);

        return mainPanel;
    }

    public void setStatusLabel(String text) {
        statusLabel.setText(text);
    }

    private class LoginListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (database.validateUser(usernameField.getText(), passwordField.getText())) {
                new MainFrame(config);
                frame.setVisible(false);
                dispose();
            } else {
                frame.setStatusLabel("Incorrect login details!");
            }
        }
    }

    private class CancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.exit(0);
        }
    }

    private class EnterKeyListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (e.getKeyChar() == KeyEvent.VK_ENTER) {

                if (database.validateUser(usernameField.getText(), passwordField.getText())) {
                    new MainFrame(config);
                    frame.setVisible(false);
                    dispose();
                } else {
                    frame.setStatusLabel("Incorrect login details!");
                }
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

}
