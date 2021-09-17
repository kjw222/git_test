package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

public class TCPServer {

	public static void main(String[] args) {
		//1. 서버 소켓 생성
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket();
				//2. bind = 서버랑 소켓을 묶어줌? 무슨 소린지 몰겠네
				//Socket에 ip주소랑 port를 바인딩 시켜줌(InetSocketAddress(IPAddress+port)
				//IPAdress(<상대의 주소대역) : 0.0.0.0 : 모든 ip로부터의 연결을 허용함. : 210.113.134.216(?) 특정 ip로 세팅할 수도 있지만.. 위험함. 아이피가 바뀔 수 있음.
				//serverSocket.bind(new InetSocketAddress(InetSocketAddress.getLocalHost().getHostAddress(), 5000));    //어려움
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000));
			
			//3. accept
			//클라이언트로 부터 연결 요청을 기다린다.
			socket = serverSocket.accept(); //blocking
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			System.out.println("[server] connected by client["+remoteHostAddress+":"+remoteHostPort+"]");
			System.out.println("연결!!!");
			//4. IO Stream 받아오기
			java.io.InputStream is =  socket.getInputStream();
			java.io.OutputStream os = socket.getOutputStream();
			
			while(true) {
				//5. 데이터 읽기
				byte[] buffer = new byte[256];
				int readByteCount=is.read(buffer); //blocking
				if(readByteCount == -1) {
					//클라이언트가 정상적으로 종료됨. close() 호출
					System.out.println("[server] closed by client");
					break;
				}
				String data = new String(buffer, 0, readByteCount, "utf-8");
				System.out.println("[server] received : "+data);
				
				//6. 데이터 쓰기
				os.write(data.getBytes("utf-8"));
			}
		}catch (SocketException e) {	
			System.out.println("[server] suddenly closed by client "+ e);
		} catch (IOException e) {	
			System.out.println("[server] error : "+ e);
		}finally {
			try {
				if(socket != null && socket.isClosed()==false) {socket.close();}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
			try {
				if(serverSocket != null && serverSocket.isClosed()==false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

	}


