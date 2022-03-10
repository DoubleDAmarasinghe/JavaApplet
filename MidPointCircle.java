import java.util.*;
import java.awt.*;
import java.applet.*;

public class MidPointCircle extends Applet{
	int centerX,centerY;

	void getCenter(){
		Dimension d;
		d=getSize();
		centerX= d.width/2;
		centerY= d.height/2;
	}

	voi
	d drawCircle(Graphics g,int xc,int yc,int r){
		int d=1-r;
		int x,y;
		x=0;
		y=r;
		fillCircle(g,xc,yc,x,y);

		while(x<=y){
			if(d>=0){
				y=y-1;
				d=d+2*(x-y)+5;
			}
			else{
				d=d+2*x+3;
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
		drawCircle(g,centerX,centerY,50);

	}


}
/*
<applet code="MidPointCircle.class" width="1000" height="1000"></applet>
*/