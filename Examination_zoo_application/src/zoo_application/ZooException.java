package zoo_application;

/** 
 * This exception just sets a error message to be displayed for the user in the zoo.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 10:12, Januari 17, 2016.
 */
public class ZooException extends Exception {

	private static final long serialVersionUID = 1L;

	public ZooException(String message) {
        super(message);
    }
}