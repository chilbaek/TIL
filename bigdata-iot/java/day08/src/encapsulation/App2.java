package encapsulation;

public class App2 {

	public static void main(String[] args) {
		Employee e = new Employee("Lee", "11", 500, "M");
		//e.salary = -100;
		//getter�� ���� private(encapsulation) �س����� ���ٰ���
		System.out.println(e.getName() + " " + e.getSalary());
		//setter�� encapsulation ���氡��
		//name�� ���� ����ξ ����, id-salary�� setter ���� ���ؼ� ���ٲ�
		e.setName("Kim");
	}

}
