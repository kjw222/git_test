package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {//기반 스트림
			FileReader fr = new FileReader("./src/main/java/io/BufferedReaderTest.java");
			//보조 스트림
			new BufferedReader(fr);
			
			String line = null;
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: "+e);
		}finally {
			try {
				if(br != null) {
					br.close();
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}