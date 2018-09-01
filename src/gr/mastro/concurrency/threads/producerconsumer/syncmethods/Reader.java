package gr.mastro.concurrency.threads.producerconsumer.syncmethods;

import java.util.Random;

public class Reader implements Runnable {

	private Message message;
	
	public Reader(Message message) {
		this.message = message;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		for (String latestMessage = message.read(); !"Finished".equals(latestMessage); 
				latestMessage = message.read()) {
			System.out.println(latestMessage);
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
				
			}
			
		}
	}
}
