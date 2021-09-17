package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;


//전송만 되고 반환은 안됨. 어카냐.. 조졌네......................... 선생님 코드랑 비교해가며 확인하기.
public class EchoClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 6000;
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			socket = new Socket();
			
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			log("connected");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			while(true) {
				System.out.print(">");
				String line = scanner.nextLine(); //
				//tcp client 코드 입력
				if("exit".equals(line)) {break;}
				pw.println(line);
				String data = br.readLine();
				if(data == null) {
					log("closed by server");
					break;
					
				}
				System.out.println("<"+data);
			}
	}catch (SocketException e) { 
		log("suddenly colsed by server");
	} catch (IOException e) {
		log("error:"+e);
	}finally {
		try {
			if(scanner != null) {
				scanner.close();
			}
			if(socket != null && socket.isClosed() == false) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	
	private static void log(String log) {
		System.out.println("[Eco Client]"+log);
	}

}
