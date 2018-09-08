package gr.mastro.concurrency.threads.starvation.problem;

public class Worker implements Runnable {

	private Object lock; 
	private int runCount = 1;
	
	
	public Worker(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		for (int i=0; i<100; i++) {
			synchronized (lock) {
				// TODO consider using lambda expressions instead, if possible
				System.out.format("%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
				
				// execute critical section of code
				
			}
		}
	}

}
