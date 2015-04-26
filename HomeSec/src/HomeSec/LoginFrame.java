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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Lawley
 */
public class LoginFrame extends JFrame {
    LoginFrame frame;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton okayButton, cancelButton, disabledUserButton;
    JLabel usernameLabel, passwordLabel;
    JPanel southPanel, centrePanel, usernamePanel, passwordPanel, mainPanel;

    public LoginFrame() {
        super("HomeSec");
        
        Configuration.startupConfiguration();
        
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
        southPanel = new JPanel();
        centrePanel = new JPanel();
        mainPanel = new JPanel();

        ImageIcon magnifierIcon = new ImageIcon("resources/images/login_images/Magnifier.PNG");

        mainPanel.setLayout(new BorderLayout());
        centrePanel.setLayout(new BorderLayout());
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


        southPanel.add(okayButton);
        southPanel.add(cancelButton);

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

    private class LoginListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (usernameField.getText().equalsIgnoreCase("admin")) {
                new MainFrame();
                frame.setVisible(false);
                dispose();
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

                if (usernameField.getText().equalsIgnoreCase("admin")) {
                    new MainFrame();
                    frame.setVisible(false);
                    dispose();
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
