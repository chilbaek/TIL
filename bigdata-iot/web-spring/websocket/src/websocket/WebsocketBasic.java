package websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebsocketBasic {
	@OnOpen
	public void handleOpen() {
		System.out.println("client is now connected...");
	}
	
	// WebSocket���� �޽����� ���� ��û�Ǵ� �Լ�
	@OnMessage
	public String handleMessage(String message) {
		// �޽��� ������ �ֿܼ� ����Ѵ�.
		System.out.println("receive from client : " + message);
		// ���� �޽����� �ۼ��Ѵ�.
		String replymessage = "echo " + message;
		// ���� �޽����� �ֿܼ� ����Ѵ�.
		System.out.println("send to client : " + replymessage);
		// ���� �޽����� �������� ������.
		return replymessage;
		}
	
	@OnClose
	public void handleClose() {
		System.out.println("client is now disconnected...");
	}
	
	@OnError
	public void handleError(Throwable t) {
		t.printStackTrace();
	}
}
