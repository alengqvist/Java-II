package paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/** 
 * This class handles the drawing of a free hand-object.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 15:45, November 13, 2015.
 */
public class DrawFree extends DrawObject {
	
	// Member variables.
	private List<Point> points;		// Stores all the lines which forms the Free hand-object.
	
	/**
	 * Constructor which creates a free hand-object.
	 * 
	 * @param start - Point
	 * @param end - Point
	 * @param selectedColor - Color
	 */
	public DrawFree(Point start, Point end, Color selectedColor) {
		super(start, end, selectedColor);
		points = new ArrayList<Point>();
	}
	
	/**
	 * Gets the list of points.
	 * 
	 * @returns points - ArrayList
	 */
	public List<Point> getPoints() {
		return points;
    }
   
	/**
	 * Sets a point.
	 * 
	 * @param point - Point
	 */
	public void setPoint(Point point) {
		points.add(point);
	}
	
	/**
	 * Draws the free hand-object.
	 * 
	 * @param g - Graphics
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(3));
		
	    for (int i = 1; i < points.size(); i++) {
	        Point p1 = getPoints().get(i - 1);
	        Point p2 = getPoints().get(i);
	        g.drawLine(p1.x, p1.y, p2.x, p2.y);
	    }				
	}
}