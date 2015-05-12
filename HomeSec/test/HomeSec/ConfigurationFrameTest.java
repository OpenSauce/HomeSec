/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeSec;

import javax.swing.JPanel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lawley
 */
public class ConfigurationFrameTest {
    
    public ConfigurationFrameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of createComponents method, of class ConfigurationFrame.
     */
    @Test
    public void testCreateComponents() {
        System.out.println("createComponents");
        ConfigurationFrame instance = null;
        JPanel expResult = null;
        JPanel result = instance.createComponents();
        assertEquals(expResult, result);
    }
    
}
