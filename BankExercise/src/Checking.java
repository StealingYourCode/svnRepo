public class Checking extends BankAccount {
	
	int checkNum;
	public void checking(int balance){
		setBalance(balance);
		createID();
		checkNum=1;
	}

	public void withDraw(int amount) {
		if (amount > getBalance()) {
			System.out.println("You have overdrawn");
			setBalance(getBalance() - amount);
		}
	}
}
