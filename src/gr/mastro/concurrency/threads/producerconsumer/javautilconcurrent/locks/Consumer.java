package gr.mastro.concurrency.threads.producerconsumer.javautilconcurrent.locks;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {

	private List<String> buffer;
	private ReentrantLock bufferLock;

	public Consumer(List<String> buffer, ReentrantLock bufferLock) {
		this.buffer = buffer;
		this.bufferLock = bufferLock;
	}
	
	@Override
	public void run() {
		while (true) {
			// Best practice: Enclose critical sections of code in try - finally blocks.
			bufferLock.lock();
			try {
				if (!buffer.isEmpty()) {
					if (Main.EOF.equals(buffer.get(0))) {
						System.out.println(Thread.currentThread().getName() + ": Exiting");
						break;
					}
					else {
						System.out.println(Thread.currentThread().getName() + ": Removed " + buffer.remove(0));
					}
				}
			} finally {
				bufferLock.unlock();
			}
		}
	}

}
