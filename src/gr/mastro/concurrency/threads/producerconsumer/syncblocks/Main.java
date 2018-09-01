package gr.mastro.concurrency.threads.producerconsumer.syncblocks;

import java.util.ArrayList;
import java.util.List;

/*
 * Thread synchronization using synchronized blocks of code.
 * 
 */
public class Main {
	
	public static final String EOF = "EOF";

	public static void main(String[] args) {
		List<String> buffer = new ArrayList<>();
		
		Thread producerThread = new Thread(new Producer(buffer));
		Thread consumer1Thread = new Thread(new Consumer(buffer));
		Thread consumer2Thread = new Thread(new Consumer(buffer));
		
		producerThread.setName("Producer");
		consumer1Thread.setName("Consumer 1");
		consumer2Thread.setName("Consumer 2");
		
		producerThread.start();
		consumer1Thread.start();
		consumer2Thread.start();
	}

}
