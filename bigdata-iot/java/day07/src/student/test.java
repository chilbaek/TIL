package student;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		Student s1 = new Student();
		System.out.println(s1);
		double score[] = {80,90,70,80};
		s1.setScore(score);
		System.out.println(s1 +" "+ Arrays.toString(s1.getScore()));
		System.out.println(s1.getSum());
		System.out.println(s1.getAvg());
		System.out.println(s1.getLevel(s1.getAvg()));
		//for�� ���ʿ��ϰ� ���ϱ� ������ �����ؼ� �ִ°� �� �ٶ���
	}

}
