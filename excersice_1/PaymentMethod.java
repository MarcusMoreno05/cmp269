package excersice_1;

public abstract class PaymentMethod implements Payable {

	protected String accountHolder;
	protected double balance;
	
	public PaymentMethod(String accountHolder, double balance ) {
	this.accountHolder = accountHolder;
	this.balance = balance;
		
	}
	
	protected static int totalTransactions = 0;
	
	public abstract void validateAccount();

	public static int getTotalTransactions() {
		// TODO Auto-generated method stub
		return totalTransactions;
	}
	
	
}
