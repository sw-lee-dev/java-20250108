package chapter02;

// *오버로딩(Overloading)* : 같은 클래스 내부에서 같은 이름의 메서드를 여러개 작성할 수 있도록 하는 방법론
// 오버로딩 조건
// 1. 메서드의 이름을 중복해서 작성하고 매개변수 타입의 조합(개수, 순서)을 다르게 작성
// 2. 메서드의 반환타입과 매개변수의 이름은 오버로딩에 영향을 주지 않음
class NewMath {
	
	int add (int a, int b) {
		return a + b;
	}
	
	// 문제점
	// 1. 메서드의 이름이 불규칙적임
	// 2. 사용시에 불편함을 초래함
	double add2(double a, double b) {
		return a + b;
	}
	
	// 오버로딩 : 매개변수의 타입을 다르게 한 경우
	double add(double a, double b) {
		return a + b;
	}
	
	// 오버로딩 : 매개변수의 개수를 다르게 한 경우
	int add(int a, int b, int c) {
		return a + b + c;
	}
	
	// 오버로딩 : 매개변수 타입의 조합을 다르게 한 경우 
	double add(int a, double b) {
		return a + b;
	}

	// 반환타입만 다를 땐 오버로딩 불가능 >> 매서드명과 매개변수의 타입으로 중복을 구분
//	double add(int a, int b) {
//		return a + b;
//	}
	// 매개변수 이름만 다를 땐 오버로딩 불가능 >> 매서드명과 매개변수의 타입으로 중복을 구분
//	int add(int x, int y) {
//		return x + y;
//	}
	
}

public class C_Overloading {

	public static void main(String[] args) {
		
		NewMath newMath = new NewMath();
		// newMath.add2();
		newMath.add(1.2, 1.4);
		newMath.add(1, 2, 3);
		// newMath.add("0", "0"); >> The method add(int, int) in the type NewMath is not applicable for the arguments (String, String) 지정해준 타입만 가능		
	}

}