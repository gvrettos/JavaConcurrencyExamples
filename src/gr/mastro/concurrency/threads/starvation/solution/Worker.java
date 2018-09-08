package gr.mastro.concurrency.threads.starvation.solution;

import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable {

	private ReentrantLock lock; 
	private int runCount = 1;
	
	
	public Worker(ReentrantLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		for (int i=0; i<100; i++) {
			lock.lock();
			try {
				// TODO consider using lambda expressions instead, if possible
				System.out.format("%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
				
				// execute critical section of code
				
			} finally {
				lock.unlock();
			}
		}
	}

}
