package ifelse4;

import java.util.Random;

public class If4 {
	
	public static void main(String[] args) {
		Random r = new Random();
		int ko = r.nextInt(100)+1;
		int en = r.nextInt(100)+1;
		int ma = r.nextInt(100)+1;
		int si = r.nextInt(100)+1;
		String grade = "";
		
		System.out.printf("%d, %d, %d, %d \n", ko, en, ma, si);
		//����� ���Ѵ�.
		int avg = (ko + en + ma + si) / 4;
		
		// 90�̻� A : 95�̻� A+, �̸��̸�  A-
		if(avg >= 90) {
			/*
			if(avg >= 95)
				grade = "A+";
			else
				grade = "A-";
			*/
			grade = (avg >= 95) ? "A+" : "A-";
		}
		// 80�̻� B : 95�̻� B+, �̸��̸�  B-
		if(avg >= 80) {
			if(avg >= 85)
				grade = "B+";
			else
				grade = "B-";
		}
		// 70�̻� C : 95�̻� C+, �̸��̸�  C-
		if(avg >= 70) {
			if(avg >= 75)
				grade = "C+";
			else
				grade = "C-";
		}
		// 60�̻� D : 95�̻� D+, �̸��̸�  D-
		if(avg >= 60) {
			if(avg >= 65)
				grade = "D+";
			else
				grade = "D-";
		}
		// 60�̸��� F
		if(avg < 60)
			grade = "F";
		
		// ��հ� ������ ����ϼ�
		System.out.printf("��� : %d \n", avg);
		System.out.printf("���� : %s \n", grade);
		
		//====== 3��
		// grade = (avg >= 90) ? ((avg >= 95) ? "A+" : "A-");
		
		
	}

}
