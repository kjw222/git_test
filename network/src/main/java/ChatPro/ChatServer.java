package ChatPro;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final int PORT = 8080;
	List<Writer> listWriters = new ArrayList<Writer>();
	public static void main(String[] args) {
		//1. 서버 소켓 생성
		ServerSocket serverSocket = null;
		List<Writer> listWriters = null;
		
		try {
		serverSocket = new ServerSocket();
			
		//2. 바인딩
		String hostAddress = InetAddress.getLocalHost().getHostAddress();
		serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
		log("연결 기다림"+hostAddress+":"+PORT);
		
		//3. 요청 대기
		
		while(true) {
			Socket socket = serverSocket.accept();
			//new ChatServerThread(socket).start();
			new ChatServerThread(socket, listWriters).start();	
		}
		
		}catch(IOException e){
			log("error : " + e);
			
		}
		
	}
	static void log(String log) {
		System.out.println("[ChatServer log]  " + log);
		
	}
}
