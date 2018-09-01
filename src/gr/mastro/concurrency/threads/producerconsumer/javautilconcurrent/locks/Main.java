package gr.mastro.concurrency.threads.producerconsumer.javautilconcurrent.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Thread synchronization using java.util.concurrent.locks.RentrantLock class.
 * 
 */
public class Main {
	
	public static final String EOF = "EOF";

	public static void main(String[] args) {
		List<String> buffer = new ArrayList<>();
		ReentrantLock bufferLock = new ReentrantLock();
		
		Thread producerThread = new Thread(new Producer(buffer, bufferLock));
		Thread consumer1Thread = new Thread(new Consumer(buffer, bufferLock));
		Thread consumer2Thread = new Thread(new Consumer(buffer, bufferLock));
		
		producerThread.setName("Producer");
		consumer1Thread.setName("Consumer 1");
		consumer2Thread.setName("Consumer 2");
		
		producerThread.start();
		consumer1Thread.start();
		consumer2Thread.start();
	}

}
