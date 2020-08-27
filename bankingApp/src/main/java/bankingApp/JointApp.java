package bankingApp;

import java.io.Serializable;

public class JointApp implements Serializable{ //extend Serializable to make give serialization fuctionality to object
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //used for serialization
	String U1; //instance members used for JointApp
	String P1;
	
	String U2;
	String P2;
	
	public JointApp(String U1, String P1, String U2, String P2) { // paramterized constructor
		this.U1 = U1; //use this to avoid variable overshadowing
		this.P1 = P1;
		this.U2 = U2;
		this.P2 = P2;
	}
	
	public String toString () { //override toString method to return string type of code
		return U1 + P1 + U2 + P2;
		
	}
	

	public String getU1() { //our getter methods
		return U1;
	}
	
	public String getP1() {
		return P1;
	}
	
	public String getU2() {
		return U2;
	}
	
	public String getP2() {
		return P2;
	}
}


