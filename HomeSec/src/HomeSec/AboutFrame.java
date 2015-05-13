/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeSec;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Lawley
 */
public class AboutFrame extends JFrame {
    MainFrame parentFrame;
    
    public AboutFrame(MainFrame parentFrame) {
        super("About");
        this.parentFrame = parentFrame;
        
        this.add(createComponents());
        this.pack();
        this.setLocation((int) SecuritySystem.screenWidth / 2 - (this.getWidth() / 2), (int) SecuritySystem.screenHeight / 2 - (this.getHeight() / 2));
        this.setVisible(true);
    }
    
    private JPanel createComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JLabel homesecLabel = new JLabel("HomeSec", SwingConstants.CENTER);
        mainPanel.add(homesecLabel, BorderLayout.NORTH);
        JLabel aboutLabel = new JLabel("Developed by Leigh Lawley - L021599A");
        mainPanel.add(aboutLabel, BorderLayout.SOUTH);
        return mainPanel;
    }

    public MainFrame getParentFrame() {
        return parentFrame;
    }

    public void setParentFrame(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
    }
    
}
