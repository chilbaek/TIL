package car;

public class Car {
	int serial;
	String name;
	double size;
	
	static int count;
	//static�� new Ŭ������ ������� �״�� > "	Ŭ��������"
	//serial name size �� Ŭ���� ���涧���� ���� ����µ�
	//count�� ���� �ȹް� ���� �������ܼ� �� �ѹ��� �����Ǿ� ������ 
	
	//�ϰ͵� ��� �������� > ������������
	public Car() {	
//		this.name = "KK";
//		this.size = 1000;
		this("KK",1000);
	}
	public Car(String name, double size) {
		this.serial = ++count; 
		this.name = name;
		this.size = size;
	}
	
	public Car(int serial, String name, double size) {
		this.serial = serial;
		this.name = name;
		this.size = size;
	}
	
	//this�� ��ü�� �ּҶ� ���� ����
	public void setSize(double s) {
		this.size = s;
	}
	
	@Override
	public String toString() {
		return "Car [serial=" + serial + ", name=" + name + ", size=" + size + "]";
	}
}
