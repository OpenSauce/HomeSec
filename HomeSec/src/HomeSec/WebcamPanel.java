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

public class WebcamPanel extends JPanel {

    private EmbeddedMediaPlayerComponent ourMediaPlayer;

    WebcamPanel() {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files\\VideoLAN\\VLC");
        ourMediaPlayer = new EmbeddedMediaPlayerComponent();

        /* Set the canvas */
        Canvas c = new Canvas();
        c.setBackground(Color.black);
        c.setVisible(true);

        /* Set the layout */
        this.setLayout(new BorderLayout());

        /* Add the canvas */
        this.add(c, BorderLayout.CENTER);
        this.add(ourMediaPlayer, BorderLayout.CENTER);
        this.setVisible(true);

    }

    public void play() {
        /* Play the video */
        ourMediaPlayer.getMediaPlayer().playMedia("Resources/test.3gp");

    }
}
