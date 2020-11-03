package ws05;

public class Account {
	String account;
	int balance;
	double interestRate;
	
	public Account() {}
	
	public Account(int balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public Account(String account, int balance, double interestRate) {
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	//�������� ����
	public void setAccount(String account) {
		this.account = account;
	}
	//������������
	public String getAccount() {
		return this.account;
	}
	//�ܾ���������
	 public int getBalance() {
		 return this.balance;
	 }
	 //�����ܾױ��� ���ڰ��
	 public double calculateInterest() {
		 return this.balance * this.interestRate * 0.01;
	 }
	 //�Ա�
	 public void deposit(int money) {
		 if(money >= 0) {
			 this.balance += money;
		 } else {
			 System.out.println("Invalid Value ..");
			 return;
		 }
	 }
	 //���
	 public void withdraw(int money) {
		 if(money >= 0) {
			 this.balance -= money;
		 } else {
			 System.out.println("Invalid Value ..");
			 return;
		 }
	 }
	@Override
	public String toString() {
		return "Account [account=" + account + ", balance=" + balance + ", interestRate=" + interestRate + "]";
	}
	 
}
