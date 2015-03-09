
public class Main {

	public static void main(String[] args) {
		Passenger passenger = new Passenger();
		passenger.setPassengerNum(1);
		
		TaxiA a = new TaxiA(passenger);
		TaxiB b = new TaxiB(passenger);
		
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		
		t1.start();
		t2.start();
		
	}
	
}
