package websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@ServerEndpoint("/websocket")
@ServerEndpoint(value="/websocket/{userId}")
public class Websocket {
	
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    static HashMap<String, Session> messageUserList = new HashMap<String, Session>();

	@OnOpen
	public void handleOpen(Session session, @PathParam("userId") String userId) {
		System.out.println("client is now connected...");
		// @PathParam �� �����Ͽ��� ����ϴ� @PathVariables
		// 1. userId �� �ߺ��Ǵ��� Ȯ��
		if (messageUserList.get(userId) != null) {
			logger.info("�ߺ� �߻�");
			//userId = "";
			sendMsg(session, "������� ���̵� �Դϴ�.");
		} else {// �ߺ��� �ƴ� ���
			logger.info("�ߺ� �ƴ�");

			messageUserList.put(userId, session);
			System.out.println(userId + "else USERID");

			/*
			 * String memberEmail = (String)httpSession.getAttribute("email");
			 */ broadCast(userId + "���� ���� �ϼ̽��ϴ�." /* ���� ������ �� : +userList.size() */ + "\n");
		}
	}
	
	// WebSocket���� �޽����� ���� ��û�Ǵ� �Լ�
	@OnMessage
	public String handleMessage(String message) {
        broadCast(message);
		
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
	
	//�޽��� ��ü ����
    private void broadCast(String text){
        logger.info("���� ��� : "+messageUserList.size());
        Set<String>keys =  messageUserList.keySet();
        try {            
            for(String key : keys) {
                logger.info("key : "+key);
                Session session = messageUserList.get(key);    
                session.getBasicRemote().sendText(text);
                System.out.println(session.getId() + "ID!!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
  //�Ѹ��� �޽��� ����
    private void sendMsg(Session session, String msg) {
        try {
            session.getBasicRemote().sendText(msg);
        } catch (IOException e) {    
            e.printStackTrace();
        }
    }
}
