package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer<writer> {
	
	private static final int PORT = 6000;
	List<writer> WriterPool = new ArrayList<writer>();
	
	
	public static void main(String[] args){
		
		ServerSocket serverSocket = null;
		
		
		try {
			serverSocket = new ServerSocket();
			
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("starts... [port:" + PORT + "]");
			
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerReceiveThread(socket).start();
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
