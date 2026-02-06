package excersice_1;

public class MealPlan extends PaymentMethod{

	public MealPlan(String accountHolder, double balance) {
		super(accountHolder, balance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processPayment(double amount) {
		if (amount <= 0 || amount > balance ) {
			System.out.println("Transaction Declined. Cannot be negative");
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
		if (balance<0) {
			System.out.println("Transaction Declined. Cannot be less than 0");
		}
		
	}

}
