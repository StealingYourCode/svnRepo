public class BankAccount {

	static int ID = 1000;

	double balance;
	double depositValue;
	double withdrawValue;
	
	Type type;
	
	public void BankAccount(double bal) {
		createID();
		setBalance(bal);
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type=type;
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
	
	public enum Type{
		PERSON, COMPANY;
	}
	
	

}
