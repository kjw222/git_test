package chapter03;

public class Goods {
	public static int countOfGoods=0; 
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public Goods() {		//생성자는 같은 패키지 안에서는 자바가 자동으로 생성해줌.
		
		Goods.countOfGoods = Goods.countOfGoods+1;	//countOfGoods = countOfGoods+1; 같은 클래스라서 이렇게 써도 허용해줌
		
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0) {
			return;
		}
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	public void showInfo() {
		System.out.println("name :"+ name + "price : "+ price +"countStock :" + countStock + "countSold : "+countSold);
	}
	public int calcDiscountPrice(int percentage) {
		return price * percentage/100;
		
	}
}
