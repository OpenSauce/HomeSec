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
import java.io.Serializable;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Lawley
 */
public class Configuration implements Serializable {
    private final long serialVersionUID = 7526472295622776147L;
    protected Configuration configuration;
    private String port, JPEGPort, address;

    public Configuration() {
        this.configuration = this;
        this.port = "5000";
        this.JPEGPort = "6000";
        this.address = "127.0.0.1";
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getJPEGPort() {
        return JPEGPort;
    }

    public void setJPEGPort(String JPEGPort) {
        this.JPEGPort = JPEGPort;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration startupConfiguration() {
        File temp = new File("test.conf");
        if (temp.exists()) {
            configuration = loadConfiguration(temp);
        } else {
            System.out.println("No default database file!");
            configuration = new Configuration();
        }
        return configuration;
    }

    public Configuration loadConfiguration(File f) {
        Configuration config = null;
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(f));
            config = (Configuration) input.readObject();
            input.close();
            port = config.port;
            JPEGPort = config.JPEGPort;
            address = config.address;
            
        } catch (IOException | ClassNotFoundException i) {
            System.out.println("Error reading configuration file!");
        }
        return config;
    }

    public boolean saveConfiguration(JFrame parentFrame) {
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
                out.writeObject(this);
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
