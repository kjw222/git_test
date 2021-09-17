package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
//	private static int PORT = 5555;
//	//java echo.EchoServer 6000
//	public static void main(String[] args) {
//	
//		ServerSocket serverSocket = null;  //서버소켓 선언 초기값은 null
//		
//		try {
//			serverSocket = new ServerSocket(); //서버소켓 생성
//			//binding
//			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));  //바인딩 시킴. 000이나 자기 아이피로 입력해야함
//			log("start... [port : "+PORT+"]");	//몇번 포트가 열렸는지 반환
//			
//		}
//			while(true) {
//			Socket socket = serverSocket.accept();  //대기. blocking 상태로 connect하기를 기다림.
//			new EchoServerReceiveThread(socket).start();
//								}
//		
//	}
//
//	
//	public static void log(String log) {System.out.println("[EchoServer] "+log);}
	
private static final int PORT = 6000;
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("starts... [port:" + PORT + "]");
			
			while(true) {
				Socket socket = serverSocket.accept();
				new EchoServerReceiveThread(socket).start();
			}

		} catch(IOException e) {
			log("error: " + e);
		} finally {
			try {
				if(serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String log) {
		System.out.println("[EchoServer] " + log);
	}

}

//cmd로 들어가서 C:\douzone2021\eclipse-workspace\javastudy\network\target\classes 위치로 들어간 다음 java echo.EchoServer  열어주기.
