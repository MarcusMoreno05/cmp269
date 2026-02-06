package excersice_1;

public class CreditCard extends PaymentMethod {
	
	private double creditLimit;

	public CreditCard(String accountHolder, double balance, double creditLimit) {
		super(accountHolder, balance);
		this.creditLimit = creditLimit;
	}

	@Override
	public void processPayment(double amount) {
		
		if (amount > balance + creditLimit){
			System.out.println("Transaction Declined.");
			return;
		}
		balance -= amount;
		totalTransactions++;
        System.out.println("Transaction Approved.");	
	}

	@Override
	public String getPaymentStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void validateAccount() {
		// TODO Auto-generated method stub
		
	}


}
