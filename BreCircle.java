import java.util.*;
import java.awt.*;
import java.applet.*;

public class BreCircle extends Applet{
	int centerX,centerY;

	void getCenter(){
		Dimension d;
		d=getSize();
		centerX= d.width/2;
		centerY= d.height/2;
	}

	void drawCircle(Graphics g,int xc,int yc,int r){
		int d=3-2*r;
		int x,y;
		x=0;
		y=r;
		fillCircle(g,xc,yc,x,y);

		while(x<=y){
			if(d>=0){
				y=y-1;
				d=d+4*(x-y)+10;
			}
			else{
				d=d+4*x+6;
			}
			x++;
			fillCircle(g,xc,yc,x,y);
		}

	}

	void fillCircle(Graphics g,int xc,int yc,int x, int y){
		g.fillOval(xc+x,yc+y,5,5);
		g.fillOval(xc+y,yc+x,5,5);
		g.fillOval(xc+y,yc-x,5,5);
		g.fillOval(xc+x,yc-y,5,5);
		g.fillOval(xc-x,yc-y,5,5);
		g.fillOval(xc-y,yc-x,5,5);
		g.fillOval(xc-y,yc+x,5,5);
		g.fillOval(xc-x,yc+y,5,5);
	}
	public void paint(Graphics g){
		getCenter();
		drawCircle(g,centerX,centerY,100);

	}


}
/*
<applet code="BreCircle.class" width="1000" height="1000"></applet>
*/