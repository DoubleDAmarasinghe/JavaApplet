import java.util.*;
import java.awt.*;
import java.applet.*;

public class PassPapers extends Applet{
	int centerX,centerY;

	/* get center coordinates */
	void getCenter(){
		Dimension d;
		d=getSize();
		centerX= d.width/2;
		centerY= d.height/2;
	}

	/* bresenham line algorithom function */
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


	void drawCircle(Graphics g,int xc,int yc,int r){
		int d=3-2*r;
		int x,y;
		x=0;
		y=r;
		while(x<=y){
			fillCircle(g,xc,yc,x,y);
			if(d>=0){
				y=y-1;
				d=d+4*(x-y)+10;
			}
			else{
				d=d+4*x+6;
			}
			x++;
		}

	}
	void fillCircle(Graphics g,int xc,int yc,int x, int y){

		int points[][]={{xc+x,yc+y},{xc+y,yc+x},{xc+y,yc-x},{xc+x,yc-y},{xc-x,yc-y},{xc-y,yc-x},{xc-y,yc+x},{xc-x,yc+y}};
		for(int i=0;i<8;i++){
			g.fillOval(points[i][0],points[i][1],5,5);
		}
		
		
		
	}

	//cicle scaling
	void drawCircle(Graphics g,int xc,int yc,int r,double s[]){
		int d=3-2*r;
		int x,y;
		x=0;
		y=r;
		while(x<=y){
			fillCircle(g,xc,yc,x,y,s);
			if(d>=0){
				y=y-1;
				d=d+4*(x-y)+10;
			}
			else{
				d=d+4*x+6;
			}
			x++;
		}

	}
	void fillCircle(Graphics g,int xc,int yc,int x, int y,double s[]){

		int points[][]={{xc+x,yc+y},{xc+y,yc+x},{xc+y,yc-x},{xc+x,yc-y},{xc-x,yc-y},{xc-y,yc-x},{xc-y,yc+x},{xc-x,yc+y}};
		/* circle Scaling */
		
		
		int newCircleScalePoints[][]=new int[8][2];

		newCircleScalePoints=scale(points,s);

		for(int i=0;i<8;i++){
			g.fillOval(newCircleScalePoints[i][0],newCircleScalePoints[i][1],5,5);
		}
		
		
	}

