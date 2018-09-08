package gr.mastro.concurrency.threads.starvation.solution;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Setting thread priorities can make more likely to happen, 
 * ie a thread with higher priority may monopolize the CPU resource.
 * 
 * Using "fair locks" will solve the starvation problem.
 * A fair lock will only guarantee a FIFO type of execution 
 * but not how much time a thread may monopolize the available resources.
 * 
 * Keep in mind:
 * 1. Synchronized blocks are generally preferable when 2-3 threads exist and do their job quickly.
 * 1. Fair locks are better for large number of threads but add an extra layer of orchestration 
 * 	  that causes performance penalty.
 *
 */
public class Main {

	public static void main(String[] args) {
		
		ReentrantLock lock = new ReentrantLock(true);
		
		Thread t1 = new Thread(new Worker(lock), "Priority 10");
		Thread t2 = new Thread(new Worker(lock), "Priority 8");
		Thread t3 = new Thread(new Worker(lock), "Priority 6");
		Thread t4 = new Thread(new Worker(lock), "Priority 4");
		Thread t5 = new Thread(new Worker(lock), "Priority 2");
		
		t1.setPriority(10);
		t2.setPriority(8);
		t3.setPriority(6);
		t4.setPriority(4);
		t5.setPriority(2);
		
		t3.start();
		t2.start();
		t5.start();
		t4.start();
		t1.start();
	}

}
