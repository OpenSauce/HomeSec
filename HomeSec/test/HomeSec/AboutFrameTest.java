/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeSec;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lawley
 */
public class AboutFrameTest {
    
    public AboutFrameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getParentFrame method, of class AboutFrame.
     */
    @Test
    public void testGetParentFrame() {
        System.out.println("getParentFrame");
        MainFrame expResult = new MainFrame(new Configuration());
        AboutFrame instance = new AboutFrame(expResult);
        instance.setParentFrame(expResult);
        assertEquals(expResult, instance.getParentFrame());
    }

    /**
     * Test of setParentFrame method, of class AboutFrame.
     */
    @Test
    public void testSetParentFrame() {
        System.out.println("setParentFrame");
        MainFrame parentFrame = new MainFrame(new Configuration());
        AboutFrame instance = new AboutFrame(parentFrame);
        instance.setParentFrame(parentFrame);
        assertEquals(parentFrame, instance.getParentFrame());
    }
    
}
