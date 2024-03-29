import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
	
	private static final int NTHREDS = 10;

	public static void main (String[] args) {
		List<Thread> threads = new ArrayList<Thread>();
		
		for (int i=0; i<500; i++) {
			Runnable task = new MyRunnable(10000000L + i);
			Thread worker = new Thread(task);
			worker.setName(String.valueOf(i));
			worker.start();
			threads.add(worker);
		}
		
		int running = 0;
		do {
			running=0;
			for (Thread thread : threads) {
				if (thread.isAlive()) {
					running++;
				}
			}
			System.out.println("We have " + running + " running threads. ");
		} while (running > 0);
	}
	
	public static void main2 (String[] args) {
		ExecutorService  executor = Executors.newFixedThreadPool(NTHREDS);
		for (int i=0; i<500; i++) {
			Runnable worker = new MyRunnable(10000000L + i);
			executor.execute(worker);
		}
		
		//This will make the executor accept no new threads
		//and finish all existing threads in the queue
		executor.shutdown();
		
		//Wait until all threads are finish
		while (!executor.isTerminated()) {
			
		}
		
		System.out.println("Finished all threads");
	}
}
