package thread;

public class ThreadEx01 {

	public static void main(String[] args) {
		
		new DigitThread().start();
		//for(char c = 'a'; c<='z'; c++) {System.out.print(c);}
		for(int i = 0; i<10; i++) {System.out.print(i);}
		System.out.print("main end");

	}

}
