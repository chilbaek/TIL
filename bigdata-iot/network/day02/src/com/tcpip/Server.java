package com.tcpip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	int port = 9999;
	ServerSocket serverSocket;
	Socket socket;
	
	InputStreamReader ir;
	BufferedReader br;
	
	public Server() {

	}

	public void startServer() throws IOException {
		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				System.out.println("Ready Server .. ");
				socket = serverSocket.accept(); // 뭐가 들어올 때 까지 계속 대기
				System.out.println("Connected ...");

				ir = new InputStreamReader(socket.getInputStream());
				br = new BufferedReader(ir);
				String msg = "";
				msg = br.readLine();
				System.out.println(msg);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (br != null)
				br.close();
			if (socket != null)
				socket.close();
		}
	}
	
	public static void main(String[] args) {
		Server server = null;
		server = new Server();
		try {
			server.startServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end server");
	}

}
