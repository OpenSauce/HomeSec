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

            ServerSocket Server = new ServerSocket(Integer.parseInt(Configuration.getJPEGPort()));
            System.out.println("Server currently waiting for client on port: " + Configuration.getJPEGPort());

            while (true) {
                Socket connected = Server.accept();
                System.out.println("The client " + connected.getInetAddress() + ":" + connected.getPort() + " has connected.");

                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connected.getInputStream()));

                while (true) {
                    fromclient = inFromClient.readLine();
                    if (fromclient.equals("q") || fromclient.equals("Q")) {
                        connected.close();
                        break;
                    } else {
                        System.out.println("Recieved data: " + fromclient);
                    }
                }
            }
        } catch (NumberFormatException | IOException e) {
            System.out.println("Server error!");
        }
    }

    public void start() {
        t = new Thread(this);
        System.out.println("Starting the JPEG thread!");
        t.start();
    }

}
