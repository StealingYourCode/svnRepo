
public class TaxiB implements Runnable{

	Passenger passenger; 
	
	TaxiB(Passenger passenger){
		this.passenger= passenger;

	}
	@Override
	public void run() {
		race();
	}
	
	public void race(){
		synchronized(passenger){
			
			for(int i=0;i<5;i++){
				passenger.arrival();
				System.out.println("TaxiB spotted passenger "+ passenger.getPassengerNum());
				System.out.println("TaxiB is picking up passenger "+passenger.getPassengerNum());
				
				passenger.incrementPassengerNum();
				passenger.notify();
				try{
					passenger.wait();
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println();
//				passenger.incrementPassengerNum();
//				passenger.notify();

			}
		}
	}

}
