package collection;

import java.util.HashSet;
import java.util.Random;

public class Col3 {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>(); //�ߺ����� �ʰ� ���� ����
		//set�� �ߺ��ʴ� ���� 6��
		Random r = new Random();
//		for(int i:set) {
//			set.add(i);
//		}
		while(true){
			set.add(r.nextInt(50));
			if(set.size() == 6)
				break;
		}
		
		//set���� ���
		System.out.println("size: "+set.size());

		for(int j:set) {
			System.out.println(j);
		}
		
	}

}
