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
    private MainFrame parentWindow;
    private Thread t;

    public InputHandler(MainFrame parentWindow) {
        this.parentWindow = parentWindow;
    }

    @Override
    public void run() {
        String fromclient;

        try {

            ServerSocket Server = new ServerSocket(Integer.parseInt(parentWindow.getConfig().getJPEGPort()));
            System.out.println("Server currently waiting for client on port: " + parentWindow.getConfig().getJPEGPort());

            while (true) {
                Socket connected = Server.accept();
                System.out.println("The client " + connected.getInetAddress() + ":" + connected.getPort() + " has connected.");

                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connected.getInputStream()));

                while (true) {
                    fromclient = inFromClient.readLine();
                    if (fromclient.equalsIgnoreCase("HIGH")) {
                        parentWindow.appendTextArea("Motion detected!");
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

    public Thread getT() {
        return t;
    }

    public void setT(Thread t) {
        this.t = t;
    }

}
