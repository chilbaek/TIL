package ex;

import java.io.IOException;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class Ex2 {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("192.168.111.1", 8888);
			//���� ���� > ������ ����
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { //exception �߻��ص� �������� ����Ǵ� �� : finally 
			 //socket.close();
		}

	}

}
