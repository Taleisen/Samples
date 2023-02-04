/*
 * Curtis Lynn
 */
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Fractals extends Canvas {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Pyramid Scheme");
		frame.setSize(700, 700);// set frame size to 700 x 700
		Fractals sc = new Fractals();
		frame.add(sc);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g) 
	{
		DrawPyramid(0, 0, this.getWidth(), g);
	}
	
	public void DrawPyramid(int x, int y, int size, Graphics g) //build large triangle
	{
		int points = 3;
		g.setColor(Color.cyan);
		int[] xPoints, yPoints;
		xPoints = new int[] {x, (x + size)/2, x + size};//far left, middle, far right
		yPoints = new int[] {y + size, y, y + size};//bottom, top, bottom
		g.fillPolygon(xPoints, yPoints, points);//builds triangle with points in bottom left, top center, bottom right
		MiniPyramids(x, y, size, g);//begin creating inverted pyramids
	}
	
	public void MiniPyramids(int x, int y, int size, Graphics g) //recursively build smaller triangles
	{
		int sub = size / 4, points = 3;
		g.setColor(Color.black);//change color to black for good contrast with green
		int[] xPoints, yPoints;
		xPoints = new int[] {x + sub, x + (2 * sub), x + (3 * sub)};// 1/4 across, 1/2 across, 3/4 across
		yPoints = new int[] {y + (sub * 2), y + size, y + (sub * 2)};// 1/2 down, bottom, 1/2 down
		g.fillPolygon(xPoints, yPoints, points);// creates inverted triangle
		if(2 * sub >= 4) //larger than 4 pixels for triangle
		{
			MiniPyramids(x + sub, y, sub * 2, g);//top
			MiniPyramids(x, y + (sub * 2), sub * 2, g);//left
			MiniPyramids(x + (sub * 2), y + (sub * 2), sub * 2, g);//right
		}
	}
}
