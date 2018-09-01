package gr.mastro.concurrency.threads.producerconsumer.javautilconcurrent.threadpools.arrayblockingqueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Producer implements Runnable {
	
	private ArrayBlockingQueue<String> buffer;

	public Producer(ArrayBlockingQueue<String> buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		Random random = new Random();
		String[] nums = {"1", "2", "3", "4", "5"};
		
		for (String num : nums) {
			try {
				System.out.println(Thread.currentThread().getName() + ": Adding... " + num);
				buffer.put(num);
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " was interrupted.");
			}
		}
		
		System.out.println(Thread.currentThread().getName() + ": Adding EOF and exiting...");
		try {
			buffer.put(Main.EOF);
		} catch (InterruptedException e) {
		}
	}

}
