package op;

public class Ws6 {
	public static void main(String[] args) {
		int fahreheit = 100;
		float celcius = (float)5/9 * (fahreheit-32);
		
		int temp = (int)(celcius * 1000)%10;		//�Ҽ��� 3��°�ڸ� ��
		celcius = (int)(celcius * 100)/(float)100 + (float)(temp >= 5 ? 0.01 : 0.00);
		
		System.out.println("Fehrenheit:"+fahreheit);
		System.out.println("Celcius:"+celcius);
	}
}
