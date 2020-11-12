package game;


import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class Boss12 {
	Image img;
        public int HPboss2 = 5;
	public int x = 1120;
	public int y= 130;
	public int count = 0;
	Boss12(){
                String imageLocation = "boss2.gif";
                URL imageURL = this.getClass().getResource(imageLocation);
		img = Toolkit.getDefaultToolkit().getImage(imageURL);
		boss2.start();
	}
	Thread boss2 = new Thread(new Runnable() {
            public void run() {
		while(true){
                    x -=3;
                    if(x == 0){
			img = null;
			boss2 = null;
			x = 1120;
			y = 120;
                    }
                    try{
			boss2.sleep(10);
                    }catch(InterruptedException e){}
                }
            }
	});
	
	public Image getImage(){
            return img;
	}
	
	public int getX(){
            return x;
	}
	public int getY(){
            return y;
	}
	public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,150,150));
	}
}
