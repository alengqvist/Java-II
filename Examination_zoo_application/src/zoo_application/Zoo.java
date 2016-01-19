package zoo_application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** 
 * This class handles the creation and management of a Zoo.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 09:35, Januari 17, 2016.
 */
public class Zoo {

	// Member variables.
	private String name;					// Name of the zoo.
	private int maxAnimals;					// Maximum number of animals in the zoo.
 	private List<Animal> animals;			// List of animals in the zoo.
	
	/**
	 * Constructor.
	 * 
	 * @param name
	 * @param maxAnimals
	 */
	public Zoo(String name, int maxAnimals) {
		this.name = name;
		this.maxAnimals = maxAnimals;
		this.animals = new ArrayList<Animal>();
	}
	
	/**
	 * Gets the name of the zoo.
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the maximum number of animals in the zoo.
	 * 
	 * @return maxAnimals
	 */
	public int getmaxAnimals() {
		return this.maxAnimals;
	}
	
	/**
	 * Gets all animals in the zoo.
	 * 
	 * @return animals
	 */
	public List<Animal> getAnimals() {
		return this.animals;
	}
	
	/**
	 * Sets the name of the zoo.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the maximum number of animals in the zoo.
	 * 
	 * @param maxAnimals
	 */
	public void setMaxAnimals(int maxAnimals) {
		this.maxAnimals = maxAnimals;
	}
	
	/**
	 * Adds an animal to the zoo.
	 * 
	 * @param animal
	 */
	public void addAnimal(Animal animal) throws ZooException {
		if (animals.size() >= maxAnimals) {
			throw new ZooException("Taket för antal djur i ditt zoo är uppnått.");
		} else {
			animals.add(animal);
		}
	}
	
	/**
	 * Removes an animal in the zoo based on its object.
	 * 
	 * @param animal
	 * @return wasRemoved
	 */
	public boolean removeAnimal(Animal animal) {
		return animals.remove(animal);
	}
	
	/**
	 * Removes an animal in the zoo based on its index.
	 * 
	 * @param animal
	 * @return wasRemoved
	 */
	public boolean removeAnimal(int index) {
		int size = animals.size();
		animals.remove(index);
		if (animals.size() == size - 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Clears and removes all the animals in the zoo.
	 */
	public void clearZoo() {
		animals.clear();
	}
	
	/**
	 * Exercised all the animals in the zoo.
	 * 
	 * @return totalLength
	 */
	public double exerciseAllAnimals() {
		
	    Random rand = new Random();
	    double totalLength = 0.0;
	    
		for (Animal animal : animals) {
		    int randomX = rand.nextInt((3 - (-3)) + 1) + (-3);
		    int randomY = rand.nextInt((3 - (-3)) + 1) + (-3);
			totalLength = animal.move(randomX, randomY);
		}
		return round(totalLength, 2);
	}
	
	/**
	 * Rounds a double to only two decimals.
	 * 
	 * @param value
	 * @param places
	 * @return formatted double
	 */
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	/**
	 * Returns a string of the zoo content (in this case just the number of animals).
	 * 
	 * @return content
	 */
	@Override
	public String toString() {
		return Integer.toString(animals.size());
	}
}