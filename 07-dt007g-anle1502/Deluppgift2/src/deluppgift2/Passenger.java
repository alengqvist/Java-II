package deluppgift2;

/** 
 * This class simulates a passenger.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 15:25, September 16, 2015.
 */
public class Passenger extends Person {

	// Member variables.
	private double weight;

	/** 
	 * Constructor which initialize the passenger.
	 */
	public Passenger(String name, double weight) {
		super(name);
		this.weight = weight;
	}
	
	/** 
	 * Sets the weight.
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/** 
	 * Gets the weight.
	 */
	public double getWeight() {
		return this.weight;
	}
}