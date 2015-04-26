/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeSec;

import javax.swing.UIManager;

/**
 *
 * @author Lawley
 */
public class SecuritySystem {
    final static double screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    final static double screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Error setting native LAF: " + e);
        } 
        
        new LoginFrame();
    }
    
}
