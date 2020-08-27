package bankingApp;

import java.io.Serializable;

public class Application implements Serializable{ //extend Serializable to give Application serialization functionality
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	String U1; //Application class members
	String P1;
	String F1;
	String L1;
	int funds;
	
	public Application (String F1, String L1, String U1, //parameterized constructor 
			String P1, int funds) {
		this.F1 = F1;
		this.L1 = L1;
		this.U1 = U1;
		this.P1 = P1;
		this.funds = funds;
	}
	
	public String toString () { //restructure application
		return U1 + P1;
	}
	
	public String getU1() {
		return U1;
	}
	
	public String getP1() {
		return P1;
	}
	
}
