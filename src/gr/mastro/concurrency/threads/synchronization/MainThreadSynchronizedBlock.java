package gr.mastro.concurrency.threads.synchronization;

public class MainThreadSynchronizedBlock {

	public static void main(String[] args) {
		System.out.println("Testing threads with synchronized block");
		System.out.println("=======================================");
		
		Countdown countdown = new CountdownSynchronizedBlock();

		CountdownThread thread1 = new CountdownThread(countdown);
		thread1.setName("Thread 1");
		CountdownThread thread2 = new CountdownThread(countdown);
		thread1.setName("Thread 2");

		thread1.start();
		thread2.start();
	}

}
