public class BankAccount {

	static int ID = 1000;

	double balance;
	double depositValue;
	double withdrawValue;
	
	Boolean Person;

	public void BankAccount(double bal) {
		createID();
		setBalance(bal);
	}
	
	public Boolean getPerson() {
		return Person;
	}

	public void setPerson(Boolean person) {
		Person = person;
	}

	public double getWithdrawValue() {
		return withdrawValue;
	}

	public void setWithdrawValue(double withdrawValue) {
		this.withdrawValue = withdrawValue;
	}

	

	public double getBalance() {
		return balance;
	}
	
	public int getID(){
		return ID;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void createID() {
		this.ID = getID() + 5;
	}

	public void deposit(int amount) {
		this.balance = getBalance() + amount;
		depositValue = amount;
	}

	public void withDraw(int amount) {
		setBalance(getBalance() - amount);
		withdrawValue = amount;
	}

	public void correction(int amount) {
		setBalance(amount);
	}

}
