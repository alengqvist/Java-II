package deluppgift2;

public class TestCar {

	public static void main(String[] args) {
		
		
		System.out.println("En bil inväntar sina passagerare...");
		Car car = new Car(10.0, 400.0);
		
		System.out.println("...den här bilen har totalt gått " + car.getMilage() + " kilometer.");

		car.addPassenger(new Passenger("Sven", 80.0));
		car.addPassenger(new Passenger("Sverker", 70.0));
		car.addPassenger(new Passenger("Sverker", 100.0));
		car.addPassenger(new Passenger("Sverker", 100.0));
		car.addPassenger(new Passenger("Steve", 50.0));
		
		
		System.out.println("Passagerarnas totala vikt är nu " + car.getPassengersWeight() + " kg "
				 + "och bilens maxvikt är " + car.getMaxPassengersWeight() + " kg.");
				
		System.out.println("Startar bilen...");
		car.startCar();
		
		
		System.out.println("Kör bilen...");
		if (car.drive(15)) {
			System.out.println("...bilen har nu totalt gått " + car.getMilage() + " kilometer.");
		} else {
			System.out.println("... men det gick inte! Bilen måste ju startas innan man kan köra den!");
		}
		
		System.out.println("Stoppar bilen...");
		car.stopCar();
	}
}
