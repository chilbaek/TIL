package forwhile;

public class For5 {

	public static void main(String[] args) {
		int i=0, j=0;
		while(i<5) {
			j=0;
			while(j<5) {
				System.out.print(i + "" + j + " ");
				j++;
			}
			System.out.println(i + "" + j);
			i++;
		}
		
		
	/*
		
		System.out.println("START ...");
		out: //for���� ���� �̸��� "out"
		for (int i=0; i < 5; i++) {
			for(int j=0 ; j<5 ; j++) {
				if(i==2 && j==2)
					break out; 
					//continue; //�ؿ��ִ°� ���� ���ϰ� for�� �� ����Ŭ ����
				if(i==j)
					System.out.println(i + " " + j);
			}
		}
		System.out.println("END ...");
	*/
	
	}

}
