
package game;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

public class Fish2 {
       public ImageIcon FH = new ImageIcon(this.getClass().getResource("fish.png"));
    public int y;
    public int x;
    public int count=0;
     Fish2(int x,int y){
            this.x=x;
            this.y=y;
    }
	
    public void move(){
	this.y-=7;
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,100,100));
    }
}
