package bankingApp;

import java.io.Serializable;

public class Customer implements Serializable { //extend Serializable to give Application serialization functionality
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	String uname; //Customer class members
	String pw;
	int funds;
	String fname;
	String lname;
	
	public Customer(String fname, String lname, String uname,  //parameterized constructor for customer
						String pw, int funds) {
		//super();
		this.uname = uname; //use  this to prevent variable shadowing 
		this.pw = pw;
		this.fname = fname;
		this.lname= lname;
		this.funds = funds;
		
	}



	public void setFunds(int funds) {
		this.funds = funds; // set funds
	}


	public String toString() { // toString method overriden
        return "[USERNAME: " + uname +","+ " PASSWORD: " + pw  +","+ " FIRST NAME: " + 
        			fname +"," + " LAST NAME: " + lname +","+ " ACCOUNT BALANCES: " +"$"+ funds  
        			+ "]";
	
	}
	
	public String getUN() { //getters and setters
		return uname;
	}
	
	public String getPW() {
		return pw;
	}
	
	public String getFN() {
		return fname;
	}
	
	public String getLN() {
		return lname;
	}
	
	public int get$() {
		return funds;
		
	}
}