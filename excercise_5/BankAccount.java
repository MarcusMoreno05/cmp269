package excercise_5;

public class BankAccount {
    private int balance = 1000;

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. New balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw but insufficient funds.");
        }
    }

    public int getBalance() {
        return balance;
    }

    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        Runnable task = () -> account.withdraw(700);

        Thread husband = new Thread(task, "Husband");
        Thread wife = new Thread(task, "Wife");

        husband.start();
        wife.start();

        husband.join();
        wife.join();

        System.out.println("Final balance: " + account.getBalance());
    }
}
