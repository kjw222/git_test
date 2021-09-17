package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderTest {
	public static void main(String[] args) {
		Reader in = null;
		try {
			in = new FileReader("1234.text");
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found:"+e);
		}
		catch(IOException e) {
			System.out.println("err:"+e);
		}finally {try {
			if(in !=null) {in.close();}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}

}
