package excercise_5;

public class HeavyCalculation {

    public static void main(String[] args) throws InterruptedException {

        final long[] resultHolder = new long[1];

        Thread worker = new Thread(() -> {
            long sum = 0;
            for (long i = 1; i <= 1_000_000_000L; i++) {
                sum += i;
            }
            resultHolder[0] = sum;
        }, "Heavy-Worker");

        worker.start();

        worker.join();

        System.out.println("Calculation Finished: " + resultHolder[0]);
    }
}
