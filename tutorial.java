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

public class tutorial extends JPanel {

    private ImageIcon feildtutorial = new ImageIcon(this.getClass().getResource("ftutorial.jpg"));
    private ImageIcon back = new ImageIcon(this.getClass().getResource("back.png"));
    public JButton Bback = new JButton(back);

    tutorial() {
        setLayout(null);
        Bback.setBounds(450, 550, 350, 120);
        Bback.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(Bback);

    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(feildtutorial.getImage(), 0, 0,getWidth(),getHeight(), this);

    }
 
}
