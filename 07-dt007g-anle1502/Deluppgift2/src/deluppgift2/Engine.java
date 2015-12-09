package deluppgift2;


/** 
 * This class simulates a engine.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 15:25, September 16, 2015.
 */
public class Engine {
	
	// Member variable.
	private boolean engineRunning;
	
	/** 
	 * Constructor which initialize the engine.
	 */
	public Engine() {
		engineRunning = false;
	}
	
	/** 
	 * Starts the engine.
	 */
	public void startEgine() {
		engineRunning = true;
	}
	
	/** 
	 * Stops the engine.
	 */
	public void stopEgine() {
		engineRunning = false;
	}
	
	/** 
	 * Checks if the engine is running.
	 * 
	 * @param isEngineRunning - boolean
	 */
	public boolean isEngineRunning() {
		return engineRunning;
	}
}