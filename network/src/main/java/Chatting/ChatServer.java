package Chatting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	

	public static void main(String[] args) {
		Socket socket =null;
		ServerSocket serversocket=null;
		
		try {
			socket = new Socket();
			serversocket = new ServerSocket();
			socket.connect(new InetSocketAddress("0.0.0.0", 8080));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			
			
		}catch(Exception e){
			
		}
		
		
		
	}

}
