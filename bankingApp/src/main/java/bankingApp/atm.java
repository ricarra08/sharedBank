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
	
	Scanner s = new Scanner(System.in); //scanner class instatiated 
	
 	ArrayList<Customer> custys = new ArrayList<Customer>();		//ArrayLists used for object
	ArrayList<Application> apply = new ArrayList<Application>();
	ArrayList<JointApp> Japps = new ArrayList<JointApp>();
	String uname;
	String pw;
	String U2;
	String P2;
	String lname;
	String fname;
	int funds;
	
	
	String BAun = "Big Daddy";	//hardcode BankAdmin Username
	String BApw = "BigPapa"; //hardcode BankAdmin password
	
	String Eu = "Big Mama"; //hardcode Employee Username
	String Ep = "BigMa"; //hardcode Employee password
	
	ArrayList<Customer> custList; //ArrayList used to deserialize data to and then iterate over
	ArrayList<Application> appList;
	ArrayList<JointApp> JappList;
	
	public void battery() { //method used to run our Bank Interface
		sys();
	}
	
	public void sys() { // The heart of our project is built using this if-else if-else branch
		readfile();	//deserialize the CustomerData
		readApps(); //deserialize the application 
		  readJA();//deserialize the joint app
		  
		  
		  
		System.out.println("Login as:" + "\n" + "a) Customer" + "\n"
					+ "b) Employee"+"\n" + "c) Bank Admin" + "\n" 
					);//Our "Seed" that begins our decision tree												
		String p = s.nextLine(); // input users decision into string variable and then use conditionals to branch out to either 3 Users

		
		
		if (p.equals("a"))  {//branch 1 Customer
			System.out.println("What would you like to do?"+"\n" //Apply for an account or Login if account has been approved
					+"a)Register"+ "\n"
					+ "b)Login to account" );
			String c1 = s.nextLine(); //reads user input
			
			if( c1.equals("a")) {//branch 1a
				System.out.println("Would you like to apply for an : " + "\n" + " a) Account"  //asks useer for what type of account they would like
									+"\n" + " b) Joint Account");
				String o1 = s.nextLine(); 
				if (o1.equals("a")) {
					System.out.println("What is your first name?"); //asks for first name, last name, username, and password info
					String fname = s.nextLine();
					System.out.println("What is your last name?");
					String lname = s.nextLine();
					System.out.println("Create New Username:");
					String uname = s.nextLine();
					System.out.println("Create Password:");
					funds = 10;										//funds is set automatically to $10 because our policy does not allow broke ppl to apply
					String pw = s.nextLine();
					apply.add(new Application (fname,lname,uname,pw,funds)); //create new appliction object and then add to apply list
					writeApps(apply); //saves application to appplication.txt file
					System.out.println("Your Account Application has been submitted!"); //Let the user know their application is waiting for approval
					sys(); //recall the system
				} else if (o1.equals("b")) { 
					System.out.println("Create First Username:"); // asks for Joint Account user info
					String uname = s.nextLine(); 
					System.out.println("Create Password for First User:");
					String pw = s.nextLine();
					System.out.println("Create Second Username:");
					String U2 = s.nextLine();
					System.out.println("Create Password for Second User:");
					String P2 = s.nextLine();
					Japps.add(new JointApp (uname,pw, U2, P2)); //instantiates new JointApp Object and adds to japps
					writeJA(Japps);
					System.out.println("Your Joint Account Application has been submitted!");
					sys();
				}
			} else if(c1.equals("b")) {//Customer branch 1b
				System.out.println("Input Username: "); 
				String checkUname = s.nextLine(); //stores username to string variable
				System.out.println("Input Password: ");
				String checkPwd = s.nextLine(); //Stores password to string variable
				for (int i = 0 ; i < custList.size(); i++) { //iterate over customer arraylist to check if username and password are correct
					if (custList.get(i).getUN().equals(checkUname) && custList.get(i).getPW().equals(checkPwd)) { //if true then transactions branch is open
						
					 System.out.println("Would you like to:" + "\n" + "a) Withdraw" + "\n" + "b) Deposit" //decide transaction
											+"\n"+ "c) Transfer");
							String c2b = s.nextLine(); 
							if (c2b.contentEquals("a")) { //Withdraw branch
								int $ = custList.get(i).get$(); 
								System.out.println("How much would you like to withdraw?"); 
								int less$ = Integer.parseInt(s.nextLine()); //
								if (less$ >= $ ) { //ensures no overdrafts
									int newF = $ - less$;
									custList.get(i).setFunds(newF); //replaces old funds with new funds
									System.out.println("Remaining Balance: $"+custList.get(i).get$()); //Show remaining balance
									writefile(custList); //saves new data to customerlist
								}else {System.out.println("You can't cheat money!"); //let them know they can't do overdrafts
									sys();
								}
								
							} else if (c2b.equals("b")) {//Depoist
								int $ = custList.get(i).get$(); 
								System.out.println("How much would you like to Deposit?"); 
								int plus$ = Integer.parseInt(s.nextLine()); 
								int newF = $ + plus$;
								custList.get(i).setFunds(newF);
								System.out.println("New Balance: $"+custList.get(i).get$());
								writefile(custList);
								
								
							} else if (c2b.equals("c")){ //take in account info that you will be transfering info too 
								System.out.println("Enter Account Username that you will be transferring money to: ");
								String h = s.nextLine();
								System.out.println("Enter Account Password that you will be transferring money to: ");
								String h1 = s.nextLine();
									for (int t = 0; t < custList.size(); t++ ) { //iterate over custlist
										if ((custList.get(t).getUN().equals(h) && custList.get(t).getPW().equals(h1)) && t!=i) { //create conditional that will verify account 
																																//and ensure account is not the same
											
											System.out.println("Transfer has begun\n" + "How much money would you like to Transfer?"); //transfering arithmetic
											int m$ = Integer.parseInt(s.nextLine());
											if(m$ <= custList.get(t).get$() ) {
												int newF = custList.get(i).get$() - m$;
												custList.get(i).setFunds(newF);
												int nf = custList.get(t).get$() + m$;
												custList.get(t).setFunds(nf);
												System.out.println("New Balance for 1st Account: $"+custList.get(i).get$() + "\n"
															+	"New Balance for 2nd Account: $"+custList.get(t).get$());
											} else {
												System.out.println("You're not slick!!!"); //Let them know they can't mess around
												sys();
											}
											
										}
									}writefile(custList); //save fil
																	
								
								
							} sys();
						}
					 else {
						System.out.println("You're a thief!!" + "\n" ); //if you can't login then your definitley a thief
						sys();
					}
				}
			}
		}
		
// Employee branch 2		
		
		else if(p.equals("b")) {
	 		System.out.println("Login in to Employee Account" + "\n" + "What is your Username?"); //ask for employee info
	 		String eu = s.nextLine();
	 		System.out.println("What is your Password?");
	 		String ep = s.nextLine(); 
	 		
	 		if (eu.equals(Eu) && ep.equals(Ep)) { //boolean shorthand operator used to validate user information
	 			System.out.println("Would you like to:" +"\n"+ "a) View Customer Information " + "\n"
									+ "b) Approve or deny customer appliactions");
	 			String e1 = s.nextLine();
	 			if(e1.equals("a")) {
	 					for (int i=0; i< custList.size(); i++){
	 						System.out.println(custList.get(i) + "\n"); //iterates over custList and prints information
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
	 			System.out.println("You are not Big Mama!!!"); // -_-
	 			sys();
	 		}
		}
		
 // Bank Admin branch 3	
		
		
		
		else if(p.equals("c")) {
			System.out.println("Login in to account" + "\n" + "What is your Username?"); //ask for bankadmin info
			String bu = s.nextLine();
			System.out.println("What is your Password?");
			String bp = s.nextLine(); 
			
			if (bu.equals(BAun) && bp.equals(BApw)) { //esnures info is valid
			
				System.out.println("a) View Accounts" + "\n" + "b) Edits Accounts" + "\n");
				String d1 = s.nextLine();
				if(d1.equals("a")) { //View Accounts
					for (int x=0; x < custList.size(); x++){
						System.out.println(custList.get(x) + "\n");
						sys();
					}
					
					
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
						for (int x=0; x < custList.size(); x++){ //iterate over custList to view account info
							System.out.println(custList.get(x) + "\n");
						} 
						System.out.println("Input Username of account you would like to edit");
						String ua = s.nextLine();
						for (int n = 0; n < custList.size(); n++) {
							if (custList.get(n).getUN().equals(ua)) { //grabs correct oject based on username
								System.out.println("Would you like to:" + "\n" + "a) Withdraw" + "\n" + "b) Deposit" 
									+"\n"+ "c) Transfer");
								String d3a = s.nextLine(); 
							if(d3a.contentEquals("a")) {
									int $ = custList.get(n).get$(); 
									System.out.println("How much would you like to withdraw?"); 
									int less$ = Integer.parseInt(s.nextLine()); 
										if(less$ <= $) {
											int newF = $ - less$;
											custList.get(n).setFunds(newF);
											System.out.println("Remaining Balance: $"+custList.get(n).get$());
											writefile(custList);
											sys();
											}else {
												System.out.println("You're a Bankadmin and you can't count?!?!");
												sys();
											}
							} else if (d3a.equals("b")) {
									int $ = custList.get(n).get$();
									System.out.println("How much would you like to Deposit?"); 
									int plus$ = Integer.parseInt(s.nextLine()); 
									int newF = $ + plus$;
									custList.get(n).setFunds(newF);
									System.out.println("New Balance: $"+custList.get(n).get$());
									writefile(custList);
									sys();
							} else if (d3a.equals("c")) {
									System.out.println("Enter Account Username that you will be transferring money to: ");
									String h = s.nextLine();
									
										for (int t = 0; t < custList.size(); t++ ) {
											if (custList.get(t).getUN().equals(h) && n!= t ) {
											
												System.out.println("Transfer has begun\n" + "How much money would you like to Transfer?");
												int m$ = Integer.parseInt(s.nextLine());
												if(m$ <= custList.get(t).get$()) {
													int newF = custList.get(n).get$() - m$;
													custList.get(n).setFunds(newF);
													int nf = custList.get(t).get$() + m$;
													custList.get(t).setFunds(nf);
													System.out.println("New Balance for 1st Account: $"+custList.get(n).get$() + "\n"
															+	"New Balance for 2nd Account: $"+custList.get(t).get$());
												} else {
													System.out.println("Sorry, Company policy does not allow overdrafts!!");
												}
										}
									}writefile(custList);
								sys();
							}
							
							}
							
							}
						
					} else if (d2.equals("c")) {
						System.out.println("What account would you like to delete?");
						String d3b = s.nextLine(); 
						System.out.println("Account has been canceled");
					}
				}	
			 
			 	}else {
				System.out.println("You are not Big Daddy!");
				sys();
			 	}
			 }else {
				 System.out.println("Invalid input plzzz try again");
				 sys();
			 }
		s.close();
		
	}


	
		
//Serialization Methods	
	
	public void writefile(ArrayList<Customer> custys) {
		try {
        	FileOutputStream fos = new FileOutputStream("CustomerData.txt");
        	ObjectOutputStream oos = new ObjectOutputStream(fos);
        	oos.writeObject(custys);
        	System.out.println();
        	oos.flush();
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
	    	oos.flush();
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