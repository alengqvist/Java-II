package zoo_application;

import java.awt.image.BufferedImage;

/** 
 * This abstract class handles the creation of an animal.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 09:12, Januari 17, 2016.
 */
public abstract class Animal {

	// Member variables.
	private AnimalType type;		// Type of animal.
	private String name;			// Name of the animal.
	private int weight;				// Weight in kilos.
	private boolean isSleeping;		// If the animal is sleeping.
	private int x;					// The X-position in the zoo.
	private int y;					// The Y-position in the zoo.
	
	// Enumeration for which type of animal.
	public enum AnimalType { SHARK, TIGER, CAT };
	
	/**
	 * Constructor.
	 * 
	 * @param type
	 * @param name
	 * @param weight
	 */
	public Animal(AnimalType type, String name, int weight) {
		this.type = type;
		this.name = name;
		this.weight = weight;
	}
	
	/**
	 * Gets which type the animal is.
	 * 
	 * @return type
	 */
	public String getType() {
		return this.type.name();
	}
	
	/**
	 * Gets the name of the animal.
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the weight of the animal.
	 * 
	 * @return weight
	 */
	public int getWeight() {
		return this.weight;
	}
	
	/**
	 * Checks if the animal is asleep.
	 * 
	 * @return isSleeping
	 */
	public boolean isSleeping() {
		return this.isSleeping;
	}
	
	/**
	 * Gets animals X-position in the zoo.
	 * 
	 * @return x
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Gets animals Y-position in the zoo.
	 * 
	 * @return y
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Sets the name of the animal.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the weight of the animal.
	 * 
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	/**
	 * Sets the X-position of the position of the animal in the zoo.
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Sets the Y-position of the position of the animal in the zoo.
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Makes the animal fall asleep.
	 */
	public void sleep() {
		this.isSleeping = true;
	}
	
	/**
	 * Wakes the animal up from its sleep.
	 */
	public void wakeUp() {
		this.isSleeping = false;
	}
	
	/**
	 * Moves the animal to a new position in the zoo.
	 * 
	 * @param deltaX
	 * @param deltaY
	 * @return length
	 */
	public double move(int deltaX, int deltaY) {
		if (isSleeping) {
			wakeUp();
		}
		double length = Math.sqrt(Math.pow((this.x + deltaX) - this.x, 2) + Math.pow((this.y + deltaY) - this.y, 2));
		this.x += deltaX;
		this.y += deltaY;
		return length;
	}
	
	/**
	 * Abstract method which gets the image of the animal.
	 */
	public abstract BufferedImage getImage();
	
	/**
	 * Returns a string of the animal content (in this case the class name and the animals name).
	 * 
	 * @return content
	 */
	@Override
	public String toString() {
		return this.getClass().getName() + ", " + this.name;
	}
}