package variable;

public class Var1 {

	public static void main(String[] args) {
		int a = 10; //small
		long a2 = 3000000000L; //big
		char c = 'A';
		
		double b = 10.1; //big
		float b2 = 10.1F; //small
		// AA = BB; ����  BB�� ����,, BB�� AA�� �ִ´�

		String s1 = "Result:";
		
		System.out.println(a+","+b);
		System.out.println(c);
		System.out.println((int)c);
		System.out.println(s1+" "+(int)(a+b));
	}

}
