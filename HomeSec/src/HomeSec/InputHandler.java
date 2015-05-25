/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeSec;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;

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

                int count = 0;
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                File f = new File("captures");
                f.mkdir();
                while (true) {
                    fromclient = inFromClient.readLine();
                    if (fromclient.equalsIgnoreCase("HIGH")) {
                        Calendar cal = Calendar.getInstance();
                        BufferedImage img1 = parentWindow.getWebcamPanel().getMediaPlayer().getSnapshot();
                        String filename = "captures//" + dateFormat.format(cal.getTime()) + ".jpg";
                        File f1 = new File(filename);
                        parentWindow.setStatusField("File saved: " + filename);
                        count++;
                        try {
                            ImageIO.write(img1, "png", f1);
                        } catch (IOException ex) {
                            System.out.println(ex);
                        }
                        // else
                        //System.out.println("blank image");
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
