import java.util.*;
import java.awt.*;
import java.applet.*;


public class DdaLine extends Applet{
	int centerX,centerY;

	void getCenter(){
		Dimension d;
		d=getSize();
		centerX= d.width/2;
		centerY= d.height/2;
	}

	void drawLine(Graphics g,int x1,int y1,int x2,int y2){
		int dx=x2-x1;
		int dy=y2-y1;
		int step,x,y;

		if(dx>dy){
			step=dx;
		}
		else{
			step=dy;
		}
		x=x1;
		y=y1;
		g.fillOval(x,y,5,5);

		float xinc=dx/step;
		float yinc=dy/step;

		for(int i=0;i<step;i++){
			x=(int)(x+xinc);
			y=(int)(y+yinc);
			g.fillOval(x,y,5,5);
		}

	}
	public void paint(Graphics g){
		getCenter();
		drawLine(g,centerX+200,centerY,centerX+400,centerY-100);

	}
}






/*<applet code='DdaLine' width=1000 height=1000></applet>*/