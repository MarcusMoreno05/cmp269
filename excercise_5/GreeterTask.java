package excercise_5;

public class GreeterTask implements Runnable {

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        for (int i = 0; i < 5; i++) {
            System.out.println("Hello from " + threadName);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        GreeterTask task = new GreeterTask();


        Thread t1 = new Thread(task, "Lehman-Thread-1");
        Thread t2 = new Thread(task, "Lehman-Thread-2");

        // Start both threads
        t1.start();
        t2.start();
    }
}