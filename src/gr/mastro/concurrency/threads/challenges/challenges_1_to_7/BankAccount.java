package gr.mastro.concurrency.threads.challenges.challenges_1_to_7;

public class BankAccount {
	
	private double balance;
	private String accountNumber;
	
	public BankAccount(String accountNumber, double initialBalance) {
		this.accountNumber = accountNumber;
		this.balance = initialBalance;
	}
	
	public void deposit(double amount) {
		synchronized (this) {
			balance += amount;
		}
	}
	
	public void withdraw(double amount) {
		synchronized (this) {
			balance -= amount;
		}
	}

	public double getBalance() {
		return balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
}
