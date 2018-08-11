package gr.mastro.concurrency.threads.synchronization;

public class CountdownSynchronizedBlock extends Countdown {

	@Override
	protected void countdown() {
		// You can also use synchronized(this) here instead of an explicit lock object
		synchronized(lock) {
			doCountdown();
		}
	}
}
