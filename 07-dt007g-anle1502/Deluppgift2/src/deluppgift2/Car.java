package deluppgift2;

import java.util.ArrayList;
import java.util.List;


/** 
 * This class simulates a car.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 15:25, September 16, 2015.
 */
public class Car {
	
	// Member variables.
	private static final int MAX_PASSENGERS = 5;
	private double maxPassengersWeight = 400.0;
	private double passengersWeight;
	private double milage;
	private Engine engine;
	private List<Passenger> passengers;
	private boolean carRunning;
	
	/** 
	 * 1th constructor which initialize the car.
	 * 
	 * @param milage - double
	 */
	public Car(double milage) {
		this.milage = milage;
		this.passengers = new ArrayList<Passenger>();
		this.carRunning = false;
		engine = new Engine();
	}
	
	/** 
	 * 2nd constructor which initialize the car with a different max weight.
	 * 
	 * @param milage - double
	 * @param maxWeight - double
	 */
	public Car(double milage, double maxWeight) {
		this.milage = milage;
		this.maxPassengersWeight = maxWeight;
		this.passengers = new ArrayList<Passenger>();
		this.carRunning = false;
		engine = new Engine();
	}
	
	/** 
	 * Gets the milage.
	 * 
	 * @returns this.milage - double
	 */
	public double getMilage() {
		return this.milage;
	}
	
	/** 
	 * Gets the max passengers weight.
	 * 
	 * @returns this.maxPassengersWeight - double
	 */
	public double getMaxPassengersWeight() {
		return this.maxPassengersWeight;
	}
	
	/** 
	 * Gets the passengers weight.
	 * 
	 * @return this.passengerWeight - double
	 */
	public double getPassengersWeight() {
		return this.passengersWeight;
	}
	
	/** 
	 * Adds a passenger to the car.
	 * 
	 * @param person - Passenger
	 */
	public void addPassenger(Passenger person) {
		if ((person.getWeight() + passengersWeight) <= maxPassengersWeight && passengers.size() < MAX_PASSENGERS) {
			this.passengers.add(person);
			passengersWeight += person.getWeight();
			System.out.println(person.getName() + " sŠtter sig i bilen. Han vŠger " + person.getWeight() + " kg.");
		} else {
			System.out.println("Bilen Šr full! SŒ " + person.getName() + " fick tyvŠrr inte plats i bilen.");
		}
	}
	
	/** 
	 * Starts the car.
	 */
	public void startCar() {
		if (engine.isEngineRunning()) {
			System.out.println("...bilen Šr redan igŒng!");
		} else {
			engine.startEgine();
			System.out.println("...bilen startar...");
			
			if (engine.isEngineRunning()) {
				carRunning = true;
				System.out.println("...bilen Šr nu igŒng.");
			}
		}
	}
	
	/** 
	 * Stops the car.
	 */
	public void stopCar() {
		if (!engine.isEngineRunning()) {
			System.out.println("...bilen Šr inte igŒng!");
		} else {
			engine.stopEgine();
			System.out.println("...bilen stŠngs av...");
			
			if (!engine.isEngineRunning()) {
				carRunning = false;
				System.out.println("...bilen Šr nu inte lŠngre igŒng.");
			}
		}
	}
	
	/** 
	 * Drives the car.
	 * 
	 * @return carRunning - boolean
	 */
	public boolean drive(double distance) {
		if (carRunning) {
			this.milage += distance;
			System.out.println("..." + distance + " kilometer...");
			return true;
		}
		return false;
	}
}