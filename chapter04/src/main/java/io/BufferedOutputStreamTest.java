package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {
	public static void main(String[] args) {
		BufferedOutputStrea bos =null;
		try {
			//기반 스트림
			FileOutputStream fos = new FileOutputStream("test.txt");
			//보조 스트림
			bos = new BufferedOutputStream(fos);
			
			for(int i = 'a'; i<'z';i++) {
				bos.write(i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("cant open : "+e);
		} catch (IOException e) {
			System.out.println("err : "+e);
		}
		finally {
			bos.close();
			
		}
	}
	
}
