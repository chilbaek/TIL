package ws05;

public class AccountTest {

	public static void main(String[] args) {
		Account acc1 = new Account(500000, 7.3);
		acc1.setAccount("441-0290-1203");
		System.out.println("��������: " + acc1.getAccount());
		System.out.println("�ܾ����� : " + acc1.getBalance());
		
		acc1.deposit(20000);
		System.out.println("�Ա����ܾ� " + acc1.getBalance());
//		acc1.withdraw(40000);
//		System.out.println("������ܾ� " + acc1.getBalance());
		
		System.out.println("�����ܾױ������� : " + acc1.calculateInterest());
		
		System.out.println(acc1);
	}
}
