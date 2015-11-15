package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/** 
 * This class handles the drawing of a rectangle-object.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 15:45, November 13, 2015.
 */
public class DrawRect extends DrawObject {

	// Member variables.
	private int w;
	private int h;
	private int x;
	private int y;
	
	/**
	 * Constructor which creates a rectangle-object.
	 * 
	 * @param start - Point
	 * @param end - Point
	 * @param selectedColor - Color
	 */
	public DrawRect(Point start, Point end, Color selectedColor) {
		super(start, end, selectedColor);
	}
	
	/**
	 * Draws the rectangle-object.
	 * 
	 * @param g - Graphics
	 */
	@Override
	public void draw(Graphics g) {
		
		g.setColor(color);
		
		int width = start.x - end.x;
    	int height = start.y - end.y;

    	this.w = Math.abs(width);
    	this.h = Math.abs(height);
    	this.x = width < 0 ? start.x : end.x;
    	this.y = height < 0 ? start.y : end.y;
		
		g.drawRect(this.x, this.y, this.w, this.h);
	}
}