	public void paint(Graphics g){
		getCenter();
		
		/* pass paper 2015-2016 */

		/*
		int circlePoints[][]={{centerX,centerY}};
		int rectanglePoints[][]={{centerX-70,centerY-70},{centerX+70,centerY-70},{centerX-70,centerY+70},{centerX+70,centerY+70}};
		int trianglePoints[][]={{centerX-180,centerY+100},{centerX+180,centerY+100},{centerX,centerY-180}};

		drawCircle(g,circlePoints[0][0],circlePoints[0][1],100);

		drawLine(g,rectanglePoints[0][0],rectanglePoints[0][1],rectanglePoints[1][0],rectanglePoints[1][1]);
		drawLine(g,rectanglePoints[0][0],rectanglePoints[0][1],rectanglePoints[2][0],rectanglePoints[2][1]);
		drawLine(g,rectanglePoints[2][0],rectanglePoints[2][1],rectanglePoints[3][0],rectanglePoints[3][1]);
		drawLine(g,rectanglePoints[1][0],rectanglePoints[1][1],rectanglePoints[3][0],rectanglePoints[3][1]);

		drawLine(g,trianglePoints[0][0],trianglePoints[0][1],trianglePoints[1][0],trianglePoints[1][1]);
		drawLine(g,trianglePoints[2][0],trianglePoints[2][1],trianglePoints[0][0],trianglePoints[0][1]);
		drawLine(g,trianglePoints[2][0],trianglePoints[2][1],trianglePoints[1][0],trianglePoints[1][1]);
		*/

		/* translating */

		/*
		int t[]={10,20};
		int newCircleTranslatePoints[][]=new int[1][2];
		int newTriangleTranslatePoints[][]=new int[3][2];
		int newRectangleTranslatePoints[][]=new int[4][2];

		newCircleTranslatePoints=translate(circlePoints,t);
		newTriangleTranslatePoints=translate(trianglePoints,t);
		newRectangleTranslatePoints=translate(rectanglePoints,t);


		drawCircle(g,newCircleTranslatePoints[0][0],newCircleTranslatePoints[0][1],100);

		drawLine(g,newRectangleTranslatePoints[0][0],newRectangleTranslatePoints[0][1],newRectangleTranslatePoints[1][0],newRectangleTranslatePoints[1][1]);
		drawLine(g,newRectangleTranslatePoints[0][0],newRectangleTranslatePoints[0][1],newRectangleTranslatePoints[2][0],newRectangleTranslatePoints[2][1]);
		drawLine(g,newRectangleTranslatePoints[2][0],newRectangleTranslatePoints[2][1],newRectangleTranslatePoints[3][0],newRectangleTranslatePoints[3][1]);
		drawLine(g,newRectangleTranslatePoints[1][0],newRectangleTranslatePoints[1][1],newRectangleTranslatePoints[3][0],newRectangleTranslatePoints[3][1]);
		drawLine(g,newRectangleTranslatePoints[1][0],newRectangleTranslatePoints[1][1],newRectangleTranslatePoints[0][0],newRectangleTranslatePoints[0][1]);

		drawLine(g,newTriangleTranslatePoints[0][0],newTriangleTranslatePoints[0][1],newTriangleTranslatePoints[1][0],newTriangleTranslatePoints[1][1]);
		drawLine(g,newTriangleTranslatePoints[2][0],newTriangleTranslatePoints[2][1],newTriangleTranslatePoints[0][0],newTriangleTranslatePoints[0][1]);
		drawLine(g,newTriangleTranslatePoints[2][0],newTriangleTranslatePoints[2][1],newTriangleTranslatePoints[1][0],newTriangleTranslatePoints[1][1]);

		*/

		/* rotating */

		/*
		int newCircleRotatePoints[][]=new int[1][2];
		int newRectangleRotatePoints[][]=new int[4][2];
		int newTriangleRotatePoints[][]=new int[3][2];

		//for(int i=1;i<12;i++){
		newCircleRotatePoints=rotate(circlePoints,60);
		newRectangleRotatePoints=rotate(rectanglePoints,60);
		newTriangleRotatePoints=rotate(trianglePoints,60);

		drawCircle(g,newCircleRotatePoints[0][0],newCircleRotatePoints[0][1],100);

		drawLine(g,newRectangleRotatePoints[0][0],newRectangleRotatePoints[0][1],newRectangleRotatePoints[1][0],newRectangleRotatePoints[1][1]);
		drawLine(g,newRectangleRotatePoints[0][0],newRectangleRotatePoints[0][1],newRectangleRotatePoints[2][0],newRectangleRotatePoints[2][1]);
		drawLine(g,newRectangleRotatePoints[2][0],newRectangleRotatePoints[2][1],newRectangleRotatePoints[3][0],newRectangleRotatePoints[3][1]);
		drawLine(g,newRectangleRotatePoints[1][0],newRectangleRotatePoints[1][1],newRectangleRotatePoints[3][0],newRectangleRotatePoints[3][1]);
		
		drawLine(g,newTriangleRotatePoints[0][0],newTriangleRotatePoints[0][1],newTriangleRotatePoints[1][0],newTriangleRotatePoints[1][1]);
		drawLine(g,newTriangleRotatePoints[2][0],newTriangleRotatePoints[2][1],newTriangleRotatePoints[0][0],newTriangleRotatePoints[0][1]);
		drawLine(g,newTriangleRotatePoints[2][0],newTriangleRotatePoints[2][1],newTriangleRotatePoints[1][0],newTriangleRotatePoints[1][1]);

		newCircleRotatePoints=rotate(circlePoints,45);
		newRectangleRotatePoints=rotate(rectanglePoints,45);
		newTriangleRotatePoints=rotate(trianglePoints,45);

		drawCircle(g,newCircleRotatePoints[0][0],newCircleRotatePoints[0][1],100);

		drawLine(g,newRectangleRotatePoints[0][0],newRectangleRotatePoints[0][1],newRectangleRotatePoints[1][0],newRectangleRotatePoints[1][1]);
		drawLine(g,newRectangleRotatePoints[0][0],newRectangleRotatePoints[0][1],newRectangleRotatePoints[2][0],newRectangleRotatePoints[2][1]);
		drawLine(g,newRectangleRotatePoints[2][0],newRectangleRotatePoints[2][1],newRectangleRotatePoints[3][0],newRectangleRotatePoints[3][1]);
		drawLine(g,newRectangleRotatePoints[1][0],newRectangleRotatePoints[1][1],newRectangleRotatePoints[3][0],newRectangleRotatePoints[3][1]);
		
		drawLine(g,newTriangleRotatePoints[0][0],newTriangleRotatePoints[0][1],newTriangleRotatePoints[1][0],newTriangleRotatePoints[1][1]);
		drawLine(g,newTriangleRotatePoints[2][0],newTriangleRotatePoints[2][1],newTriangleRotatePoints[0][0],newTriangleRotatePoints[0][1]);
		drawLine(g,newTriangleRotatePoints[2][0],newTriangleRotatePoints[2][1],newTriangleRotatePoints[1][0],newTriangleRotatePoints[1][1]);
		//}
		*/

		/* scaling */

		/*
		double scaleArray[]={1.5,1.5};
		int newRectangleScalePoints[][]=new int[4][2];
		int newTriangleScalePoints[][]=new int[3][2];

		newRectangleScalePoints=scale(rectanglePoints,scaleArray);
		newTriangleScalePoints=scale(trianglePoints,scaleArray);

		drawCircle(g,circlePoints[0][0],circlePoints[0][1],100,scaleArray);

		drawLine(g,newRectangleScalePoints[0][0],newRectangleScalePoints[0][1],newRectangleScalePoints[1][0],newRectangleScalePoints[1][1]);
		drawLine(g,newRectangleScalePoints[0][0],newRectangleScalePoints[0][1],newRectangleScalePoints[2][0],newRectangleScalePoints[2][1]);
		drawLine(g,newRectangleScalePoints[2][0],newRectangleScalePoints[2][1],newRectangleScalePoints[3][0],newRectangleScalePoints[3][1]);
		drawLine(g,newRectangleScalePoints[1][0],newRectangleScalePoints[1][1],newRectangleScalePoints[3][0],newRectangleScalePoints[3][1]);
		
		drawLine(g,newTriangleScalePoints[0][0],newTriangleScalePoints[0][1],newTriangleScalePoints[1][0],newTriangleScalePoints[1][1]);
		drawLine(g,newTriangleScalePoints[2][0],newTriangleScalePoints[2][1],newTriangleScalePoints[0][0],newTriangleScalePoints[0][1]);
		drawLine(g,newTriangleScalePoints[2][0],newTriangleScalePoints[2][1],newTriangleScalePoints[1][0],newTriangleScalePoints[1][1]);
		*/

		/* passpaper Q1 2016-2017 */
		/*
		drawLine(g,centerX-150,centerY+200,centerX+150,centerY+200);
		drawLine(g,centerX-150,centerY+200,centerX-150,centerY-300);
		drawLine(g,centerX+150,centerY-300,centerX-150,centerY-300);
		drawLine(g,centerX+150,centerY-300,centerX+150,centerY+200);

		drawLine(g,centerX-150,centerY+200,centerX-50,centerY);
		drawLine(g,centerX+50,centerY,centerX-50,centerY);
		drawLine(g,centerX+50,centerY,centerX+150,centerY+200);

		drawLine(g,centerX-50,centerY-300,centerX-50,centerY);
		drawLine(g,centerX+50,centerY,centerX+50,centerY-300);

		drawCircle(g,centerX,centerY+100,50);
		*/

		/* passpaper Q1 2016-2017 */
		/*
		int line[][]={{centerX-150,centerY-300},{centerX,centerY-450},{centerX+150,centerY-300}};
		int rectangle1[][]={{centerX-150,centerY},{centerX-150,centerY-300},{centerX+150,centerY-300},{centerX+150,centerY}};
		int rectangle2[][]={{centerX-50,centerY-5},{centerX+50,centerY-5},{centerX-50,centerY-150},{centerX+50,centerY-150}};

		drawLine(g,line[0][0],line[0][1],line[1][0],line[1][1]);
		drawLine(g,line[0][0],line[0][1],line[2][0],line[2][1]);
		drawLine(g,line[1][0],line[1][1],line[2][0],line[2][1]);

		drawLine(g,rectangle1[0][0],rectangle1[0][1],rectangle1[1][0],rectangle1[1][1]);
		drawLine(g,rectangle1[2][0],rectangle1[2][1],rectangle1[1][0],rectangle1[1][1]);
		drawLine(g,rectangle1[2][0],rectangle1[2][1],rectangle1[3][0],rectangle1[3][1]);
		drawLine(g,rectangle1[0][0],rectangle1[0][1],rectangle1[3][0],rectangle1[3][1]);

		drawLine(g,rectangle2[0][0],rectangle2[0][1],rectangle2[1][0],rectangle2[1][1]);
		drawLine(g,rectangle2[0][0],rectangle2[0][1],rectangle2[2][0],rectangle2[2][1]);
		drawLine(g,rectangle2[3][0],rectangle2[3][1],rectangle2[2][0],rectangle2[2][1]);
		drawLine(g,rectangle2[3][0],rectangle2[3][1],rectangle2[1][0],rectangle2[1][1]);


		int t[]={300,400};
		translateLine(line,t);
		translateRectangle(rectangle1,t);
		translateRectangle(rectangle2,t);

		drawLine(g,line[0][0],line[0][1],line[1][0],line[1][1]);
		drawLine(g,line[0][0],line[0][1],line[2][0],line[2][1]);
		drawLine(g,line[1][0],line[1][1],line[2][0],line[2][1]);

		drawLine(g,rectangle1[0][0],rectangle1[0][1],rectangle1[1][0],rectangle1[1][1]);
		drawLine(g,rectangle1[2][0],rectangle1[2][1],rectangle1[1][0],rectangle1[1][1]);
		drawLine(g,rectangle1[2][0],rectangle1[2][1],rectangle1[3][0],rectangle1[3][1]);
		drawLine(g,rectangle1[0][0],rectangle1[0][1],rectangle1[3][0],rectangle1[3][1]);

		drawLine(g,rectangle2[0][0],rectangle2[0][1],rectangle2[1][0],rectangle2[1][1]);
		drawLine(g,rectangle2[0][0],rectangle2[0][1],rectangle2[2][0],rectangle2[2][1]);
		drawLine(g,rectangle2[3][0],rectangle2[3][1],rectangle2[2][0],rectangle2[2][1]);
		drawLine(g,rectangle2[3][0],rectangle2[3][1],rectangle2[1][0],rectangle2[1][1]);

		*/

		/* passpaper Q3 2016-2017 */
		/*
		int p[][]={{centerX+50,centerY+50},{centerX+200,centerY+300},{centerX+200,centerY-300},{centerX+50,centerY-150}};

		drawLine(g,p[0][0],p[0][1],p[1][0],p[1][1]);
		drawLine(g,p[2][0],p[2][1],p[1][0],p[1][1]);
		drawLine(g,p[2][0],p[2][1],p[3][0],p[3][1]);
		drawLine(g,p[0][0],p[0][1],p[3][0],p[3][1]);

		reflectY(p);

		drawLine(g,p[0][0],p[0][1],p[1][0],p[1][1]);
		drawLine(g,p[2][0],p[2][1],p[1][0],p[1][1]);
		drawLine(g,p[2][0],p[2][1],p[3][0],p[3][1]);
		drawLine(g,p[0][0],p[0][1],p[3][0],p[3][1]);
		*/

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

	public int[][] translate(int points[][],int t[]){
		int newPoints[][]=new int[points.length][2];

		for(int i=0;i<points.length;i++){
			newPoints[i][0]=points[i][0]+t[0];
			newPoints[i][1]=points[i][1]+t[1];
		}
		return newPoints;
	}

	public int[][] rotate(int points[][],double angle){
		int rotatePoints[][]=new int[points.length][2];
		angle=Math.toRadians(angle);

		for(int i=0;i<points.length;i++){
			rotatePoints[i][0] = (int)((points[i][0]-centerX)*Math.cos(angle) - (points[i][1]-centerY)*Math.sin(angle))+centerX;
			rotatePoints[i][1] = (int)((points[i][1]-centerY)*Math.cos(angle) + (points[i][0]-centerX)*Math.sin(angle))+centerY;
		}
		return rotatePoints;
	}

	public int[][] scale(int points[][],double s[]){
		int scalePoints[][]=new int[points.length][2];

		for(int i=0;i<points.length;i++){
			scalePoints[i][0] = (int)(points[i][0]*s[0]);
			scalePoints[i][1] = (int)(points[i][1]*s[1]);
		}
		return scalePoints;
	}


	/* passpaper 2016-2017 Q2 */

	public void translatePoint(int p[],int t[]){
		p[0]=p[0]+t[0];
		p[1]=p[1]+t[1];
	}

	public void translateLine(int p[][],int t[]){
		for(int i=0;i<p.length;i++){
			translatePoint(p[i],t);
		}
	}

	public void translateRectangle(int p[][],int t[]){
		for(int i=0;i<p.length;i++){
			translatePoint(p[i],t);
		}
	}

	public void reflectY(int p[][]){
		for(int i=0;i<p.length;i++){
			p[i][0]=p[i][0]*(-1)+2*centerX;
		}
	}

	public void reflectX(int p[][]){
		for(int i=0;i<p.length;i++){
			p[i][0]=p[i][1]*(-1)+2*centerY;
		}
	}
}

/*
<applet code="PassPapers.class" width="1000" height="1000"></applet>
*/