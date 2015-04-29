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
public class MainFrameTest {
    
    public MainFrameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getWebcamPanel method, of class MainFrame.
     */
    @Test
    public void testGetWebcamPanel() {
        System.out.println("getWebcamPanel");
        MainFrame instance = new MainFrame();
        WebcamPanel expResult = null;
        WebcamPanel result = instance.getWebcamPanel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWebcamPanel method, of class MainFrame.
     */
    @Test
    public void testSetWebcamPanel() {
        System.out.println("setWebcamPanel");
        WebcamPanel webcamPanel = null;
        MainFrame instance = new MainFrame();
        instance.setWebcamPanel(webcamPanel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatusField method, of class MainFrame.
     */
    @Test
    public void testSetStatusField() {
        System.out.println("setStatusField");
        String text = "";
        MainFrame instance = new MainFrame();
        instance.setStatusField(text);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
