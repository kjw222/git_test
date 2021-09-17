package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

public class PhoneList02 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {//기반 스트림
			File file = new File("phone.txt");
			
			if(!file.exists()) {
			System.out.println("file not found");
			return;
			
			}
			
			System.out.println("=========파일 정보===============");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length()+"bytes");
			System.out.println(file.lastModified());
			
			System.out.println("=========전화번호===============");
			
			FileInputStream fis = new FileInputStream(file);
			
			FileReader fr = new FileReader("./src/main/java/io/BufferedReaderTest.java");
			InputStreamReader isr = new InputStreamReader(System.in,"utf-8");
			//보조 스트림
			br = new BufferedReader(fr);
			
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
				StringTokenizer st = new StringTokenizer(line, "\t");
				int index = 0;
				while(st.hasMoreElements()) {
					String token = st.nextToken(); 
					if(index ==0) {
						System.out.print(token + ":");
					}else if(index ==1) {
						System.out.print(token + "-");
					}else if(index ==2) {
						System.out.print(token + "-");
					}else if(index ==3) {
						System.out.print(token + "-");
					}
					index++;
					System.out.println(token+":");}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: "+e);
		} catch (UnsupportedEncodingException e) {
			System.out.println("ERR: "+e);
		} catch (IOException e) {
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