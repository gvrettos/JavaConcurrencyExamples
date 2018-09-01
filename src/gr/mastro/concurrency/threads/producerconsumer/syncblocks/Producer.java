package gr.mastro.concurrency.threads.producerconsumer.syncblocks;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
	
	private List<String> buffer;

	public Producer(List<String> buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		Random random = new Random();
		String[] nums = {"1", "2", "3", "4", "5"};
		
		for (String num : nums) {
			System.out.println(Thread.currentThread().getName() + ": Adding... " + num);
			synchronized (buffer) {
				buffer.add(num);
			}
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " was interrupted.");
			}
		}
		
		System.out.println(Thread.currentThread().getName() + ": Adding EOF and exiting...");
		synchronized (buffer) {
			buffer.add(Main.EOF);
		}
	}

}
