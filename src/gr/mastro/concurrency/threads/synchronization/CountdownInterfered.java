package gr.mastro.concurrency.threads.synchronization;

public class CountdownInterfered extends Countdown {
	
	@Override
	public void countdown() {		
		doCountdown();
	}
}
