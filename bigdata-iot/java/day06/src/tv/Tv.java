package tv;

public class Tv {
	//attribute
	String color;
	boolean power;
	int channel;
	
	//Constructor ������ -- ��ü ������� �� �Ӽ��� �ʱ�ȭ
	public Tv() {
		this.color = "black";
		this.power = false;
		this.channel = 10;
	}
	
	//�������� ������ : ������ �� ���� �Է����� �ʱ�ȭ ����
	public Tv(String color, boolean power, int channel) {
		this.color = color;
		this.power = power;
		this.channel = channel;
	}
	
	//behavior, function, method
	public void powerOn() {
		power = true;
	}
	public void powerOff() {
		power = false;
	}
	public void channelUp() {
		channel += 1;
	}
	public void channelDown() {
		channel -= 1;
	}
	@Override
	public String toString() {
		return "Tv [color=" + color + ", power=" + power + ", channel=" + channel + "]";
	}
	
	
}
