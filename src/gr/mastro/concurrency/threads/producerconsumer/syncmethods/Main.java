package gr.mastro.concurrency.threads.producerconsumer.syncmethods;

/*
 * Thread synchronization using wait(), notifyAll() inside synchronized methods.
 */
public class Main {

	public static void main(String[] args) {
		Message message = new Message();
		new Thread(new Writer(message)).start();
		new Thread(new Reader(message)).start();
	}

}
