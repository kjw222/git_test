package ChatPro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import Chat.ChatServerReceiveThread;

public class ChatClient {
	public static void main(String[] args) {
		final String SERVER_IP = "0.0.0.0";
		final int SERVER_PORT = 8080;
		Scanner scanner = null;
		Socket socket = null;
		PrintWriter printWriter = null;
		
		try {
			//키보드 연결
			scanner = new Scanner(System.in);
			
			
		//3.socket 생성
			socket = new Socket();
		//4. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			log("connected");
		//5. reader/writer 생성
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
		//join 연결
		System.out.print("닉네임>>" );
		String nickname = null;
		while(true) {
			nickname = scanner.nextLine();
			printWriter.println("join:"+nickname);
			printWriter.flush();
				if("".equals(nickname)) {System.out.println("닉네임 재입력.");
				}else {break;}
		}
			
		//6. ChatClientReceiveThread 시작
			
			new ChatClientThread(socket).start();
			
		//7. 키보드 입력 처리
		System.out.print(">>");	
			while(true) {
				
				String input = scanner.nextLine();
				if("".equals(input)) {
					System.out.println("한 글자 이상 입력하세요.");
					continue;
				}
				if("quit".equals(input)==true) {
					//8. quit 프로토콜 처리
					pw.println("quit:"+nickname+"님이 나갔습니다.");
					break;
				}else {
					//9. 메시지 처리
					pw.println("message:" + input);
				}
			}
		}catch(IOException ex) {
			log("error : "+ex);
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
		System.out.println("[ChatClient]  " + log);
		
	}

}
