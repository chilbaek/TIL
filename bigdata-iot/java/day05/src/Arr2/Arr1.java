package Arr2;

import java.util.Random;

public class Arr1 {

	public static void main(String[] args) {
//		int i = 10; //primitive type
//		int a[] = new int[3]; //reference type (heap)
		int a2[][] = new int[3][2]; //�ุŭ�� �ݵ�� �����ؾ�
		for(int i=0 ; i<a2.length ; i++) {
			for (int j=0 ; j<a2[i].length ; j++) {
				System.out.printf("a2[%d][%d] \n",  i,j);
			}
		}
		
		// 1~9 ������ �迭�� �ְ� ���
		System.out.printf("=======================");
		int a3[][] = new int[3][3];
		Random r = new Random();
		for(int i=0; i<a3.length ; i++) {
			for (int j=0 ; j<a3[i].length ; j++) {
				a3[i][j] = r.nextInt(8)+1;
			}
		}
		
		for(int i=0 ; i<a3.length ; i++) {
			for (int j=0 ; j<a3[i].length ; j++) {
				System.out.printf("a3[%d][%d] \n",  i,j);
			}
		}

	}
}
