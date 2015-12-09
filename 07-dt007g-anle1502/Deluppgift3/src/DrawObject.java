

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/** 
 * This class is the base class of all drawing objects.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 15:45, November 13, 2015.
 */
public abstract class DrawObject {
	
	// Member variables.
	protected Point start;
	protected Point end;
	protected Color color;
	
	/**
	 * Constructor which creates a drawing object.
	 * 
	 * @param start - Point
	 * @param end - Point
	 * @param selectedColor - Color
	 */
	public DrawObject(Point start, Point end, Color color) {
		this.start = start;
		this.end = end;
		this.color = color;
	}
	
	/**
	 * Gets the starting point of the drawing objected.
	 * 
	 * @returns start - Point
	 */
	public Point getStart() {
		return start;
	}

	/**
	 * Abstract method which draws the object.
	 * 
	 * @param g - Graphics
	 */
	public abstract void draw(Graphics g);
}
