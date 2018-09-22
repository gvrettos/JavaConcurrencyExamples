package gr.mastro.concurrency.threads.challenges.challenge_1_to_6;

/**
 * Challenge #1: Create and start threads
 * We could have two people using a joint bank account at the same time.
 * Create and start two threads that use the same BankAccount instance and an initial balance of $1000.00.
 * One will deposit $300.00 in the bank account and then withdraw $50.00.
 * The other will deposit $203.75 and then withdraw $100.00. 
 *
 * Challenge #2: Make the BankAccount class ThreadSafe using the synchronized keyword
 * I hope you can see that there's going to be thread interference when two threads are accessing the same
 * BankAccount instance at the same time.
 * We have to make the BankAccount class thread safe and that's our next challenge.
 * Use the synchronized keyword to make the BankAccount class thread safe.
 * 
 * Challenge #3: Make the BankAccount class ThreadSafe again using the synchronized keyword
 * Update the code so that the BankAccount class is thread safe for the 3 extra methods (getBalance, getAccountNumber, 
 * printAccountNumber).
 * Use the synchronized keyword wherever necessary.
 * Solution: No changes to the code are needed. Both threads only read values so thread interference isn't an issue.
 * 
 * Challenge #4: Use ReentrantLock
 * Instead of using the synchronized keyword, make the BankAccount class thread safe using the ReentrantLock class.
 * 
 * Challenge #5: User tryLock with a timeout value
 * Instead of using lock(), use tryLock() with a timeout value of 1 second. 
 * If the waiting period times out, print the message "Could not get the lock" to the console.
 * 
 * Challenge #6: Update the code so that the status variable is thread safe
 * Use whatever method you like: the synchronized keyword or the locked object.
 * Solution: Since the status variable is a local variable, it's already thread safe.
 * 			 Local variables are stored on the thread stack; each thread will have its own copy.
 * 			 Threads won't interfere with each other when it comes to setting and getting the status value.
 * 
 */
public class Main {

	public static void main(String[] args) {
		
		BankAccount account = new BankAccount("12345-678", 1000.00);
		
		System.out.println("Account: " + account.getAccountNumber() + ", Initial balance: " + account.getBalance());
		
		Thread user1 = new Thread(() -> {
			account.deposit(300.00);
			account.withdraw(50.00);
			System.out.println("User1: Account: " + account.getAccountNumber() + ", balance: " + account.getBalance());
		});
		
		Thread user2 = new Thread(() -> {
			account.deposit(203.75);
			account.withdraw(100.00);
			System.out.println("User2: Account: " + account.getAccountNumber() + ", balance: " + account.getBalance());
		});
		
		user1.start();
		user2.start();
	}

}
