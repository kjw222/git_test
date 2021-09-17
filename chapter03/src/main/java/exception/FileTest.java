package exception;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class FileTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("hello.txt")
			int data = fis.read();
		} catch (FileNotFoundException e) {
			System.out.println("error:"+e);
		} finally {
			try {
			fis.close();
		} catch (IOExciption e) {
			e.printStackTrace();
		}
		
	}
	}
}
