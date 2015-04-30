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
public class StartServerFrameTest {
    
    public StartServerFrameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of createComponents method, of class StartServerFrame.
     */
    @Test
    public void testCreateComponents() {
        System.out.println("createComponents");
        StartServerFrame instance = null;
        JPanel expResult = null;
        JPanel result = instance.createComponents();
        assertEquals(expResult, result);
    }
    
}
