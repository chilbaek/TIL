package com.sync;

public class Account {
	private int balance;
	public Account() {}
	public Account(int balance) {
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
	
	public void deposit (int money) {
		if(money > 0) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance += money;
		}
	}
	public synchronized void withdraw(int money) {
		if(balance >= money)
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= money;
	}
	@Override
	public String toString() {
		return "Account [balance=" + balance + "]";
	}
	
}
