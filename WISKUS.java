package game;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class WISKUS {
	Image img;
	public int x = (int) ((Math.random()*1000)+100);
	public int y= 0;
	public int count = 0;
	WISKUS(){
                String imageLocation = "wiskus.png";
                URL imageURL = this.getClass().getResource(imageLocation);
		img = Toolkit.getDefaultToolkit().getImage(imageURL);
		wiskus.start();
	}
	Thread wiskus = new Thread(new Runnable() {
            public void run() {
		while(true){
                    y += 2;
                    if(y >= 1100){
			img = null;
			wiskus = null;
			x = -500;
			y = -500;
                    }
                    try{
			wiskus.sleep(10);
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
    	    return (new Rectangle2D.Double(x,y,45,45));
	}
}
