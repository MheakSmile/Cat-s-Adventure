package game;

import game.Page;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class Play extends JFrame implements ActionListener {

    Page Homegame = new Page();
    Playstate1 state1 = new Playstate1();
    tutorial t = new tutorial();

    public Play() {
        this.setSize(1280, 720);
        this.add(Homegame);
        Homegame.BStart.addActionListener(this);
        Homegame.Bexit.addActionListener(this);
        Homegame.Btutorial.addActionListener(this);
        state1.Bshut.addActionListener(this);
        t.Bback.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Homegame.BStart) {
            this.setLocationRelativeTo(null);
            this.remove(Homegame);
            this.setSize(1280, 720);
            this.add(state1);
            state1.requestFocusInWindow();
            state1.timestart = false;
            state1.scor = 0;
            state1.HP = 5;
            state1.times = 30;
            state1.startcan = false;
            state1.timestart = false;
        } else if (e.getSource() == Homegame.Bexit || e.getSource() == state1.Bshut) {
            System.exit(0);
        } else if (e.getSource() == Homegame.Btutorial) {
            this.setLocationRelativeTo(null);
            this.remove(Homegame);
            this.setSize(1280, 720);
            this.add(t);
            t.requestFocusInWindow();
        } else if (e.getSource() == t.Bback) {
            this.setLocationRelativeTo(null);
            this.remove(t);
            this.setSize(1280, 720);
            this.add(Homegame);
            Homegame.requestFocusInWindow();
        }
        this.validate();
        this.repaint();
    }

    public static void main(String[] args) {
        JFrame jf = new Play();
        jf.setSize(1280, 720);
        jf.setTitle("Cat's Adventure");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        String filepath = "Triage X-Dear my friend.wav";
     Musicstuff musicObject = new Musicstuff();
     musicObject.playmusic(filepath);
    }
}
