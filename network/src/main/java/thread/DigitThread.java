package thread;

public class DigitThread extends Thread {

	@Override
	public void run() {
		for(int i = 0; i<10; i++) {System.out.print(i);}
		//for(char c = 'a'; c=='z'; c++) {System.out.print(c);}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
