package bankingApp;

import java.io.Serializable;

public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	String uname;
	String pw;
	int funds;
	String fname;
	String lname;
	
	public Customer(String fname, String lname, String uname, 
						String pw, int funds) {
		//super();
		this.uname = uname;
		this.pw = pw;
		this.fname = fname;
		this.lname= lname;
		this.funds = funds;
		
	}
	
	public String toString() {
        return "Username: " + uname + " Password: " + pw + " First Name: " + 
        			fname + " Last Name: " + lname;
	
	}
	
	public String getUN() {
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