package calc;

public class Calc {
	
	// "static" 
	// ���� new�� ��ü �������� �ʾƵ� �Լ��� ��� ��� ����
	
	public static int add(int a, int b) {
		int add = 0;
		add = a+b;
		return add;
	}
	
	//�ڹ��� "�����ε�" > �Լ� �̸� �Ȱ��� "add"
	//��� ���̽��� ���� �� ����
	public static double add(int a, double b) {
		double add = 0;
		add = a+b;
		return add;
	}
	
	public static double add(double a, int b) {
		double add = 0;
		add = a+b;
		return add;
	}

	public static double add(double a, double b) {
		double add = 0;
		add = a+b;
		return add;
	}	
	
}
