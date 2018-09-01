package gr.mastro.concurrency.threads.producerconsumer.syncmethods;

import java.util.Random;

public class Writer implements Runnable {
	
	private Message message;
	
	public Writer(Message message) {
		super();
		this.message = message;
	}

	// Messages are taken from the startup workspace quotes displayed in Eclipse Darkest Dark theme.
	@Override
	public void run() {
		String devJokes[] = {
			"Developers will develop... Oh! And they eat, too.",
			"In order to understand recursion, one must first understand recursion.",
			"First solve the problem, then write the code",
			"Don't get distracted by the noise.",
			"If at first you do not succeed, call it version 1.0.",
		};
		
		Random random = new Random();
		
		for (int i=0; i<devJokes.length; i++) {
			message.write(devJokes[i]);
		}
		
		try {
			Thread.sleep(random.nextInt(2000));
		} catch (InterruptedException e) {
			
		}
		
		message.write("Finished");
	}

}
