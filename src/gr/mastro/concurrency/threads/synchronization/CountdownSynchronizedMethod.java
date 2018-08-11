package gr.mastro.concurrency.threads.synchronization;

public class CountdownSynchronizedMethod extends Countdown {

	@Override
	protected synchronized void countdown() {
		doCountdown();
	}
}
