package chapter04;

public class ObjectTest01 {
	public static void main(String[] args) {
		Point p = new Point(10, 20);
		
		//Class class =  p.getClass();
		System.out.println(p.getClass()); //reflection 반사, 반응하다. 클래스 정보를 보여줌.
		System.out.println(p.hashCode()); //address 기반의 해싱값이라는 설이 많다! 다들 다른 이야기를 한다. 정체를 정확히 알기 힘듬.
		System.out.println(p.toString()); //객체 안의 내용을 스트링으로 바꿔줌. getClass() + "@" + hashCode()
		System.out.println(p); //toString이 자동으로 호출됨. 윗줄과 같은 결과가 나옴.
	}
}
