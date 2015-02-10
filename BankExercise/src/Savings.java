
public class Savings extends BankAccount {
	
	double interestRate=0;

	public void savings(int balance, int interestRate, Boolean type){//TODO: use enums
		setInterestRate(interestRate);
		setBalance(balance);
		createID();
		setPerson(type);
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void withDraw(int amount){
		if(amount>getBalance())
			System.out.println("You do not have enough funds");
		else
			setBalance(getBalance() - amount);

	}
	
	public void reset(){
		if(getPerson()==true){
			setBalance(0);
			System.out.println("Your account has been reset");
		}
		else
			System.out.println("Only a Human can do that.");
			
	}
	
	
	
	
}
