package gr.mastro.concurrency.threads.challenges.challenge_7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NewBankAccount {
	private double balance;
	private String accountNumber;
	private Lock lock = new ReentrantLock();

	NewBankAccount(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public boolean withdraw(double amount) {
		if (lock.tryLock()) {
			try {
				return doWithdraw(amount);
			} finally {
				lock.unlock();
			}
		}
		return false;
	}

	public boolean deposit(double amount) {
		if (lock.tryLock()) {
			try {
				return doDeposit(amount);
			} finally {
				lock.unlock();
			}
		}
		return false;
	}

	public boolean transfer(NewBankAccount destinationAccount, double amount) {
		if (withdraw(amount)) {
			if (destinationAccount.deposit(amount)) {
				return true;
			} else {
				// The deposit failed. Refund the money back into the account.
				System.out.printf("%s: Destination account busy. Refunding money\n", Thread.currentThread().getName());
				deposit(amount);
			}
		}

		return false;
	}

	private boolean doWithdraw(double amount) {
		simulateDatabaseAccess();
		balance -= amount;
		System.out.printf("%s: Withdrew %f\n", Thread.currentThread().getName(), amount);
		return true;
	}

	private boolean doDeposit(double amount) {
		simulateDatabaseAccess();
		balance += amount;
		System.out.printf("%s: Deposited %f\n", Thread.currentThread().getName(), amount);
		return true;
	}

	private void simulateDatabaseAccess() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	}
}
