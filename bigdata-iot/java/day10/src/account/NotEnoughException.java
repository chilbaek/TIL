package account;

//exception�� ����Ŭ������
//������ exception
public class NotEnoughException extends Exception {
	public NotEnoughException() {
		super();
	}
	public NotEnoughException(String msg) {
		super(msg);
	}
}
