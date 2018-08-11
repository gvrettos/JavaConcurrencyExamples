package gr.mastro.concurrency.threads.synchronization;

public abstract class Countdown {

	private int i;
	
	// lock as a class variable (not a local one inside a method) is shared amongst all threads
	protected Object lock = new Object();

	
	protected abstract void countdown();
	
	protected void doCountdown() {
		for (i=10; i>0; i--) {
			System.out.println(Thread.currentThread().getName() + ": i = " + i);
		}
	}
}
