package ChatPro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatClientThread extends Thread{
	private BufferedReader br=null;
	Socket socket = null;
	

	public ChatClientThread(Socket socket) {
		this.socket = socket;
		
	}

	@Override
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			while(true) {
				String message = br.readLine();
				System.out.println("<" + message);
			}
			
		} catch (UnsupportedEncodingException e) {
			
		} catch (IOException e) {
			
		}
	}
	

}
