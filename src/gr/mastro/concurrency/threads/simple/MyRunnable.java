package gr.mastro.concurrency.threads.simple;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Hello from MyRunnable's implementation of run()");
	}
}
