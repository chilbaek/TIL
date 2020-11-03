package lotto;

import java.util.Arrays;
import java.util.Random;

public class Rand {

	public static void main(String[] args) {
		// 1�� ����� �����Է�
		// 99�� ����
		
		//��÷��ȣ �������� �ߺ����� 1~45
		int winnum[] = new int[6];
		Random r = new Random();
		for(int i=0 ; i<winnum.length ; i++) {
			winnum[i] = r.nextInt(45)+1; //������ȣ ����
			for(int j=0 ; j<i ; j++) { //�ߺ��˻�
				if(winnum[i] == winnum[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println("��÷��ȣ : ");
		System.out.println(Arrays.toString(winnum));
		
		//�������� ����
		for(int i=0 ; i<winnum.length ; i++) {
			for(int j=i+1 ; j<winnum.length ; j++) {
				if(winnum[i] > winnum[j]) {
					int temp = winnum[i];
					winnum[i] = winnum[j];
					winnum[j] = temp;
				}
			}
		}
		System.out.println("��÷��ȣ(��������) : ");
		System.out.println(Arrays.toString(winnum));
	}
}
