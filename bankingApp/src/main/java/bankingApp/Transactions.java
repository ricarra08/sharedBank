package bankingApp;

public interface Transactions {
	void deposit(int moneyM);
	void withdraw(int moneyP);
	void transfer(CustomerAccount x, CustomerAccount y,Integer z);
	
	
}
