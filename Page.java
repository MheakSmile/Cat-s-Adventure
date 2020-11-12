package game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class Page extends JPanel {

    private ImageIcon feild = new ImageIcon(this.getClass().getResource("BG34.jpg"));
    private ImageIcon starts = new ImageIcon(this.getClass().getResource("startbutton.png"));
    private ImageIcon exit = new ImageIcon(this.getClass().getResource("endbutton.png"));
    private ImageIcon tutorial = new ImageIcon(this.getClass().getResource("tutorial.png"));

    public JButton BStart = new JButton(starts);
    public JButton Bexit = new JButton(exit);
    public JButton Btutorial = new JButton(tutorial);

    Page() {
        setLayout(null);
        BStart.setBounds(500, 300, 235, 100);
        add(BStart);
        BStart.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setLayout(null);
        Bexit.setBounds(515, 550, 210, 80);
        add(Bexit);
        Bexit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setLayout(null);
        Btutorial.setBounds(400, 425, 450, 100);
        add(Btutorial);
        Btutorial.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(feild.getImage(), 0, 0, getWidth(), getHeight(), this);

    }

}
