package paint;

import java.awt.Point;

/** 
 * This interface tracks the mouse coordinates.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 15:45, November 13, 2015.
 */
public interface CoordinateListener {
	public void coordinateStatus(Point coordinates);
}
