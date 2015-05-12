/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeSec;

import java.io.File;
import javax.swing.JFrame;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lawley
 */
public class ConfigurationTest {
    
    public ConfigurationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getPort method, of class Configuration.
     */
    @Test
    public void testGetPort() {
        System.out.println("getPort");
        Configuration config = new Configuration();
        config.setPort("");
        String result = config.getPort();
        assertEquals("", result);
    }

    /**
     * Test of setPort method, of class Configuration.
     */
    @Test
    public void testSetPort() {
        System.out.println("setPort");
        String port = "";
        Configuration config = new Configuration();
        config.setPort(port);
        assertEquals("", config.getPort());
    }

    /**
     * Test of getJPEGPort method, of class Configuration.
     */
    @Test
    public void testGetJPEGPort() {
        System.out.println("getJPEGPort");
        Configuration config = new Configuration();
        config.setJPEGPort("");
        String result = config.getJPEGPort();
        assertEquals("", result);
    }

    /**
     * Test of setJPEGPort method, of class Configuration.
     */
    @Test
    public void testSetJPEGPort() {
        System.out.println("setJPEGPort");
        String JPEGPort = "";
        Configuration config = new Configuration();
        config.setJPEGPort(JPEGPort);
        assertEquals("", config.getJPEGPort());
    }

    /**
     * Test of getAddress method, of class Configuration.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Configuration config = new Configuration();
        config.setAddress("");
        String result = config.getAddress();
        assertEquals("", result);
    }

    /**
     * Test of setAddress method, of class Configuration.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        Configuration config = new Configuration();
        config.setAddress(address);
        assertEquals("", config.getAddress());
    }

    /**
     * Test of loadConfiguration method, of class Configuration.
     */
    @Test (expected=NullPointerException.class)
    public void testLoadConfiguration() {
        System.out.println("loadConfiguration");
        File f = null;
        Configuration expResult = null;
        Configuration result = Configuration.loadConfiguration(f);
        assertEquals(expResult, result);
    }

    /**
     * Test of saveConfiguration method, of class Configuration.
     */
    @Test
    public void testSaveConfiguration() {
        System.out.println("saveConfiguration");
        JFrame parentFrame = null;
        boolean expResult = false;
        boolean result = Configuration.saveConfiguration(parentFrame);
        assertEquals(expResult, result);
    }
    
}
