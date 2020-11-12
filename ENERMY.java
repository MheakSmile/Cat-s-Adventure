package game;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class ENERMY {
	Image img;
	public int x = 1120;
	public int y= 550;
	public int count = 0;
	ENERMY(){
                String imageLocation = "enermy.gif";
                URL imageURL = this.getClass().getResource(imageLocation);
		img = Toolkit.getDefaultToolkit().getImage(imageURL);
		enermy.start();
	}
	Thread enermy = new Thread(new Runnable() {
            public void run() {
		while(true){
                    x -= 2;
                    if(x == 0){
			img = null;
			enermy = null;
			x = 1120;
			y = 550;
                    }
                    try{
			enermy.sleep(10);
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
    	    return (new Rectangle2D.Double(x,y,80,80));
	}
}
