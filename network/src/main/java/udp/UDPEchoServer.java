package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	public static final int PORT = 7000;
	public static void main(String[] args) {
		DatagramSocket socket = null;
		final int BUFFER_SIZE = 1024;
		
		try {
			//1. 소켓 생성
			socket = new DatagramSocket(PORT);
			while(true) {
			//2. data 수신
				DatagramPacket rcvPacket = new DatagramPacket(new byte[1024], 1024);  //읽어야하는 버퍼를 넣어줌. 편지봉투에(버퍼에) 내용을 넣어줌
				socket.receive(rcvPacket); //blocking
				
				byte[] rcvData = rcvPacket.getData(); //rcvData에 받은 데이터를 저장함.
				int length = rcvPacket.getLength(); //답으로 받은 메세지 길이와 보낸 메세지 길이를 비교. 확인함.
				String message = new String(rcvData, 0, length, "utf-8");
				
				System.out.println("[server receive ; "+message);
				
				//3. 데이터 송신
				byte[] sndData = message.getBytes("utf-8");
				DatagramPacket sndPacket = new DatagramPacket(sndData, sndData.length, rcvPacket.getAddress(), rcvPacket.getPort());  //보내는 패킷을 만들었음. 보내는 데이터, 보내는 데이터의 길이, 받을 패ㅣㅅ 주소, 받을 패킷 포트를 값으로 넣어줌.
			}
		} catch (SocketException e) {
			System.out.println("error : "+e);
			
		}catch (IOException e) {
			System.out.println("error : "+e);
			
		}
		finally {
			if(socket!= null && socket.isClosed()==false) {socket.close();}
		}
		
	} 

}
