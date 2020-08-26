package bankingApp;

import java.io.Serializable;

public class Application implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String U1;
	String P1;
	
	public Application (String U1, String P1) {
		this.U1 = U1;
		this.P1 = P1;
	}
	
	public String toString () {
		return U1 + P1;
	}
	
	public String getU1() {
		return U1;
	}
	
	public String getP1() {
		return P1;
	}
	
}
