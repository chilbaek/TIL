package op;

public class Op5 {

	public static void main(String[] args) {
//		char c = '1';
//		System.out.println(c);
//		boolean result = (('0' <= c) && (c <= '9'));
//		System.out.println(result);
		
		char c = '1';
		//char���� ���ĺ������� �˾ƺ�
		boolean result = ((('A' <= c) && (c <= 'Z')) || (('a'<= c) && (c <= 'z')));
		//����� Ȱ��/���� �����ϴ� ����
		System.out.println(result);
	}
}
