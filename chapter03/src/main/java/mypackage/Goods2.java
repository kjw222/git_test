package mypackage;

public class Goods2 {
	public String name;	//모든 접근이 가능(접근 제한 x)
	protected int price;	//1. 같은 패키치 접근 가능, 2. 자식 접근이 가능
	 int countStock;		//default, 같은 패키지
	private int countSold;	//클래스 내부에서만 접근이 가능
	
	void m() {
		countSold = 100;
	}

}
