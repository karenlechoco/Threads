
public class MyRunnable implements Runnable {

	private final long countUntil;
	
	MyRunnable(long countUntil) {
		this.countUntil = countUntil;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long sum=0;
		for (long i=1; i<countUntil; i++) {
			sum += 1;
		}
		System.out.println(sum);
	}

}
