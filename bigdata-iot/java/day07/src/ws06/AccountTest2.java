package ws06;

import java.util.Arrays;

public class AccountTest2 {

	public static void main(String[] args) {
		//5���� Account�� ��ü�迭 ����
		Account[] acc2 = new Account[5];
		//for������ Account��ü�� �迭�� ����
		for (int i=0 ; i<acc2.length ; i++) {
			acc2[i] = new Account("221-0101-211"+(i+1), 100000, 4.5);
		}
		//for������ Account ���� ���
		for (int i=0 ; i<acc2.length ; i++) {
			acc2[i].accountInfo();
		}
		//for������ ������ ����, ȭ�����
		for (int i=0 ; i<acc2.length ; i++) {
			acc2[i].interestRate = 3.7;
			System.out.println("�����������: " + acc2[i].interestRate);
		}
		
		System.out.println(Arrays.deepToString(acc2));
		
	}
}
