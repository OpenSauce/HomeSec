/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeSec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lawley
 */
public class InputHandler implements Runnable {
    Thread t;

    public InputHandler() {
    }

    @Override
    public void run() {
        String fromclient;

        try {

            ServerSocket Server = new ServerSocket(6000);

            System.out.println("TCPServer Waiting for client on port 5000");

            while (true) {
                Socket connected = Server.accept();
                System.out.println(" THE CLIENT" + " " + connected.getInetAddress() + ":" + connected.getPort() + " IS CONNECTED ");

                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connected.getInputStream()));

                while (true) {
                    fromclient = inFromClient.readLine();

                    if (fromclient.equals("q") || fromclient.equals("Q")) {
                        connected.close();
                        break;
                    } else {
                        System.out.println("RECIEVED:" + fromclient);
                    }
                }
            }
        } catch (Exception e) {

        }
    }
    
    public void start ()
   {
      System.out.println("Starting webcam thread");
      if (t == null)
      {
         t = new Thread (this);
         t.start ();
      }
   }

}
