package gr.mastro.concurrency.threads.producerconsumer.javautilconcurrent.threadpools.arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Consumer implements Runnable {

	private ArrayBlockingQueue<String> buffer;

	public Consumer(ArrayBlockingQueue<String> buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				if (!buffer.isEmpty()) {
					if (Main.EOF.equals(buffer.peek())) {
						System.out.println(Thread.currentThread().getName() + ": Exiting");
						break;
					}
					else {
						System.out.println(Thread.currentThread().getName() + ": Removed " + buffer.take());
					}
				}
			} catch (InterruptedException e) {
				
			}
		}
	}

}
