package chapter04;

public class ObjectTest03 {
	
	public static void main(String[] args) {
		String s1 = "Hello "+"World "+"Java "+1.8;
		new StringBuffer("Hello ").append("World ").append("Java").append(1.8).toString();
	
		System.out.println(s1);
	}	

}
