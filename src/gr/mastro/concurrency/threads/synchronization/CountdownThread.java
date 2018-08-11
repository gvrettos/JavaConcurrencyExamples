package gr.mastro.concurrency.threads.synchronization;

public class CountdownThread extends Thread {
	
	private Countdown threadCounter;

	public CountdownThread(Countdown threadCounter) {
		this.threadCounter = threadCounter;
	}

	@Override
	public void run() {
		threadCounter.countdown();
	}

}
