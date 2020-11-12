package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Playstate1 extends JPanel implements ActionListener {

    private ImageIcon feild1 = new ImageIcon(this.getClass().getResource("BG23.gif"));
    private ImageIcon feild2 = new ImageIcon(this.getClass().getResource("BG24.gif"));
    private ImageIcon feildover = new ImageIcon(this.getClass().getResource("BG25.jpg"));
    private ImageIcon gameover = new ImageIcon(this.getClass().getResource("Gameover.png"));
    public ImageIcon header = new ImageIcon(this.getClass().getResource("header.jpg"));
    public ImageIcon shut = new ImageIcon(this.getClass().getResource("shut.png"));

    CAT c = new CAT();

    private JLabel score = new JLabel();
    public JButton Bshut = new JButton(shut);

    public ArrayList<CAN> can11 = new ArrayList<CAN>();
    public ArrayList<CAN> can12 = new ArrayList<CAN>();
    public ArrayList<WISKUS> wiskus11 = new ArrayList<WISKUS>();
    public ArrayList<dog1> dog11 = new ArrayList<dog1>();
    public ArrayList<ENERMY> enermy11 = new ArrayList<ENERMY>();
    public ArrayList<Boss11> boss11 = new ArrayList<Boss11>();
    public ArrayList<Boss12> boss12 = new ArrayList<Boss12>();
    public ArrayList<Boss13> boss13 = new ArrayList<Boss13>();
    public ArrayList<Fish1> fh1 = new ArrayList<Fish1>();
    public ArrayList<Fish2> fh2 = new ArrayList<Fish2>();

    public int times;
    public int HP;

    boolean timestart = true;
    boolean startcan = false;

    public int scor = 0;
    boolean paralyze1 = false;
    int time_paralyze = 5;

    Thread time = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }

                if (timestart == false) {
                    repaint();
                }
            }
        }
    });

    Thread actor = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
                repaint();
            }
        }
    });
    Thread can = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startcan == false) {
                        Thread.sleep((long) (Math.random() * 8000) + 200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startcan == false) {
                    can11.add(new CAN());
                }
            }
        }
    });

    Thread can2 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startcan == false) {
                        Thread.sleep((long) (Math.random() * 8000) + 200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startcan == false) {
                    can12.add(new CAN());
                }
            }
        }
    });

    Thread wiskus = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startcan == false) {
                        Thread.sleep((long) (Math.random() * 15000) + 5000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startcan == false) {
                    wiskus11.add(new WISKUS());
                }
            }
        }
    });

    Thread dog = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startcan == false) {
                        Thread.sleep((long) (Math.random() * 10000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startcan == false) {
                    dog11.add(new dog1());
                }
            }
        }
    });

    Thread boss1 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startcan == false) {
                        Thread.sleep((long) (Math.random() * 30000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startcan == false) {
                    boss11.add(new Boss11());
                }
            }
        }
    });

    Thread boss2 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startcan == false) {
                        Thread.sleep((long) (Math.random() * 15000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startcan == false) {
                    boss12.add(new Boss12());
                }
            }
        }
    });

    Thread boss3 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startcan == false) {
                        Thread.sleep((long) (Math.random() * 10000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startcan == false) {
                    boss13.add(new Boss13());
                }
            }
        }
    });

    Thread enermy = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startcan == false) {
                        Thread.sleep((long) (Math.random() * 8000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startcan == false) {
                    enermy11.add(new ENERMY());
                }
            }
        }
    });
    Thread paralyze = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (time_paralyze < 1) {
                    paralyze1 = false;
                    time_paralyze = 5;
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });
    Thread t = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (timestart == false) {
                    times = (times - 1);
                    if (paralyze1) {
                        time_paralyze--;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    Playstate1() {
        this.setFocusable(true);
        this.setLayout(null);
        Bshut.setBounds(950, 50, 230, 220);
        Bshut.setOpaque(false);
        Bshut.setBorderPainted(false);
        Bshut.setContentAreaFilled(false);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int a = e.getKeyCode();
                if (a == KeyEvent.VK_LEFT) {
                    c.x -= 10;
                    c.count++;
                } else if (a == KeyEvent.VK_RIGHT) {
                    c.x += 10;
                    c.count++;
                }
                if (c.count >= 4) {
                    c.count = 0;

                } else if (a == KeyEvent.VK_UP) {
                    c.count = 5;
                    fh2.add(new Fish2(c.x + 125, c.y));
                } else if (a == KeyEvent.VK_SPACE) {
                    c.count = 6;
                    fh1.add(new Fish1(c.x + 125, c.y));
                }
            }

            public void keyReleased(KeyEvent e) {
                c.count = c.count;
            }
        });

        c.x = 0;
        c.y = 480;
        time.start();
        actor.start();
        t.start();
        can.start();
        dog.start();
        paralyze.start();
        wiskus.start();
        enermy.start();
        can2.start();
        boss1.start();
        boss2.start();
        boss3.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (times <= 0 || HP <= 0) {
            this.setLayout(null);
            this.add(Bshut);
            Bshut.setBounds(500, 300, 230, 220);
            g.drawImage(shut.getImage(), 300, 300, 300, 300, this);
            g.drawImage(feildover.getImage(), 0, 0, getWidth(), getHeight(), this);
            g.drawImage(gameover.getImage(), 375, -100, 500, 500, this);
            g.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 90));
            g.setColor(Color.BLACK);
            g.drawString("Total Score = " + scor, 400, 325);
        } else {
            if (times <= 60) {
                this.setLayout(null);
                this.add(Bshut);
                g.drawImage(feild1.getImage(), 0, 0, getWidth(), getHeight(), this);
                g.drawImage(header.getImage(), 0, 0, 1280, 200, this);
                g.drawImage(c.im[c.count].getImage(), c.x, 430, 300, 200, this);

                for (int i = 0; i < fh1.size(); i++) {
                    Fish1 etb = fh1.get(i);
                    g.drawImage(etb.FH.getImage(), etb.x, etb.y, 100, 100, null);
                    etb.move();
                    if (etb.x > 1280) {
                        fh1.remove(i);
                    }
                }
                for (int i = 0; i < fh2.size(); i++) {
                    Fish2 etb2 = fh2.get(i);
                    g.drawImage(etb2.FH.getImage(), etb2.x, etb2.y, 100, 100, null);
                    etb2.move();
                    if (etb2.y < 150) {
                        fh2.remove(i);
                    }
                }

                for (int i = 0; i < dog11.size(); i++) {
                    g.drawImage(dog11.get(i).getImage(), dog11.get(i).getX(), dog11.get(i).getY() - 100, 200, 150, this);
                    if (Intersect(dog11.get(i).getbound(), c.getbound())) {
                        HP -= 1;
                        dog11.remove(i);
                    }
                }
                for (int i = 0; i < fh1.size(); i++) {
                    for (int j = 0; j < dog11.size(); j++) {
                        if (Intersect(fh1.get(i).getbound(), dog11.get(j).getbound())) {
                            dog11.remove(j);
                            fh1.remove(i);
                            scor += 10;

                        }
                    }
                }

                for (int i = 0; i < boss11.size(); i++) {
                    g.drawImage(boss11.get(i).getImage(), boss11.get(i).getX(), boss11.get(i).getY() - 350, 800, 500, this);
                    if (Intersect(boss11.get(i).getbound(), c.getbound())) {
                        HP -= 5;
                        boss11.remove(i);
                    }
                }
                for (int i = 0; i < fh1.size(); i++) {
                    for (int j = 0; j < boss11.size(); j++) {
                        if (Intersect(fh1.get(i).getbound(), boss11.get(j).getbound())) {
                            boss11.get(0).HPboss1 -= 1;
                            fh1.remove(i);
                            if (boss11.get(0).HPboss1 == 0) {
                                boss11.remove(j);
                                scor += 50;
                            }
                        }
                    }
                }

                for (int i = 0; i < can11.size(); i++) {
                    g.drawImage(can11.get(i).getImage(), can11.get(i).getX(), can11.get(i).getY(), 100, 100, this);
                    if (Intersect(can11.get(i).getbound(), c.getbound())) {
                        HP -= 1;
                        can11.remove(i);
                    }
                }

                for (int i = 0; i < wiskus11.size(); i++) {
                    g.drawImage(wiskus11.get(i).getImage(), wiskus11.get(i).getX(), wiskus11.get(i).getY(), 100, 100, this);
                    if (Intersect(wiskus11.get(i).getbound(), c.getbound())) {
                        if (HP < 5) {
                            HP += 1;
                        } else {
                            HP += 0;
                        }
                        wiskus11.remove(i);
                    }
                }
                g.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 50));
                g.setColor(Color.WHITE);
                g.drawString("State 1 ", 100, 175);
                g.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 50));
                g.setColor(Color.WHITE);
                g.drawString("Time :" + times, 500, 175);
                g.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 50));
                g.setColor(Color.WHITE);
                g.drawString("HP  " + HP, 300, 175);
                g.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 50));
                g.setColor(Color.WHITE);
                g.drawString("Score  " + scor, 750, 175);
            }
            if (times <= 30) {
                dog11.clear();
                can11.clear();
                boss11.clear();
                this.setLayout(null);
                this.add(Bshut);
                g.drawImage(feild2.getImage(), 0, 0, getWidth(), getHeight(), this);
                g.drawImage(header.getImage(), 0, 0, 1280, 200, this);
                g.drawImage(c.im[c.count].getImage(), c.x, 430, 300, 200, this);

                for (int i = 0; i < fh1.size(); i++) {
                    Fish1 etb = fh1.get(i);
                    g.drawImage(etb.FH.getImage(), etb.x, etb.y, 100, 100, null);
                    etb.move();
                    if (etb.x > 1200) {
                        fh1.remove(i);
                    }
                }
                for (int i = 0; i < fh2.size(); i++) {
                    Fish2 etb2 = fh2.get(i);
                    g.drawImage(etb2.FH.getImage(), etb2.x, etb2.y, 100, 100, null);
                    etb2.move();
                    if (etb2.y < 150) {
                        fh2.remove(i);
                    }
                }

                for (int i = 0; i < enermy11.size(); i++) {
                    g.drawImage(enermy11.get(i).getImage(), enermy11.get(i).getX(), enermy11.get(i).getY() - 225, 450, 400, this);
                    if (Intersect(enermy11.get(i).getbound(), c.getbound())) {
                        HP -= 1;
                        enermy11.remove(i);
                    }
                }
                for (int i = 0; i < fh1.size(); i++) {
                    for (int j = 0; j < enermy11.size(); j++) {
                        if (Intersect(fh1.get(i).getbound(), enermy11.get(j).getbound())) {
                            enermy11.remove(j);
                            fh1.remove(i);
                            scor += 10;

                        }
                    }
                }

                for (int i = 0; i < boss13.size(); i++) {
                    g.drawImage(boss13.get(i).getImage(), boss13.get(i).getX(), boss13.get(i).getY() - 300, 600, 400, this);
                    if (Intersect(boss13.get(i).getbound(), c.getbound())) {
                        HP -= 2;
                        boss13.remove(i);
                    }
                }
                for (int i = 0; i < fh1.size(); i++) {
                    for (int j = 0; j < boss13.size(); j++) {
                        if (Intersect(fh1.get(i).getbound(), boss13.get(j).getbound())) {
                            boss13.get(0).HPboss1 -= 1;
                            fh1.remove(i);
                            if (boss13.get(0).HPboss1 == 0) {
                                boss13.remove(j);
                                scor += 50;
                            }
                        }
                    }
                }

                for (int i = 0; i < boss12.size(); i++) {
                    g.drawImage(boss12.get(i).getImage(), boss12.get(i).getX(), boss12.get(i).getY() + 100, 400, 150, this);
                    if (Intersect(boss12.get(i).getbound(), c.getbound())) {
                        HP -= 2;
                        boss12.remove(i);
                    }
                }

                for (int i = 0; i < fh2.size(); i++) {
                    for (int j = 0; j < boss12.size(); j++) {
                        if (Intersect(fh2.get(i).getbound(), boss12.get(j).getbound())) {
                            boss12.get(0).HPboss2 -= 1;
                            fh2.remove(i);
                            if (boss12.get(0).HPboss2 == 0) {
                                boss12.remove(j);
                                scor += 50;
                            }
                        }
                    }
                }

                for (int i = 0; i < can12.size(); i++) {
                    g.drawImage(can12.get(i).getImage(), can12.get(i).getX(), can12.get(i).getY(), 100, 100, this);
                    if (Intersect(can12.get(i).getbound(), c.getbound())) {
                        HP -= 1;
                        can12.remove(i);
                    }

                }

                for (int i = 0; i < wiskus11.size(); i++) {
                    g.drawImage(wiskus11.get(i).getImage(), wiskus11.get(i).getX(), wiskus11.get(i).getY(), 100, 100, this);
                    if (Intersect(wiskus11.get(i).getbound(), c.getbound())) {
                        if (HP < 5) {
                            HP += 1;
                        } else {
                            HP += 0;
                        }
                        wiskus11.remove(i);
                    }
                }
                g.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 50));
                g.setColor(Color.WHITE);
                g.drawString("State 2 ", 100, 175);
                g.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 50));
                g.setColor(Color.WHITE);
                g.drawString("Time " + times, 500, 175);
                g.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 50));
                g.setColor(Color.WHITE);
                g.drawString("HP  " + HP, 300, 175);
                g.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 50));
                g.setColor(Color.WHITE);
                g.drawString("Score  " + scor, 750, 175);
            }

        }
        if (c.x < 0) {
            c.x = 0;
        } else if (c.x > 1000) {
            c.x = 1000;
        }
    }

    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
