package gr.mastro.concurrency.threads.challenges.challenges_1_to_7;

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
 * We have to make the BankAccount class threadsafe and that's our next challenge.
 * Use the synchronized keyword to make the BankAccount class threadsafe.
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
