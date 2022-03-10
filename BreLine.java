import java.util.*;
import java.awt.*;
import java.applet.*;

public class BreLine extends Applet{
	int centerX,centerY;

	void getCenter(){
		Dimension d;
		d=getSize();
		centerX= d.width/2;
		centerY= d.height/2;
	}

	void drawLine(Graphics g,int x1,int y1, int x2,int y2){
		int dx=x2-x1;
		int dy=y2-y1;
		int xend,x,y,d,yend;
		xend=x2;yend=y2;
		if(Math.abs(dx)>=Math.abs(dy)){
			d=2*Math.abs(dy)-Math.abs(dx);

			if (x1<x2){
				x=x1;
				y=y1;
				xend=x2;
				yend=y2;

			}
			else{
				if(dx==0){
					if(y1>y2){
						x=x2;
						y=y2;
						yend=y1;
					}
					else{
						x=x1;
						y=y1;
						yend=y2;	
					}
				}
				else{
					x=x2;
					y=y2;
					xend=x1;
					yend=y1;
				}
				
			}
			g.fillOval(x,y,5,5);

			while(x<=xend){
				if(dx==0){
					if(y>yend){
						break;
					}
					
				}
				else{
					x++;
				}
				if (d>=0){
					if(dy>0){
						y=getY(y,yend);
					}
					else{
						y=getY(y,yend);
						
					}
					d=d+2*Math.abs(dy)-2*Math.abs(dx);
				}
				else{
					d=d+2*Math.abs(dy);
				}
				g.fillOval(x,y,5,5);
			}
		}
		else{
			d=2*Math.abs(dx)-Math.abs(dy);

			if (y1<y2){
				x=x1;
				y=y1;
				yend=y2;
				xend=x2;

			}
			else{
				x=x2;
				y=y2;
				yend=y1;
				xend=x1;
			}
			g.fillOval(x,y,5,5);
			while(y<=yend){
				if(dy!=0){
					y++;	
				}
				if (d>=0){
					if(dx>0){
						x=getX(x,xend);
					}
					else{
						x=getX(x,xend);
					}
					d=d+2*Math.abs(dx)-2*Math.abs(dy);
				}
				else{
					d=d+2*Math.abs(dx);
				}
				g.fillOval(x,y,5,5);
			}
		}

	}
	public int getY(int y,int yend){
		if(y<yend){
			return ++y;
		}
		else{
			return --y;
		}
	}
	public int getX(int x,int xend){
		if(x<xend){
			return ++x;
		}
		else{
			return --x;
		}
	}
	public void paint(Graphics g){
		getCenter();
		drawLine(g,centerX+100,centerY+100,centerX,centerY);

	}
}

/*
<applet code="BreLine.class" width="1000" height="1000"></applet>
*/