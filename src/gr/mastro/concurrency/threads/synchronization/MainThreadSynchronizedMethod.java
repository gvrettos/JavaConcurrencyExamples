package gr.mastro.concurrency.threads.synchronization;

public class MainThreadSynchronizedMethod {

	public static void main(String[] args) {
		System.out.println("Testing threads with synchronized method");
		System.out.println("========================================");
		
		Countdown countdown = new CountdownSynchronizedMethod();

		CountdownThread thread1 = new CountdownThread(countdown);
		thread1.setName("Thread 1");
		CountdownThread thread2 = new CountdownThread(countdown);
		thread1.setName("Thread 2");

		thread1.start();
		thread2.start();
	}

}
