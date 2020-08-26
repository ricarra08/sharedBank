package bankingApp;

import java.io.Serializable;

public class JointApp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String U1;
	String P1;
	
	String U2;
	String P2;
	
	public JointApp(String U1, String P1, String U2, String P2) {
		this.U1 = U1;
		this.P1 = P1;
		this.U2 = U2;
		this.P2 = P2;
	}
	
	public String toString () {
		return U1 + P1 + U2 + P2;
		
	}
	

	public String getU1() {
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


