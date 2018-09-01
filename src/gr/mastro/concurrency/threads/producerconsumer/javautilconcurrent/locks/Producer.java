package gr.mastro.concurrency.threads.producerconsumer.javautilconcurrent.locks;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable {
	
	private List<String> buffer;
	private ReentrantLock bufferLock;

	public Producer(List<String> buffer, ReentrantLock bufferLock) {
		this.buffer = buffer;
		this.bufferLock = bufferLock;
	}

	@Override
	public void run() {
		Random random = new Random();
		String[] nums = {"1", "2", "3", "4", "5"};
		
		for (String num : nums) {
			System.out.println(Thread.currentThread().getName() + ": Adding... " + num);
			bufferLock.lock();
			// Best practice: Enclose critical sections of code in try - finally blocks.
			try {
				buffer.add(num);
			} finally {
				bufferLock.unlock();
			}			
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " was interrupted.");
			}
		}
		
		System.out.println(Thread.currentThread().getName() + ": Adding EOF and exiting...");
		bufferLock.lock();
		// Best practice: Enclose critical sections of code in try - finally blocks.
		try {
			buffer.add(Main.EOF);
		} finally {
			bufferLock.unlock();
		}
	}

}
