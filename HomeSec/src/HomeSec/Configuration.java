/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeSec;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Lawley
 */
public class Configuration {
    private static Configuration configuration;
    private static String port, address;

    public Configuration() {
        this.port = "5018";
        this.address = "5.151.14.80";
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        Configuration.port = port;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        Configuration.address = address;
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

    public static void setConfiguration(Configuration configuration) {
        Configuration.configuration = configuration;
    }

    public static void startupConfiguration() {
        File temp = new File("configuration.conf");
        if (temp.exists()) {
            configuration = loadConfiguration(temp);
        } else {
            System.out.println("No default database file!");
            configuration = new Configuration();
        }
    }

    public static Configuration loadConfiguration(File f) {
        Configuration config = null;
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(f));
            config = (Configuration) input.readObject();
            input.close();
        } catch (IOException | ClassNotFoundException i) {
            System.out.println("Error reading configuration file!");
        }
        return config;
    }

    public static boolean saveConfiguration(JFrame parentFrame) {
        final JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Configuration Files", "conf");
        fc.setFileFilter(filter);
        fc.setCurrentDirectory(new java.io.File("."));
        int returnVal = fc.showSaveDialog(parentFrame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fc.getSelectedFile();
                String filePath = file.getPath();
                if (!filePath.toLowerCase().endsWith(".conf")) {
                    file = new File(filePath + ".conf");
                }
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                out.writeObject(configuration);
                System.out.println("Configuration saved.");
                return true;
            } catch (Exception e) {
                System.out.println("Error saving configuration.");
                return false;
            }
        }
        return false;
    }
}
