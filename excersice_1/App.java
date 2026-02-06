package excersice_1;
import java.util.ArrayList;

public class App {
	 public static void main(String[] args) {
		
		 ArrayList<Payable> paymentQueue = new ArrayList<>();
		 paymentQueue.add(new CreditCard("User 1", 40.0, 000.0));
		 paymentQueue.add(new MealPlan("User 2", 100.0));

		 for (Payable p : paymentQueue) {
			    p.processPayment(50.0);
			}
		 
		 System.out.println("Total Transactions: " + PaymentMethod.getTotalTransactions());

		 
	 }
}
