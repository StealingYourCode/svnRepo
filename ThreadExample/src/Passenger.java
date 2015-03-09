
public class Passenger {
	
	private int passengerNum;
	
	public void incrementPassengerNum(){
		passengerNum++;
	}
	
	public void arrival(){
		System.out.println("Passenger "+passengerNum+" is looking for a cab.");
	}

	public int getPassengerNum() {
		return passengerNum;
	}

	public void setPassengerNum(int passengerNum) {
		this.passengerNum = passengerNum;
	}

	

}
