

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Stack;
import javax.swing.event.MouseInputAdapter;

/** 
 * This class handles the paint area in which the objects are painted.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 15:45, November 13, 2015.
 */
public class PaintArea extends javax.swing.JPanel {

	private static final long serialVersionUID = -4958389609575638156L;
	private static final int DRAW_RECT = 1;
	
	// Member variables.
	private CoordinateListener coordinateObserver;
	private Stack<DrawObject> drawings = null;
	private DrawObject currentDrawing;
	private Color selectedColor;
	private int drawingType;
	
	/**
	 * Constructor which creates a Paint Area.
	 */
	public PaintArea() {
		setBackground(Color.WHITE);
		DrawListener listener = new DrawListener();
		addMouseMotionListener(listener);
		addMouseListener(listener);
		drawings = new Stack<DrawObject>();
	}
	
	/**
	 * Sets which type of object to draw.
	 * 
	 * @param drawingType - int
	 */
	public void setDrawingType(int drawingType) {
		this.drawingType = drawingType;
	}
	
	/**
	 * Sets which color to draw with.
	 * 
	 * @param color - Color
	 */
	public void setColor(Color color) {
		selectedColor = color;
	}
	
	/**
	 * Paints the component.
	 * 
	 * @param g - Graphics
	 */
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	
    	for (DrawObject drawing : drawings) {
    		System.out.println(drawing);
    		drawing.draw(g);
    	}
    	
    	g.setColor(selectedColor);

    	if (currentDrawing == null) {
    		return;
    	}
    	currentDrawing.draw(g);
    }
    
	/**
	 * Resets the Paint Area.
	 */
    public void reset() {
    	drawings.clear();
    	repaint();
    }
    
	/**
	 * Steps back one drawn object.
	 */
    public void undo() {
    	if (!drawings.isEmpty()) {
	    	drawings.pop();
	    	repaint();
    	}
    }
    
	/**
	 * Class which listens on different mouse operations.
	 */
    private class DrawListener extends MouseInputAdapter {
    	
		@Override
    	public void mousePressed(MouseEvent e) {
    		if (drawingType == DRAW_RECT) {
				currentDrawing = new DrawRect(e.getPoint(), e.getPoint(), selectedColor);
    		} else {
				currentDrawing = new DrawFree(e.getPoint(), e.getPoint(), selectedColor);
    		}	    		
    	}

    	@Override
    	public void mouseReleased(MouseEvent e) {
    		if (drawingType == DRAW_RECT) {
	    		drawings.push(new DrawRect(currentDrawing.getStart(), e.getPoint(), selectedColor));
	    		currentDrawing = null;
    		} else {
	    		drawings.push(currentDrawing);
	    		currentDrawing = null;
    		}
    	}
    	
    	@Override
    	public void mouseDragged(MouseEvent e) {
    		coordinateObserver.coordinateStatus(e.getPoint());
    		if (drawingType == DRAW_RECT) {
	    		currentDrawing = new DrawRect(currentDrawing.getStart(), e.getPoint(), selectedColor);
	    		repaint();
    		} else {
	            ((DrawFree) currentDrawing).setPoint(e.getPoint());
	    		repaint();
	    	}
    	}
    	
    	@Override
    	public void mouseMoved(MouseEvent e) {
    		coordinateObserver.coordinateStatus(e.getPoint());
    	}
    }
    
	/**
	 * Observer which keeps track of the mouse coordinates.
	 * 
	 * @param observer - CoordinateListener
	 */
    public void addListener(CoordinateListener observer) {
        coordinateObserver = observer;
    }
}