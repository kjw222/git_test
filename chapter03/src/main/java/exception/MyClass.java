package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException {
		System.out.println("some codes1");
		System.out.println("some codes2");
		if(10-10 ==0) {
			throw new IOEception();
		}
		System.out.println("some code3s");
		System.out.println("some codes4");
	}
}
