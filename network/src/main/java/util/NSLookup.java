package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {

	public static void main(String[] args) {
		//www.douzone.com 치면 여기 ip주소를 입력받음. , naver도 마찬가지.quit으로 종료까지 시키는 것으로.
		
		String line = "www.douzone.com";
		try {
			InetAddress[] inetAddresses = InetAddress.getAllByName(line);
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
	}

}
