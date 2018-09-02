package gr.mastro.concurrency.threads.deadlocks.example2;

public class Main {

	public static void main(String[] args) {
		PolitePerson jane = new PolitePerson("Jane");
		PolitePerson john = new PolitePerson("John");
		
		/*
		 * Invoking the methods in separate threads will cause a deadlock 
		 * because two locks (jane, john) are used in different order in each thread execution.
		 * 
		 * Possible scenario that causes the deadlock:
		 * 1. Thread 1 acquires the lock on the jane object and enters sayHello() method. 
		 * 	  It prints to the console, then suspends.
		 * 2. Thread 2 acquires the lock on the john object and enters sayHello() method. 
		 * 	  It prints to the console, then suspends.
		 * 3. Thread 1 runs again and wants to say hello back to the john object. 
		 * 	  It tries to call the sayHelloBack() method using the john object that was passed into the sayHello() 
		 * 	  method but Thread 2 is holding the john lock, so Thread 1 suspends.
		 * 4. Thread 2 runs again and wants to say hello back to the jane object. 
		 * 	  It tries to call the sayHelloBack() method using the jane object that was passed into the sayHello() 
		 * 	  method but Thread 1 is holding the jane lock, so Thread 2 suspends.
		 */
		new Thread(() -> jane.sayHello(john)).start();
		new Thread(() -> john.sayHello(jane)).start();
	}

}
