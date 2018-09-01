package gr.mastro.concurrency.threads.producerconsumer.javautilconcurrent.threadpools.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Thread synchronization using java.util.concurrent.ExecutorService interface.
 * 
 * This relieves the programmer from fussing about threads management and their life cycles. 
 * 
 */
public class Main {
	
	public static final String EOF = "EOF";

	public static void main(String[] args) {
		List<String> buffer = new ArrayList<>();
		ReentrantLock bufferLock = new ReentrantLock();
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Producer producer = new Producer(buffer, bufferLock); // pool-1-thread-1
		Consumer consumer1 = new Consumer(buffer, bufferLock); // pool-1-thread-2
		Consumer consumer2 = new Consumer(buffer, bufferLock); // pool-1-thread-3
		
		executorService.execute(producer); 
		executorService.execute(consumer1);
		executorService.execute(consumer2);
		
		demoFutureCallableClass(executorService);
		
		executorService.shutdown();
	}
	
	private static void demoFutureCallableClass(ExecutorService executorService) {
		// Get a value back from a thread's execution
		Future<String> future = executorService.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("I'm being printed for the Callable class");
				return "This is the callable result";
			}
		});
		
		try {
			System.out.println(future.get()); // this call is blocking until the result is actually fetched
		} catch (ExecutionException e) {
			System.out.println("Something went wrong");
		} catch (InterruptedException e) {
			System.out.println("Thread running the task was interrupted");
		}
	}

}
