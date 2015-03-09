
public class TaxiA implements Runnable{

	Passenger passenger;
	
	public TaxiA(Passenger passenger){
		this.passenger= passenger;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		race();
		
	}
	
	public void race(){
		synchronized(passenger){
			
			for(int i=0;i<5;i++){
				passenger.arrival();
				System.out.println("TaxiA spotted passenger "+ passenger.getPassengerNum());
				
				System.out.println("TaxiA is picking up passenger "+passenger.getPassengerNum());
				
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
