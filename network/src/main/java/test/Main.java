package test;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Main {

	public static void main(String[] args) {
	
		Writer wr = new OutputStreamWriter(System.out); 

		String str = "Hello, Hi";	
		try {
			wr.write(str);
			wr.flush();
			//writer는 스트링 객체를 전달받아 바로 출력하는게 가능하다.	
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				wr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
