/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeSec;

import java.net.ServerSocket;
import java.net.Socket;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lawley
 */
public class InputHandlerTest {

    public InputHandlerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of run method, of class InputHandler.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        InputHandler instance = new InputHandler(new MainFrame());
        instance.run();
        assertEquals(null, instance.getT());
    }

    /**
     * Test of start method, of class InputHandler.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Configuration.setPort("5000");
        InputHandler instance = new InputHandler(new MainFrame());
        instance.start();
        ServerSocket s = null;
        try {
            s = new ServerSocket(Integer.parseInt(Configuration.getJPEGPort()));
        } catch (Exception e) {
        }

        //Expect server to already be running
        assertEquals(null, s);
    }

}
