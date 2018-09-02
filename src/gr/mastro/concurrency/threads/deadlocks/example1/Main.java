package gr.mastro.concurrency.threads.deadlocks.example1;

/**
 * Demonstrates a case when deadlock will happen.
 * 
 * Possible workarounds to prevent deadlock situations from happening:
 * 1. Lock on a single object. This cannot be achieved in all cases.
 * 2. Ensure that all threads that compete for the same two or more locks try to obtain the locks in the same order.
 *
 */
public class Main {
	
	public static void main(String[] args) {
		final Object lock1 = new Object();
		final Object lock2 = new Object();
		new Thread1(lock1, lock2).start();
		new Thread2(lock1, lock2).start();
	}

}
