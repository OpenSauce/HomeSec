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
        WebcamPanel expResult = new WebcamPanel();
        instance.setWebcamPanel(expResult);
        WebcamPanel result = instance.getWebcamPanel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWebcamPanel method, of class MainFrame.
     */
    @Test
    public void testSetWebcamPanel() {
        System.out.println("setWebcamPanel");
        WebcamPanel webcamPanel = new WebcamPanel();
        MainFrame instance = new MainFrame();
        instance.setWebcamPanel(webcamPanel);
        assertEquals(webcamPanel, instance.getWebcamPanel());
    }

    /**
     * Test of setStatusField method, of class MainFrame.
     */
    @Test
    public void testSetStatusField() {
        System.out.println("setStatusField");
        String text = "Test";
        MainFrame instance = new MainFrame();
        instance.setStatusField(text);
        assertEquals("Status: Test", instance.getStatusField());
    }

}
