package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("pic.jpg");
			os = new FileOutputStream("pic.copy.jpg");
			//is.read();
			
			int data = 0;
			while((data=is.read()) != -1) {
				
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found"+e);
		} catch (IOException e) {
			System.out.println("err"+e);
		}finally {
			try {
				if(is != null) {
				is.close();
				}
				if(os != null) {
					os.close();
					}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
