public class Customer {

	static int customerID = 2000000;
	int taxID;

	String name;
	String address;

	Boolean Person;
	
	public void Customer(String name, String address, int taxID){
		setName(name);
		setAddress(address);
		setTaxID(taxID);
		setCustomerID();
	}

	public static int getCustomerID() {
		return customerID;
	}

	public static void setCustomerID() {
		Customer.customerID = customerID + 7;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTaxID() {
		return taxID;
	}

	public void setTaxID(int taxID) {
		this.taxID = taxID;
	}

}
