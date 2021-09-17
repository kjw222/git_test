package io;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class KeyboardTest {

	public static void main(String[] args) {
		InputStreamReader b = null;
		try {
			InputStreamReader isr = new InputStreamReader(System.in, "utf-8");
			b = new InputStreamReader(System.in, "utf-8");
		}catch(UnsupportedEncodingException e) {
			System.out.println("err : "+e);
		}

	}

}
