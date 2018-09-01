package gr.mastro.concurrency.threads.producerconsumer.syncblocks;

import java.util.List;

public class Consumer implements Runnable {

	private List<String> buffer;

	public Consumer(List<String> buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		while (true) {
			synchronized (buffer) {
				if (!buffer.isEmpty()) {
					if (Main.EOF.equals(buffer.get(0))) {
						System.out.println(Thread.currentThread().getName() + ": Exiting");
						break;
					}
					else {
						System.out.println(Thread.currentThread().getName() + ": Removed " + buffer.remove(0));
					}
				}
			}
		}
	}

}
