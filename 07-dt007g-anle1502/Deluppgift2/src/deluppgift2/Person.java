package deluppgift2;

/** 
 * This class simulates a person.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 15:25, September 16, 2015.
 */
public class Person {
	
	// Member variables.
	protected String name;
	
	/** 
	 * Constructor which initialize the person.
	 */
	public Person(String name) {
		this.name = name;
	}
	
	/** 
	 * Sets the name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** 
	 * Gets the name.
	 */
	public String getName() {
		return this.name;
	}
}