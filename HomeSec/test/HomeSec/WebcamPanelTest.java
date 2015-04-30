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
public class WebcamPanelTest {
    
    public WebcamPanelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of start method, of class WebcamPanel.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        WebcamPanel instance = new WebcamPanel();
        instance.start();
        assertEquals(true, instance.getT().isAlive());
    }
    
}
