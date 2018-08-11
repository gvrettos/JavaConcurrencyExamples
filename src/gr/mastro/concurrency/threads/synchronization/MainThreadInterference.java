package gr.mastro.concurrency.threads.synchronization;

public class MainThreadInterference {

	public static void main(String[] args) {
		System.out.println("Testing threads without any synchronization strategy");
		System.out.println("====================================================");
		
		Countdown countdown = new CountdownInterfered();
		
		CountdownThread thread1 = new CountdownThread(countdown);
		thread1.setName("Thread 1");
		CountdownThread thread2 = new CountdownThread(countdown);
		thread1.setName("Thread 2");
		
		thread1.start();
		thread2.start();
	}

}
