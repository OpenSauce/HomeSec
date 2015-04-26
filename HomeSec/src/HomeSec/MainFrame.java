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

/**
 *
 * @author Lawley
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        super("Security System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setJMenuBar(createMenuBar());
        this.setLayout(new BorderLayout());
        this.add(createComponents(), BorderLayout.CENTER);
        setSize(900, 500);
        setLocation((int) SecuritySystem.screenWidth / 2 - (this.getWidth() / 2), (int) SecuritySystem.screenHeight / 2 - (this.getHeight() / 2));
        setVisible(true);

        try {
            acceptCams();
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem startServerItem = new JMenuItem("Start Server");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ExitItemListener());
        
        JMenuItem settingsItem = new JMenuItem("Settings");
        
        JMenuItem aboutMenuItem = new JMenuItem("About");

        fileMenu.add(startServerItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        
        editMenu.add(settingsItem);
        
        helpMenu.add(aboutMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        return menuBar;
    }

    private JPanel createComponents() {
        return new JPanel();
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

    private void acceptCams() throws IOException {
        WebcamPanel p = new WebcamPanel(); 
        this.add(p, BorderLayout.CENTER);

        this.setVisible(true);

        //p.play();
    }

    private MainFrame getFrame() {
        return this;
    }

}
