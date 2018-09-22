package gr.mastro.concurrency.threads.challenges.challenge_7;

/**
 * Challenge #7: Spot and fix the problem
 * The challenge is to spot what's wrong with this code and to fix it.
 * What do we call this particular situation (deadlock, livelock, etc)?
 * Why is it happening?
 * How would we fix it?  
 *
 */
public class Main {

	public static void main(String[] args) {
		NewBankAccount account1 = new NewBankAccount("12345-678", 500.00);
		NewBankAccount account2 = new NewBankAccount("98765-432", 1000.00);

		new Thread(new Transfer(account1, account2, 10.00), "Transfer1").start();
		new Thread(new Transfer(account2, account1, 55.88), "Transfer2").start();
	}

}