package gr.mastro.concurrency.threads.starvation.problem;

/**
 * Setting thread priorities can make more likely to happen, 
 * ie a thread with higher priority may monopolize the CPU resource.
 *
 */
public class Main {

	public static void main(String[] args) {
		Object lock = new Object();
		Thread t1 = new Thread(new Worker(lock), "Priority 10");
		Thread t2 = new Thread(new Worker(lock), "Priority 8");
		Thread t3 = new Thread(new Worker(lock), "Priority 6");
		Thread t4 = new Thread(new Worker(lock), "Priority 4");
		Thread t5 = new Thread(new Worker(lock), "Priority 2");
		
		t3.setPriority(10);
		t2.setPriority(8);
		t5.setPriority(6);
		t4.setPriority(4);
		t1.setPriority(2);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
