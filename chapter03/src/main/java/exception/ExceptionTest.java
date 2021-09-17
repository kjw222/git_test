package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a =10;
		int b = 10 -a;
		
		System.out.println("some code...");
		
		try {
		int result = (1+2+3)/b;
		}catch(ArithmeticException e) {
			
		}
		System.out.println("some code2...");

	}

}
