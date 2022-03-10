import java.applet.*;
import java.awt.*;
import java.util.*;

public class bresenhams extends Applet{
	int centerX, centerY, dGrid = 1, maxX, maxY;
    
/*void initgr() {
	Dimension d;	// get the window size and compute minimum, maximum and center
	d = getSize();
	maxX = d.width - 1; 
	maxY = d.height - 1;
	centerX = maxX/2; centerY = maxY/2;
   	}*/
	
void drawLine(Graphics g, int x0, int y0, int x1, int y1) { // Bresenhams Algorithm 
    int dx, dy, p, x, y;
 
	dx=x1-x0;
	dy=y1-y0;
 
	x=x0;
	y=y0;
 
	p=2*dy-dx;
 
	while(x<x1)
	{
		if(p>=0)
		{
			g.fillOval((int)x,(int)y,5,5);
			y=y+1;
			p=p+2*dy-2*dx;
		}
		else
		{
			g.fillOval((int)x,(int)y,5,5);
			p=p+2*dy;
		}
		x=x+1;
	}
}

	public void paint(Graphics g) {
		//initgr();
		/*drawLine(g, centerX-100, centerY-100, centerX+100, centerY-100);
		drawLine(g, centerX+100, centerY-100, centerX+100, centerY+100);
		drawLine(g, centerX+100, centerY+100, centerX-100, centerY+100);
		drawLine(g, centerX-100, centerY+100, centerX-100, centerY-100);
		
		drawLine(g, centerX, centerY-240, centerX+240, centerY+100);
		drawLine(g, centerX, centerY-240, centerX-240, centerY+100);
		drawLine(g, centerX-240, centerY+100, centerX+240, centerY+100);*/
		
		drawLine(g, 0, 0, 250, 250);
		drawLine(g, 250, 250, 500, 0);
		//drawLine(g, 500, 500, 1000, 0);
		
	}	

}

/*<applet code="bresenhams.class" width="1000" height="1000">
 </applet>

 */