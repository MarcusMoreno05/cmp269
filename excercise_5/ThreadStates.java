package excercise_5;

public class ThreadStates {
	
	 public static void main(String[] args) throws InterruptedException {

	        Thread sleeper = new Thread(() -> {
	            try {
	                Thread.sleep(2000);
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        });

	        System.out.println("State after creation: " + sleeper.getState());

	        sleeper.start();

	        System.out.println("State right after start(): " + sleeper.getState());

	        Thread.sleep(500); 
	        
	        System.out.println("State while sleeping: " + sleeper.getState());


	        sleeper.join();
	        System.out.println("State after completion: " + sleeper.getState());
	    }


}
