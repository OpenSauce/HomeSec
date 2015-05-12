/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeSec;

import com.sun.jna.NativeLibrary;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class WebcamPanel extends JPanel implements Runnable {
    private Configuration config;
    private Thread t;
    private EmbeddedMediaPlayerComponent ourMediaPlayer;

    WebcamPanel(MainFrame parentWindow) {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files\\VideoLAN\\VLC");
        ourMediaPlayer = new EmbeddedMediaPlayerComponent();

        config = parentWindow.getConfig();
        
        Canvas c = new Canvas();
        c.setBackground(Color.black);
        c.setVisible(true);

        this.setLayout(new BorderLayout());

        this.add(c, BorderLayout.CENTER);
        this.add(ourMediaPlayer, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void play() {
        //ourMediaPlayer.getMediaPlayer().playMedia("Resources/test.3gp");
        ourMediaPlayer.getMediaPlayer().playMedia("tcp/h264://" + config.getAddress()
                + ":" + config.getPort() + "/");
    }

    @Override
    public void run() {
        play();
    }

    public void start() {
        t = new Thread(this);
        t.start();
    }

    public Thread getT() {
        return t;
    }

    public void setT(Thread t) {
        this.t = t;
    }

    public EmbeddedMediaPlayerComponent getOurMediaPlayer() {
        return ourMediaPlayer;
    }

    public void setOurMediaPlayer(EmbeddedMediaPlayerComponent ourMediaPlayer) {
        this.ourMediaPlayer = ourMediaPlayer;
    }
    
    
}
