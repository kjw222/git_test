package ChatPro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

import Chat.ChatServer;

public class ChatServerThread extends Thread{

	private String nickname=null;
	private Socket socket;
	PrintWriter Writer = null;
	private List<Writer> listWriters =null;
	

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters= listWriters;
		System.out.println(listWriters+"님이 입장하였습니다.");
	}

	@Override
	public void run(){
		//1. Remote Host Information
		try {
			//2. 스트림 얻기
			BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			//3. 요청처리
			while(true) {
				String request = bufferedReader.readLine();
				if(request == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					doQuit(Writer);
					break;
				}

				//4. 프로토콜 분석

				String[] tokens = request.split(":");

				if("join".equals(tokens[0])) {
					doJoin(tokens[1], writer);
				}else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				}else if("quit".equals(tokens[0])) {
					doQuit(writer);
				}else {
					ChatServer.log("에러:알 수 없는 요청("+tokens[0]+")");
				}
			}	

		}catch(IOException e){
			ChatServer.log("error:" + e);
		}finally {
				try {
					if (socket != null && socket.isClosed() == false) {
					socket.close();}
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
	}
	


		private void doJoin(String nickName, Writer writer) {
			this.nickname = nickName;

			String data = nickName + "님이 참여하였습니다.";
			broadcast(data);

			// writer pool에 저장
			addWriter(writer);

			//ack
			Writer.println("join:ok");
			Writer.flush();

		}

		private void addWriter(Writer writer) {
			synchronized(listWriters) {
				listWriters.add(writer);
			}
		}

		private void broadcast(String data) {
			synchronized(listWriters) {
				for(PrintWriter Writer : listWriters) {
				
					Writer.println(data);
					Writer.flush();
				}
			}
		}

		private void doMessage(String message) {
			broadcast(this.nickname + ":" + message);															//잘 구현해보기

		}
		private void doQuit(Writer writer) {
			removeWriter(writer);

			String data = nickname + "님이 퇴장 하였습니다.";
			broadcast(data);
		}

		private void removeWriter(Writer writer) {
			synchronized(listWriters) {
				listWriters.remove(writer);
			}
			//잘 구현해보기
		}
	}
