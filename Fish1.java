
package game;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

public class Fish1 {
    
    public ImageIcon FH = new ImageIcon(this.getClass().getResource("fish.png"));
    public int y;
    public int x;
    public int count=0;
     Fish1(int x,int y){
            this.x=x;
            this.y=y;
    }
	
    public void move(){
	this.x+=7;
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,80,80));
    }
}
