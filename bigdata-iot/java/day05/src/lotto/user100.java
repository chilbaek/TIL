package lotto;

import java.util.Arrays;
import java.util.Random;

public class user100 {

	public static void main(String[] args) {
		// 99�� ������ȣ ����
		// 2���迭 > 1���� ����ڽĺ���ȣ / 2���� �����ζǹ�ȣ
		
		//��÷��ȣ �������� �ߺ����� 1~45
		int user100[][] = new int[100][6];
		Random r = new Random();
		
		for(int i=0 ; i<user100.length ; i++) { //�Ǿտ��� �����Է��� ���� ��ȣ �ο�
			for(int j=0 ; j<user100[j].length ; j++) {
				if(i!=0) { //������ ������ȣ �ο� + �ߺ�����
					user100[i][j] = r.nextInt(45)+1; // ������ȣ ����
					for(int k=0 ; k<j ; k++) { //�ߺ��˻�
						if(user100[i][j] == user100[i][k]) {
							k--;
							break;
						}
					}
					
				} else { //���� �Է¶� �ʱ�ȭ
					user100[i][j] = 0;
				}
			}
		}
		
		
		System.out.println("99�� �ζǹ�ȣ ���� : ");
		System.out.println(Arrays.deepToString(user100));
	}
}
