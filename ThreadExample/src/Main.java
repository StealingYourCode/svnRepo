
public class Main {

	public static void main(String[] args) {
		Passenger passenger = new Passenger();
		passenger.setPassengerNum(1);
		
		TaxiA a = new TaxiA(passenger);
		TaxiB b = new TaxiB(passenger);
//		TaxiC c = new TaxiC(passenger);
		
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
//		Thread t3 = new Thread(c);
		
		t1.start();
		t2.start();
//		t3.start();
		
	}
	
}
