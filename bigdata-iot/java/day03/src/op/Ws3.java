package op;

import java.util.Scanner;

public class Ws3 {

	public static void main(String[] args) {
		//���ڸ��� ���ڸ� �Է¹޴´�.
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert number 1 : ");
		
		String s1 = sc.nextLine();
		int num1 = Integer.parseInt(s1);
		int data = 100;
		
		//�Է� ���� ���� 0���� ������ data�� 10�� ���ϰ�
		//�׷��� ������ 1�� ���Ѵ�.
		
		//SOLUTION1
//		int result = (num1 < 0) ? data*10 : data*1;
//		System.out.println(result);
		//SOLUTION2
		data = (num1<0) ? data*10 : data*1;
		sc.close();
		System.out.println(data);
		//SOLUTION3
//		data *= ((num1<0) ? 10:1);
//		System.out.println(data);
		
	}
}
