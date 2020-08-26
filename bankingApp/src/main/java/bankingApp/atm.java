package bankingApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class atm {
	
	Scanner s = new Scanner(System.in);
	
	ArrayList<Customer> custys = new ArrayList<Customer>();
	ArrayList<Application> apply = new ArrayList<Application>();
	ArrayList<JointApp> Japps = new ArrayList<JointApp>();
	String uname;
	String pw;
	String U2;
	String P2;
	String lname;
	String fname;
	int funds;
	
	
	String BAun = "Big Daddy";
	String BApw = "BigPapa";
	
	String Eu = "Big Mama";
	String Ep = "BigMa";
	
	ArrayList<Customer> custList; 
	ArrayList<Application> appList;
	ArrayList<JointApp> JappList;
	
	public void battery() {
		sys();
	}
	
	public void sys() {
		readfile();
		readApps();
		  readJA();
		  
		  
		  
		System.out.println("Login as:" + "\n" + "a) Customer" + "\n"
					+ "b) Employee"+"\n" + "c) Bank Admin" + "\n" 
					);//seed												
		String p = s.nextLine(); //stems out

		
		
		if (p.equals("a"))  {//branch 1
			//Customer a = new Customer();
			System.out.println("What would you like to do?"+"\n"
					+"a)Register"+ "\n"
					+ "b)Login to account" );
			String c1 = s.nextLine();
			
			if( c1.equals("a")) {//branch 1a
				System.out.println("Would you like to apply for an : " + "\n" + " a) Account" 
									+"\n" + " b) Joint Account");
				String o1 = s.nextLine();
				if (o1.equals("a")) {
					System.out.println("What is your first name?");
					String fname = s.nextLine();
					System.out.println("What is your last name?");
					String lname = s.nextLine();
					System.out.println("Create New Username:");
					String uname = s.nextLine();
					System.out.println("Create Password:");
					funds = 10;
					String pw = s.nextLine();
					apply.add(new Application (fname,lname,uname,pw,funds)); 
					writeApps(apply);
					System.out.println("Your Account Application has been submitted!");
					sys();
				} else if (o1.equals("b")) { 
					System.out.println("Create First Username:"); // figure out how to accept application
					String uname = s.nextLine();
					System.out.println("Create Password for First User:");
					String pw = s.nextLine();
					System.out.println("Create Second Username:");
					String U2 = s.nextLine();
					System.out.println("Create Password for Second User:");
					String P2 = s.nextLine();
					Japps.add(new JointApp (uname,pw, U2, P2)); 
					writeJA(Japps);
					System.out.println("Your Joint Account Application has been submitted!");
					sys();
				}
			} else if(c1.equals("b")) {//branch 1b
				System.out.println("Input Username: ");
				String checkUname = s.nextLine();
				System.out.println("Input Password: ");
				String checkPwd = s.nextLine();
				for (int i = 0 ; i < custList.size(); i++) {
					if (custList.get(i).getUN().equals(checkUname) && custList.get(i).getPW().equals(checkPwd)) {
						//Customer $4T = custList.get(i);
						//int x = indexOf((custList.get(i));
					 System.out.println("Would you like to:" + "\n" + "a) Withdraw" + "\n" + "b) Deposit" 
											+"\n"+ "c) Transfer");
							String c2b = s.nextLine(); 
							if (c2b.contentEquals("a")) {
								int $ = custList.get(i).get$(); //change funds to double
								System.out.println("How much would you like to withdraw?"); 
								int less$ = Integer.parseInt(s.nextLine()); 
								int newF = $ - less$;
								custList.get(i).setFunds(newF);
								System.out.println("Remaining Balance"+custList.get(i).get$());
								
							} else if (c2b.equals("b")) {
								//call deposit method
							} else if (c2b.equals("c")){
								//call transfer method
							} sys();
						}
					 else {
						System.out.println("You're a thief!!" + "\n" );
						sys();
					}
				}
			}
		}
		
// Employee branch 2		
		
		else if(p.equals("b")) {
	 		System.out.println("Login in to Employee Account" + "\n" + "What is your Username?");
	 		String eu = s.nextLine();
	 		System.out.println("What is your Password?");
	 		String ep = s.nextLine(); 
	 		
	 		if (eu.equals(Eu) && ep.equals(Ep)) {
	 			System.out.println("Would you like to:" +"\n"+ "a) View Customer Information " + "\n"
									+ "b) Approve or deny customer appliactions");
	 			String e1 = s.nextLine();
	 			if(e1.equals("a")) {
	 					for (int i=0; i< custList.size(); i++){
	 						System.out.println(custList.get(i) + "\n");
	 					} sys();
	 				
	 		   }else if(e1.equals("b")) {
	 				System.out.println("Would you like to:"+ "\n" + "a) Approve Account" + "\n" +
	 						"b) Deny Accounts");
	 				String d2b = s.nextLine();
	 				if (d2b.equals("a")) {
	 					//call approve account
	 					System.out.println("Account approve!");
	 				} else if(d2b.equals("b")){
	 					//call deny method
	 					System.out.println("Account denied!");
	 				} sys();
	 			}
	 			
	 			
	 		}else {
	 			System.out.println("You are not Big Mama!!!");
	 			sys();
	 		}
		}
		
 // Bank Admin branch 3	
		
		
		
		else if(p.equals("c")) {
			System.out.println("Login in to account" + "\n" + "What is your Username?");
			String bu = s.nextLine();
			System.out.println("What is your Password?");
			String bp = s.nextLine(); 
			
			if (bu.equals(BAun) && bp.equals(BApw)) {
			
				System.out.println("a) View Accounts" + "\n" + "b) Edits Accounts" + "\n");
				String d1 = s.nextLine();
				if(d1.equals("a")) {
					//call method made for bank admin
				} else if(d1.contentEquals("b")){
					System.out.println("Would you like to:"+ "\n" + "a) Approve/Deny Accounts" + "\n" +
									"b) Transaction" + "\n" +"c) Delete Accounts"	);
					String d2 = s.nextLine();
					if(d2.equals("a")) {
						System.out.println("Would you like to:"+ "\n" + "a) Approve Account" + "\n" +
							"b) Deny Accounts");
						String d2a = s.nextLine();
						if (d2a.equals("a")) {
							//call approve account
							System.out.println("Account approve!");
						} else if(d2a.equals("b")){
							System.out.println("Account denied!");
						}
					} else if (d2.equals("b")) {
						System.out.println("Would you like to:" + "\n" + "a) Withdraw" + "\n" + "b) Deposit" 
								+"\n"+ "c) Transfer");
						String d3a = s.nextLine(); 
						if(d3a.contentEquals("a")) {
							//call withdraw method
						} else if (d3a.equals("b")) {
							//call deposit method
						} else if (d3a.equals("c")){
							//call transfer method
						}
					} else if (d2.equals("c")) {
						System.out.println("What account would you like to delete?");
						String d3b = s.nextLine(); 
						System.out.println("Account has been canceled");
					}
				}	
			} else {
				System.out.println("You are not Big Daddy!");
			}
		}
		s.close();
		
	}

	
	Customer findCusty(String checkPwd) {
		for(Customer customer : custList) {
			if (customer.getPW().equals(checkPwd)){
				return customer;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
//Serialization Methods	
	
	public void writefile(ArrayList<Customer> custys) {
		try {
        	FileOutputStream fos = new FileOutputStream("CustomerData.txt");
        	ObjectOutputStream oos = new ObjectOutputStream(fos);
        	oos.writeObject(custys);
        	System.out.println();
        	oos.close();
        	fos.close();
    	} 
    	catch (IOException ioe) {
        	ioe.printStackTrace();
    	}
	}
	
	public void writeApps(ArrayList<Application> apply) {
		try {
	    	FileOutputStream fos = new FileOutputStream("Applications.txt");
	    	ObjectOutputStream oos = new ObjectOutputStream(fos);
	    	oos.writeObject(apply);
	    	System.out.println();
	    	oos.close();
	    	fos.close();
		} 
		catch (IOException ioe) {
	    	ioe.printStackTrace();
		}
	}
	
	public void writeJA(ArrayList<JointApp> Japps) {
		try {
			FileOutputStream fos = new FileOutputStream("Joint.txt");
	    	ObjectOutputStream oos = new ObjectOutputStream(fos);
	    	oos.writeObject(Japps);
	    	System.out.println();
	    	oos.close();
	    	fos.close();
		} 
		catch (IOException ioe) {
	    	ioe.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void readfile() {
		try {	
			ArrayList<Customer> deSerializedCustys;
			FileInputStream fis = new FileInputStream(new File ("CustomerData.txt"));
			ObjectInputStream ois = new ObjectInputStream(fis);
        	deSerializedCustys = ((ArrayList<Customer>)ois.readObject());
			custList = deSerializedCustys;
			ois.close();
			fis.close();
    	} 
    	catch (IOException ioe) {
        	ioe.printStackTrace();
        	//return;
    	} 
		catch(ClassNotFoundException c) {
        	System.out.println("Class not found");
        	c.printStackTrace();
        	//return;
    	}
	}
	
	@SuppressWarnings("unchecked")
	public void readApps() {
		try {	
			ArrayList<Application> deSerializedApps;
			FileInputStream fis = new FileInputStream(new File ("Applications.txt"));
			ObjectInputStream ois = new ObjectInputStream(fis);
        	deSerializedApps = ((ArrayList<Application>)ois.readObject());
			appList = deSerializedApps;
			ois.close();
			fis.close();
    	} 
    	catch (IOException ioe) {
        	ioe.printStackTrace();
        	//return;
    	} 
		catch(ClassNotFoundException c) {
        	System.out.println("Class not found");
        	c.printStackTrace();
        	//return;
    	}
	}
		
	@SuppressWarnings("unchecked")
	public void readJA() {
		try {	
			ArrayList<JointApp> deSerializedJA;
			FileInputStream fis = new FileInputStream(new File ("Joint.txt"));
			ObjectInputStream ois = new ObjectInputStream(fis);
	        deSerializedJA = ((ArrayList<JointApp>)ois.readObject());
			JappList = deSerializedJA;
			ois.close();
			fis.close();
	    } 
	    catch (IOException ioe) {
	        ioe.printStackTrace();
	        	//return;
	    } 
		catch(ClassNotFoundException c) {
	        	System.out.println("Class not found");
	        	c.printStackTrace();
	        	//return;
	    }
	}
}