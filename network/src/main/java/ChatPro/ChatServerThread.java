package ChatPro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;




public class ChatServerThread extends Thread{

	private String nickname;
	private Socket socket;
	BufferedReader bufferedReader = null;
	PrintWriter printWriter = null;
	List<PrintWriter> listWriters = null;
	
	
	public ChatServerThread(Socket socket, List<PrintWriter> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		
		
		// 1. remote Host INfomation
		InetSocketAddress inetRemoteSocketaddress =  (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketaddress.getAddress().getHostAddress();
		int remoteHostPort = inetRemoteSocketaddress.getPort();	
		ChatServer.log("connected by client[" + remoteHostAddress + ":" + remoteHostPort+ "]");

		//2. 스트림 얻기
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
			
			//3. 요청처리
			while(true) {
				String request = bufferedReader.readLine();
				if(request == null) {
					log(nickname + "(으)로부터 연결끊김");
					break;
					
				}

				String[] tokens = request.split(":");
				if("join".equals(tokens[0])) {
					if(tokens.length < 2) {
						continue;
					}
					doJoin(tokens[1], printWriter);
					log(tokens[1] + "님이 참여하였습니다.");
					
				}
				else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				}
				else if("quit".equals(tokens[0])) {
					doQuit(printWriter);
				}
				else {
					ChatServer.log("에러: 알 수 없는 요청(" + tokens[0] + ")");
				}
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	         if (socket != null && socket.isClosed() == false) {
	             try {
	                socket.close();
	             } catch (IOException e) {
	                e.printStackTrace();
	             }
	          }
	     }
	}

	private void log(String string) {
		System.out.println("[server] " + string);
		
	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			for(PrintWriter writer : listWriters) {
				writer.println(data);
				writer.flush();
			}
		}
	}
	
	private void doJoin(String nickName, PrintWriter writer) {
		this.nickname = nickName;
		
		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);
		
		/* writer pool에 저장 */
		addWriter(writer);
		
		//ack
		printWriter.println("join:ok");
		printWriter.flush();
	}
	
	private void addWriter(PrintWriter writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}
	
	private void doMessage(String message) {
		/* 잘 구현 해보기 */
		broadcast(this.nickname + ":" + message);
	}
	
	private void doQuit(Writer writer) {
		removeWriter(writer);
		String data = nickname + "님이 퇴장하였습니다.";
		broadcast(data);
	}
	
	private void removeWriter(Writer writer) {
		/* 잘 구현 해보기*/
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
	}
}



//public class ChatServerThread extends Thread{
//
//	private String nickname=null;
//	private Socket socket;
//	PrintWriter writer = null;
//	BufferedReader reader = null;
//	List<Writer> listWriters =null;
//	
//
//	public ChatServerThread(Socket socket, List<Writer> listWriters) {
//		this.socket = socket;
//		this.listWriters= listWriters;
//	
//	}
//
//	@Override
//	public void run(){
//		//1. Remote Host Information
//		
//		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
//		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
//		int remoteHostPort = inetRemoteSocketAddress.getPort();
//		EchoServer.log("connected by client[" + remoteHostAddress + ":" + remoteHostPort + "]");
//		
//		
//		try {
//			//2. 스트림 얻기
//			reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
//			writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
//			
//			
//			//3. 요청처리
//			while(true) {
//				String request = reader.readLine();
//				if(request == null) {
//					ChatServer.log("클라이언트로 부터 연결 끊김");
//					doQuit(writer);
//					break;
//				}
//
//				//4. 프로토콜 분석
//
//				String[] tokens = request.split(":");
//
//				if("join".equals(tokens[0])) {
//					if(tokens.length <2) {continue;}
//					doJoin(tokens[1], writer);
//					System.out.println(tokens[1]+"님이 입장하였습니다.");
//				}else if("message".equals(tokens[0])) {
//					doMessage(tokens[1]);
//				}else if("quit".equals(tokens[0])) {
//					doQuit(writer);
//				}else {
//					ChatServer.log("에러:알 수 없는 요청("+tokens[0]+")");
//				}
//			}	
//
//		}catch(IOException e){
//			ChatServer.log("error:" + e);
//		}finally {
//			if (socket != null && socket.isClosed() == false) {
//				try {
//					socket.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//	
//
//
//		private void doJoin(String nickName, PrintWriter writer) {
//			this.nickname = nickName;
//
//			String data = nickName + "님이 참여하였습니다.";
//			broadcast(data);
//
//			// writer pool에 저장
//			addWriter(writer);
//
//			//ack
//			writer.println("join:ok");
//			writer.flush();
//
//		}
//
//		private void addWriter(PrintWriter writer) {
//			synchronized(listWriters) {
//				listWriters.add(writer);
//			}
//		}
//
//		private void broadcast(String data) {
//			synchronized(listWriters) {
//				for(PrintWriter writer : listWriters) {
//				
//					writer.println(data);
//					writer.flush();
//				}
//			}
//		}
//
//		private void doMessage(String message) {
//			broadcast(this.nickname + ":" + message);															//잘 구현해보기
//
//		}
//		private void doQuit(Writer writer) {
//			removeWriter(writer);
//
//			String data = nickname + "님이 퇴장 하였습니다.";
//			broadcast(data);
//		}
//
//		private void removeWriter(Writer writer) {
//			synchronized(listWriters) {
//				listWriters.remove(writer);
//			}
//			//잘 구현해보기
//		}
//	}
