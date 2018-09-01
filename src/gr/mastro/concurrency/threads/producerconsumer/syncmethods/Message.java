package gr.mastro.concurrency.threads.producerconsumer.syncmethods;

public class Message {
	private String text;
	private boolean empty = true;
	
	// Missing wait() and notifyAll() calls lead to deadlock: one thread waiting for the other
	public synchronized String read() {
		while (empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		empty = true;
		notifyAll();
		return text;
	}
	
	// Missing wait() and notifyAll() calls lead to deadlock: one thread waiting for the other
	public synchronized void write(String text) {
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		empty = false;
		this.text = text;
		notifyAll();
	}
}
